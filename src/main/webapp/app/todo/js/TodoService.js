'use strict';

/* Services */

var todoServices = angular.module('todoServices', [ 'ngResource' ]);

todoServices.factory('todoService', [ '$resource', function($resource) {
	return $resource('/todo/:id', {
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
