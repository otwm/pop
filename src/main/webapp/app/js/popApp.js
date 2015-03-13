'use strict';

/**
 * App Module
 */

var phonecatApp = angular.module('popApp', [ 'ngRoute', 'homeControllers',
		'aritcleControllers', 'articleServices' ]);

phonecatApp.config([ '$routeProvider', '$locationProvider',
		function($routeProvider, $locationProvider) {
			$routeProvider.when('/article', {
				templateUrl : 'article/list.html',
				controller : 'articleListController'
			}).when('/app', {
				templateUrl : 'content.html'
			}).when('/article/:id/form', {
				templateUrl : 'article/form.html',
				controller : 'articleFormController'
			}).when('/article/form', {
				templateUrl : 'article/form.html',
				controller : 'articleFormController'
			}).otherwise({
				redirectTo : '/app'
			});
		} ]);
