//create module
var issuehubApp = angular.module('issuehubApp', []);

// configure our routes
issuehubApp.config(function ($routeProvider) {
    $routeProvider

            // route for the home page
            .when('/', {
                templateUrl: 'static/view/main.html',
                controller: 'mainController'
            })

            // route for the about page
            .when('/login', {
                templateUrl: 'static/view/login.html',
                controller: 'loginController'
            })

//            // route for the contact page
//            .when('/contact', {
//                templateUrl: 'pages/contact.html',
//                controller: 'contactController'
//            });
});

issuehubApp.controller('mainController', function ($scope) {
    // create a message to display in our view
    $scope.message = 'Everyone come and see how good I look!';
});

issuehubApp.controller('loginController', ['$scope', '$http', function ($scope, $http) {

        this.postForm = function () {

            var encodedString = 'username=' +
                    encodeURIComponent(this.inputData.username) +
                    '&password=' +
                    encodeURIComponent(this.inputData.password);

            $http({
                method: 'POST',
                url: 'check-login.php',
                data: encodedString,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            })
                    .success(function (data, status, headers, config) {
                        console.log(data);
                        if (data.trim() === 'correct') {
                            window.location.href = 'success.html';
                        } else {
                            $scope.errorMsg = "Login not correct";
                        }
                    })
                    .error(function (data, status, headers, config) {
                        $scope.errorMsg = 'Unable to submit form';
                    })
        }

    }])