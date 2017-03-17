angular.module("admin").factory("adminService", ["$http", function ($http) {
    return {
        getFinishedAuctions: function () {
            return $http.get("http://nackademiska-api.azurewebsites.net/api/auction/completed")
        }
    }
}]);