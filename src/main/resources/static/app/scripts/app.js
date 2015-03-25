'use strict';

/**
 * @ngdoc overview
 * @name myAwesomeApp
 * @description
 * # myAwesomeApp
 *
 * Main module of the application.
 */
angular
  .module('myAwesomeApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/users/list', {
        templateUrl: 'views/users.html',
        controller: 'UserCtrl'
      })
      .when('/users/user/:userId', {
        templateUrl: 'views/userProfile.html',
        controller: 'UserProfileCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
