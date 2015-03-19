'use strict';

/**
 * @ngdoc function
 * @name myAwesomeAppApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the myAwesomeAppApp
 */
angular.module('myAwesomeAppApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
