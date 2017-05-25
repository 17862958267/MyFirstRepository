<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" style="text/css" href="css/bootstrap.min.css" >
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style type="text/css">
.center{
   width:400px;
   margin:0 auto;
}
.img{
    text-align:center;
}

</style>
</head>
<body>
  <div class="center">
		<div class="panel panel-primary">
			<div class="panel-heading">注册</div>
			<div class="panel-body">
				<form class="form-horizontal"
					action="${pageContext.request.contextPath}/regist" method="post">
					<div class="form-group form-group-sm">
						<label class="control-label col-sm-3">用户名：</label>
						<div class="col-sm-9">
							<div class="input-group">
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-user"></span>
								</span> <input type="text" name="username"
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
					<div class="form-group form-group-sm">
						<label class="control-label col-sm-3">昵称 ：</label>
						<div class="col-sm-9">
							<div class="input-group">
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-asterisk"></span>
								</span> <input type="text" name="nickname" class="form-control">
							</div>
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="control-label col-sm-3">电话 ：</label>
						<div class="col-sm-9">
							<div class="input-group">
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-asterisk"></span>
								</span> <input type="text" name="phonenum" class="form-control">
							</div>
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="control-label col-sm-3">地址 ：</label>
						<div class="col-sm-9">
							<div class="input-group">
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-asterisk"></span>
								</span> <input type="text" name="address" class="form-control">
							</div>
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="control-label col-sm-3">邮箱：</label>
						<div class="col-sm-9">
							<div class="input-group">
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-asterisk"></span>
								</span> <input type="text" name="email" class="form-control">
							</div>
						</div>
					</div>
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
					   <img id="ImgCode" src="/netstore/image">
					   <a href="javascript:_chg();">看不清换一张</a>
					</div>
					 <c:if test="${error!=null}">
					  <div class="alert alert-warning">
					  <a href="#" class="close" data-dismiss="alert"> &times;</a>
					  <strong>警告</strong>
					  ${error}
					  </div>
					 </c:if>
					<div class="col-sm-offset-4 col-sm-8">
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
	  var url = "/netstore/image?"+Math.random();
	  var img = document.getElementById("ImgCode");
	  img.src = url;
	  }
</script>
</html>