var myApp = angular.module('myApp', []);
myApp.controller('loginCtrl', function($scope, $http) {
	$scope.submit = function(){
		var name = $scope.name;
		if(name == null){
			alert("请填写用户名！");
			return;
		}
		var password = $scope.password;
		if(password == null){
			alert("请填写密码！");
			return;
		}
		$http({
		    method: 'GET',
		    url: '/verify',
		    params: {'name':name,'password':password}
		}).then(function successCallback(res) {
			var status = res.data;
	        console.log("status = " + status);
	        if (status == true){
	            alert("登录成功，页面跳转......");
	        }else {
	        	alert("请输入正确的用户名和密码！");
	        }
        	}, function errorCallback(res) {
        		alert("登录失败，请稍后再试！");
		});    
	}
});