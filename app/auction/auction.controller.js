angular.module("auction").controller("auctionController", ["$scope", "auctionService",
    "$location", function ($scope, auctionService, $location) {

    auctionService.getAuctions().then(function (response) {
        $scope.auctions = response.data;
    });

    $scope.auctionClicked = function (id) {
        $location.path("/product/" + id);
    };

    auctionService.getCategories().then(function (response) {
        $scope.categories = response.data;
    })


}]);