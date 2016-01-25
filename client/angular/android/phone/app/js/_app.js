/**
 * Created by Henrikh on 1/20/16.
 */

/**
 *
 * @author Geppetto Generated Code</br>
 * Date Created: </br>
 * @since  </br>
 build:   </p>
 *
 * code was generated by the Geppetto System </br>
 * Geppetto system Copyright - NewPortBay LLC </br>
 * The generated code is free to use by anyone</p>
 *
 *
 *
 */

var app = angular.module('Sloan', ['ionic', 'social', 'Sloan_test_11'])

  .run(function ($ionicPlatform) {
    $ionicPlatform.ready(function () {
      // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
      // for form inputs)

      if (window.cordova && window.cordova.plugins.Keyboard) {
        cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
        cordova.plugins.Keyboard.disableScroll(true);

      }
      if (window.StatusBar) {
        // org.apache.cordova.statusbar required
        StatusBar.styleDefault();
      }
    });
  })

  .config(function ($stateProvider, $urlRouterProvider) {

    $stateProvider

      // setup an abstract state for the tabs directive

      .state('app', {
        url: '/app',
        abstract: true,
        templateUrl: 'app/views/menu.html'
      })

      .state('home', {
        url: '/home',
        controller: 'Authentication',
        templateUrl: 'app/views/home/home.html'
      })

      .state('auth', {
        url: '/auth',
        controller: 'Authentication',
        templateUrl: 'app/views/en-US/user/auth.html'
      })

      //S.A

      .state('organization', {
        url: '/organization',
        controller: 'OrganizationController',
        templateUrl: 'app/views/organisations/organization.html'
      })


      .state('profile', {
        url: '/profile',
        //controller: 'IntroController',
        templateUrl: 'app/views/en-US/user/profile.html'
      })


      .state('app.First_time_setup-en', {
        url: '/First_time_setup-en',
        views: {
          'menuContent': {
            templateUrl: 'app/views/en/First_time_setup-en.html',
            controller: 'First_time_setup'
          }
        }
      })

      .state('app.Ft_set_up_org_selection-en', {
        url: '/Ft_set_up_org_selection-en',
        views: {
          'menuContent': {
            templateUrl: 'app/views/en/Ft_set_up_org_selection-en.html',
            controller: 'Landing_page'
          }
        }
      });


    // if none of the above states are matched, use this as the fallback
    $urlRouterProvider.otherwise('/home');

  })

  .factory('People_testId', function () {
    var id = '';
    return {
      setId: function (id) {
        this.id = id;
      },
      getId: function () {
        return this.id;
      }
    }
  })

  .controller('MainCtrl', ['$scope', function ($scope) {
    $scope.hideSidemenuBackButton = true;
    var top_menu_items;
    top_menu_items = $scope.menu_items =
      [

        {
          is_first_level: true,
          name: "First_time_setup",
          label: "first_time_setup",
          id: 181,
          screens: [
            {
              id: 293,
              is_first_level: false,
              name: "First_time_setup-en",
              label: "first_time_setup"
            },
            {
              id: 295,
              is_first_level: false,
              name: "First_time_setup-en",
              label: "first_time _setup"
            }]
        },
        {
          is_first_level: true,
          name: "Landing_page",
          label: "landing_page",
          id: 182,
          screens: [
            {
              id: 294,
              is_first_level: false,
              name: "Ft_set_up_org_selection-en",
              label: "select org screen"
            }]
        },
        {
          is_first_level: true,
          name: "Authentication",
          label: "login",
          id: 183,
          screens: []
        },
        {
          is_first_level: true,
          name: "MailChimp Activity",
          label: "MailChimp",
          id: 184,
          screens: []
        }
      ];

    var getByParentId = function (id) {
      for (var i in top_menu_items) {
        if (top_menu_items[i].id == id) {
          return top_menu_items[i].screens;
        }
      }
    };

    $scope.showSubcategories = function (category) {
      $scope.menu_items = getByParentId(category.id);
      $scope.hideSidemenuBackButton = false;
    };

    $scope.showTopLevelCategories = function () {
      $scope.menu_items = top_menu_items;
      $scope.hideSidemenuBackButton = true;
    };
  }]);


var social = angular.module('social', ['ionic'])

  .config(function ($stateProvider, $urlRouterProvider) {
    //FacebookProvider.init('1008436239221044');

    //$stateProvider
    //  .state('home', {
    //    url: '/auth',
    //    controller: 'Authentication',
    //    templateUrl: 'app/views/home/home.html'
    //  });
    //
    //$stateProvider
    //  .state('signUp', {
    //    url: '/signUp',
    //    controller: 'Authentication',
    //    templateUrl: 'app/views/en-US/user/auth.html'
    //  });
    //
    ////S.A
    //
    //$stateProvider
    //  .state('organization', {
    //    url: '/organization',
    //    controller: 'IntroController',
    //    templateUrl: 'app/views/organisations/organization.html'
    //  });
    //
    //
    //$stateProvider
    //  .state('profile', {
    //    url: '/profile',
    //    //controller: 'IntroController',
    //    templateUrl: 'app/views/en-US/user/profile.html'
    //  });

    //S.A

    $urlRouterProvider.otherwise('/home');
  })

  .run(function ($ionicPlatform) {
    $ionicPlatform.ready(function () {
      if (window.cordova && window.cordova.plugins.Keyboard) {
        cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
      }
      if (window.StatusBar) {
        StatusBar.styleDefault();
      }
    });
  });

angular.module('Sloan_test_11', ['ngRoute', 'ngCookies', 'ui.bootstrap',
  'ui.grid', 'ui.grid.pagination', 'ui.grid.resizeColumns', 'ui.grid.edit'])

  .config(function ($routeProvider) {
    $routeProvider
      .when('/organization/', {
        templateUrl: 'app/views/en-US/user/organization.html',
        controller: 'OrganizationController'
      })
      .when('/First_time_setup-en/', {
        templateUrl: 'app/views/en/First_time_setup-en.html',
        controller: 'First_time_setup'
      })
      .when('/en-US/user/profile/', {
        templateUrl: 'app/views/en-US/user/profile.html',
        controller: 'Landing_page'
      })
      .when('/en-US/campaigns/', {
        templateUrl: 'app/views/en-US/user/campaigns.html',
        controller: 'CampaignController'
      })
      .when('/en-US/campaign/:action/', {
        templateUrl: 'app/views/en-US/user/campaign.html',
        controller: 'CampaignController'
      })
      .otherwise({});
  });