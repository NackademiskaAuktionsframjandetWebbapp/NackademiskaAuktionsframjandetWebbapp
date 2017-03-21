angular.module("admin").controller("finishedAuctionsController", ["$routeParams", "$scope", "$q", "adminService", "supplierService", "auctionService",
    function ($routeParams, $scope, $q, adminService, supplierService, auctionService) {
        adminService.getFinishedAuctions().then(function (response) {
            finishedAuctions = response.data;
            var promises = [];
            angular.forEach(finishedAuctions, function (auction) {
                promises.push(supplierService.getSupplierById(auction.supplierId));
            });
            $q.all(promises).then(function (response) {
                for (var i = 0; i<finishedAuctions.length; i++){
                    finishedAuctions[i].supplierPercent = response[i].data.commission;
                    finishedAuctions[i].supplierName = response[i].data.companyName;
                    //finishedAuctions[i].profit = finishedAuctions[i].
                    console.log(finishedAuctions[i].supplierName);
                }
                promises = [];
                angular.forEach(finishedAuctions, function (auction) {
                    promises.push(auctionService.getBidsById(auction.id))
                });
                $q.all(promises).then(function (response) {
                    for (i = 0; i<finishedAuctions.length; i++){
                        bids = response[i].data;
                        finishedAuctions[i].highestBid = bids[bids.length-1].bidPrice;
                        finishedAuctions[i].profit = (finishedAuctions[i].highestBid * (finishedAuctions[i].supplierPercent));
                    }
                })


            });
            $scope.auctions = finishedAuctions;
            $scope.monthAndYear = $routeParams.monthAndYear;
    }



    )}]);
