package org.project.common.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.member.domain.Login;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheck extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if(request.getSession().getAttribute("login") == null){
			ModelAndView mav = new ModelAndView();
			Login login = new Login();
			login.loginFirst();
			mav.addObject("login", login);
			throw new ModelAndViewDefiningException(mav);
		}
		
		return true;		
	}
}
