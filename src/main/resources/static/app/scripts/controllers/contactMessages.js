'use strict';

/**
 * @ngdoc function
 * @name myAwesomeApp.controller:ContactmessagesCtrl
 * @description # ContactmessagesCtrl Controller of the myAwesomeApp
 */
angular.module('myAwesomeApp').controller('ContactMessagesCtrl', [ '$scope', '$http', function($scope, $http) {
	$http.get('contact/viewLastMessages').then(function(response) {
		$scope.contactMessages = response.data;
	});
} ]);
