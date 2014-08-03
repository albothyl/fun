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

	<title>joinCertify</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="/include/css/user/userCSS.css">
	<script src="/include/javaScript/jQuery/jquery-2.1.1.min.js"></script>	
	<script src="/include/javaScript/user/memberValidationCheck.js"></script>
	
	<script>
	$().ready(function()
	{
		$("#certifyKeySubmit").click(function(){
			var randomKey = $("#randomKey").val();
			
			if(nullCheck("인증번호", randomKey)){
				var certifyForm    =  document.getElementById("memberCertifyForm");
				certifyForm.action = "/member/joinCertified.do";
				certifyForm.method = "POST";
				certifyForm.submit();
			}
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
				<h1>certifyForm</h1>
							
				<form:form modelAttribute="certification" id="memberCertifyForm">
				<legend> 회원 가입 </legend>
					<p>
						<form:label  path="email" cssErrorClass="errorMessage">
							${certification.email}으로 인증번호를 발송하였습니다.<br/>		
							이메일로 전송된 인증번호를 아래에 입력해주시기 바랍니다.
						</form:label>
					</p>
					
					<p>
						<form:label  path="randomKey" cssErrorClass="errorMessage">인증번호 : </form:label>
						<input type="number" id="randomKey" name="randomKey" maxlength="30" />
						<br/>
						<form:errors path="randomKey" cssClass="errorMessage" />
					</p>
					
					<p>
						 <input type="button" class="btn" id="certifyKeySubmit" value="확인" />
					</p>
					<form:hidden path="email"/>
				</form:form>
			</div>
		</div> <!-- end middle -->
		
		<div id="bottom">
			<%@ include file='/include/basicLayout/bottom.jsp'%>
		</div> <!-- end bottom -->
		
	</div>
	
</body>

</html>