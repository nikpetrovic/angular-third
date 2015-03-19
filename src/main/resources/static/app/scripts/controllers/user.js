'use strict';

/**
 * @ngdoc function
 * @name staticApp.controller:UserCtrl
 * @description # UserCtrl Controller of the staticApp
 */
angular.module('myAwesomeAppApp').controller('UserCtrl', function($scope, $http) {
	$http.get('users/list').then(function(response) {
		console.log(response.data);
		$scope.users = response.data;
	});
});
