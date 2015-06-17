issuehubApp.controller('dashboardController',
        ['$scope', 'SessionService',
            function($scope, SessionService) {
                SessionService.checkUserSession("login","You need to be logged in to view the dashboard");


            }])