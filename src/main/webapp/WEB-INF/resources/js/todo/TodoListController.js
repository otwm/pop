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
			
			$scope.client;
			$scope.name = '';
			$scope.message = '';
			
			$scope.init = function() {
				var socket = new SockJS(contextRoot + '/endpoint');
				$scope.client = Stomp.over(socket);
				$scope.client.connect({}, function(frame) {
					console.log('connected stomp over sockjs');
					// subscribe message
					$scope.client.subscribe(contextRoot +'/subscribe/echo', function(message) {
						console.log('receive subscribe');
						console.log(message);
					});
					
					$scope.client.subscribe(contextRoot +'/subscribe/test', function(message) {
						console.log('receive subscribe');
						console.log(message);
					});
				});
			};

			// send message
			$scope.send = function() {
				var data = {
					name: $scope.name,
					message: $scope.message
				};
				$scope.client.send(contextRoot + '/app/echo', {}, JSON.stringify(data));
				$scope.client.send(contextRoot + '/app/test', {}, JSON.stringify(data));
			};
			
			$scope.init();
		}]);