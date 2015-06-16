issuehubApp.controller('navController',
        ['$scope', '$location', 'HttpService', 'SessionService',
            function($scope, $location, HttpService, SessionService) {

                $scope.loggedIn = false;
                $scope.isAdmin = false;
                $scope.userId = null;
                
                $scope.$on('session-changed', function() {
                    $scope.loggedIn = SessionService.isUserSession();
                    $scope.isAdmin = SessionService.isAdminSession();
                    $scope.userId = SessionService.getCurrentUser().userId;
                });
                
                $scope.logout = function() {
                    HttpService.call('api/session/remove', 'POST', {},
                            {
                                successMessage: 'Logout successful',
                                failureMessage: 'Logout unsuccessful',
                                successCallback: function(responseData) {
                                    SessionService.removeUser();
                                    $location.path('/login');
                                },
                                failureCallback: function(responseData) {

                                },
                                successMsgRetention: 1,
                                failureMsgRetention: 0
                            });
                };
                
//                this.loadSessionData = function() {
//                    HttpService.call('api/session/', 'GET', {},
//                            {
//                                successCallback: function(responseData) {
//                                    //alert("loaded session information");
//                                    //alert(angular.toJson(responseData,true))
//                                    if(responseData){
//                                        SessionService.setCurrentUser(responseData);
//                                        $location.path("/");
//                                    }
//                                },
//                                failureCallback: function(responseData) {
//
//                                }
//                            });
//                };
//                
//                this.loadSessionData();
            }])