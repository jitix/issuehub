issuehubApp.controller('listUserController',
        ['$scope', '$location', 'HttpService', 'SessionService',
            function($scope, $location, HttpService, SessionService) {

                SessionService.checkAdminUserSession(
                        '/', 'You need to be an admin user to view user list');

                $scope.userList = [];

                $scope.showNewUser = function() {
                    $location.path("users/create");
                };
                
                $scope.showViewUser = function(userId) {
                    $location.path("users/"+userId);
                };
                
                $scope.showDeleteDialog = function(userId) {
                    $location.path("users/"+userId+"/delete");
                };

                $scope.fetchUsers = function() {
                    HttpService.call('api/users/', 'GET', {},
                            {
                                failureMessage: 'Error fetching users list',
                                successCallback: function(responseData) {
                                    if (responseData) {
                                        $scope.userList = responseData;
                                    }
                                },
                                failureCallback: function(responseData) {

                                },
                                failureMsgRetention: 0
                            });
                };

                $scope.fetchUsers();

            }])

