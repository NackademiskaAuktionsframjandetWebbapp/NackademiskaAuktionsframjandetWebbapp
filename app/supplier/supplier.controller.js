angular.module("supplier").controller("supplierController", ["$scope","$routeParams","$location", "supplierService",
    function ($scope, $routeParams,$location, supplierService) {

        supplierService.getAllSuppliers().then(function (response) {
            $scope.suppliers = response.data;
        });


        supplierService.getSupplierById($routeParams.supplierId).then(function (response) {
            $scope.supplier = response.data;
            console.log(response.data);
        }, function (errorResponse) {

    });
}]);
