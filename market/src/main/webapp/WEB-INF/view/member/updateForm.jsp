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

	<title>update</title>

	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="/include/css/user/userCSS.css">
	<script src="/include/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	<script src="/include/javaScript/user/memberValidationCheck.js"></script>

	<script>
	$().ready(function()
	{
		$("#updateSubmit").click(function(){
			if(updateFormValidationCheck()){
				var updateForm    =  document.getElementById("memberUpdateForm");
				updateForm.action = "/member/memberUpdate.do";
				updateForm.method = "POST";
				updateForm.submit();
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
			<%@ include file='/include/basicLayout/leftSideMenuBar.jsp'%>
			
			<div id="main">
				<h1>updateForm</h1>
				
				<div class="user">
					<p><strong>${login.email}</strong> 님 반갑습니다</p>
					로그아웃 하시려면 <a href="/member/logout.do">로그아웃</a>을 클릭해 주시기 바랍니다.
				</div>
				
				<br/>
				
				<div>
					<form:form modelAttribute="member" id="memberUpdateForm">
					<fieldset>
					<legend> 회원정보 수정 </legend>
						<p>
							<form:label  path="email" cssErrorClass="errorMessage">email : ${member.email}</form:label>
						</p>
						<p>
							<form:label  path="pw" cssErrorClass="errorMessage">password : </form:label>
							<form:password  path="pw" id="pw" size="30"/>
							<br/>
							<form:errors path="pw" cssClass="errorMessage" />
						</p>
						<p>
							<form:label  path="nick" cssErrorClass="errorMessage">nickname : </form:label>
							<form:input  path="nick" id="nick" size="30"/>
							<br/>
							<form:errors path="nick" cssClass="errorMessage" />
						</p>
						<p>
							<input type="button" class="btn" id="updateSubmit" value="확인" />
							<input type="button" class="btn" id="cancle" value="취소" />
						</p>
						<form:hidden path="email"/>
						<form:hidden path="grade"/>
					</fieldset>
					</form:form>	
				</div>
			</div>
		</div> <!-- end middle -->
		
		<div id="bottom">
			<%@ include file='/include/basicLayout/bottom.jsp'%>
		</div> <!-- end bottom -->
		
	</div>
	
</body>

</html>