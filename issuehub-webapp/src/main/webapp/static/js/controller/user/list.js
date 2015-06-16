issuehubApp.controller('listUserController',
        ['$scope', 'HttpService', 'SessionService',
            function($scope, HttpService, SessionService) {
                
                SessionService.checkAdminUserSession(
                        '/','You need to be an admin user to view user list');
                
                $scope.userList=[];
                
                $scope.fetchUsers=function(){
                    HttpService.call('api/users/', 'GET', {},
                            {
                                failureMessage: 'Error fetching users list',
                                successCallback: function(responseData) {
                                    if(responseData){
                                        $scope.userList=responseData;
                                    }
                                },
                                failureCallback: function(responseData) {

                                },
                                failureMsgRetention: 0
                            });
                };
                
                $scope.fetchUsers();
                
            }])

