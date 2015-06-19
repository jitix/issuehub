//$('.selectpicker').selectpicker();
//
//$('.selectpicker').selectpicker({
//    style: 'btn-info',
//    size: 4
//});

var viewPath = 'static/view/';

//create module
var issuehubApp = angular.module('issuehubApp', ['ngRoute']);

issuehubApp.run(
        ['$rootScope', '$location', 'HttpService', 'SessionService',
            function($rootScope, $location, HttpService, SessionService) {

                SessionService.updateCurrentUser();

                var history = [];

                $rootScope.$on('$routeChangeSuccess', function() {
                    history.push($location.$$path);
                });

                $rootScope.back = function() {
                    var prevUrl = history.length > 1 ? history.splice(-2)[0] : "/";
                    $location.path(prevUrl);
                };

            }]
        )
