issuehubApp.service("IssueTypeService",
        ['$rootScope', '$location', 'HttpService', 'MessageService',
            function($rootScope, $location, HttpService, MessageService) {

                var self = this;

                this.issueTypes = [];

                this.setIssueTypes = function(issueTypes) {
                    //alert(angular.toJson(issueTypes,true));
                    this.issueTypes = angular.fromJson(angular.toJson(issueTypes));
                };

                this.fetchIssueTypes = function(successCallback) {
                    //get session from backend
                    HttpService.call('api/issuetypes/', 'GET', {},
                            {
                                successCallback: function(responseData) {
                                    if (responseData) {
                                        self.setIssueTypes(responseData);
                                    }
                                    if (successCallback) {
                                        successCallback(responseData);
                                    }
                                },
                                failureCallback: function(responseData) {

                                }
                            });
                };

                this.getIssueTypes = function() {
                    return this.issueTypes;
                };

                this.getIssueType = function(issueTypeId) {
                    for (var issueType in this.issueTypes) {
                        if(issueType.issueTypeId===issueTypeId){
                            return issueType;
                        }
                    }
                    
                    return null;
                };

                this.fetchIssueTypes();

            }])
