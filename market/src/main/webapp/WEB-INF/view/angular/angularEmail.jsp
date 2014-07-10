<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Example - example-email-input-directive-production</title>
  

  <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.0-beta.14/angular.min.js"></script>
  

  
</head>
<body ng-app="emailExample">
  <script>
  angular.module('emailExample', [])
    .controller('ExampleController', ['$scope', function($scope) {
      $scope.text = 'me@example.com';
    }]);
</script>
  <form name="myForm" ng-controller="ExampleController">
    Email: <input type="email" name="input" ng-model="text" required>
    <span class="error" ng-show="myForm.input.$error.required">
      Required!</span>
    <span class="error" ng-show="myForm.input.$error.email">
      Not valid email!</span>
    <tt>text = {{text}}</tt><br/>
    <tt>myForm.input.$valid = {{myForm.input.$valid}}</tt><br/>
    <tt>myForm.input.$error = {{myForm.input.$error}}</tt><br/>
    <tt>myForm.$valid = {{myForm.$valid}}</tt><br/>
    <tt>myForm.$error.required = {{!!myForm.$error.required}}</tt><br/>
    <tt>myForm.$error.email = {{!!myForm.$error.email}}</tt><br/>
  </form>
</body>
</html>