var loginApp = angular.module('loginApp',[]);
app.controller("loginCon",function ($scope,$http) {
    $http.get("/test").then(function (response) {
        $scope.hello=response.data.username
    })
})
