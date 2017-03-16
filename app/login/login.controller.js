angular.module("login").controller("loginController", ["$scope","$location", "loginService",
    function ($scope,$location, loginService) {
        $scope.text = "";
        $scope.user = {};



        $scope.login = function(){

            var userinfo = {
                email: $scope.user.email,
                password: $scope.user.password};

            loginService.login(userinfo).then(function () {

                console.log(loginService.isLoggedIn());

                if(!loginService.isLoggedIn()){
                    $scope.text = "Fel användarnamn eller lösenord. vänligen försök igen."
                }else{
                    $location.path("/cart");

                }
            });
        };



    }]);
