<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.project.common.system.globalCode.defineCode"%>
<script src="/include/javaScript/jQuery/jquery-2.1.1.min.js"></script>
<script>
$().ready(function()
{
	var menuList = eval(localStorage.getItem("menuList"));
	
	//리플이 HTML5 저장소에 없으면 ajax로 가져온다.
	if(menuList == null) {
		getMenuListFromServer();
	//리플이 HTML5 저장소에 있으면 가져와서 리스팅해준다.
	}else{		
		setMenuListToUl(menuList);
	}
});

function getMenuListFromServer() {
	$.ajax({
		type: "GET",
		url: "/code/menuList.do",
		dataType:"JSON",
		success : function(data) {
			setMenuListToUl(eval(data));
			localStorage.setItem("menuList", JSON.stringify(eval(data)));			
		},
		// 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
		complete : function(data) {
		},
		error : function(data, xhr, status, error, textStatus) {
			alert(data.responseText);
		}
	});
}

function setMenuListToUl(menuListData) {
	var menuData = "";
	
	for(var i=0; i<menuListData.length; i++) {
		menuData = menuData + makeMenuListCode(menuListData[i]);
	}				
	$("#menuList").append(menuData);
}

function makeMenuListCode(menuListData) {
	var menuData = ""; 
	
	if(menuListData['key2'] < 1000) {
		menuData = 
		"<br/><p><label>"+ menuListData['value'] +"</label></p>" +
		"<p><a href=\"#\" onclick=\"list("+ menuListData['key2'] +")\">"+ menuListData['value'] +"게시판</a></p>";
	}else {
		menuData = 
		"<li><a href=\"#\" onclick=\"list("+ menuListData['key2'] +")\">"+ menuListData['value'] +"</a></li>";
	}
	return menuData;
		
}
	
function list(subjectCode) {	
	var menuForm  = document.getElementById("menuForm");
	menuForm.action = "/board/SHTBoard/list.do";
	menuForm.method = "get";
	menuForm.pageId.value  = subjectCode;
	menuForm.pageCnt.value = <%=defineCode.MENU_PAGE_CNT%>;
	menuForm.pageNum.value = <%=defineCode.MENU_PAGE_NUM%>;
	menuForm.submit();			
}
</script>

<div id="leftMenuBar">			
	<ul id="menuList">
	</ul>
	
	<div>
		<form id= "menuForm">
			<input type= "hidden" id="pageId"  name ="pageSubjectCode" />
			<input type= "hidden" id="pageCnt" name ="selectCnt" />
			<input type= "hidden" id="pageNum" name ="pageNo" />
		</form>
	</div>
</div>
