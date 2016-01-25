 
(function() {
	app.controller('SignUpController', [ '$rootScope', 
	                                    '$scope', 
	                                    '$http', 
	                                    '$location', 
	                                    '$log', 
	                                    '$timeout', 
	                                    'userService',
	                                    function($rootScope, $scope, $http, $location, $log, $timeout,userService) {

		$log.log("Inside the SignUp Controller");

		$scope.userSignUpDetails = {
				
				"organisation":{
					"base_organisation_id":"2"
				}
		};
		$scope.orgnasationlist='';
		
		self.init = function() {
		//http://45.55.156.148:8080/Sloan_app_ionic 
			$http.get("http://45.55.156.148:8080/Sloan_app_ionic/organization/getAllOrg/").success (function(data) {
				console.log("list of organization",angular.toJson(data));
				$scope.orgnasationlist=data;
				userService.UserObject.organisation=data;
				})
				.error(function(data) {
					$log.log("can't create a careGiver", data);
			});	
		
		};
		 
		$scope.doSignUp = function(loginform,userSignUpDetails) {
			$log.log("Inside the doSignUp",angular.toJson(userSignUpDetails));
			if (loginform.$valid) {
			/*	if (userSignUpDetails.email != null || userSignUpDetails.email != "" &&  
						userSignUpDetails.passWord != null || userSignUpDetails.passWord != "" &&
						userSignUpDetails.firstName != null || userSignUpDetails.firstName != "" &&
						userSignUpDetails.lastName != null || userSignUpDetails.lastName != "" &&
						userSignUpDetails.phoneNumber != null || userSignUpDetails.phoneNumber != "") {*/
					//var signUp = "http://localhost:8080/sloan_test/signup/create"
					//var signUp = "http://45.55.156.148:8080/sloan_test/signup/create"
				if (userSignUpDetails.email != null || userSignUpDetails.email != "" &&  
						userSignUpDetails.passWord != null || userSignUpDetails.passWord != "" ) {
					$log.log("Inside the doSignUp() Details cheking---",angular.toJson(userSignUpDetails));
					userService.UserObject=userSignUpDetails;
					console.log("user object in service ---",userService.UserObject);
					$location.url('/en-Us/Organisations');
				}
			} else {
				alert('You must Enter all the field')
			}
		}
	} ]); 

})(); 
