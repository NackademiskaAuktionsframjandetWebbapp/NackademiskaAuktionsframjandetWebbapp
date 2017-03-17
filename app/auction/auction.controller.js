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

        $scope.newBid = function(){
            var customerId = loginService.customerIdAfterLogin();

            var bidInfo = {
                auctionId: $scope.auction.id,
                customerId: customerId,
                bidPrice: $scope.bid.bidPrice};

            auctionService.newBid(bidInfo).then(function () {


            });
        };


    }]);