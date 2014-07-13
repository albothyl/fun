<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html lang="ko">

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>loginForm</title>

	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="/include/css/user/userCSS.css">
	<script src="/include/javaScript/jQuery/jquery-2.1.1.min.js"></script>	
	<script src="/include/javaScript/user/memberValidationCheck.js"></script>
	
	<script>
	$(document).ready(function()
	{
	     $("#loginSubmit").click(function(){
	          if(loginFormValidationCheck()){
	               var loginForm    =  document.getElementById("memberLoginForm");
	               loginForm.action = "/member/login.do";
	               loginForm.method = "POST";
	               loginForm.submit();
	          }
	     });

	     $("#cancle").click(function(){
	          history.back();
	     });
	});
	</script>
</head>

<body>

	<div id="all">
		<div id="top">
			<%@ include file='/include/basicLayout/top.jsp'%>
		</div> <!-- end all -->
		
		<div id="middle">
			<%@ include file='/include/basicLayout/leftSideMeneBar.jsp'%>
			
			<div id="main">
				<h1>loginForm</h1>
	
				<c:choose>
					<c:when test="${login.loginYN == true}">
						<div>
							${login.email}님이 로그인 하셨습니다.
							<br/>
							로그아웃 하시려면 <a href="/member/logout.do">로그아웃</a>을 클릭해 주시기 바랍니다.
							회원정보를 변경하시려면 <a href="/member/memberManagementForm.do">회원정보 관리</a>을 클릭해 주시기 바랍니다.
						</div>
					</c:when>
					<c:otherwise>
						<div>
							<div>
								<form:form modelAttribute="login" id="memberLoginForm">
								<fieldset>
								<legend> 회원 로그인 </legend>
									<p style="color: red; font-weight: bold;">${login.resultMessage}</p>
									<p>
										<form:label  path="email" cssErrorClass="errorMessage">email : </form:label>
										<form:input  path="email" id="email" size="30"/>
										<br/>
										<form:errors path="email" cssClass="errorMessage" />
									</p>
									<p>
										<form:label  path="pw" cssErrorClass="errorMessage">password : </form:label>
										<form:password  path="pw" id="pw" size="30"/>
										<br/>
										<form:errors path="pw" cssClass="errorMessage" />
									</p>
									<p>
										<input type="button" class="btn" id="loginSubmit" value="확인" />
										<input type="button" class="btn" id="cancle" value="취소" />
									</p>
								</fieldset>
								</form:form>
							</div>			
							<div class="span-12 append-12 last">
								<div class="notice">
									처음 방문하셨으면 <a href="/member/joinForm.do">회원가입</a>을 클릭해 주시기 바랍니다.
									비밀번호를 찾으시려면 <a href="/member/recoverPwForm.do">비밀번호 찾기</a>를 클릭해 주시기 바랍니다.
								</div>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div> <!-- end middle -->
		
		<div id="bottom">
			<%@ include file='/include/basicLayout/bottom.jsp'%>
		</div> <!-- end bottom -->
			
	</div>
	
</body>

</html>