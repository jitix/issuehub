issuehubApp.controller('listIssueController',
        ['$scope', '$location', 'HttpService', 'SessionService',
            function($scope, $location, HttpService, SessionService) {

                SessionService.checkUserSession(
                        '/', 'You need to login to view issue list');

                $scope.issueList = [];

                $scope.convertTimestamp = function(timestamp) {
                    var a = new Date(timestamp);
                    var months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
                    var year = a.getFullYear();
                    var month = months[a.getMonth()];
                    var date = a.getDate();
                    var hour = a.getHours();
                    var min = a.getMinutes();
                    var sec = a.getSeconds();
                    var time = month + ' '+ date + ' ' + year + ' ' + hour + ':' + min + ':' + sec;
                    return time;
                };

                $scope.showNewIssue = function() {
                    $location.path("issues/create");
                };

                $scope.showViewIssue = function(issueNumber) {
                    $location.path("issues/" + issueNumber);
                };

                $scope.showDeleteDialog = function(issueNumber) {
                    $location.path("issues/" + issueNumber + "/delete");
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

