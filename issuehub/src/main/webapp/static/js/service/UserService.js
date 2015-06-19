issuehubApp.service("UserService",
        ['$rootScope', '$location', 'HttpService', 'MessageService',
            function($rootScope, $location, HttpService, MessageService) {

                var self = this;

                this.users = [];

                this.setUsers = function(users) {
                    //alert(angular.toJson(issueTypes,true));
                    this.users = angular.fromJson(angular.toJson(users));
                };

                this.fetchUsers = function(successCallback) {
                    //get session from backend
                    HttpService.call('api/users/', 'GET', {},
                            {
                                successCallback: function(responseData) {
                                    if (responseData) {
                                        self.setUsers(responseData);
                                    }
                                    if (successCallback) {
                                        successCallback(responseData);
                                    }
                                },
                                failureCallback: function(responseData) {

                                }
                            });
                };

                this.getUsers = function() {
                    return this.users;
                };

                this.getUser = function(userId) {
                    for (var user in this.users) {
                        if (user.userId===userId){
                            return user;
                        }
                    }
                    
                    return null;
                };

                this.fetchUsers();

            }])


