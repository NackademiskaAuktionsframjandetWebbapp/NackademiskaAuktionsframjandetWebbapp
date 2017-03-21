angular.module("auction").controller("auctionDetailsController", ["$scope", "$routeParams", "$location","$route", "auctionService","loginService",
    function ($scope, $routeParams, $location,$route, auctionService, loginService) {

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
        auctionService.getBidsById($routeParams.auctionId).then(function (response) {
            $scope.bids = response.data;

        });
        $scope.newBid = function(){

            if (!loginService.isLoggedIn()) {
                $location.path("/login")
            }
            var customerId = loginService.customerIdAfterLogin();

            var bidInfo = {
                auctionId: $scope.auction.id,
                customerId: customerId,
                bidPrice: $scope.bid.bidPrice
            };


            auctionService.newBid(bidInfo).then(function successCallBack() {

                $route.reload();


            },function errorCallBack() {

            });
        };

        $scope.directBuy = function(buyNowPrice){

            if (!loginService.isLoggedIn()) {
                $location.path("/login")
            }
            var customerId = loginService.customerIdAfterLogin();

            var bidInfo = {
                auctionId: $scope.auction.id,
                customerId: customerId,
                bidPrice: buyNowPrice
            };


            auctionService.newBid(bidInfo).then(function successCallBack() {

                $route.reload();


            },function errorCallBack() {

            });
        };


    }]);
