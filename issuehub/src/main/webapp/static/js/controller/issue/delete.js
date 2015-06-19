issuehubApp.controller('deleteIssueController',
        ['$scope', '$routeParams', '$location', 'HttpService', 'SessionService',
            function($scope, $routeParams, $location, HttpService, SessionService) {

                SessionService.checkUserSession('/', 'You need to be logged in to delete issues');

                $scope.issueDetails = {};

                $scope.deleteIssue = function() {
                    HttpService.call('api/issues/' + $routeParams.issueNumber, 'DELETE', {},
                    {
                        successMessage: 'Issue #'+$scope.issueDetails.issueNumber+' deleted',
                        failureMessage: 'Could not delete issue',
                        successCallback: function(responseData) {
                            $location.path("issues")
                        },
                        failureCallback: function(responseData) {

                        },
                        successMsgRetention: 0,
                        failureMsgRetention: 0
                    });
                };

                this.loadIssueDetails = function() {
                    HttpService.call('api/issues/'+$routeParams.issueNumber, 'GET', {},
                            {
                                failureMessage: 'Error fetching issue details',
                                successCallback: function(responseData) {
                                    if (responseData) {
                                        $scope.issueDetails = responseData;
                                    }
                                },
                                failureCallback: function(responseData) {

                                },
                                failureMsgRetention: 0
                            });
                };

                this.loadIssueDetails();
            }])

