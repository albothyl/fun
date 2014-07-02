<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String email= (String)request.getAttribute("email");
%>
<!doctype html>

<html lang="ko">

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>joinCertify</title>
	
	<link rel="stylesheet" href="/css/user/userCSS.css">		
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>	
	<script src="/javaScript/user/memberValidationCheck.js"></script>
	
	<script>
	$(document).ready(function()
	{
		$("#certifyKeySubmit").click(function(){
			var randomKey = $("#randomKey").val();
			
			if(nullCheck("인증번호", randomKey)){
				var joinForm    =  document.getElementById("memberCertifyForm");
				joinForm.action = "/member/joinCertifiedAction.do";
				joinForm.method = "POST";
				joinForm.submit();
			}
		});
	});
	</script>
</head>

<body>
	<form id="memberCertifyForm">
		<div class="form" id="memberJoinDiv">
		<%=email%>으로 인증번호를 발송하였습니다. 
		이메일로 전송된 인증번호를 아래에 입력해주시기 바랍니다.
			<div class="clear"></div>
				<div class="caption">인증번호</div>
				<div class="userInput"><input type="text" name="randomKey" id="randomKey" value="" maxlength="4" /></div>
				<input type="button" class="btn" id="certifyKeySubmit" value="확인" />
				<input type="hidden" id="email" name="email" value="<%=email%>" />
		</div>
	</form>
</body>

</html>