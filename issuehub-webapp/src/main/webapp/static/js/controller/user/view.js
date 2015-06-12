issuehubApp.controller('viewUserController', ['$scope', '$routeParams', '$http',
    function($scope, $routeParams, $http) {

        $scope.userId = $routeParams.userId;

        $scope.somevar = "fsf";


    }])