<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app>

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>Binding</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	
	<script>
	function mainCtrl($scope){
		var menuList = [ {itemId : 1, itemName : '센드위치', itemPrice : 2000, itemCount : 0}
		               , {itemId : 2, itemName : '아메리카노', itemPrice : 1000, itemCount : 0}
		               , {itemId : 3, itemName : '카푸치노', itemPrice : 1500, itemCount : 0} ]
		
		$scope.menuList = menuList;
		$scope.totalPrice = 0;
		
		$scope.buy = function(){
			$scope.totalPrice = 0;
			
			angular.forEach($scope.menuList, function(menu, idx){
				$scope.totalPrice = $scope.totalPrice + (menu.itemPrice * Number(menu.itemCount));
			});
		};		
	}
	</script>

</head>

<body ng-controller="mainCtrl">
	<div>
		<h1>메뉴판</h1>
		<h2>메뉴 목록</h2>
		<table>
			<thead>
				<tr>
					<th>메뉴</th>
					<th>가격</th>
					<th>갯수</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="menu in menuList">
					<td>{{menu.itemName}}</td>
					<td>{{menu.itemPrice}}</td>
					<td><input type="text" ng-model="menu.itemCount"></td>
				</tr>
			</tbody>
		</table>
		<button ng-click="buy()">구매</button>
		<h2>구입 가격</h2>
		<div>
			가격 : {{totalPrice}}
		</div>		
	</div>
</body>

</html>