'use strict';

/* Services */

var MessageServices = angular.module('MessageServices', [ 'ngResource' ]);

MessageServices.factory('MessageService', [ '$resource', function($resource) {
	return $resource(contextRoot + '/message/:id', {}, {});
} ]);
