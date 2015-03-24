angular.module('myAwesomeApp').controller('CreateUserCtrl',
	[ '$scope', '$http', 'ModalService', function($scope, $http, ModalService) {
	    $scope.createUser = function() {
		$http.post('/users/createUser', $scope.newUser).then(function(response) {
		    $scope.message = response.data.status;
		});
	    };
	} ]);