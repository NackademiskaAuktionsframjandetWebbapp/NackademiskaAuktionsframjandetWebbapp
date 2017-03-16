angular.module("supplier").factory("supplierService", ["$http", function ($http) {
    return {
        getSupplier: function (id) {
            $http.get("http://nackademiska-api.azurewebsites.net/api/supplier/" + id)
        },
        getAllSuppliers: function () {
            $http.get("http://nackademiska-api.azurewebsites.net/api/supplier/")
        }
    }
}]);
