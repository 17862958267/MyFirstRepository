<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link style="text/css" rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.min.css'/>">
<script type="text/javascript"
	src="<c:url value='/assets/jquery-3.2.1.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">学生管理</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li class="dropdown-header">Nav header</li>
							<li><a href="#">Separated link</a></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="../navbar/">【${user.name}】</a></li>
					<li><a href="<c:url value='/login'/>">退出</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="panel panel-info">
					<div class="panel-heading">操作</div>
					<div class="list-group">
						<a href="/studs/add.jsp" class="list-group-item">增加学生</a>
						<a href="/studs/modify.jsp" class="list-group-item">修改学生</a>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="row">
					<div class="panel panel-default">
						<div class="panel-body">
							<form class="form-horizontal" action="<c:url value='/stud'/>"
								method="post">
								<div class="row">
									<div class="col-md-6">
										<div class="form-group form-group-sm">
											<label class="col-md-3 control-label"> 姓名： </label>
											<div class="col-md-9">
												<div class="has-feedback">
													<input type="text" class="form-control" name="name"
														value="${sessionScope.stud.name}"> <span
														class="form-control-feedback"> &times; </span>
												</div>
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group form-group-sm">
											<label class="col-md-3 control-label"> 年龄： </label>
											<div class="col-md-9">
												<input type="text" class="form-control" name="age"
													value="${sessionScope.stud.age}">
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group form-group-sm">
											<label class="col-md-3 control-label"> 性别： </label>
											<div class="col-md-9">
												<label class="checkbox-inline"> <input name="sex"
													type="radio" value="">不限
												</label> <label class="checkbox-inline"> <input name="sex"
													type="radio" value="1">男
												</label> <label class="checkbox-inline"> <input name="sex"
													type="radio" value="0">女
												</label>
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group form-group-sm">
											<label class="col-md-3 control-label"> 地址： </label>
											<div class="col-md-9">
												<input type="text" class="form-control" name="addr"
													value="${sessionScope.stud.addr}">
											</div>
										</div>
									</div>
								</div>
								<div class="row" style="text-align: right; padding-right: 20px">
									<input type="submit" class="control-label btn btn-primary"
										value="查询"> <input type="reset"
										class="control-label btn btn-danger" value="清空">
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="row">
					<table class="table table-bordered table-striped table-hover">
						<thead>
							<tr>
								<td>姓名</td>
								<td>年龄</td>
								<td>性别</td>
								<td>地址</td>
								<td>删除</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="stud">
								<tr>
									<td>${stud.name}</td>
									<td>${stud.age}</td>
									<td>${stud.sex}</td>
									<td>${stud.addr}</td>
									<td><span class="glyphicon glyphicon-remove"></span> <span
										class="glyphicon glyphicon-edit"></span></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<ul class="pagination">
						<c:if test="${page!=1}">
							<li><a
								href="<c:url value='/stud?page=${requestScope.page-1}'/>">&laquo;</a></li>
						</c:if>
						<c:forEach begin="${start}" end="${end}" var="page">
							<li <c:if test="${page==requestScope.page}">class="active"</c:if>><a
								href="<c:url value='/stud?page=${page}'/>">${page}</a></li>
						</c:forEach>
						<c:if test="${requestScope.page!=pages}">
							<li><a
								href="<c:url value='/stud?page=${requestScope.page+1}'/>">&raquo;</a></li>
						</c:if>
						<li><a>当前是：${page}/${pages}</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>