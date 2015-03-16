'use strict';

/* Controllers */
var aritcleControllers = angular.module('aritcleControllers', []);

aritcleControllers.controller('articleListController', [ '$scope', '$location',
		'articleService', function($scope, $location, articleService) {
			$scope.query = {};
			$scope.query.kind = 'titleAndContent';
			$scope.search = function() {
				articleService.query($scope.query, function(result) {
					$scope.articles = result;
				});
			};
			$scope.articles = articleService.query();
			$scope.go = function(path) {
				$location.path(path);
			}
		} ]);

aritcleControllers.controller('articleFormController', [ '$scope',
		'$routeParams', '$location', 'articleService',
		function($scope, $routeParams, $location, articleService) {
			$scope.go = function(path) {
				$location.path(path);
			};
			if ($routeParams.id) {
				$scope.article = articleService.get({
					id : $routeParams.id
				});
			}
			;
			$scope.save = function(article) {
				if (article.id) {
					articleService.update(article, function(result) {
						alert('저장 되었습니다.');
					});
				} else {
					articleService.save(article, function(result) {
						alert('저장 되었습니다.');
					});
				}
			};
			$scope.delete = function(id) {
				if(confirm('삭제 하시겠습니까?')){
					articleService.remove({id:$routeParams.id}, function(result) {
						alert('삭제 되었습니다.');
						$scope.go('/article');
					});
				}
			};
		} ]);
