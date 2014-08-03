package org.project.common.intercepter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.common.system.customAnnotation.Ajax;
import org.project.common.system.customAnnotation.LoginRequired;
import org.project.common.system.customAnnotation.Ownership;
import org.project.member.domain.Login;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.springframework.web.method.HandlerMethod;


public class LoginCheck extends WebContentInterceptor {
	
	private Login sessionLogin;

	/*
	 * 어노테이션을 활용한 인터셉터 방식
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
		
		//System.out.println("LoginCheckInterceptor");
		
		//@LoginCheckInterceptor 어노테이션이 컨트롤러에 사용되었는지 체크함
		LoginRequired loginRequiredMethod = (LoginRequired) ((HandlerMethod) handler).getMethodAnnotation(LoginRequired.class);
		Ownership ownershipMethod = (Ownership) ((HandlerMethod) handler).getMethodAnnotation(Ownership.class);
		Ajax ajax = (Ajax) ((HandlerMethod) handler).getMethodAnnotation(Ajax.class);
		
		sessionLogin = null;
		sessionLogin = (Login)request.getSession().getAttribute("login");
		
		//@LoginCheckInterceptor이 있으면 로그인 체크
		if(loginRequiredMethod != null) {
			if(sessionLogin == null || sessionLogin.isLoginYN() == false){
				if(ajax == null) {
					ModelAndView mav = new ModelAndView();
					Login login = new Login();
					login.loginFirst();
					mav.addObject("login", login);
					mav.setViewName("/member/loginForm");
					throw new ModelAndViewDefiningException(mav);
				}else{
					returnStringMAV("ajaxMessage", "로그인 해주시기바랍니다.", "/common/error/ajaxMessage");
				}
			}
		}
		if(ownershipMethod != null) {
			if(sessionLogin != null || sessionLogin.isLoginYN() == true) {
				String email = (String)request.getParameter("email").trim();
				
				//본인이 아닌 글에 대하여 수정,삭제하려고 할 때
				if(!sessionLogin.getEmail().equals(email)) {
					if(ajax == null) {
						System.out.println(sessionLogin.getEmail());
						System.out.println(email);
						returnStringMAV("resultMsg", "작성자가 아닙니다.", "/common/error/commonError");					
					}else{
						returnStringMAV("ajaxMessage", "본인이 아닙니다.", "/common/error/ajaxMessage");
					}
				}
			}
		}		
		return true;
	}
	
	public void returnStringMAV(String key, String value, String destination) throws ModelAndViewDefiningException {
		ModelAndView mav = new ModelAndView();
		mav.addObject(key, value);
		mav.setViewName(destination);
		throw new ModelAndViewDefiningException(mav);
	}
}

/*
 * before LoginCheck Interceptor
 
public class LoginCheck extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {		
		
		Login sessionLogin = null; 
		sessionLogin = (Login)request.getSession().getAttribute("login");
		
		if(sessionLogin == null || sessionLogin.isLoginYN() == false){
			ModelAndView mav = new ModelAndView();
			Login login = new Login();
			login.loginFirst();
			mav.addObject("login", login);
			mav.setViewName("/member/loginForm");
			throw new ModelAndViewDefiningException(mav);
		}
		
		return true;		
	}
}
*/