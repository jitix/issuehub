issuehubApp.service("SessionService",
        ['$rootScope','$location', 'MessageService',
            function($rootScope,$location, MessageService) {

                this.userDetails = {};

                this.setCurrentUser = function(userDetails) {
                    this.userDetails = angular.fromJson(angular.toJson(userDetails));
                    $rootScope.$broadcast('session-changed');
                };
                
                this.getCurrentUser=function(){
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
                    if (!this.isUserSession()) {
                        MessageService.setMessage('error', errorMessage, 1);
                        $location.path(errorRedirect);
                    }
                };

                this.checkAdminUserSession = function(errorRedirect, errorMessage) {
                    if (!this.isAdminSession()) {
                        MessageService.setMessage('error', errorMessage, 1);
                        $location.path(errorRedirect);
                    }
                };

                this.removeUser = function() {
                    this.userDetails = {};
                    $rootScope.$broadcast('session-changed');
                };

            }])