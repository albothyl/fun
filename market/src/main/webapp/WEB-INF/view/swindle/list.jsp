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
	
	<title>Swindle List</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="/include/css/user/userCSS.css">
	<script src="/include/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	
	<script>
	$().ready(function()
	{
		/*
		1. 첫 사기꾼 검색페이지 호출시 
		    - 검색창만 보여줄 것인가? (o)
		    - 최신 사기꾼 리스트를 보여줄 것인가?
		2. 계좌번호, 전화번호, 거래자 입력후 검색시 
			- ajax로 처리할 것인가? (o)
			- sumit으로 처리할 것인가?
		3. 더 보기는 ajax로 처리하도록 (o)
		
		4. 자료검색시 이전 검색어와 서버로 요청할 검색어를 비교해서 틀리면 pageNo를 1로 변경.
		       이는 거래자 xxx에서 더보기 4번 누른 상태(pageNo=5)에서 다른 타입이나 거래자를
		       입력하여 새롭게 검색할 때 pageNo가 유지되지 않고 새로운 1 페이지의 정보를 불러오기 위함
		
		5. 사기정보 읽기나 사기정보 쓰기기능은 submit으로
		
		6. ajax로 처리시 form 생성 function이 필요함
		
		7. 더 보기 버튼은 최조 리스트 요청시 맨 밑에 붙고, 더 보기요청후에 기존 더 보기 버튼을 제거하고
		       추가된 리스트 맨 밑에 추가한다. 또 리스트의 갯수가 selectCnt보다 작을 경우 정보가 더 없
		       다고 알린다.
		*/
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
				<div>
				
					<br/><br/>
					
					<div>
						<form:form modelAttribute="pageVO" id="searchForm">
							
							<legend>사기꾼 검색</legend>
							
							<form:select path="searchType" id="searchType">
								<form:options items="${codeList}" itemValue="key2" itemLabel="value" />
							</form:select>
							<form:input path="searchKeyword" id="searchKeyword" rows="1" cols="40" />							
							<input type="button" class="search" id="search" value="검색" />
							<form:hidden path="selectCnt"/>
							<input type="hidden" id="pageNo"    name="pageNo" />
							<input type="hidden" id="swindleNo" name="swindleNo" />
						</form:form>
					</div>
				</div>
				
				<div>					
					<ul id="swindleList"></ul>
					
					<!-- paging -->
					<c:if test="${pageVO.pageNo > 1}">
					<input type="button" class="search" id="morePage" value="더 보기" />
					</c:if>
				</div>
			</div>
		</div> <!-- end middle -->
		
		<div id="bottom">
			<%@ include file='/include/basicLayout/bottom.jsp'%>
		</div> <!-- end bottom -->
			
	</div>
	
</body>

</html>
