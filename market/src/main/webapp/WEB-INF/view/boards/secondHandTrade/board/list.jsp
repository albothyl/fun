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
	
	<title>list</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="/include/css/user/userCSS.css">
	<script src="/include/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	
	<script>
	$().ready(function()
	{
		$(".search").click(function() {
			var action      = "/board/SHTBoard/list.do";			
			var pageNo      = <c:out value="${pageVO.pageNo}"/>;
			var subjectCode = <c:out value="${pageVO.pageSubjectCode}"/>;
			var tradeNo     = 0;
						
			var btnType = $(this).attr('id');
			
			//beforePage
			if(btnType == "beforePage") {
				pageNo -= 1;
			//afterPage
			}else if(btnType == "afterPage") {
				pageNo += 1;
			//firstPage
			}else if(btnType == "firstPage") {
				pageNo  = 1;
			//read
			}else if(btnType == "read") {
				action  = "/board/SHTBoard/read.do";
				tradeNo = $(this).children().attr('id');
			//writeForm	
			}else if(btnType == "writeForm") {
				action  = "/board/SHTBoard/writeForm.do";	
			}
			
			var searchForm               = document.getElementById("searchForm");
			searchForm.action            = action;
			searchForm.method            = "get";
			searchForm.subjectCode.value = subjectCode;
			searchForm.pageNo.value      = pageNo;  //페이지 번호
			searchForm.tradeNo.value     = tradeNo; //게시글 번호
						
			searchForm.submit();			
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
				<!-- 실제 코딩부 -->				
				<table id="boardListTable">
				<tr>
					<td>거래</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일</td>					
				</tr>
				
				<c:forEach var="boardList" items="${pageVO.listInfo}">
				<tr>
					<td id="status"><c:out value="${boardList.writeStatus}"/></td>
					<td class="search" id="read">					
						<div class="boardListTitle" id="${boardList.writeNo}">
							<c:out value="${boardList.title} [${boardList.replyCnt}]"/>
						</div>
					</td>
					<td>
						<div class="boardWriter">
							<c:out value="${boardList.writer}"/>
						</div>
					</td>
					<td id="date"><c:out value="${boardList.writeDate}"/></td>
				</tr>
				</c:forEach>						
				</table>
				
				<div id="writeBtn">
					<c:if test="${sessionScope.login.email != null}">
					<input type="button" class="search" id="writeForm" value="글쓰기" />
					</c:if>
				</div>
				
				<br/><br/>
				
				<!-- 페이징 / 검색 -->
				<div>
					<form:form modelAttribute="pageVO" id="searchForm">
						<c:if test="${pageVO.pageNo > 1}">
						<input type="button" class="search" id="beforePage" value="이전 페이지" />
						<input type="button" class="search" id="firstPage"  value="처음으로" />
						</c:if>
						<input type="button" class="search" id="afterPage"  value="다음 페이지" />
						
						<br/><br/>
						
						<fieldset>
						<legend></legend>
						<form:select path="searchType" id="searchType">
							<form:options items="${codeList}" itemValue="key2" itemLabel="value" />
						</form:select>
						<form:input path="searchKeyword" id="searchKeyword" rows="1" cols="20" />
						
						<input type="button" class="search" id="search" value="검색" />
						<form:hidden path="pageSubjectCode"/>
						<form:hidden path="selectCnt"/>
						<input type="hidden" id="subjectCode" name="subjectCode" />
						<input type="hidden" id="pageNo"      name="pageNo" />
						<input type="hidden" id="tradeNo"     name="tradeNo" />
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
