<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<div class="page-header">
		<h2>
			<span class="glyphicon glyphicon-edit" />게시판<small>조회</small>
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
					ng-click="go('/article/form')">등록</button>
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
						<th class="col-md-1 text-center">순번</th>
						<th class="col-md-4 text-center">제목</th>
						<th class="col-md-2 text-center">등록자</th>
						<th class="col-md-2 text-center">작성일</th>
						<th class="col-md-2 text-center">수정일</th>
						<th class="col-md-1 text-center">조회</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="article in articles">
						<td class="col-md-1 text-center"><a href="#/article/{{article.id}}/form">{{article.id}}</a></td>
						<td class="col-md-4 text-center"><a href="#/article/{{article.id}}/form">{{article.title}}</a></td>
						<td class="col-md-2 text-center"><a href="#/article/{{article.id}}/form">등록자</a></td>
						<td class="col-md-2 text-center"><a href="#/article/{{article.id}}/form">{{article.regDate | date:'yyyy-MM-dd'}}</a></td>
						<td class="col-md-2 text-center"><a href="#/article/{{article.id}}/form">{{article.modDate | date:'yyyy-MM-dd'}}</a></td>
						<td class="col-md-1 text-center"><a href="#/article/{{article.id}}/form">{{article.hit}}</a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="panel-footer text-right">{{articles.length}} 건</div>
	</div>

	<div class="center">
		<ul class="pagination pagination-sm">
			<li><a href="#" class="prev">&laquo;</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#" class="next">&raquo;</a></li>
		</ul>
	</div>
</div>	