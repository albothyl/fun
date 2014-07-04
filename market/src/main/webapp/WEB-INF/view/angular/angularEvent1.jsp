<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app>

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>Event - Common</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	<style type="text/css">
		.box{
			width: 100px;
			height: 60px;
			margin: 10px;
			background-color: black;
			color: white;
			text-align: center;
			padding-top: 40px;
		}
	</style>
	
	<script>
		function mainCtrl($scope){
			$scope.message = "";
			$scope.eventCnt = 0;
			$scope.handleEvt = function(message){
				$scope.message = message;
				$scope.eventCnt++;
			}
		}
	</script>
</head>

<body ng-controller="mainCtrl">
	<div>
		<div class="box" ng-click="handleEvt('박스 click 이벤트 발생')">click</div>
		<div class="box" ng-mousedown="handleEvt('박스 mouseDown 이벤트 발생')">mouseDown</div>
		<div class="box" ng-mouseenter="handleEvt('박스 mouseDown 이벤트 발생')">mouseenter</div>
		<div class="box" ng-mousemove="handleEvt('박스 mouseDown 이벤트 발생')">mousemove</div>
		change : <input type="text" ng-model="inputText" ng-change="handleEvt('입력 박스의 값이 변경 되었습니다.')">
		keydown : <input type="text" ng-model="inputText2" ng-keydown="handleEvt($event.keyCode + '키코드 눌러짐')">
	</div>
	<div>
		<p>{{message}} {{eventCnt}}</p>
	</div>
</body>

</html>