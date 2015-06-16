issuehubApp.controller('loginController',
        ['$scope', '$location', 'HttpService',
            function($scope, $location, HttpService) {

                $scope.authReq = {};

                $scope.loginUser = function() {

                    HttpService.call('api/session/create', 'POST', $scope.authReq,
                            {
                                successMessage: 'Login successful',
                                failureMessage: 'Login unsuccessful',
                                successCallback: function(responseData) {
                                    alert(angular.toJson(responseData, true));
                                    $location.path('/');
                                },
                                failureCallback: function(responseData) {
                                    alert(angular.toJson(responseData, true));
                                },
                                msgRetention: 1
                            });
                };

            }])