angular.module("login").factory("loginService",["$http", function ($http) {
    var isLoggedIn = false;
    var customerIdAfterLogin;


    return {

        createLogin: function(customer) {
            return $http.post("http://nackademiska-api.azurewebsites.net/api/account", customer);

        },

        login: function (user) {

            return $http.post("http://nackademiska-api.azurewebsites.net/api/account/login", user).then(function (response) {

                isLoggedIn = true;
                customerIdAfterLogin = response.data.id;

                history.back();

            })

        },
        isLoggedIn: function () {
            console.log(isLoggedIn);
            return isLoggedIn;

        },
        customerIdAfterLogin: function () {
            return customerIdAfterLogin;

        }


    };
}]);