issuehubApp.controller('msgController',
        ['$scope', 'MessageService',
            function($scope, MessageService) {

                $scope.msgType = null;
                $scope.msgText = null;
                $scope.msgRetention = 0;

                $scope.$on('msg-changed', function() {
                    var msg = MessageService.getMessage();
                    $scope.msgType = msg.msgType;
                    $scope.msgText = msg.msgText;
                    $scope.msgRetention = msg.msgRetention;
                });

                $scope.$on('$locationChangeStart', function(event) {
                    //alert($scope.msgType+" "+$scope.msgText+" "+$scope.msgRetention)
                    if ($scope.msgRetention <= 0) {
                        $scope.msgType = null;
                        $scope.msgText = null;
                        $scope.msgRetention=0;
                    }
                    else {
                        $scope.msgRetention = $scope.msgRetention - 1;
                    }
                });
            }])