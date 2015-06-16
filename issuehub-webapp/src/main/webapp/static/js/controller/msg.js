issuehubApp.controller('msgController',
        ['$scope', 'MessageService',
            function($scope, MessageService) {

                var self=this;

                $scope.msgType = null;
                $scope.msgText = null;
                $scope.msgRetention = 0;

                $scope.close = function() {
                    $scope.msgType = null;
                    $scope.msgText = null;
                    $scope.msgRetention = 0;
                };

                this.showMessage = function() {
                    var msg = MessageService.getMessage();
                    $scope.msgType = msg.msgType;
                    $scope.msgText = msg.msgText;
                    $scope.msgRetention = msg.msgRetention;
                };

                $scope.$on('msg-changed', function() {
                    self.showMessage();
                });

                $scope.$on('$routeChangeSuccess', function(event) {
                    self.showMessage();
                });
            }])