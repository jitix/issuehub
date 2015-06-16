// configure our routes
issuehubApp.config(function($routeProvider) {
    $routeProvider

            // route for the home page
//            .when('/', {
//                redirectTo: '/dashboard'
//            })

            .when('/login', {
                templateUrl: viewPath + 'login.html',
                controller: 'loginController'
            })

            .when('/', {
                templateUrl: viewPath + 'dashboard.html',
                controller: 'dashboardController'
            })

            .when('/users', {
                templateUrl: viewPath + 'user/list.html',
                controller: 'listUserController'
            })

            .when('/users/create', {
                templateUrl: viewPath + 'user/create.html',
                controller: 'createUserController'
            })

            .when('/users/:userId', {
                templateUrl: viewPath + 'user/view.html',
                controller: 'viewUserController'
            })
});