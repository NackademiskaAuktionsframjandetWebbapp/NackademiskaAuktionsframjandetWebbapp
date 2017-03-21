angular.module("auction").filter("activeAuctions", function () {
    return function (input) {
        var activeAuctions = [];

        var time = function (data) {
            var parts = data.split("T");
            var time = parts[1].split(":");
            var date = parts[0].split("-");
            var dateTime = new Date(date[0],date[1],date[2],[time[0],time[1],time[2]]);
            return dateTime;
        };

        angular.forEach(input, function (auction) {
            if (auction.highestBid != auction.buyNowPrice &&
                (new Date(auction.endTime) > new Date() && new Date(auction.startTime) < new Date())){
                activeAuctions.push(auction);
            }
        });
        return activeAuctions;
    }
});
