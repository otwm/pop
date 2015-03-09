'use strict';

/* Controllers */
var _articleService;
var aritcleControllers = angular.module('aritcleControllers', []);

aritcleControllers.controller('articleListController', [ '$scope',
		'articleService', function($scope, articleService) {
			$scope.articles = articleService.query();
			console.log($scope.articles.length);
			_articleService = articleService;
		} ]);

aritcleControllers.controller('aritcleEditController', [ '$scope',
		'$routeParams', 'articleService',
		function($scope, $routeParams, articleService) {
	//TODO:에디트 소스
		} ]);
