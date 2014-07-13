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
	
	<title>wirteForm</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/user/userCSS.css">
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	<script src="/include/openAPI/editor/SE2/js/HuskyEZCreator.js"></script>
	
	<script>
	$(document).ready(function()
	{
		//SMART EDITOR LOADING
		var oEditors = [];		
		nhn.husky.EZCreator.createInIFrame({	
	    oAppRef: oEditors,	
	    elPlaceHolder: "ir1",	
	    sSkinURI: "/include/openAPI/editor/SE2/SmartEditor2Skin.html",	
	    fCreator: "createSEditor2"});
		
		//SMART EDITOR WRITE
		$("#btn_seWrite").click(function() {	
			oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
			
			var writeForm    =  document.getElementById("");
	    	writeForm.action = "";
	    	writeForm.method = "post";
	    	writeForm.writer.value = ""; //향후 로그인기능 추가후 세션처리
	    	writeForm.subjectCode.value = ""; //게시판 구분코드
	    	writeForm.submit();
		});
		
		//CANCLE
		$("#btn_cancle").click(function() {			
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
				<!-- 스마트에디터 -->
				<!-- 이슈 :: 이미지 저장경로 및 reflash -->
				<!-- 향후 업로드한 파일 다운로드 폼 코딩 -->
				<form id="writeForm">		
					<table id="boardTable">
						<tr>
							<td height="20"></td>
						</tr>
						<tr>
							<td><input type="text" maxlength="50" name="title" style="width:815px"/></td>
						</tr>
						<tr>
							<td height="10"></td>
						</tr>
						<tr>
							<td>
								<textarea name="content" id="ir1" rows="20" cols="100"></textarea>
							</td>
						</tr>
						<tr>
							<td height="5"></td>
						</tr>
						<tr>
							<td align="right">
								<input type="button" id="btn_seWrite" class="button"     value="글쓰기"/>
								<input type="button" id="btn_cancle"  class="button"     value="취소"/>
								<input type="hidden" id="subjectCode" name="subjectCode"/>
								<input type="hidden" id="writer"      name="writer"/>
							</td>
						</tr>
					</table>
				</form>	
				<!-- 스마트에디터 end -->
			</div>
		</div> <!-- end middle -->
		
		<div id="bottom">
			<%@ include file='/include/basicLayout/bottom.jsp'%>
		</div> <!-- end bottom -->
			
	</div>
	
</body>

</html>
