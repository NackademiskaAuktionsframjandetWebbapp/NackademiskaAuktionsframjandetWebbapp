angular.module("admin").filter("finishedAuctionsByMonthYear", function () {
    return function (input) {
        angular.forEach(input, function (auction) {
            if (auction.monthAndYear == input.monthAndYear) {
                activeAuctions.push(auction);
            }
        });
    }
});
