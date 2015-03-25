<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./inculde.jsp"%>
<!DOCTYPE html> 
<html lang="ko" ng-app="popApp">
<head>
<base href="/pop">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Pop app</title>

<!-- bootstrap css-->
<link rel="stylesheet"
	href="${context}/app/bower_components/bootstrap/dist/css/bootstrap.css">
<link rel="stylesheet"
	href="${context}/app/bower_components/bootstrap/dist/css/bootstrap-theme.css">

<style type="text/css">
body {
	padding-top: 50px;
	padding-bottom: 20px;
}

.center {
	text-align: center;
}
</style>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${context}/app/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${context}/app/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- angularjs -->
<script src="${context}/app/bower_components/angular/angular.js"></script>
<script src="${context}/app/bower_components/angular-animate/angular-animate.js"></script>
<script src="${context}/app/bower_components/angular-route/angular-route.js"></script>
<script src="${context}/app/bower_components/angular-resource/angular-resource.js"></script>

<!-- pop app -->
<script src="${context}/app/js/popApp.js"></script>
<!-- controller -->
<script src="${context}/app/js/homeController.js"></script>
<script src="${context}/app/article/js/articleControllers.js"></script>
<script src="${context}/app/todo/js/TodoListController.js"></script>
<!-- service -->
<script src="${context}/app/article/js/articleService.js"></script>
<script src="${context}/app/todo/js/TodoService.js"></script>


</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Pop</a>
			</div>

			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#/">home <span class="sr-only">(current)</span></a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li><a href="#/article">ê²ìí <span class="sr-only">(current)</span></a></li>
				</ul>
				<ul class="nav navbar-nav">
					<li><a href="#/todo">Todo <span class="sr-only">(current)</span></a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" placeholder="Email" class="form-control">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" class="form-control">
					</div>
					<button type="submit" class="btn btn-success">Sign in</button>
				</form>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>

	<div ng-view class="view-frame"></div>

	<div class="container">
		<footer>
			<p>&copy; kdo 2015</p>
		</footer>
	</div>
</body>
</html>