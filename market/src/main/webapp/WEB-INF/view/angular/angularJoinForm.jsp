<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app="joinForm">

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>joinForm</title>
		
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	
	<script>
		var joinForm = angular.module('joinFormCtrl', []);
		
		joinForm.controller('joinFormCtrl', function($scope, $http){
			
			//email 중목체크 ajax함수
			$scope.duplicationCheck = function(){
				var email = $scope.email;
				
				
				var request = $http({
					method : 'POST'
				  , url : '/member/duplicationCheckAction.do'
				  , data : email					
				});
				request.success(function(data,status,headers,config){
					//$scope.duplicationCheckMessage = data;
				});
				request.error(function(data,status,headers,config){
					//$scope.duplicationCheckMessage = data;
				});
			};
			
			$scope.submitJoinForm = function(){
				
			}
			
			$scope.cancle = function(){
				history.back();
			};
			
		});
	</script>

</head>

<body>
	<form ng-controller="joinFormCtrl" name="joinForm">
		<div class="member">
			<div class="clear"></div>
				
				<div>email</div>
				<div><input type="email" ng-model="email" name="input" ng-maxlength="20" required /></div>
				<span class="error" ng-show="joinForm.input.$error.required">
			    Required!</span>
			  	<span class="error" ng-show="joinForm.input.$error.email">
			    Not valid email!</span>	
			    						
				<input type="button" ng-click="duplicationCheck()" value="중복체크" />
			<div class="clear"></div>
				<div ng-model="duplicationCheckMessage">E-MAIL 중복체크를 해주세요.</div>
			<div class="clear"></div>
				<div>password</div>
				<div><input type="password" ng-model="pw" value="" ng-required="true" ng-maxlength="20" /></div>
				<div><input type="password" ng-model="pwCheck" ng-required="true" ng-maxlength="20" /></div>
			<div class="clear"></div>
				<div>nickname</div>
				<div><input type="text" ng-model="nick" ng-required="true" ng-maxlength="20" /></div>
			<div class="clear"></div>
				<input type="button" ng-click="submitJoinForm()" value="확인" />
				<input type="button" ng-click="cancle()" value="취소" />
		</div>
	</form>
</body>

</html>