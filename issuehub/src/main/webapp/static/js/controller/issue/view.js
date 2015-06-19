issuehubApp.controller('viewIssueController',
        ['$scope', '$routeParams', '$location', 'HttpService', 'SessionService', 'MessageService', 'IssueTypeService', 'UserService',
            function($scope, $routeParams, $location, HttpService, SessionService, MessageService, IssueTypeService, UserService) {

                SessionService.checkUserSession(
                        '/', 'You need to be logged in to view an issue');

                var self = this;

                $scope.issueDetails = {};
                
                $scope.newComment="";

                $scope.reporterUserName = null;
                $scope.updatedByUserName = null;

                $scope.issueTypes = [];
                $scope.statusList = [];
                $scope.substatusList = [];


                $scope.users = [];

                $scope.priorities = ["High", "Medium", "Low"];

                this.updateUserNames = function(issueDetails) {
                    //alert(angular.toJson(issueDetails,true));
                    HttpService.call('api/users/' + issueDetails.reporterUserId, 'GET', {},
                            {
                                failureMessage: 'Error fetching user details',
                                successCallback: function(responseData) {
                                    if (responseData) {
                                        $scope.reporterUserName = responseData.userName;
                                    }
                                },
                                failureCallback: function(responseData) {

                                },
                                failureMsgRetention: 0
                            });

                    if (issueDetails.updatedByUserId) {
                        HttpService.call('api/users/' + issueDetails.updatedByUserId, 'GET', {},
                                {
                                    failureMessage: 'Error fetching user details',
                                    successCallback: function(responseData) {
                                        if (responseData) {
                                            $scope.updatedByUserName = responseData.userName;
                                        }
                                    },
                                    failureCallback: function(responseData) {

                                    },
                                    failureMsgRetention: 0
                                });
                    }
                    
                    if(issueDetails.comments){
                        for(var i in issueDetails.comments){
                            var comment=issueDetails.comments[i];
                            
                            alert(angular.toJson(comment,true));
                            
                            HttpService.call('api/users/' + comment.userId, 'GET', {},
                                {
                                    failureMessage: 'Error fetching user details',
                                    successCallback: function(responseData) {
                                        if (responseData) {
                                            if(responseData.userName){
                                                comment.userName=responseData.userName;
                                            }
                                            else{
                                                comment.userName="Unknown User";
                                            }
                                        }
                                    },
                                    failureCallback: function(responseData) {

                                    },
                                    failureMsgRetention: 0
                                });
                            
                        }
                    }

                };

                this.updateStatusList = function(issueDetails) {
                    IssueTypeService.fetchIssueTypes(function(data) {
                        //alert(angular.toJson(data,true));
                        //alert(angular.toJson(issueDetails,true));
                        $scope.issueTypes = data;

                        for (var i in $scope.issueTypes) {
                            var issueType = $scope.issueTypes[i];
                            //alert(angular.toJson(issueType,true)+" ~ "+issueDetails.issueTypeName);
                            if (issueType.issueTypeName === issueDetails.issueTypeName) {
                                $scope.statusList = issueType.statusList;

                            }
                        }
                    });
                };

                $scope.$watch(function(scope) {
                    return scope.issueDetails.status;
                },
                        function(newValue, oldValue) {
                            //alert(newValue, oldValue);
                        }
                );

                $scope.loadSubStatus = function(status) {
                    //alert("fdfd");
                };

                $scope.convertTimestamp = function(timestamp) {
                    var a = new Date(timestamp);
                    var months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
                    var year = a.getFullYear();
                    var month = months[a.getMonth()];
                    var date = a.getDate();
                    var hour = a.getHours();
                    var min = a.getMinutes();
                    var sec = a.getSeconds();
                    var time = month + ' ' + date + ' ' + year + ' ' + hour + ':' + min + ':' + sec;
                    return time;
                };

                $scope.saveIssue = function() {
                    HttpService.call('api/issues/' + $routeParams.issueNumber, 'PUT', {
                        saveIssueDetails: {
                            title:$scope.issueDetails.title,
                            description:$scope.issueDetails.description,
                            priority:$scope.issueDetails.priority,
                            assigneeUserId:$scope.issueDetails.assigneeUserId,
                            status:$scope.issueDetails.status,
                            substatus:$scope.issueDetails.substatus
                        },
                        commentDetails:{
                            userId:null,
                            comment:$scope.newComment
                        }
                    },
                    {
                        successMessage: 'Issue details saved',
                        failureMessage: 'Could not update issue details',
                        successCallback: function(responseData) {

                        },
                        failureCallback: function(responseData) {

                        },
                        successMsgRetention: 0,
                        failureMsgRetention: 0
                    });
                };

                this.fetchData = function() {
                    IssueTypeService.fetchIssueTypes(function(data) {
                        //alert(angular.toJson(data,true));
                        $scope.issueTypes = data;
                    });

                    UserService.fetchUsers(function(data) {
                        $scope.users = data;
                    });

                    HttpService.call('api/issues/' + $routeParams.issueNumber, 'GET', {},
                            {
                                failureMessage: 'Error fetching issue details',
                                successCallback: function(responseData) {
                                    if (responseData) {
                                        alert("Issue details: "+angular.toJson(responseData, true));
                                        $scope.issueDetails = responseData;
                                        self.updateUserNames(responseData);
                                        self.updateStatusList(responseData);
                                    }
                                },
                                failureCallback: function(responseData) {

                                },
                                failureMsgRetention: 0
                            });

                };

                this.fetchData();
            }])