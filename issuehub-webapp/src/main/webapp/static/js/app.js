var viewPath = 'static/view/';

//create module
var issuehubApp = angular.module('issuehubApp', ['ngRoute']);

issuehubApp.run(
        ['$rootScope','$location', 'HttpService', 'SessionService',
            function($rootScope,$location, HttpService, SessionService) {
                
                SessionService.updateCurrentUser();
                
            }]
        )
