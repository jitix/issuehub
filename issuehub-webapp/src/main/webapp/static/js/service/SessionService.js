issuehubApp.service("SessionService",
        ['$rootScope', '$location', 'HttpService', 'MessageService',
            function($rootScope, $location, HttpService, MessageService) {

                var self = this;

                this.userDetails = {};

                this.setCurrentUser = function(userDetails) {
                    //alert("Setting current user:" + angular.toJson(userDetails));
                    this.userDetails = angular.fromJson(angular.toJson(userDetails));
                    $rootScope.$broadcast('session-changed');
                };

                this.updateCurrentUser = function(successCallback) {
                    //get session from backend
                    HttpService.call('api/session/', 'GET', {},
                            {
                                successCallback: function(responseData) {
                                    if (responseData) {
                                        //alert("Response: " + angular.toJson(responseData, true));
                                        self.setCurrentUser(responseData);
                                    }
                                    if (successCallback) {
                                        successCallback(responseData);
                                    }
                                },
                                failureCallback: function(responseData) {

                                }
                            });
                };

                this.getCurrentUser = function() {
                    return this.userDetails;
                };

                this.isUserSession = function() {
                    if (this.userDetails.userId) {
                        return true;
                    }
                    else {
                        return false;
                    }
                };

                this.isAdminSession = function() {
                    if (this.userDetails.userId && this.userDetails.adminFlag) {
                        return true;
                    }
                    else {
                        return false;
                    }
                };

                this.checkUserSession = function(errorRedirect, errorMessage) {

                    this.updateCurrentUser(function(responseData) {
                        if (!responseData.userId) {
                            MessageService.setMessage('error', errorMessage, 1);
                            $location.path(errorRedirect);
                        }
                    });
                };

                this.checkAdminUserSession = function(errorRedirect, errorMessage) {
                    //alert("checking admin session. msg: "+errorMessage);
                    this.updateCurrentUser(function(responseData) {
                        if (!(responseData.userId && responseData.adminFlag)) {
                            MessageService.setMessage('error', errorMessage, 1);
                            $location.path(errorRedirect);
                        }
                    });
                };

                this.removeUser = function() {
                    this.userDetails = {};
                    $rootScope.$broadcast('session-changed');
                };

            }])