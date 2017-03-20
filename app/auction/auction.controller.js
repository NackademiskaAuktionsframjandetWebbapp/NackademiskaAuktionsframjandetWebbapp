angular.module("auction").controller("auctionController", ["$scope", "$q", "auctionService",
    "$location", function ($scope, $q, auctionService, $location) {
        $scope.bid = {};
        var auctions = [];
        var bids = [];

        auctionService.getAuctions().then(function (response) {
            auctions = response.data;
            var promises = [];
            angular.forEach(auctions, function (auction) {
                promises.push(auctionService.getBidsById(auction.id));
            });
            $q.all(promises).then(function (response) {
                for (var i = 0; i<auctions.length; i++){
                    bids = response[i].data;
                    console.log(bids);
                    if (bids.length > 0){
                        auctions[i].highestBid = bids[bids.length-1].bidPrice;
                    }

                }


            });
            $scope.auctions = auctions;
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