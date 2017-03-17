angular.module("admin").controller("adminController", ["$q", "$scope", "adminService", "auctionService",
    function ($q, $scope, adminService, auctionService) {
    var finishedAuctions = [];
    var bids;

    adminService.getFinishedAuctions().then(function (response) {
        finishedAuctions = response.data;
        var promises = [];
        angular.forEach(finishedAuctions, function (auction) {
            promises.push(auctionService.getBidsById(auction.id));
        });
        $q.all(promises).then(function (response) {
           for (var i = 0; i<finishedAuctions.length; i++){
               finishedAuctions[i].bids = response[i].data;
           }
        });

        $scope.auctions = finishedAuctions;
        console.log($scope.auctions[0].bids);
    });
}]);
