<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app>

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>Controller</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	<script>
	function customerCtrl($scope){
		var customerList = [ {name : '영희', age : 10}
		                   , {name : '순희', age : 28} ];
		var youngCusterList = [];
		
		angular.forEach(customerList, function(value, key){
			if(value.age < 19){
				youngCusterList.push(value);
			}
		});
		
		$scope.customerList = customerList;
		$scope.youngCusterList = youngCusterList;
	}
	</script>
</head>

<body ng-controller="customerCtrl"> 
	<div>
		고객목록
		<ul>
			<li ng-repeat="customer in customerList">
				[{{$index + 1}}] 고객 이름 : {{customer.name}}, 고객 나이 : {{customer.age}}
			</li>
		</ul>
	</div>
	<div>
		18세 미만 고객
		<ul>
			<li ng-repeat="youngCuster in youngCusterList">
				[{{$index + 1}}] 고객 이름 : {{youngCuster.name}}, 고객 나이 : {{youngCuster.age}}
			</li>
		</ul>
	</div>
</body>

</html>