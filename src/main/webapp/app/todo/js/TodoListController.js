'use strict';

/* Controllers */
var todoControllers = angular.module('TodoControllers', []);

todoControllers = todoControllers.controller('TodoListController', [ '$scope', '$location',
		'todoService','$timeout', function($scope, $location, todoService,$timeout) {
			$scope.todos = todoService.query();
			$scope.addTodo = function(){
				$scope.todos.push({});
			};
			$scope.save = function(todo){
				if(todo.id){
					todoService.update(todo,function(result){
						alert('저장 되었습니다.');
					});
				}else{
					todoService.save(todo,function(result){
						alert('저장 되었습니다.');
					});
				}
			};
			$scope.delete = function(todo) {
				if(confirm('삭제 하시겠습니까?')){
					todoService.remove({id:todo.id}, function(result) {
						alert('삭제 되었습니다.');
						$scope.go('/todo');
					});
				}
			};
			
			$scope.todoRemaining = function(){
				var count = 0;
				for(var todo in $scope.todos){
					if($scope.todos[todo].isDone === false)count++;
				}
				return count;
			};
			
			$scope.message = '';
			$scope.ws;
			$scope.echoMessages = [];

			$scope.init = function() {
				$scope.ws = new WebSocket('ws://localhost:8080/echo');
				$scope.ws.onopen = function() {
					console.log('websocket opened');
				};
				$scope.ws.onmessage = function(message) {
					console.log(message);
					console.log('receive message : ' + message.data);
					$scope.echoMessages.unshift(message.data);
					$timeout(function() {
						$scope.$apply('echoMessages');
					})
				};
				$scope.ws.onclose = function(event) {
					console.log(event);
					console.log('websocket closed');
				};
			};

			$scope.send = function() {
				$scope.ws.send($scope.message);
			};

			$scope.init();
		}]);