<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html lang="ko" ng-app="sampleApp">

<head>
	<meta charset="utf-8">
	<meta name="description" content=""/>
	<meta name="keywords"    content=""/>
	<meta name="author"      content=""/>

	<title>Http</title>
	
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
	<script src="/javaScript/angular/angular.min.js"></script>
	<script src="/javaScript/jQuery/jquery-2.1.1.min.js"></script>
	
	<style type="text/css">
		.info{
			margin: 0px auto;
			height: 20px;
			background-color: aliceblue;
		}
		.info button{
			float: right;
		}
	</style>
	<script>
		angular.module('sampleApp', []).
			directive('infoBox', [function(){
				return{
					restrict: 'E',
				    scope: {infoMessage: '='},
				    template: '<p class="info">{{infoMessage}}<button ng-click="hide()">x</button></p>',
				    link: function(scope, iElement, iAttrs){
				    	scope.$watch("infoMessage",function(newData,beforeData){
				    		
				    	if(newData == undefined || newData == ''){
				    			scope.hide();
						  	}else{
						  		iElement.show({
						  			duration: 3000,
								  	complete: function(){
								  		iElement.hide();
								  	}
							  	});
						  	}
					  	});
					  	scope.hide = function(){
					  		iElement.hide();
						  	scope.infoMessage = undefined;
					  	};
				  	}
				};
			}]).
			controller('mainCtrl', function($scope, $http){
				$scope.member = {};
				$scope.search = function(){
					var reqPromise = $http({
						method: 'POST',
					    url: '/member/angularAjaxAction.do',
					    data: {"email":"test@email.com", "pw":"password", "nick":"albothyl"}
					});
					reqPromise.success(function(data,status,headers,config){
						$scope.member = data;
					});
					reqPromise.then(function(response){
						$scope.msg = response.data.email + "로딩 완료";
					},function(response){
						$scope.msg = "Error";
					});
				};
			});
	</script>

</head>

<body ng-controller="mainCtrl">
	<info-box info-message="msg"></info-box>
	<p class="member">
		사용자 이메일: {{member.email}}
		<br>
		사용자 비밀번호: {{member.pw}}
		<br>
		사용자 닉네임: {{member.nick}}		
	</p>
	<div><button ng-click="search()">조회</button></div>
</body>

</html>