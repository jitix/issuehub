issuehubApp.controller('createIssueController',
        ['$scope', '$location', 'HttpService', 'SessionService',
            function($scope, $location, HttpService, SessionService) {

                SessionService.checkUserSession(
                        '/', 'You need to be logged in to create new issue');

                $scope.newIssueDetails = {};

                $scope.createIssue = function() {
                    HttpService.call('api/issues/', 'POST', $scope.userDetails,
                            {
                                failureMessage: 'Error creating new issue',
                                failureMsgRetention: 0,
                                successCallback: function(responseData) {
                                    MessageService.setMessage('success',
                                            "Created issue #"+responseData.issueNumber, 
                                            0);
                                    $location.path('issues/');
                                },
                                failureCallback: function(responseData) {
                                    
                                }
                            });
                }

            }])