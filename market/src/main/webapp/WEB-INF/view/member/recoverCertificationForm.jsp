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

	<title>recoverPassword</title>

	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="/include/css/user/userCSS.css">
	<script src="/include/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	<script src="/include/javaScript/user/memberValidationCheck.js"></script>
	
	<script>
	var certificationCheck = false;
	
	$(document).ready(function()
	{
		$("#certificationInfo").text("email을 입력하시고 인증키 요청버튼을 눌러주시기 바랍니다.");
		
		$("#recoverSubmit").click(function(){
			if(certificationCheck){
				if(recoverFormValidationCheck()){
					var recoverForm    =  document.getElementById("memberRecoverForm");
					recoverForm.action = "/member/recoverPw.do";
					recoverForm.method = "POST";
					recoverForm.submit();
				}
			}else{
				alert("입력하신 E-MAIL로 인증키를 요청해 주시기 바랍니다.");
			}
		});
		
		$("#cancle").click(function(){
			history.back();
		});
		
		$("#requestCertificationKey").click(function(){
			
			var email = $("#email").val();
			
			if(!emailCheck()){
				return false;
			}
			
			$.ajax({
				type:"GET",
				url:"/member/sendCertificationKey.do",
				data:{'email':email},
				dataType:"JSON",
				success : function(data) {
					$.each(data, function(key, value){
						alert("key :" + key + " | value : " + value);
						if(value == true){
							$("#certificationInfo").text("인증키를 입력하신 email로 전송했습니다. 인증키를 확인하시고 입력해 주시기 바랍니다.");
							certificationCheck = true;
							//each문을 빠져나가기 위함 return false;
							return false;
						}else{
							certificationCheck = false;
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
					certificationCheck = false;
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
			<%@ include file='/include/basicLayout/leftSideMeneBar.jsp'%>
			
			<div id="main">
				<h1>recoverForm</h1>
				
				${certification.resultMessage}
				<br/>
				
				<div>					
					<div>
						<form:form modelAttribute="certification" id="memberRecoverForm">
						<fieldset>
						<legend> password 찾기 </legend>
							<form:label  path="email" id="certificationInfo"></form:label>
							<p>					
								<form:label  path="email" cssErrorClass="errorMessage">email : </form:label>
								<form:input  path="email" id="email" size="30"/>
								<input type="button" class="btn" id="requestCertificationKey" value="인증키 요청" />
								<br/>
								<form:errors path="email" cssClass="errorMessage" />
							</p>
							
							<p>
								<form:label  path="randomKey" cssErrorClass="errorMessage">인증번호 : </form:label>
								<input type="number" id="randomKey" name="randomKey" maxlength="30" />
								<br/>
								<form:errors path="randomKey" cssClass="errorMessage" />
							</p>
							
							<p>
								<input type="button" class="btn" id="recoverSubmit" value="확인" />
								<input type="button" class="btn" id="cancle" value="취소" />
							</p>
						</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div> <!-- end middle -->
		
		<div id="bottom">
			<%@ include file='/include/basicLayout/bottom.jsp'%>
		</div> <!-- end bottom -->
		
	</div>
	
</body>

</html>