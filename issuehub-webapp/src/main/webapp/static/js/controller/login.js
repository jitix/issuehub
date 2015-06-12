issuehubApp.controller('loginController', ['$scope', '$http', function($scope, $http) {

        this.postForm = function() {

            var encodedString = 'username=' +
                    encodeURIComponent(this.inputData.username) +
                    '&password=' +
                    encodeURIComponent(this.inputData.password);

            $http({
                method: 'POST',
                url: 'check-login.php',
                data: encodedString,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            })
                    .success(function(data, status, headers, config) {
                        console.log(data);
                        if (data.trim() === 'correct') {
                            window.location.href = 'success.html';
                        } else {
                            $scope.errorMsg = "Login not correct";
                        }
                    })
                    .error(function(data, status, headers, config) {
                        $scope.errorMsg = 'Unable to submit form';
                    })
        }

    }])