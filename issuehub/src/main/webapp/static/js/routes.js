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
            
            .when('/users/:userId/delete', {
                templateUrl: viewPath + 'user/delete.html',
                controller: 'deleteUserController'
            })
            
            .when('/issues', {
                templateUrl: viewPath + 'issue/list.html',
                controller: 'listIssueController'
            })

            .when('/issues/create', {
                templateUrl: viewPath + 'issue/create.html',
                controller: 'createIssueController'
            })

            .when('/issues/:issueNumber', {
                templateUrl: viewPath + 'issue/view.html',
                controller: 'viewIssueController'
            })
            
            .when('/issues/:issueNumber/delete', {
                templateUrl: viewPath + 'issue/delete.html',
                controller: 'deleteIssueController'
            })
});