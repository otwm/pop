'use strict';

/**
 * App Module
 */

var phonecatApp = angular.module('popApp', [ 
	'ngRoute'
	,'homeControllers'
	,'aritcleControllers'
	,'articleServices'
]);

phonecatApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/article', {
		templateUrl : 'article/list.html',
		controller : 'articleListController'
	}).when('/app', {
		templateUrl : 'content.html'
	})
	.otherwise({
		redirectTo : '/app'
	});
} ]);
