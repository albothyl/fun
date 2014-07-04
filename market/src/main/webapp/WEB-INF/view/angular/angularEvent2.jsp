<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app>

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>Event - CSS1</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	<style type="text/css">
	.apple{
		background-color: red;			
	}
	.lemon{
		background-color: yellow;
	}
	.even{
		background-color: blue;
	}
	</style>
</head>

<body>
	<div ng-init="fruitList = ['apple', 'banana', 'tomato', 'lemon', 'grape']">
		<ul>
			<li ng-repeat="fruit in fruitList" ng-class="'{{fruit}}'">{{fruit}}</li>
		</ul>
		<ul>
			<li ng-repeat="fruit in fruitList" ng-class="{'even':{{$index%2==0}}}">{{fruit}}</li>
		</ul>
	</div>
</body>

</html>