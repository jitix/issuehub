issuehubApp.controller('viewUserController',
        ['$scope', '$routeParams', '$location', 'HttpService', 'SessionService',
            function($scope, $routeParams, $location, HttpService, SessionService) {

                $scope.userId = $routeParams.userId;

                SessionService.checkUserSession('login', 'You need to log in to view user profile');

                if (SessionService.getCurrentUser().userId !== $scope.userId) {
                    //if the user is trying to view another user's profile
                    SessionService.checkAdminUserSession('/', 'You need to be an admin to view other users profiles');
                }

                $scope.user = SessionService.getCurrentUser();

                $scope.saveUser = function() {
                    HttpService.call('api/users/' + $scope.userId, 'PUT', {
                        userName: $scope.user.userName,
                        email: $scope.user.email,
                        password: $scope.user.password,
                        adminFlag: $scope.user.adminFlag
                    },
                    {
                        successMessage: 'User details updated',
                        failureMessage: 'Could not update user details',
                        successCallback: function(responseData) {

                        },
                        failureCallback: function(responseData) {

                        },
                        successMsgRetention: 0,
                        failureMsgRetention: 0
                    });
                }
            }])