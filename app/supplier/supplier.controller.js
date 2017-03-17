angular.module("supplier").controller("supplierController", ["$scope","$routeParams", "supplierService",
    function ($scope, $routeParams, supplierService) {


        supplierService.getSupplierById($routeParams.supplierId).then(function (response) {
            $scope.supplier = response.data;

        }, function (errorResponse) {

    });

}]);
