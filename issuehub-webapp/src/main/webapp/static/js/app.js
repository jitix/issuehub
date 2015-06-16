var viewPath = 'static/view/';

//create module
var issuehubApp = angular.module('issuehubApp', ['ngRoute']);

issuehubApp.run(
        ['$rootScope','$location', 'HttpService', 'SessionService',
            function($rootScope,$location, HttpService, SessionService) {
                
                SessionService.updateCurrentUser();
                
//                //get session from backend
//                HttpService.call('api/session/', 'GET', {},
//                        {
//                            successCallback: function(responseData) {
//                                alert(angular.toJson(responseData,true))
//                                if (responseData) {
//                                    SessionService.setCurrentUser(responseData);
//                                    //$location.path("/");
//                                }
//                            },
//                            failureCallback: function(responseData) {
//
//                            }
//                        });
            }]
        )
