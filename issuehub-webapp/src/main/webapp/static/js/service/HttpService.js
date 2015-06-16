issuehubApp.service("HttpService",
        ['$http', 'MessageService',
            function($http, MessageService) {

                this.call = function(url, method, requestData, callOptions) {
                    console.log(angular.toJson(requestData, true));

                    $http({
                        method: method,
                        url: url,
                        data: requestData,
                        headers: {'Content-Type': 'application/json'}
                    })
                            .success(function(responseData, status, headers, config) {

                                console.log("Success. Response Data:" + angular.toJson(responseData, true));
                                if (callOptions.successMessage) {
                                    MessageService.setMessage('success',
                                            callOptions.successMessage, callOptions.msgRetention);
                                }

                                callOptions.successCallback(responseData);
                            })
                            .error(function(responseData, status, headers, config) {
                                console.log("Error. Response Data:" + angular.toJson(responseData, true));
                                if (responseData.hasOwnProperty("msg")) {
                                    MessageService.setMessage('error',
                                            responseData.msg, callOptions.msgRetention);
                                }
                                else {
                                    if (callOptions.failureMesssage) {
                                        MessageService.setMessage('error',
                                                callOptions.failureMesssage, callOptions.msgRetention);
                                    }
                                }

                                callOptions.failureCallback(responseData);
                            });
                };



            }])
