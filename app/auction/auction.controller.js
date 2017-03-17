angular.module("auction").controller("auctionController", ["$scope", "auctionService",
    "$location", function ($scope, auctionService, $location) {

        auctionService.getAuctions().then(function (response) {
            $scope.auctions = response.data;
        });

        $scope.auctionClicked = function (id) {
            $location.path("/auction/" + id);
        };

        auctionService.getCategories().then(function (response) {
            $scope.categories = response.data;
        });

        $scope.newBid = function(){

            var bidinfo = {

                bidPrice: $scope.bid.bidPrice};

            loginService.login(userinfo).then(function () {

                console.log(loginService.isLoggedIn());

                if(!loginService.isLoggedIn()){
                    $scope.text = "Fel användarnamn eller lösenord. vänligen försök igen."
                }else{
                    $location.path("/cart");

                }
            });
        };


    }]);