/**
 *
 * @author Schubert Generated Code</br>
 * Date Created: </br>
 * @since  </br>
   build:   </p>
 *
 * code was generated by the Schubert System </br>
 * Schubert system Copyright - NewPortBay LLC copy_right_range</br>
 * The generated code is free to use by anyone</p>
 *
 *
 *
*/

app.controller("Landing_page", [ '$scope', '$rootScope', '$location', '$window', '$q', '$http', 'People_testId', '$ionicPopup',
				    function( $scope, $rootScope, $location, $window, $q, $http, People_testId, $ionicPopup) {

		$scope.People_test = {
		_Id: '',
		_First_name : '', 
		_Last_name : '', 
		_Organization_id : ''
		};



        $scope.search_for_update = function (id) {

		  //this is where the start code goes

		  //this is where the validate code goes


		  //this is where the post code goes
		  $http.get('http://45.55.156.148:8080/Sloan_test_1_10000/Landing_page/search_for_update_People_test/?People_test_id=' + id).success(function(response) {
		  	 console.log('Operation search_for_update People_test successful');
		  $scope.People_test._Id = response._Id;
		  $scope.People_test._First_name = response._First_name;
		  $scope.People_test._Last_name = response._Last_name;
		  $scope.People_test._Organization_id = response._Organization_id;People_testId.setId(undefined)
		  }).error(function(err) {
		  	 alert('You got' + err + 'error');
		  });

		  //this is where the server response code goes

		  //this is where the display server response code goes


		  //this is where the end code goes

        };

        $scope.update = function () {

		  //this is where the start code goes

		  //this is where the validate code goes


		  //this is where the post code goes
		  var deferred = $q.defer();
		  $http.post('http://45.55.156.148:8080/Sloan_test_1_10000/Landing_page/update_People_test/', $scope.People_test).success(function(response) {
		  	 alert('Operation updatePeople_test successful');
		  	 deferred.resolve(response);
		  }).error(function(err) {
		  	 alert('You got' + err + 'error');
		  	 deferred.reject(err);
		  });

		  //this is where the server response code goes

		  //this is where the display server response code goes


		  //this is where the end code goes 
		  return deferred.promise; 


        };




		function handle_search_result(search_result){
			$scope.items = search_result;
		}

		var showPopup = function(verb){
			$ionicPopup.prompt({
				title: verb,
				template: 'Enter the People_test ID to ' + verb,
				inputType: 'text',
				inputPlaceholder: 'Your People_test ID',
				okText: verb
			}).then(function(res) {
				console.log('Your People_testId is', res);
				if (res) {
					id = res;
					$scope.search_for_update(id);
				} else {
					alert('You should enter ID');
				}
		});
		};var id = People_testId.getId();
		if (id) {
			console.log(id);
			$scope.search_for_update(id);
		} else {
			if ($location.path().match('Update-en') || $location.path().match('update-en')) {
			showPopup('Search');
			};
		}


}]);

