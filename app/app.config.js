angular.module("app").config(["$routeProvider", "$locationProvider", function ($routeProvider, $locationProvider) {
    $routeProvider

        .when("/", {
            templateUrl: "app/auction/auction.template.html",
            controller: "auctionController"
        })
        .when("/login", {
            templateUrl: "app/login/login.template.html",
            controller: "loginController"
        })

        .otherwise("/");
    $locationProvider.html5Mode(true);
}]);

