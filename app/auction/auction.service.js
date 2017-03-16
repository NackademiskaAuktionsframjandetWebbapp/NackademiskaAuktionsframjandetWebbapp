angular.module("auction").factory("auctionService", ["$http", function ($http) {
    return {
        getAuctions: function () {
            return $http.get("http://nackademiska-api.azurewebsites.net/api/auction");
        },
        getAuction: function (id) {
            return $http.get("http://nackademiska-api.azurewebsites.net/api/auction" + id);
        },
        getCategories: function () {
            return $http.get("http://nackademiska-api.azurewebsites.net/api/category");
        }

    }
}]);