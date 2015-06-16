issuehubApp.controller('navController', 
['$scope', '$rootScope', '$http','MessageService',
    function($scope, $rootScope, $http, MessageService) {

        $scope.loggedIn = ($rootScope.userDetails !== null);
        $scope.isAdmin = ($rootScope.userDetails !== null) && $rootScope.userDetails.adminFlag;

        this.sendMsgTest = function() {
            MsgService.setMessage('err','Error');
        };

        this.logout = function() {

            $http({
                method: 'POST',
                url: 'api/session/remove',
                data: {},
                headers: {'Content-Type': 'application/json'}
            })
                    .success(function(data, status, headers, config) {
                        console.log(data);
                        if (data.trim() === 'correct') {
                            window.location.href = 'success.html';
                        } else {
                            $scope.errorMsg = "Login not correct";
                        }
                    })
                    .error(function(data, status, headers, config) {
                        $scope.errorMsg = 'Unable to submit form';
                    })
        }

    }])