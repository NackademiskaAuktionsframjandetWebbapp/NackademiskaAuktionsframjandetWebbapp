angular.module("login").controller("loginController", ["$scope","$location","$rootScope", "loginService",
    function ($scope,$location,$rootScope, loginService) {
        $scope.text = "";
        $scope.user = {};




        $scope.login = function(){

            var userinfo = {
                email: $scope.user.email,
                password: $scope.user.password};
            loginService.login(userinfo).then(function () {
                if(!loginService.isLoggedIn()){
                    $scope.text = "Fel användarnamn eller lösenord. vänligen försök igen.";
                    console.log($scope.text)
                }else{
                    $location.path("/auction/");
                }
            });
        };
        $scope.logout = function () {
            $location.path("/auction/");
          return loginService.logout()
        };
        $scope.isLoggedIn = function () {
            return loginService.isLoggedIn()
        };
        $scope.isAdmin = function () {
            return loginService.isAdmin()
        };
        $scope.customerName = function () {
            return loginService.customerNameAfterLogin();
        }

    }]);
