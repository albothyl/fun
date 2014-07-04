<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app>

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>Repeat</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	
</head>

<body> 
	<div ng-init="customerList = [ {name : '영희', age : 25}, {name : '순희', age : 28}]">
	고객목록
		<ul>
			<li ng-repeat="customer in customerList">
				[{{$index + 1}}] 고객 이름 : {{customer.name}}, 고객 나이 : {{customer.age}}
			</li>
		</ul>
	</div>
	<div ng-init="myFriend = {name : '철수', age : 25, hobby : '축구'}">
	내 친구 소개
		<ul>
			<li ng-repeat="(attr, value) in myFriend">
				<p>{{attr}} : {{value}}</p>
			</li>
		</ul>
	</div>
	
 	<div ng-init="customerList = [ {name : '영희', age : 25}, {name : '순희', age : 28}]">
	고객목록
		<ul ng-repeat="customer in customerList">
			<ui ng-repeat="(attr, value) in customer">
				<p>{{attr}} : {{value}}</p>
			</ui>
		</ul>
	</div>
</body>

</html>