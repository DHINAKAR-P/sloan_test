/**
 * Created by Henrikh on 1/20/16.
 */

app.controller('ProfileController', ['$scope', '$state', '$http', '$ionicPopup', 'RestURL', 'People_testId', 'Settings',
    function ($scope, $state, $http, $ionicPopup, RestURL, People_testId, Settings) {

    var self = $scope;

    console.log('Profile');
    console.log(Settings.global);

    self.firstName = Settings.global.user.firstName;
    self.lastName = Settings.global.user.lastName;

    var chart = c3.generate({
        data: {
            columns: [
                ['canceled', 80],
                ['hired', 120]
            ],
            type: 'donut',
            colors: {
                canceled: '#f5f5f5',
                hired: '#387ef5'
            },
            onclick: function (d, i) {
                console.log('onclick', d, i);
            },
            onmouseover: function (d, i) {
                console.log('onmouseover', d, i);
            },
            onmouseout: function (d, i) {
                console.log('onmouseout', d, i);
            }
        },
        donut: {
            title: 'Job Success'
        }
    });
}]);