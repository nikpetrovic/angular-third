'use strict';
angular.module('myAwesomeApp').controller('UserProfileCtrl',
		[ '$scope', '$http', '$routeParams', function($scope, $http, $routeParams) {
			$http.get('/users/user/' + $routeParams.userId).then(function(response) {
				$scope.user = response.data;
			});

		} ]);
