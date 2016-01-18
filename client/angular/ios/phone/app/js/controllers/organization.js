/**
 * Created by Henrikh on 1/13/16.
 */

app.controller('OrganizationController', ['$scope', '$state', '$location', '$http', 'RestURL', 'Settings',
  function ($scope, $state, $location, $http, RestURL, Settings) {

    var self = $scope;

    $http.get(RestURL.baseURL + 'sloan_test/organization/getAllOrg/')
      .success(function (response) {
        self.organizations = response;
        self.organizations = [
          {
            organisationName: 'Kappa Alpha Theta'
          },
          {
            organisationName: 'Alpha Omicron Pi'
          },
          {
            organisationName: 'Delta Tau Delta'
          },
          {
            organisationName: 'Kappa Sigma'
          }
        ];
      })
      .error(function (error) {
        console.warn(error);
      });


    self.submit = function () {
      console.log(self.organization);
      if (self.organization) {
        Settings.global.organization = self.organization;

        console.log('Organization');

        //$http.post(RestURL.baseURL + '')
        //    .success(function (response) {
        //        console.log(response);
        //    })
        //    .error(function (error) {
        //        console.warn(error);
        //    });

        $state.go('profile');
      }

      return false;
    };
  }]);
