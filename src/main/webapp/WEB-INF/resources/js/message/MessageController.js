'use strict';

/**
 * message controller
 */
var MessageControllers = angular.module('MessageControllers', []);

MessageControllers.controller('MessageController', [ '$scope', '$location',
		'MessageService', function($scope, $location, messageService) {
			var socket, stompClient;
			(function socketInit() {
				socket = new SockJS(contextRoot + '/endpoint');
				stompClient = Stomp.over(socket);
				stompClient.connect({}, function(frame) {
					if(console)console.log("connected!!!");
					
					stompClient.subscribe('/topic/users', function(users) {
						console.log(users.body);
					});
				});
			})();
			
			$scope.getUsers = function(){
				stompClient.send('/app/users',{});
			};

		} ]);
