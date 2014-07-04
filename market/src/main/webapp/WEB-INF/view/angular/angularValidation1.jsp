<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app>

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>Validation1 - Common</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>

</head>

<body>
	<form name="sampleForm" ng-init="name = '철수'">
		이름 : <input type="text" name="name" ng-model="name" ng-maxlength="3" ng-required="true">
		<span class="error" ng-show="sampleForm.name.$error.required">필수입력</span>
		<br/>
		핸드폰 번호 : <input type="text" name="tel" ng-model="tel" ng-pattern="/^\d{3}-\d{3,4}-\d{4}$/">
		<span class="error" ng-show="sampleForm.tel.$error.required">000-0000-0000</span>
		<br/>
		<p>사용자 정보 : {{name}}/{{tel}}</p>
		<p>sampleForm.name.$valid = {{sampleForm.name.$valid}}</p>
		<p>sampleForm.name.$error = {{sampleForm.name.$error}}</p>
		<p>sampleForm.tel.$valid = {{sampleForm.tel.$valid}}</p>
		<p>sampleForm.tel.$error = {{sampleForm.tel.$error}}</p>
		<p>sampleForm.$valid = {{sampleForm.$valid}}</p>
		<p>sampleForm.$error.required = {{sampleForm.$error.required}}</p>		
	</form>
</body>

</html>