angular.module("auction").filter("activeAuctions", function () {
    return function (input) {
        var activeAuctions = [];
        angular.forEach(input, function (auction) {
            if (auction.highestBid != auction.buyNowPrice ||
                (new Date(auction.endTime) <= new Date() && new Date(auction.startTime) >= new Date())){
                activeAuctions.push(auction);
            }
        });
        return activeAuctions;
    }
});
