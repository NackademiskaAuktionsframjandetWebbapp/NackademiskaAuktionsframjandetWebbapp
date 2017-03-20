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
               finishedAuctions[i].monthAndYear = finishedAuctions[i].endTime.substring(0,7);
               totalInMonth = {monthAndYear: finishedAuctions[i].endTime.substring(0,7), total: finishedAuctions[i].highestBid};
               console.log(totalInMonth.total);
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
        console.log(totalsByMonth);



        $scope.totalsByMonth = totalsByMonth;
    });
}]);
