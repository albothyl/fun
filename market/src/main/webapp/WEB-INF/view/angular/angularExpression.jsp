<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app>

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>Expression</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>
</head>

<body ng-init="person = { name : '재도', favorite : ['사과', '딸기', '포도']}">
	<h1>Hello {{person.name}}</h1>
	<p>좋아하는 과일의 갯수 : {{numberOfFavorite = person.favorite.length}}</p>
	<p>과일 갯수 * $100 = {{numberOfFavorite * 100 | currency}}</p>
	<p>재도가 맞나요? {{person.name == '재도'}}</p>
	<p>좋아하는 과일 수가 4개보다 많나요? {{numberOfFavorite > 4}}</p>
	<p>scope에 없는 객체 접근 하면? {{car.type.name}}</p>	
</body>

</html>