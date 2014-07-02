<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko">

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>joinCertified</title>
	
	<link rel="stylesheet" href="/css/user/userCSS.css">		
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>	
	<script src="/javaScript/user/memberValidationCheck.js"></script>
	
	<script>
	$(document).ready(function()
	{
		$("#loginSubmit").click(function(){
			if(loginFormValidationCheck()){
				var joinForm    =  document.getElementById("memberLoginForm");
				joinForm.action = "/member/loginAction.do";
				joinForm.method = "POST";
				joinForm.submit();
			}
		});		
		
		$("#cancle").click(function(){
			history.back();
		});
	});
	</script>
	
</head>

<body>
	회원가입을 축하합니다.
	<form id="memberLoginForm">
		<div class="form" id="memberLoginDiv">
			<div class="clear"></div>
				<div class="caption">email</div>
				<div class="userInput"><input type="text" name="email" id="email" value="" maxlength="20" /></div>
			<div class="clear"></div>
				<div class="caption">password</div>
				<div class="userInput"><input type="password" name="pw" id="pw" value="" maxlength="20" /></div>
			<div class="clear"></div>
				<input type="button" class="btn" id="loginSubmit" value="로그인" />
				<input type="button" class="btn" id="cancle" value="취소" />
		</div>
		<div class="clear"></div>
		<div>
			<a href="/member/joinForm.do">회원가입</a> / <a href="/member/findPwForm.do">PW 찾기</a>
		</div>
	</form>
</body>

</html>