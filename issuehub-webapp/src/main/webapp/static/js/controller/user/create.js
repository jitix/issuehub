issuehubApp.controller('createUserController',
        ['$scope', '$location', 'HttpService', 'SessionService',
            function($scope, $location, HttpService, SessionService) {

                SessionService.checkAdminUserSession(
                        '/','You need to be an admin user to create new users');

                $scope.userDetails = {adminFlag: false};

                $scope.createUser = function() {
                    HttpService.call('api/users/', 'POST', $scope.userDetails,
                            {
                                successMessage: 'Created new user ' + $scope.userDetails.userName,
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