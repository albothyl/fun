<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app>

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>Switch</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	<style type="text/css">
		.box{
			width:100px;
			height:100px;
		}
		.red{
			background-color:red;
		}
		.green{
			background-color:green;
		}
		.blue{
			background-color:blue;
		}
		.black{
			background-color:black;
		}
	</style>
</head>

<body> 
	<div>
		<input type="radio" ng-model="color" value="red">빨간색 <br/>
		<input type="radio" ng-model="color" value="green">녹색 <br/>
		<input type="radio" ng-model="color" value="blue">파란색 <br/>
		
		<div ng-switch="color">
			<div ng-switch-when="red"     class="box red"></div>
			<div ng-switch-when="green"   class="box green"></div>
			<div ng-switch-when="blue"    class="box blue"></div>
			<div ng-switch-when="default" class="box black"></div>
		</div>
	</div>
</body>

</html>