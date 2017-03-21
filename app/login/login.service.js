angular.module("login").factory("loginService",["$http", function ($http) {
    var isLoggedIn = false;
    var isAdmin = false;
    var customerIdAfterLogin;


    return {

        createLogin: function(customer) {
            return $http.post("http://nackademiska-api.azurewebsites.net/api/account", customer);

        },

        login: function (user) {

            return $http.post("http://nackademiska-api.azurewebsites.net/api/account/login", user).then(function (response) {
                isLoggedIn = true;
                isAdmin = response.data.role == "Administrator";
                customerIdAfterLogin = response.data.id;
                history.back();
            })

        },
        logout: function () {
            isLoggedIn = false;
            isAdmin = false;
            customerIdAfterLogin = null;
        },
        isLoggedIn: function () {
            return isLoggedIn;

        },
        isAdmin: function () {
            return isAdmin;
        },
        customerIdAfterLogin: function () {
            return customerIdAfterLogin;

        }


    };
}]);