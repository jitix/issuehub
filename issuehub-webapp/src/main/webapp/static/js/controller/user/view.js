issuehubApp.controller('viewUserController',
        ['$scope', '$routeParams', '$location', 'HttpService', 'SessionService',
            function($scope, $routeParams, $location, HttpService, SessionService) {

                SessionService.checkUserSession('login', 'You need to log in to view user profile');

                if (SessionService.getCurrentUser().userId !== $routeParams.userId) {
                    //if the user is trying to view another user's profile
                    SessionService.checkAdminUserSession('/', 'You need to be an admin to view other users profiles');
                }

                $scope.user = {};

                $scope.saveUser = function() {
                    HttpService.call('api/users/' + $routeParams.userId, 'PUT', {
                        userName: $scope.user.userName,
                        email: $scope.user.email,
                        password: $scope.user.password,
                        adminFlag: $scope.user.adminFlag
                    },
                    {
                        successMessage: 'User details saved',
                        failureMessage: 'Could not update user details',
                        successCallback: function(responseData) {

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