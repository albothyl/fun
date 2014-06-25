package org.project.common.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheck extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if(request.getSession().getAttribute("member") == null){
			throw new ModelAndViewDefiningException((new ModelAndView("/view/common/error/loginFirst")));
		}
		
		return true;		
	}
}
