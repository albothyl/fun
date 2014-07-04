<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app>

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>Validation3 - SelectBox(DropdownBox)</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>

</head>

<body>
	<div ng-init="countryList = [ {name:'한국',code:'KR',continent:'아시아'}
	                            , {name:'일본',code:'jr',continent:'아시아'}
	                            , {name:'미국',code:'en',continent:'북미'} ]">
		<form name="myRouteForm">
			<div>
				출발 국가 : 
				<select ng-model="depCountry" ng-options="country.name for country in countryList" ng-required="true">
					<option value="">선택하여 주세요</option>
				</select>
			</div>
			<div>
				경유 국가 : 
				<select ng-model="viaCountry" ng-options="country.name as country.name for country in countryList">
					<option value="">선택하여 주세요</option>
				</select>
			</div>
			<div>
				도작 국가 : 
				<select ng-model="arrCountry" ng-options="country.name group by country.continent for country in countryList" ng-required="true">
					<option value="">선택하여 주세요</option>
				</select>
			</div>
		</form>
		<div>
			<p>출발 국가 : {{depCountry.name}}</p>
			<p>경유 국가 : {{viaCountry}}</p>
			<p>도착 국가 : {{arrCountry.name}}</p>
		</div>
		<div ng-show="myRouteForm.$invalid">
			출발 국가와 도착 국가는 필히 선택해 주세요.
		</div>
	</div>
</body>

</html>