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




    }]);