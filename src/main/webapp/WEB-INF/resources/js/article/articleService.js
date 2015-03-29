'use strict';

/* Services */

var articleServices = angular.module('articleServices', [ 'ngResource' ]);

articleServices.factory('articleService', [ '$resource', function($resource) {
	return $resource(contextRoot + '/article/:id', {
		id : '@id'
	}, {
		update : {
			method : 'PUT'
		},
		query : {
			method : 'GET',
			isArray : true,
			params : {
				kind : '@kind',
				text : '@text'
			}
		}
	});
} ]);
