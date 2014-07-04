<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app>

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>Show_Hide</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>	
</head>

<body> 
	동의 여부 : <input type="checkbox" ng-model="checked" ng-init="checked=false" />
	<br/>
	<div>
		<span ng-show="checked">
			다음으로 진행합니다. <button>계속</button> 
		</span>
	</div>
	<div>
		<span ng-hide="checked">
			다음으로 진행할 수 없습니다.
		</span>
	</div>	
</body>

</html>