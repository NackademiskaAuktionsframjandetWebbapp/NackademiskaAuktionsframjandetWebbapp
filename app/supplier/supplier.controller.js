angular.module("supplier").controller("supplierController", ["$scope","$routeParams", "supplierService",
    function ($scope, $routeParams, supplierService) {

        $scope.goBack = function() {
            window.history.back();
        };


        supplierService.getSupplierById($routeParams.supplierId).then(function (response) {
            $scope.supplier = response.data;

        }, function (errorResponse) {

    });

}]);





