issuehubApp.controller('listIssueController',
        ['$scope', '$location', 'HttpService', 'SessionService',
            function($scope, $location, HttpService, SessionService) {

                SessionService.checkUserSession(
                        '/', 'You need to login to view issue list');

                $scope.issueList = [];

                $scope.showNewIssue = function() {
                    $location.path("issues/create");
                };
                
                $scope.showViewIssue = function(issueNumber) {
                    $location.path("issues/"+issueNumber);
                };
                
                $scope.showDeleteDialog = function(issueNumber) {
                    $location.path("issues/"+issueNumber+"/delete");
                };

                $scope.fetchIssues = function() {
                    HttpService.call('api/issues/', 'GET', {},
                            {
                                failureMessage: 'Error fetching issue list',
                                successCallback: function(responseData) {
                                    if (responseData) {
                                        $scope.issueList = responseData;
                                    }
                                },
                                failureCallback: function(responseData) {

                                },
                                failureMsgRetention: 0
                            });
                };

                $scope.fetchIssues();

            }])

