issuehubApp.controller('createIssueController',
        ['$scope', '$location', 'HttpService', 'SessionService','MessageService','IssueTypeService',
            function($scope, $location, HttpService, SessionService, MessageService, IssueTypeService) {

                SessionService.checkUserSession(
                        '/', 'You need to be logged in to create new issue');

                $scope.newIssueDetails = {};

                $scope.issueTypes = [];
                
                $scope.selectIssueType=function(issueTypeId){
                    alert(issueTypeId);
                };

                $scope.createIssue = function() {
                    HttpService.call('api/issues/', 'POST', $scope.userDetails,
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
                
                this.getIssueTypes=function(){
                    IssueTypeService.fetchIssueTypes(function(data){
                        //alert(angular.toJson(data,true));
                        $scope.issueTypes=data;
                    });
                };
                
                this.getIssueTypes();
            }])