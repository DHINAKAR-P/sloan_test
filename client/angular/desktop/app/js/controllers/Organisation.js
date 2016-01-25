 
(function() {
	app.controller('OrganisationController', [ '$rootScope', 
	                                    '$scope', 
	                                    '$http', 
	                                    '$location', 
	                                    '$log', 
	                                    '$timeout', 
	                                    'userService',
	                                    function($rootScope, $scope, $http, $location, $log, $timeout,userService) {

		$log.log("Inside the Organisation controller");
var self=$scope;
		 
self.orgnasationlist='';
		
self.init = function() {
		//http://localhost:8080/SlaonAlone
			$http.get("http://45.55.156.148:8080/Sloan_app_ionic/organization/getAllOrg/").success (function(data) {
				console.log("list of organization",angular.toJson(data));
				
				self.careGiverListVar=["Child Care","Special Needs","Tutoring","Senior care","Pet care","HouseKeeper","Errands"];
				self.customerListVar=["BabySitter","Nanny","PetSitter","HouseKeeper","Senior card provider","Tutor","Odd Jobs Provider/Errands"];
				$scope.orgnasationlist=data;
				})
				.error(function(data) {
					$log.log("can't create a careGiver", data);
			});	
		
		};
		
	
		/*self.careGiverList=function(){
			
		};*/
		
		self.customerLookingFor=function(result){
			console.log("Customer ---",angular.toJson(result));
			$location.url("/en-US/customer");
		};
		
		self.CareGiverIamA=function(result){
			console.log("Customer ---",angular.toJson(result));
			$location.url("/en-US/careGiver");
		};
		
		
		self.organization=function(data){
			console.log("in org method",data);
			userService.UserObject.organisation=data;
			console.log("in service method",angular.toJson(userService.UserObject));
			$location.url("/en-US/UserType");

		};
		self.init();
 
	} ]); 

})(); 
