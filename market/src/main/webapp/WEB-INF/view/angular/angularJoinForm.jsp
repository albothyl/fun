<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app="join">

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
		var joinForm = angular.module('join', []);
				
		joinForm.controller('joinFormCtrl', function($scope, $http){		
			$scope.duplicationCheckMeaage = "E-MAIL 중복체크를 해주시기 바랍니다.";			
			
			//email 중목체크 ajax함수
			$scope.duplicationCheck = function(email){
				var request = $http({
					method : 'POST'
				  , url : '/member/duplicationCheckAction.do'
				  , data : {"email" : email}					
				});
				request.success(function(data,status,headers,config){
					$.each(data, function(key, value){
						if(value == true){
							$scope.duplicationCheckMeaage = "사용중인 E-MAIL 입니다.";
						}else if(value == false){
							$scope.duplicationCheckMeaage = "사용 가능한 E-MAIL 입니다.";
						}
					});
				});
				request.error(function(data,status,headers,config){
					$scope.duplicationCheckMeaage = "E-MAIL 중복체크 중 오류가 발생하였 습니다.";
				});
			};
			
			$scope.submitJoinForm = function(email, pw, nick){
				
			}
			
			$scope.cancle = function(){
				history.back();
			};
			
		});
	</script>

</head>

<body>
	<form ng-controller="joinFormCtrl">
		<div class="member">
			<div class="form-group" ng-class="{ 'has-error' : userForm.name.$invalid && !userForm.name.$pristine }">
				<label>email</label>
				<div><input type="email" name="email" ng-model="member.email"  ng-maxlength="20" required></div>								
				<input type="button" ng-click="duplicationCheck(email)" value="중복체크" />
				<p>{{duplicationCheckMeaage}}</p>
			</div>
				
			<div class="form-group" ng-class="{ 'has-error' : userForm.username.$invalid && !userForm.username.$pristine }">
				<label>password</label>
				<div><input type="password" name="pw" ng-model="member.pw" value="" ng-required="true" ng-maxlength="20"></div>
				<div><input type="password" ng-model="pwCheck" ng-required="true" ng-maxlength="20"></div>
			</div>
			<div class="form-group" ng-class="{ 'has-error' : userForm.email.$invalid && !userForm.email.$pristine }">
				<label>nickname</label>
				<div><input type="text" name="nick" ng-model="member.nick" ng-required="true" ng-maxlength="20"></div>
			</div>
			
			<div class="clear">
				<input type="button" ng-click="submitJoinForm(member.email, member.pw, member.nick)" value="확인">
				<input type="button" ng-click="cancle()" value="취소">
			</div>
		</div>
	</form>
</body>

</html>