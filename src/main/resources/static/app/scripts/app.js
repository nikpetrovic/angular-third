'use strict';

/**
 * @ngdoc overview
 * @name myAwesomeApp
 * @description # myAwesomeApp
 * 
 * Main module of the application.
 */
angular.module('myAwesomeApp', [ 'ngAnimate', 'ngCookies', 'ngResource', 'ngRoute', 'ngSanitize', 'ngTouch', 'flow' ])
		.config([ '$routeProvider', 'flowFactoryProvider', function($routeProvider, flowFactoryProvider) {
			$routeProvider.when('/', {
				templateUrl : 'views/main.html',
				controller : 'MainCtrl'
			}).when('/users/list', {
				templateUrl : 'views/users.html',
				controller : 'UserCtrl'
			}).when('/users/user/:userId', {
				templateUrl : 'views/userProfile.html',
				controller : 'UserProfileCtrl'
			}).when('/about', {
				templateUrl : 'views/about.html',
				controller : 'AboutCtrl'
			}).otherwise({
				redirectTo : '/'
			});

			flowFactoryProvider.defaults = {
				target : '/content/upload',
				permanentErrors : [ 500, 501 ],
				maxChunkRetries : 1,
				chunkRetryInterval : 5000,
				simultaneousUploads : 1,
				singleFile : true
			};
		} ]);