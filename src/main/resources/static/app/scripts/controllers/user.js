'use strict';

/**
 * @ngdoc function
 * @name staticApp.controller:UserCtrl
 * @description # UserCtrl Controller of the staticApp
 */
angular
		.module('myAwesomeApp')
		.controller(
				'UserCtrl',
				[
						'$scope',
						'$http',
						'$route',
						function($scope, $http, $route) {
							$scope.uploader = {};

							$http.get('/users/list').then(function(response) {
								$scope.users = response.data;
							});

							$("#createUserModal").on('shown.bs.modal', function() {
								$("input[name='firstName']").focus();
							});

							$scope.searchText = '';
							$scope.filterUsers = function(user) {
								return (user.firstName.toLowerCase().match($scope.searchText.toLowerCase())
										|| user.lastName.toLowerCase().match($scope.searchText.toLowerCase()) || user.username
										.toLowerCase().match($scope.searchText.toLowerCase()));
							};

							$scope.createUser = function() {
								$scope.message = null;
								$http.post('/users/createUser', $scope.newUser).then(function(response) {
									if (response.data.status === 'succeeded') {
										if ($scope.uploader.flow.files[0] != null) {
											$scope.uploader.flow.opts.query.userId = response.data.userId;
											$scope.uploader.flow.files[0].retry();
										}
									} else {
										$scope.message = response.data.message;
									}
								});
							};

							$scope.checkFileSize = function() {
								if ($scope.uploader.flow.files[0].size > (1024 * 1024)) {
									$scope.message = "The file '"
											+ $scope.uploader.flow.files[0].name
											+ "' exceeds the maximum alowed size of 1 MB. Please choose another one or create user without photo.";
									$scope.uploader.flow.removeFile($scope.uploader.flow.files[0]);
								} else {
									$scope.message = null;
								}
							}

							$scope.onUploadError = function() {
								$scope.message = "Error while uploading file";
							}

							$scope.onUploadCompleted = function() {
								$("#createUserModal").on('hidden.bs.modal', function() {
									$route.reload();
								});

								// wait a half a second to fill progress bar
								setTimeout(function() {
									$("#createUserModal").modal('hide');
								}, 500);
							}

						} ]);