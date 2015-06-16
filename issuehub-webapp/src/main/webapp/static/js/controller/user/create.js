issuehubApp.controller('createUserController',
        ['$scope', '$http', 'MessageService',
            function($scope, $http, MessageService) {

                $scope.userDetails = {};

                $scope.createUser = function() {

                    alert(angular.toJson($scope.userDetails, true));

                    $http({
                        method: 'POST',
                        url: 'api/users/',
                        data: $scope.userDetails,
                        headers: {'Content-Type': 'application/json'}
                    })
                            .success(function(data, status, headers, config) {
                                console.log("Success. Data: " + data);
                                MessageService.setMessage('success', 'Successfully created user '
                                        + $scope.userDetails.userName);
                            })
                            .error(function(data, status, headers, config) {
                                console.log(data);
                                if (data.hasOwnProperty("msg")) {
                                    MessageService.setMessage('error', data.msg)
                                }
                                else {
                                    MessageService.setMessage('error', 'Could not create user')
                                }
                            });
                }

            }])