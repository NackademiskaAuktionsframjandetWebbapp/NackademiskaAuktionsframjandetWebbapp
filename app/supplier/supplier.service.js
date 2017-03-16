angular.module("supplier").factory("supplierService", ["$http", function ($http) {
    return {
        getAllSuppliers: function () {
            $http.get("http://nackademiska-api.azurewebsites.net/api/supplier")
        },
        getSupplierById: function (id) {
            $http.get("http://nackademiska-api.azurewebsites.net/api/supplier/" + id)
        }

    }
}]);
