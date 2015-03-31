'use strict';

/**
 * @ngdoc function
 * @name myAwesomeApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the myAwesomeApp
 */
angular.module('myAwesomeApp').controller('AboutCtrl', [ '$scope', '$http', '$route', function($scope, $http, $route) {
	
    $scope.sendMessage = function() {
    	$scope.message = null;
    	$scope.contactMessageSent = false;
    	$scope.submittedName = {};
    	$http.post('/contact/sendMessage', $scope.newMessage).then(function(response) {
			if (response.data.status === 'succeeded') {
				$scope.contactMessageSent = true;
				$scope.submittedName = $scope.newMessage.name;
				$scope.newMessage = {};
				$scope.form.$setPristine();
			} else {
				$scope.message = response.data.message;
			}
		});
    };
    
    $http.get('/users/list').then(function(response) {
		$scope.users = response.data;
	});
} ]);
