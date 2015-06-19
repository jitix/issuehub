issuehubApp.controller('createIssueController',
        ['$scope', '$location', 'HttpService', 'SessionService','MessageService','IssueTypeService','UserService',
            function($scope, $location, HttpService, SessionService, MessageService, IssueTypeService, UserService) {

                SessionService.checkUserSession(
                        '/', 'You need to be logged in to create new issue');

                $scope.newIssueDetails = {};

                $scope.issueTypes = [];
                
                $scope.users=[];
                
                $scope.priorities=["High","Medium","Low"];

                $scope.createIssue = function() {
                    HttpService.call('api/issues/', 'POST', $scope.newIssueDetails,
                            {
                                failureMessage: 'Error creating new issue',
                                failureMsgRetention: 0,
                                successCallback: function(responseData) {
                                    MessageService.setMessage('success',
                                            "Created issue #" + responseData.issueNumber,
                                            0);
                                    $location.path('issues/');
                                },
                                failureCallback: function(responseData) {

                                }
                            });
                };
                
                this.fetchLists=function(){
                    IssueTypeService.fetchIssueTypes(function(data){
                        //alert(angular.toJson(data,true));
                        $scope.issueTypes=data;
                    });
                    
                    UserService.fetchUsers(function(data){
                        $scope.users=data;
                    });
                };
                
                this.fetchLists();
            }])