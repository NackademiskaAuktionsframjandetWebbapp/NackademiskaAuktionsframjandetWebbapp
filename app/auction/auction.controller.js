angular.module("auction").controller("auctionController", ["$scope", "auctionService",
    "$location", function ($scope, auctionService, $location) {
        $scope.bid = {};

        auctionService.getAuctions().then(function (response) {
            $scope.auctions = response.data;
        });

        $scope.auctionClicked = function (id) {
            $location.path("/auction/" + id);
        };

        auctionService.getCategories().then(function (response) {
            $scope.categories = response.data;
        });
        $scope.time = function (data) {
            var parts = data.split("T");
            var time = parts[1].split(":");
            var date = parts[0].split("-");
            var dateTime = new Date(date[0],date[1],date[2][time[0],time[1],time[2]]);
            return dateTime;
        }





    }]);