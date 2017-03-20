angular.module("admin").controller("finishedAuctionsController", ["$scope", "$q", "adminService", "supplierService",
    function ($scope, $q, adminService, supplierService) {
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


            });
            $scope.auctions = finishedAuctions;
    }

    )}]);
