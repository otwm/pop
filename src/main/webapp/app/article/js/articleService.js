'use strict';

/* Services */

var articleServices = angular.module('articleServices', [ 'ngResource' ]);

articleServices.factory('articleService', [ '$resource', function($resource) {
	return $resource('/article.json', {}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);
