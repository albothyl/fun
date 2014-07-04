<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app>

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>Validation3 - CSS</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	<style type="text/css">
		.ng-invalid{
			border:3px solid red;
		}
		.ng-valid{
			border:3px solid green;
		}
		.ng-pristin{
			border-style:solid;
		}
		.ng-dirty{
			border-style:dashed;
		}
	</style>
</head>

<body>
	<form name="sampleForm" ng-init="name='철수'">
		이름 : <input type="text" name="name" ng-model="name" ng-maxlength="3" ng-required="true">
		핸드폰 번호 : <input type="text" name="tel" ng-model="tel" ng-pattern="/^\d{3}-\d{3,4}-\d{4}$/">
	</form>
</body>

</html>