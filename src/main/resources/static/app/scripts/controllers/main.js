'use strict';

/**
 * @ngdoc function
 * @name myAwesomeAppApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the myAwesomeAppApp
 */
angular.module('myAwesomeAppApp')
  .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
