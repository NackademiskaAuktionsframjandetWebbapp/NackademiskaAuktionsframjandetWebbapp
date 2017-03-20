angular.module("admin").controller("adminController", ["$q", "$scope", "adminService", "auctionService",
    function ($q, $scope, adminService, auctionService) {
    var finishedAuctions = [];
    var bids = [];
    var totalsByMonth= [];
    var totalInMonth;
    var monthExists = false;

    adminService.getFinishedAuctions().then(function (response) {
        finishedAuctions = response.data;
        var promises = [];
        angular.forEach(finishedAuctions, function (auction) {
            promises.push(auctionService.getBidsById(auction.id));
        });
        $q.all(promises).then(function (response) {
           for (var i = 0; i<finishedAuctions.length; i++){
               bids = response[i].data;
               finishedAuctions[i].highestBid = bids[bids.length-1].bidPrice;
               finishedAuctions[i].monthAndYear = finishedAuctions[i].endTime.substring(0,7),
               totalInMonth = {monthAndYear: finishedAuctions[i].endTime.substring(0,7), total: finishedAuctions[i].highestBid};
               console.log(totalInMonth);
               monthExists = false;
               for (var i = 0; i<totalsByMonth.length; i++){
                   if (totalInMonth.monthAndYear == totalsByMonth[i].monthAndYear){
                       totalsByMonth.total += totalInMonth.total;
                       monthExists = true;

                   }
               }
               if (!monthExists){
                   totalsByMonth.push(totalInMonth);
               }

           };


        });
        console.log(totalsByMonth);



        $scope.auctions = finishedAuctions;
        console.log($scope.auctions[0].bids);
    });
}]);
