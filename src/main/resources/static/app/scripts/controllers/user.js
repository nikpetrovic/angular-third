'use strict';

/**
 * @ngdoc function
 * @name staticApp.controller:UserCtrl
 * @description # UserCtrl Controller of the staticApp
 */
angular.module('myAwesomeApp').controller('UserCtrl', [ '$scope', '$http', '$route', function($scope, $http, $route) {
	$http.get('/users/list').then(function(response) {
		$scope.users = response.data;
	});

	$scope.createUser = function() {
		$scope.message = null;
		$http.post('/users/createUser', $scope.newUser).then(function(response) {
			if (response.data.status === 'succeeded') {
				$("#createUserModal").on('hidden.bs.modal', function() {
					$route.reload();
				});
				$("#createUserModal").modal('hide');
			} else {
				$scope.message = response.data.message;
			}
		});
	};

} ]);
