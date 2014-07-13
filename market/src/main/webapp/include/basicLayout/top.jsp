<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="org.springframework.web.util.WebUtils"%>
<%@ page import="org.project.member.domain.Login"%>

<%
	//세션에서 사용자의 정보를 가져온다.
	Login login = (Login) WebUtils.getSessionAttribute(request, "login");
%>

<div id="banner"></div>
			
<div id="header">3</div>

<div id="loginForm">
	<c:choose>
		<c:when test="${login.loginYN == true}">
			<div>
				<p><strong><%=login.getEmail() %></strong> 님 반갑습니다</p><br/>
				<a href="/member/logout.do" class="btn_logout">로그아웃</a>
				<a href="/member/memberManagementForm.do">회원관리</a>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				<a href="/member/loginForm.do">로그인</a>
				<a href="/member/joinForm.do">회원가입</a>
			</div>
		</c:otherwise>
	</c:choose>
	
	
</div>
