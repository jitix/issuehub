issuehubApp.controller('deleteUserController',
        ['$scope', '$routeParams', '$location', 'HttpService', 'SessionService',
            function($scope, $routeParams, $location, HttpService, SessionService) {

                SessionService.checkAdminUserSession('/', 'You need to be an admin to delete users profiles');

                $scope.user = {};

                $scope.deleteUser = function() {
                    HttpService.call('api/users/' + $routeParams.userId, 'DELETE', {},
                    {
                        successMessage: 'User '+$scope.user.userName+' deleted',
                        failureMessage: 'Could not delete user',
                        successCallback: function(responseData) {
                            $location.path("users")
                        },
                        failureCallback: function(responseData) {

                        },
                        successMsgRetention: 0,
                        failureMsgRetention: 0
                    });
                };

                this.loadUserDetails = function() {
                    HttpService.call('api/users/'+$routeParams.userId, 'GET', {},
                            {
                                failureMessage: 'Error fetching user details',
                                successCallback: function(responseData) {
                                    if (responseData) {
                                        $scope.user = responseData;
                                    }
                                },
                                failureCallback: function(responseData) {

                                },
                                failureMsgRetention: 0
                            });
                };

                this.loadUserDetails();
            }])

