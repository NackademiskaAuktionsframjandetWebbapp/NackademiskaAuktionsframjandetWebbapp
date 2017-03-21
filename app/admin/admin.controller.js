angular.module("admin").controller("adminController", ["$q", "$scope", "$location", "adminService", "auctionService",
    function ($q, $scope, $location, adminService, auctionService) {
    var finishedAuctions = [];
    var bids = [];
    var totalsByMonth= [];
    var totalInMonth;
    var monthExists = false;
    var winningBidDate;

    adminService.getFinishedAuctions().then(function (response) {
        finishedAuctions = response.data;
        var promises = [];
        angular.forEach(finishedAuctions, function (auction) {
            promises.push(auctionService.getBidsById(auction.id));
        });
        $q.all(promises).then(function (response) {
           for (var i = 0; i<finishedAuctions.length; i++){
               bids = response[i].data;
               winningBidDate = bids[bids.length-1].dateTime;
               finishedAuctions[i].highestBid = bids[bids.length-1].bidPrice;
               if (finishedAuctions[i].highestBid == finishedAuctions[i].buyNowPrice){
                   finishedAuctions[i].monthAndYear = winningBidDate.substring(0,7);
               }else {
                   finishedAuctions[i].monthAndYear = finishedAuctions[i].endTime.substring(0,7);
               }
               totalInMonth = {monthAndYear: finishedAuctions[i].monthAndYear, total: finishedAuctions[i].highestBid};
               monthExists = false;
               if (totalsByMonth.length == 0){
                   totalsByMonth.push(totalInMonth);
               }else {
                   for (var x = 0; x<totalsByMonth.length; x++){
                       if (totalInMonth.monthAndYear == totalsByMonth[x].monthAndYear){
                           totalsByMonth[x].total += totalInMonth.total;
                           monthExists = true;
                           x = totalsByMonth.length;
                       }
                   }
                   if (!monthExists){
                       totalsByMonth.push(totalInMonth);
                   }
               }
           };


        });

        $scope.monthSelected = function (monthAndYear) {
            $location.path("/admin/" + monthAndYear)
        };



        $scope.totalsByMonth = totalsByMonth;
    });
}]);
