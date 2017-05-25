<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style type="text/css">
   .center{
     margin:0 auto;
     width:400px; 
   }

</style>
</head>
<body>
         <div class="center">
		<div class="panel panel-primary">
			<div class="panel-heading">登录</div>
			<div class="panel-body">
				<form class="form-horizontal"
					action="${pageContext.request.contextPath}/login" method="post">
					<div class="form-group form-group-sm">
						<label class="control-label col-sm-3">用户名：</label>
						<div class="col-sm-9">
							<div class="input-group">
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-user"></span>
								</span> <input type="text" name="username" value="${param.name}"
									class="form-control">
							</div>
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="control-label col-sm-3">密码 ：</label>
						<div class="col-sm-9">
							<div class="input-group">
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-asterisk"></span>
								</span> <input type="password" name="password" class="form-control">
							</div>
						</div>
					</div>
					<c:if test="${error!=null}">
					  <div class="alert alert-warning">
					    <a href="#" class="close" data-dismiss="alert">&times;</a>
					    <strong>警告</strong>
					    ${error}
					  </div>
					</c:if>
					<div class="col-sm-offset-4 col-sm-8">
						<button type="submit" class="btn btn-primary">登录</button>
						<a type="button" class="btn btn-link"
							href="javascript:window.history.go(-1);">返回</a>
					</div>
				</form>
			</div>
		</div>
	</div>     
</body>
</html>