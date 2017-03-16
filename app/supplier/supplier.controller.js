angular.module("supplier").controller("supplierController", ["$scope","$routeParams", "supplierService",
    function ($scope, $routeParams, supplierService) {
        supplierService.getSupplier($routeParams.supplierId).then(function (response) {
            $scope.supplier = response.data;
        })
}]);
