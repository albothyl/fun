<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko">

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>joinForm</title>
	
	<link rel="stylesheet" href="/css/user/userCSS.css">		
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>	
	<script src="/javaScript/user/memberValidationCheck.js"></script>	
	
	<script>
		$(document).ready(function()
		{
			$("#joinSubmit").click(function(){
				validationCheck();
			});
		});
		
		function validationCheck(){			
			if(emailCheck()){
				alert("emailCheck success!!");
			}
			if(pwCheck()){
				alert("pwCheck success!!");
			}
			if(nickCheck()){
				alert("nickCheck success!!");
			}
		}
	</script>

</head>

<body>
	<form action="/member/joinCertifyAction.do" method="POST">
		<div class="form" id="memberJoinForm">
			<div class="clear"></div>
				<div class="caption">email</div>
				<div class="userInput"><input type="text" name="email" id="email" value="" maxlength="20" /></div>
			<div class="clear"></div>
				<div class="caption">password</div>
				<div class="userInput"><input type="password" name="pw" id="pw" value="" maxlength="20" /></div>
				<div class="userInput2"><input type="password" id="pwRepeat" value="" maxlength="20" /></div>
			<div class="clear"></div>
				<div class="caption">nickname</div>
				<div class="userInput"><input type="text" name="nick" id="nick" value="" maxlength="20" /></div>
			<div class="clear"></div>
				<input type="button" class="btn" id="joinSubmit" value="확인" />
				<input type="button" class="btn" id="joinCancle" value="취소" />
		</div>
	</form>
</body>

</html>