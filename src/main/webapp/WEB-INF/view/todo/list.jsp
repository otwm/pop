<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<div class="page-header">
		<h2>
			<span class="glyphicon glyphicon-edit" />Todo<small>조회</small>
		</h2>
	</div>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">
				<button class="btn btn-primary btn-xs glyphicon glyphicon-menu-down"
					style="vertical-align: text-bottom"></button>
				검색
			</h3>
		</div>
		<div class="panel-body">
			<form class="form-inline" role="form" action="/article">
				<div class="form-group">
					<label class="sr-only" for="kind">종류</label> <select
						class="form-control" id="kind" name="kind" ng-model="query.kind">
						<option value="titleAndContent">제목+내용</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
						<option value="writer">글쓴이</option>
					</select>
				</div>
				<div class="form-group">
					<label class="sr-only" for="text">text</label> <input type="text"
						class="form-control" id="text" name="text" ng-model="query.text"
						placeholder="text" />
				</div>
				<button type="button"
					class="btn btn-default glyphicon glyphicon-search"
					ng-click="search()">검색</button>
				<button type="button"
					class="btn btn-default glyphicon glyphicon-pencil"
					ng-click="addTodo()">등록</button>
			</form>
		</div>
	</div>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">
				<button class="btn btn-primary btn-xs glyphicon glyphicon-menu-down"
					style="vertical-align: text-bottom"></button>
				목록
			</h3>
		</div>
		<div class="panel-body">
			<table class="table table-spriped table-hover">
				<thead>
					<tr>
						<th class="col-md-1 text-center"></th>
						<th class="col-md-8 text-center">내용</th>
						<th class="text-center">삭제</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="todo in todos">
						<td><input type="checkbox" class="form-control" name="isDone" ng-model="todo.isDone" value="true"/></td>
						<td><input type="text" class="form-control" name="content" ng-model="todo.content"/> </td>
						<td>
							<button type="button" class="btn btn-primary" ng-click="save(todo)">저장</button>
							<button type="button" class="btn btn-danger" ng-click="delete(todo)">삭제</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="panel-footer text-right">총{{todos.length}} 건 &nbsp; 남은 건{{todoRemaining()}}건</div>
	</div>

	<div class="center">
		<ul class="pagination pagination-sm">
			<li><a href="#" class="prev">&laquo;</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#" class="next">&raquo;</a></li>
		</ul>
	</div>
	
	<h3>WebSocket Test Page</h3>

<input type="text" ng-model="message"/>
<button ng-click="send()">SEND</button>

<ul ng-repeat="echo in echoMessages">
  <li>{{echo}}</li>
</ul>
</div>