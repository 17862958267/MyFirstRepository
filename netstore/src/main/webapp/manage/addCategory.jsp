<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" style="text/css" href="<c:url value='/css/bootstrap.min.css'/>">
<script type="text/javascript" src="<c:url value='js/bootstrap.min.js'/>"></script>
<style type="text/css">
  .center{
   margin:0 auto;
   width:400px;
   padding-top:50px;
  }
</style>
</head>
<body>        
<div class="center">
		<div class="panel panel-primary">
			<div class="panel-heading">添加分类</div>
			<div class="panel-body">
				<form class="form-horizontal"
					action="${pageContext.request.contextPath}/addCategory" method="post">
					<div class="form-group form-group-sm">
						<label class="control-label col-sm-3">分类名称：</label>
						<div class="col-sm-9">
							<div class="input-group">
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-user"></span>
								</span> <input type="text" name="name"
									class="form-control">
							</div>
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="control-label col-sm-3">描述：</label>
						<div class="col-sm-9">
							<div class="input-group">
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-asterisk"></span>
								</span><textarea rows="3" cols="30" name="description" class="form-control"></textarea>
							</div>
						</div>
					</div>
					<div class="col-sm-offset-4 col-sm-8">
						<button type="submit" class="btn btn-primary">保存</button>
						<a type="button" class="btn btn-link"
							href="javascript:window.history.go(-1);">返回</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>