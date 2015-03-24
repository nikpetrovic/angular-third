'use strict';

/**
 * @ngdoc function
 * @name staticApp.controller:UserCtrl
 * @description # UserCtrl Controller of the staticApp
 */
angular.module('myAwesomeAppApp').controller('UserCtrl',
		[ '$scope', '$http', '$route', function($scope, $http, $route) {
			$http.get('/users/list').then(function(response) {
				console.log(response.data);
				$scope.users = response.data;
			});

			$scope.createUser = function() {
				$http.post('/users/createUser', $scope.newUser).then(function(response) {
					$scope.message = response.data.status;
				});
			};
		} ]);
