angular.module("auction").controller("auctionDetailsController", ["$scope", "$routeParams", "$location", "auctionService",
    function ($scope, $routeParams, $location, auctionService) {

        auctionService.getAuctionByID($routeParams.auctionId).then(function (response) {
            $scope.auction = response.data;
        }, function (errorResponse) {

        });

        $scope.auctionClickedInDetails = function () {
            $location.path("/");

        };

        $scope.seeSupplier = function (id) {
            $location.path("/supplier/" + id);
        };

    }]);
