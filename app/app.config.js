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
        .when("/createlogin", {
            templateUrl: "app/login/login-create.template.html",
            controller: "loginCreateController"
        })
        .when("/auction/:auctionId", {
            templateUrl: "app/auction/auction-details.template.html",
            controller: "auctionDetailsController"
        })
        .when("/supplier/:supplierId", {
            templateUrl: "app/supplier/supplier.template.html",
            controller: "supplierController"
        })
        .when("/admin", {
            templateUrl: "app/admin/admin.template.html",
            controller: "adminController"
        })

        .otherwise("/");
    $locationProvider.html5Mode(true);
}]);

