angular.module("admin").filter("finishedAuctionsByMonthYear", function () {
    return function (input) {
        var auctions = [];
        angular.forEach(input, function (auction) {
            if (auction.monthAndYear == input.monthAndYear) {
                activeAuctions.push(auction);
            }
        });
    }
});
