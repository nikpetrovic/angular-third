'use strict';

/**
 * @ngdoc overview
 * @name myAwesomeAppApp
 * @description
 * # myAwesomeAppApp
 *
 * Main module of the application.
 */
angular
  .module('myAwesomeAppApp', [
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
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
