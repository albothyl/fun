<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko">

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>joinForm</title>
	<!-- 
	<link rel="stylesheet" href="/css/user/userCSS.css"> -->
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>	
	<script src="/javaScript/user/memberValidationCheck.js"></script>
	
	<script>
	var emailDuplicationCheck = false;

	$(document).ready(function()
	{	
		$("#joinSubmit").click(function(){
			if(emailDuplicationCheck){
				if(joinFormValidationCheck()){
					var joinForm    =  document.getElementById("memberJoinForm");
					joinForm.action = "/member/joinCertifyAction.do";
					joinForm.method = "POST";
					joinForm.submit();
				}
			}else{
				alert("E-MAIL중복체크를 해주시기 바랍니다.")
			}
		});
		
		$("#cancle").click(function(){
			history.back();
		});
		
		$("#duplicationCheck").click(function(){
			
			var email = $("#email").val();
			
			if(!nullCheck("email", email)){
				return false;
			}
			
			$.ajax({
				type:"POST",
				url:"/member/duplicationCheckAction.do",
				data:{'email':email},
				dataType:"JSON",
				success : function(data) {
					$.each(data, function(key, value){
						if(value == false){
							$("#eMailDupInfo").text("사용가능한 이메일입니다.");
							emailDuplicationCheck = true;
						}else if(value == true){
							$("#eMailDupInfo").text("이미 사용중인 E-MAIL입니다.");
							emailDuplicationCheck = false;
						}
					});
				},
				// 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
				complete : function(data) {
				},
				error : function(xhr, status, error) {
					alert("에러발생");
				}
			});			
		});
		
	});
	</script>

</head>

<body>
	<form id="memberJoinForm">
		<div class="form" id="memberJoinDiv">
			<div class="clear"></div>
				<div class="caption">email</div>
				<div class="userInput"><input type="text" name="email" id="email" value="" maxlength="20" /></div>
				<input type="button" class="btn" id="duplicationCheck" value="중복체크" />
			<div class="clear"></div>
				<div class="caption" id="eMailDupInfo">E-MAIL 중복체크를 해주세요.</div>
			<div class="clear"></div>
				<div class="caption">password</div>
				<div class="userInput"><input type="password" name="pw" id="pw" value="" maxlength="20" /></div>
				<div class="userInput2"><input type="password" id="pwRepeat" value="" maxlength="20" /></div>
			<div class="clear"></div>
				<div class="caption">nickname</div>
				<div class="userInput"><input type="text" name="nick" id="nick" value="" maxlength="20" /></div>
			<div class="clear"></div>
				<input type="button" class="btn" id="joinSubmit" value="확인" />
				<input type="button" class="btn" id="cancle" value="취소" />
		</div>
	</form>
</body>

</html>