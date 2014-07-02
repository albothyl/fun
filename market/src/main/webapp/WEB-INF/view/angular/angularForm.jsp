<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app>

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>Form</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	
	<script>
	var todoList = [ { done : true,  title : "AngularJS 독서"}
	               , { done : false, title : "AngularJS 공부하기"}
	               , { done : false, title : "AngularJS 프로젝트 구성"} ];
	
	function todoCtrl($scope){
		
		$scope.todoList = todoList;
		
		$scope.addNewTodo = function(newTitle){
			todoList.push({done : false, title : newTitle});
			$scope.newTitle = '';
		};
		
		$scope.archive = function(){
			for(var i = $scope.todoList.length - 1; i >= 0; i--){
				if($scope.todoList[i].done){
					$scope.todoList.splice(i, 1);
				}
			};
		};
		
		$scope.remain = function(){
			var remainCount = 0;
			angular.forEach($scope.todoList, function(value, key){
				if(value.done == false){
					remainCount++;
				}
			});
			return remainCount;
		};
		
	};
	</script>

</head>

<body class="well" ng-controller="todoCtrl">
	<h1>{{appName}}</h1>
	<p>전체 할 일 <strong>{{todoList.length}}</strong>개 / 남은 할일은 <strong>{{remain()}}</strong>개 [ <a href="" ng-click="archive()">보관하기</a> ]</p>
	<ul class="list-unstyled">
		<li ng-repeat="todo in todoList" class="checkbox">
			<input type="checkbox" ng-model="todo.done">{{todo.title}}
		</li>
	</ul>
	<input type="text" class="form-control" name="newItemText" placeholder="새로운 할 일" ng-model="newTitle">
	<button type="submit" class="btn btn-default" ng-click="addNewTodo(newTitle)">추가</button>
</body>

</html>