<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="assets/css/bootstrap.min.css">
<script type="text/javascript" src="assets/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<style type="text/css">
.center {
	margin: 0px auto;
	width: 400px;
	padding-top: 100px
}
.img{
  text-align:center;
}
</style>
</head>
<body>
	<div class="center">
		<!-- 以下是开始是bootstrap样式表 -->
		<div class="panel panel-primary">
			<div class="panel-heading">注册</div>
			<div class="panel-body">
				<form class="form-horizontal"
					action="${pageContext.request.contextPath}/reg" method="post">
					<div class="form-group form-group-sm">
						<label class="control-label col-sm-3">用户名：</label>
						<div class="col-sm-9">
							<div class="input-group">
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-user"></span>
								</span> <input type="text" name="name" value="${param.name}"
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
								</span> <input type="password" name="pwd" class="form-control">
							</div>
						</div>
					</div>
					<c:if test="${error!=null}">
					<div class="alert alert-warning">
					  <a href="#" class="close" data-dismiss="alert">&times;</a>
					  <strong>警告</strong>
					  {error}
					</div>
					</c:if>
					<div class="form-group form-group-sm">
						<label class="control-label col-sm-3">验证码 ：</label>
						<div class="col-sm-9">
							<div class="input-group">
								<span class="input-group-addon"> 
								<span class="glyphicon glyphicon-asterisk">
								</span>
								</span> <input type="text" name="code" class="form-control">
							</div>
						</div>
					</div>
					<div class="img">
					   <img id="ImgCode" src="/studs/image">
					   <a href="javascript:_chg();">看不清换一张</a>
					</div>
					 <c:if test="${error!=null}">
					  <div class="alert alert-warning">
					  <a href="#" class="close" data-dismiss="alert"> &times;</a>
					  <strong>警告</strong>
					  ${error}
					  </div>
					 </c:if>
					<div class="col-sm-offset-3 col-sm-9">
						<button type="submit" class="btn btn-primary">注册</button>
						<a type="button" class="btn btn-link"
							href="javascript:window.history.go(-1);">返回</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
   function _chg(){
	   var url="/studs/image?"+Math.random();
	   var img = document.getElementById("ImgCode");
	   img.src=url;
	   }
</script>
</html>