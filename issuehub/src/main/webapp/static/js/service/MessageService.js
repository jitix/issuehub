issuehubApp.service("MessageService",
        ['$rootScope',
            function($rootScope) {

                this.msg = {msgType: null, msgText: null, msgRetention: 0};

                this.setMessage = function(msgType, msgText, msgRetention) {
                    this.msg.msgType = msgType;
                    this.msg.msgText = msgText;
                    this.msg.msgRetention = msgRetention;

                    $rootScope.$broadcast('msg-changed');
                };

                this.getMessage = function() {
                    var msgCopy = angular.fromJson(angular.toJson(this.msg));
                    if (this.msg.msgRetention < 0) {
                        this.msg = {msgType: null, msgText: null, msgRetention: 0};
                    }
                    else {
                        this.msg.msgRetention = this.msg.msgRetention - 1;
                    }

                    return msgCopy;
                };
            }])