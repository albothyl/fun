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

	<title>Spring managementForm</title>

	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="/include/css/user/userCSS.css">
	<script src="/include/javaScript/jQuery/jquery-2.1.1.min.js"></script>	
	<script src="/include/javaScript/user/memberValidationCheck.js"></script>
	<script>
	function cancle(){
		history.back();
	};
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
				<h1>managementForm</h1>	
				<br/>
				<div>
					<a href="/member/memberUpdateForm.do">회원정보 수정</a>
					<a href="/member/memberSecede.do">회원 탈퇴</a>
					<a style="cursor:pointer;" onclick="cancle()">취소</a>					
				</div>
				
			</div>
		</div> <!-- end middle -->
		
		<div id="bottom">
			<%@ include file='/include/basicLayout/bottom.jsp'%>
		</div> <!-- end bottom -->
		
	</div>
	
</body>

</html>