'use strict';

/**
 * @ngdoc function
 * @name staticApp.controller:UserCtrl
 * @description # UserCtrl Controller of the staticApp
 */
angular.module('myAwesomeApp').controller('UserCtrl',
	[ '$scope', '$http', '$route', 'ModalService', function($scope, $http, $route, ModalService) {
	    $http.get('/users/list').then(function(response) {
		console.log(response.data);
		$scope.users = response.data;
	    });

	    $scope.createUser = function() {
		$http.post('/users/createUser', $scope.newUser).then(function(response) {
		    $scope.message = response.data.status;
		});
	    };

	    $scope.showAModal = function() {

		// Just provide a template url, a controller and call
		// 'showModal'.
		ModalService.showModal({
		    templateUrl : "views/createUserModal.html",
		    controller : "CreateUserCtrl"
		}).then(function(modal) {
		    // The modal object has the element built, if this is a
		    // bootstrap modal
		    // you can call 'modal' to show it, if it's a custom modal
		    // just show or hide
		    // it as you need to.
		    modal.element.modal();
		    modal.close.then(function(result) {
			$scope.message = result ? "You said Yes" : "You said No";
		    });
		});

	    };

	} ]);
