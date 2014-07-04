<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app>

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>Validation2 - CheckBox</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>

</head>

<body>
	<form name="sampleForm" ng-init="value1 = true; value2 = '좋다';">
		선택 1 : <input type="checkbox" name="check1" ng-model="value1">
		<br/>
		선택 2 : <input type="checkbox" name="check2" ng-model="value2" ng-true-value="좋다" ng-false-value="싫다">
		<br/>
		<p>선택 1의 바인딜된 값 : {{value1}}</p>
		<p>선택 2의 바인딜된 값 : {{value2}}</p>
	</form>
</body>

</html>