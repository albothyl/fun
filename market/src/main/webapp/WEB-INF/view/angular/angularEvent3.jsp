<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app>

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>Event - CSS2</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	<script>
		function mainCtrl($scope){
			$scope.bgStyle = {
					backgroundColor:'red'					
			};
			$scope.changeColor = function(color){
				$scope.bgStyle.backgroundColor = color;
			};
		}
	</script>
</head>

<body ng-controller="mainCtrl">
	<div ng-style="bgStyle">{{bgStyle.backgroundColor}}</div>
	<button ng-click="changeColor('yellow')">색 변경</button>
</body>

</html>