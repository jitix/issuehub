issuehubApp.controller('loginController',
        ['$scope', '$location', 'HttpService','SessionService',
            function($scope, $location, HttpService, SessionService) {

                $scope.authReq = {};

                $scope.loginUser = function() {

                    HttpService.call('api/session/create', 'POST', $scope.authReq,
                            {
                                successMessage: 'Login successful',
                                failureMessage: 'Login unsuccessful',
                                successCallback: function(responseData) {
                                    SessionService.setCurrentUser(responseData);
                                    $location.path('/issues/');
                                },
                                failureCallback: function(responseData) {
                                    
                                },
                                successMsgRetention: 0,
                                failureMsgRetention: 0
                            });
                };

            }])