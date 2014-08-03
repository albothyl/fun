<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>

<html lang="ko">

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>joinForm</title>

	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="/include/css/user/userCSS.css">
	<script src="/include/javaScript/jQuery/jquery-2.1.1.min.js"></script>	
	<script src="/include/javaScript/user/memberValidationCheck.js"></script>
	
	<script>
	var emailDuplicationCheck = false;

	$().ready(function()
	{	
		$("#eMailDupInfo").text("E-MAIL 중복체크를 해주시기 바랍니다.");
		
		$("#joinSubmit").click(function(){
			if(emailDuplicationCheck){
				if(joinFormValidationCheck()){
					var joinForm    =  document.getElementById("memberJoinForm");
					joinForm.action = "/member/joinCertify.do";
					joinForm.method = "POST";
					joinForm.grade.name = "grade";
					joinForm.grade.value = 1;
					joinForm.submit();
				}
			}else{
				alert("E-MAIL중복체크를 해주시기 바랍니다..");
			}
		});
		
		$("#cancle").click(function(){
			history.back();
		});
		
		$("#duplicationCheck").click(function(){
			
			var email = $("#email").val();
			
			if(!emailCheck()){
				return false;
			}
			
			$.ajax({
				type:"GET",
				url:"/member/duplicationCheck.do",
				data:{'email':email},
				dataType:"JSON",
				success : function(data) {
					$.each(data, function(key, value){
						if(value == false){
							$("#eMailDupInfo").text("사용가능한 이메일입니다.");
							emailDuplicationCheck = true;
							//each문을 빠져나가기 위함 return false;
							return false;
						}else if(value == true){
							$("#eMailDupInfo").text("이미 사용중인 E-MAIL입니다.");
							emailDuplicationCheck = false;
							//each문을 빠져나가기 위함 return false;
							return false;
						}
					});
				},
				// 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
				complete : function(data) {
				},
				error : function(xhr, status, error) {
					alert("에러발생");
					emailDuplicationCheck = false;
				}
			});			
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
			<%@ include file='/include/basicLayout/leftSideMenuBar.jsp'%>
			
			<div id="main">
				<h1>joinForm</h1>
					${member.resultMessage}
					
					<form:form modelAttribute="member" id="memberJoinForm">
					<fieldset>
					<legend> 회원 가입 </legend>
						<p>
							<form:label  path="email" cssErrorClass="errorMessage">email : </form:label>
							<form:input  path="email" id="email" size="30"/>
							<input type="button" class="btn" id="duplicationCheck" value="중복체크" />
							<form:label  path="email" id="eMailDupInfo"></form:label>
							<br/>
							<form:errors path="email" cssClass="errorMessage" />
						</p>
						<p>
							<form:label  path="pw" cssErrorClass="errorMessage">password : </form:label>
							<form:password  path="pw" id="pw" size="30"/>
							<input type="password" id="pwRepeat" maxlength="30" />
							<br/>
							<form:errors path="pw" cssClass="errorMessage" />
						</p>
						<p>
							<form:label  path="nick" cssErrorClass="errorMessage">nickname : </form:label>
							<form:input  path="nick" size="30"/>
							<br/>
							<form:errors path="nick" cssClass="errorMessage" />
						</p>
						<p>
							<input type="button" class="btn" id="joinSubmit" value="확인" />
							<input type="button" class="btn" id="cancle" value="취소" />
						</p>
						<form:hidden path="grade" id="grade"/>
					</fieldset>
					</form:form>
			</div>
		</div> <!-- end middle -->
		
		<div id="bottom">
			<%@ include file='/include/basicLayout/bottom.jsp'%>
		</div> <!-- end bottom -->
		
	</div>
	
</body>

</html>