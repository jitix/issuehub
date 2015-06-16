issuehubApp.controller('listUserController',
        ['$scope', 'HttpService', 'SessionService',
            function($scope, HttpService, SessionService) {
                
                SessionService.checkAdminUserSession(
                        '/','You need to be an admin user to view user list');
            }])

