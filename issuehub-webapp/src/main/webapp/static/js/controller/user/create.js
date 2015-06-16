issuehubApp.controller('createUserController',
        ['$scope', '$location', 'HttpService',
            function($scope, $location, HttpService) {

                $scope.userDetails = {adminFlag: false};

                $scope.createUser = function() {
                    HttpService.call('api/users/', 'POST', $scope.userDetails,
                            {
                                successMessage: 'Created new user ' + $scope.userName,
                                failureMessage: 'Error creating new user',
                                successCallback: function(responseData) {
                                    $location.path('users/');
                                },
                                failureCallback: function(responseData) {

                                },
                                successMsgRetention: 1,
                                failureMsgRetention: 0
                            });
                }

            }])