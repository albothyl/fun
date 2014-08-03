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
	
	<title>read</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="/include/css/user/userCSS.css">
	<script src="/include/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	
	<script>
	$().ready(function()
	{	
		//Board Button Controll
		$(".search").click(function() {			
			var btnType     = $(this).attr('id');
			var action      = "/board/SHTBoard/list.do";
			
			var subjectCode =  <c:out value="${pageVO.pageSubjectCode}"/>;
			var tradeNo     =  <c:out value="${shtBoard.tradeNo}"/>;
			var writer      = "<c:out value="${shtBoard.email}"/>";
			var method      = "post";

			//update
			if(btnType == "update") {
				action = "/board/SHTBoard/updateForm.do";
			//delete
			}else if(btnType == "delete") {
				action = "/board/SHTBoard/delete.do";
			//list
			}else if(btnType == "list") {
				action  = "/board/SHTBoard/list.do";
				tradeNo = 0;
				method  = "get";
			}
			
			var searchForm  = document.getElementById("searchForm");
			searchForm.action            = action;
			searchForm.method            = method;
			searchForm.subjectCode.value = subjectCode; //게시글 번호
			searchForm.tradeNo.value     = tradeNo;     //게시글 번호
			searchForm.email.value       = writer;      //글쓴이
			searchForm.submit();			
		});
		
		//Reply Button Controll
		$("#replyWriteButton").click(function() {
			var tradeNo     = <c:out value="${shtBoard.tradeNo}"/>;
			var content     = $("#replyContent").val();
			var replyWriter = "<c:out value="${sessionScope.login.email}"/>";
			var replyData   = {'tradeNo':tradeNo, 'content':content, 'email':replyWriter};
			var writeReply;
			
			if(nullCheck('리플내용을', content) == false){
				return false;
			}
						
			$.ajax({
				type: "POST",
				url: "/board/SHTReply/write.do",
				data: replyData,
				dataType:"JSON",
				success : function(data) {
					writeReply = makeReplyForm(eval(data));
					$("#replyList ul").append(writeReply);
				},
				// 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
				complete : function(data) {
					$("#replyContent").val("");
				},
				error : function(data, xhr, status, error, textStatus) {
					//alert("status :(" + status + ") === xhr :(" + xhr + ") === " + data.responseText);
					alert(data.responseText);
				}
			});
		});
	});
	
	$(window).load(function(){
		var Limit = 1103;
		var img = $('body img');
		img.each(function() {
			var imgWidth = $(this).width();
			if (imgWidth > Limit ) {
			   $(this).attr({ width : Limit + "px"});
			};
		});
	});
	
	function replyUpdateForm(repNo) {
		$("#updateToggle").remove();
		
		var content = $("#" + repNo).find(".replyListContent").text();
		var toggleUpdateForm = makeReplyUpdateToggleForm(repNo, content);
		
		$("#" + repNo).hide();
		$("#" + repNo).parent().append(toggleUpdateForm);
	}
	
	function replyUpdate(replyNo) {
		var tradeNo     = <c:out value="${shtBoard.tradeNo}"/>;
		var repNo       = replyNo;
		var content     = $.trim($("#replyUpdateContent").val());
		var replyWriter = $("#"+replyNo).parent().find("span.replyWriter").text();
		var replyData   = {'tradeNo':tradeNo, 'repNo':repNo, 'content':content, 'email':replyWriter};
		
		if(nullCheck('리플내용을', content) == false){
			return false;
		}
				
		$.ajax({
			type: "POST",
			url: "/board/SHTReply/update.do",
			data: replyData,
			dataType:"JSON",
			success : function(data) {				
				updateReply = makeReplyForm(eval(data));
				$(updateReply).insertAfter($("#"+repNo).parents("li"));
				$("#updateToggle").remove();
				$("#"+repNo).parents("li").remove();
			},
			error : function(data, xhr, status, error, textStatus) {
				alert(data.responseText);
			}
		});
	}
	
	function replyCancle(repNo) {
		$("#updateToggle").remove();
		$("#" + repNo).show();
	}
	
	function replyDelete(replyNo) {
		var tradeNo     = <c:out value="${shtBoard.tradeNo}"/>;
		var repNo       = replyNo;
		var replyWriter = $("#"+replyNo).parent().find("span.replyWriter").text();
		var replyData = {'tradeNo':tradeNo, 'repNo':repNo, 'email':replyWriter};
		
		$.ajax({
			type: "POST",
			url: "/board/SHTReply/delete.do",
			data: replyData,
			dataType:"JSON",
			success : function() {
				$("#"+repNo).parents("li").remove();
			},
			error : function(data, xhr, status, error, textStatus) {
				alert(data.responseText);
			}
		});
	}
	
	function makeReplyForm(replyFormDate) {
		var replyForm = 
			"<li>" +
				"<div>" +
					"<div class=\"replyListInfo\">" +
						"<span class=\"replyWriter\">" + replyFormDate['email'] + "</span>" +
						"<span> (" + replyFormDate['createDate'] + ")</span>" +
					"</div>" +					 
					 "<div id=" + replyFormDate['repNo'] + ">" +
						"<div class=\"replyListButton\">" +
							"<span><a href=\"#\" onclick=\"replyUpdateForm(" + replyFormDate['repNo'] + ")\">수정</a>  <a href=\"#\" onclick=\"replyDelete(" + replyFormDate['repNo'] + ")\">삭제</a></span>" +
						"</div>" +
						"<div class=\"replyListContent\">" +
							"<p>" + replyFormDate['content'] + "</p>" +
						"</div>" +
					"</div>" +
				"</div>" +
			"</li>";
			
		return replyForm;
	}
	
	function makeReplyUpdateToggleForm(reoNo, content) {
		var replyUpdateForm = 
			"<div id=\"updateToggle\">" +
				"<div class=\"replyListButton\">" +
					"<span><a href=\"#\" onclick=\"replyUpdate(" + reoNo + ")\">완료</a>  <a href=\"#\" onclick=\"replyCancle(" + reoNo + ")\">취소</a></span>" +
				"</div>" +
				"<div class=\"replyUpdateContent\">" +
					"<textarea id=\"replyUpdateContent\">"+content+"</textarea>" +
				"</div>" +
			"</div>";
			
		return replyUpdateForm;
	}
	
	function nullCheck(where, val){			
		val = $.trim(val);
		if(val.length <= 0){
			alert(where + "을 입력해주시기 바랍니다.");
			return false;
		}
		return true;
	};
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
				<div id="boardScope">
					<table id="boardReadTable">
						<tr>
							<td id="subject" colspan="3">${shtBoard.subject}</td>
							<td id="boardWriter" colspan="2">${shtBoard.email}</td>
							<td id="date" colspan="2">${shtBoard.createDate}</td>
						</tr>
						<tr>
							<td id="boardReadTitle" colspan="7">${shtBoard.title}</td>
						</tr>
						<tr>
							<td height="10"  colspan="7"></td>
						</tr>
						<tr>
							<td id="content" colspan="7">${shtBoard.content}</td>
						</tr>
						<tr>
							<td id="readButton" colspan="7">
								<c:if test="${shtBoard.email == sessionScope.login.email}">
								<input type="button" class="search" id="update" value="글수정">
								<input type="button" class="search" id="delete" value="글삭제">
								</c:if>
								<input type="button" class="search" id="list"   value="목록">
							</td>
						</tr>
					</table>
				</div>
				
				<br/><br/>
			
				<!-- 리플 -->
				<div id="replyScope">
					<c:if test="${sessionScope.login.email != null}">
					<div id="replyWrite">
						<form id="replyWriteForm">
							<textarea wrap="hard" id="replyContent"></textarea>
							<input type="button"  id="replyWriteButton" value="확인"/>
						</form>
					</div>
					</c:if>
					
					<br/>
					
					<div id="replyList">
						<ul>
							<c:forEach var="replyList" items="${replyList}">
							<li>
								<div>
									<div class="replyListInfo">
										<span class="replyWriter">  <c:out value="${replyList.email}"/></span>
										<span> (<c:out value="${replyList.createDate}"/>)</span>
									</div>
									<div id="${replyList.repNo}">
										<div class="replyListButton">
										<c:if test="${replyList.email == sessionScope.login.email}">
											<span>
												<a href="#" onclick="replyUpdateForm(${replyList.repNo})">수정</a>  
											    <a href="#" onclick="replyDelete(${replyList.repNo})">삭제</a>
										    </span>
										</c:if>
										</div>
										<div class="replyListContent">
											<p><c:out value="${replyList.content}"/></p>
										</div>
									</div>
								</div>
							</li>
							</c:forEach>
						</ul>					
					</div>
				</div>
			</div>
			 
			<!-- 페이징 / 검색 -->
			<div id="pagingScope">
				<form:form modelAttribute="pageVO" id="searchForm">
					<form:hidden path="searchType"/>
					<form:hidden path="searchKeyword"/>
					<form:hidden path="pageSubjectCode"/>
					<form:hidden path="selectCnt"/>
					<form:hidden path="pageNo"/>
					<input type="hidden" id="subjectCode" name="subjectCode">
					<input type="hidden" id="tradeNo"     name="tradeNo">
					<input type="hidden" id="email"       name="email">
				</form:form>
			</div>
				
		</div> <!-- end middle -->
		
		<div id="bottom">
			<%@ include file='/include/basicLayout/bottom.jsp'%>
		</div> <!-- end bottom -->
			
	</div>
	
</body>

</html>
