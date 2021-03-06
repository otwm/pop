<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<div class="page-header">
		<h2>
			<span class="glyphicon glyphicon-edit" />게시판<small>상세</small>
		</h2>
	</div>

	<!-- TODO:action 바꿀것 -->
	<form action="#" class="form-horizontal" role="form">
		<input type="hidden" name="id" ng-model="article.id"/>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">
					<button
						class="btn btn-primary btn-xs glyphicon glyphicon-menu-down"
						style="vertical-align: text-bottom"></button>
					게시물
				</h3>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<label class="col-md-2 control-label" for="title">제목
					</label>
					<div class="col-md-10">
						<input type="text" class="form-control" name="title" ng-model="article.title"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="title">내용
					</label>
					<div class="col-md-10">
						<textarea rows="3" class="form-control" ng-model="article.content" name="content"></textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" class="btn btn-default" ng-click="go('/article')">목록</button>
						<button type="button" class="btn btn-primary" ng-click="save(article)">저장</button>
						<button type="button" class="btn btn-danger" ng-click="remove(article.id)">삭제</button>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>