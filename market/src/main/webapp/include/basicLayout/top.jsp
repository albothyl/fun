<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="banner">
	<a href="/swindle/searchForm.do">사기꾼 검색</a>
</div>
			
<div id="header">3</div>

<div id="loginForm">
	<c:choose>
		<c:when test="${login.loginYN == true}">
			<div>
				<p><strong>${sessionScope.login.email}</strong> 님 반갑습니다</p><br/>
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
