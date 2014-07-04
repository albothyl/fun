<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app>

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>Scope - Level :: 2</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	<style>
		.ng-scope {
			border: 1px solid red;
			padding: 5ps;
		}
		.msg-list-area {
			margin: 10px;
			height: 400px;
			border: 1px solid black;
		}
	</style>
	<script>
		function mainCtrl($scope){
			$scope.broadcast = function(noticeMsg){
				$scope.$broadcast("chat:noticeMsg", noticeMsg);
				$scope.noticeMsg = "";
			};
		}
		
		function chatMsgListCtrl($scope, $rootScope){
			$scope.msgList = [];
			$rootScope.$on("chat:newMsg", function(e, noticeMsg){
				$scope.msgList.push(newMsg);
			});
			
			$scope.$on("chat:notice", function(e, noticeMsg){
				$scope.msgList.push("[공지]" + noticeMsg);
			});
		}
		
		function chatMsgInputCtrl($scope){
			$scope.submit = function(newMsg){
				$scope.$emit("chat:newMsg", newMsg);
				$scope.newMsg = "";
			};
		}
	</script>
</head>

<body ng-controller="mainCtrl">
	<input type="text" ng-model="noticeMsg">
	<input type="button" value="공지 전송" ng-click="broadcast(noticeMsg)">
	<div class="msg-list-area" ng-controller="chatMsgListCtrl">
		<ul>
			<li ng-repeat="msg in msgList track by $index">{{msg}}</li>
		</ul>
	</div>
	<div ng-controller="chatMsgInputCtrl">
		<input type="text" ng-model="newMsg">
		<input type="button" value="전송" ng-click="submit(newMsg)">
	</div>
</body>

</html>