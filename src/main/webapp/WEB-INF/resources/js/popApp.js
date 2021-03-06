'use strict';

/**
 * App Module
 */

var popApp = angular.module('popApp', [ 'ngRoute', 'homeControllers',
		'aritcleControllers', 'articleServices','todoServices','TodoControllers' ]);

popApp.config([ '$routeProvider', '$locationProvider',
		function($routeProvider, $locationProvider) {
	
			$routeProvider.when('/article', {
				templateUrl : contextRoot + '/article/list',
				controller : 'articleListController'
			}).when('/', {
				templateUrl : contextRoot + '/content'
			}).when('/article/:id/form', {
				templateUrl : contextRoot + '/article/form',
				controller : 'articleFormController'
			}).when('/article/form', {
				templateUrl : contextRoot + '/article/form',
				controller : 'articleFormController'
			}).when('/todo', {
				templateUrl : contextRoot + '/todo/list',
				controller : 'TodoListController'
			}).otherwise({
				redirectTo : '/'
			});
			
		} ]);
