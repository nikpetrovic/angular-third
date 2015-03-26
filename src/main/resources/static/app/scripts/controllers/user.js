'use strict';

/**
 * @ngdoc function
 * @name staticApp.controller:UserCtrl
 * @description # UserCtrl Controller of the staticApp
 */
angular.module('myAwesomeApp').controller('UserCtrl', [ '$scope', '$http', '$route', function($scope, $http, $route) {
	$scope.uploader = {};

	$http.get('/users/list').then(function(response) {
		$scope.users = response.data;
	});

	$("#createUserModal").on('shown.bs.modal', function() {
		$("input[name='firstName']").focus();
	});

	$scope.createUser = function() {
		$scope.message = null;
		$http.post('/users/createUser', $scope.newUser).then(function(response) {
			if (response.data.status === 'succeeded') {
				if ($scope.uploader.flow.files[0] != null) {
					$scope.uploader.flow.opts.query.userId = response.data.userId;
					$scope.uploader.flow.files[0].retry();
				}

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