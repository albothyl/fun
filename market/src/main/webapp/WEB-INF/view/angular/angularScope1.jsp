<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app>

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>Scope - Level</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	
	<script>
		function parentCtrl($scope){
			$scope.parent = {name:"parent Kim"};
		}
		
		function childCtrl($scope){
			$scope.child = {name:"child Ko"};
			$scope.changeParentName = function(){
				$scope.parent.name = "another kim";
			};
		}
	</script>

</head>

<body>
	<div ng-controller="parentCtrl">
		<h1>부모 이름 : {{parent.name}}</h1>
		
		<div ng-controller="childCtrl">
			<h2>부모 이름 : {{parent.name}}</h2>
			<h2>자식 이름 : {{child.name}}</h2>
			<button ng-click="changeParentName()">부모이름 변경</button>
		</div>
	</div>
</body>

</html>