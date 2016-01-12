/**
 * Login Controller is used to check whether the given input is right or wrong
 * in DB.
 * 
 */
(function() {
	/*var app = angular.module('Sloan_test_1');*/
	app.controller('LoginController', [ '$rootScope', '$scope', '$http', '$location', '$log', '$timeout', function($rootScope, $scope, $http, $location, $log, $timeout) {

		$log.log("Inside the Login Controller");

		$scope.userDetails = {};

		$scope.doLogin = function(loginform,userDetails) {
			$log.log("Inside the doLogin()");
			if (loginform.$valid) {
				if (userDetails.emailAddress != null || userDetails.emailAddress != "" && userDetails.password != null || userDetails.password != "") {
					//var login = "http://localhost:8080/sloanTest/login/loginValidation"
					$log.log("Inside the doLogin() Details cheking",angular.toJson(userDetails));
					if(userDetails.emailAddress == 'sloan@gmail.com'  && userDetails.password == 'sloan'){
						alert('Login SuccessFull');
					}
					else{
						alert('Invalid Crendentials');
					}
				/*	$http({
						method : "POST",
						url : login,
						data : angular.toJson(userDetails),
						headers : {
							"Content-Type" : "application/json"
						},
						success : function(data) {
							$log.log("User SuccessFully Logged In ", data);
						},
						error : function(data) {
							$log.log("Invalid Details please provide valid  Log In ", data);
						}
					});	*/
				}
			} else {
				alert('You must Enter all the field')
			}
		}
	} ]);// Controller Ends

})();// function ends
