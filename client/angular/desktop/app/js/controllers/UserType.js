(function() {
	app.controller('UserTypeController', [
			'$rootScope',
			'$scope',
			'$http',
			'$location',
			'$log',
			'$timeout',
			'userService',
			function($rootScope, $scope, $http, $location, $log, $timeout,
					userService) {

				$log.log("Inside the UserTypeController");
				var self = $scope;

				self.orgnasationlist = '';

				self.UserType = function(loginform, userSignUpDetails) {
					if (userSignUpDetails.userType == "CUSTOMER") {
						userService.UserObject.userType="CUSTOMER";
						console.log("user Ob ject======",angular.toJson(userService.UserObject));
						$location.url('/en-US/LookinFor');
					} else if (userSignUpDetails.userType == "CAREGIVER") {
						userService.UserObject.userType="CAREGIVER";
						$location.url('/en-US/IamA');
					}

				};

			} ]);

})();
