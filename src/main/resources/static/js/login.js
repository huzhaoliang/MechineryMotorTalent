var myApp = angular.module('myApp', []);
myApp.controller('loginCtrl', function($scope) {
	$scope.submit = function(){
		var name = $scope.name;
		if(name == null){
			alert("请填写用户名！");
			return;
		}
		var password = $scope.password;
		alert(password);
		if(password == null){
			alert("请填写密码！");
			return;
		}
		var result = $http({
			method:"get", 
			url:"/verify",
			params:{'name':name,'password':password},
			dataType:blob,
			}).success(function(data){
			//响应成功操作
			}).error(function(data){
			//响应失败（响应以错误状态返回）操作
			});
	}
});