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
                    $scope.text = "Fel användarnamn eller lösenord. vänligen försök igen."
                }else{
                    $location.path("/auction/");

                }
            });
        };



    }]);
