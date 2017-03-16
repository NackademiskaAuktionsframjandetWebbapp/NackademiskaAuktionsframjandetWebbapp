angular.module("login").factory("loginService",["$http", function ($http) {
    var isLoggedIn = false;



    return {

        createLogin: function(customer) {
            return $http.post("http://nackademiska-api.azurewebsites.net/api/account", customer);

        },

        login: function (user) {

            return $http.post("http://nackademiska-api.azurewebsites.net/api/account/login", user).then(function (response) {
                console.log(response.data);
                isLoggedIn = true;

            })

        },
        isLoggedIn: function () {
            return isLoggedIn;

        }

    };
}]);