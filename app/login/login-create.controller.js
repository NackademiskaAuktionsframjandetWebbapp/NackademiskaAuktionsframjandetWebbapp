angular.module("login").controller("loginCreateController", ["$scope","$routeParams","$location","loginService",
    function ($scope, $routeParams,$location,loginService) {

        $scope.customer = {};
        $scope.roles = ["Administrator", "Customer"];


        $scope.createLogin = function (form) {

            var newLogin = {
                firstname: $scope.customer.firstname,
                lastname: $scope.customer.lastname,
                email: $scope.customer.email,
                password: $scope.customer.password,
                phone: $scope.customer.phone,
                address: $scope.customer.address,
                postalCode: $scope.customer.postalCode,
                city: $scope.customer.city,
                role: $scope.customer.role


            };


            loginService.createLogin(newLogin).then(function () {
                $location.path("/login");
            });

        }



    }]);