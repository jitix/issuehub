issuehubApp.controller('dashboardController',
        ['$scope', 'SessionService',
            function($scope, SessionService) {
                SessionService.checkUserSessionForDashboard("login","Please login to continue");


            }])