'use strict';

/**
 * @ngdoc function
 * @name myAwesomeApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the myAwesomeApp
 */
angular.module('myAwesomeApp')
  .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
