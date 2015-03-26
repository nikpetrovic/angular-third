'use strict';
angular.module('myAwesomeApp').controller('UserProfileCtrl',
		[ '$scope', '$http', '$location', '$routeParams', function($scope, $http, $location, $routeParams) {
			$http.get('/users/user/' + $routeParams.userId).then(function(response) {
				$scope.user = response.data;
			});

			$scope.deleteUser = function(user) {
				$http.post('/users/delete', user).then(function(response) {
					if (response.data.status === 'succeeded') {
						$("#userDeletionConfirmationModal").on('hidden.bs.modal', function() {
							$location.path('/users/list');
							$scope.$apply();
						});
						$("#userDeletionConfirmationModal").modal('hide');
					} else {
						$scope.message = response.data.message;
					}
				});
			}
		} ]);