<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" style="text/css" href="<c:url value='/css/bootstrap.min.css'/>">
<script type="text/javascript" src="<c:url value='/js/bootstrap.min.js'/>"></script>
<style type="text/css">
  .row{
   margin:0 auto;
   width:800px;
   padding:50px;
  }
</style>
</head>

<body>
			 <div class="row" >
				  <div class="col-md-12">
					<table class="table table-bordered table-striped table-hover" style="text-align: center">
						<thead>
							<tr>
								<td>序号</td>
								<td>分类名称</td>
								<td>描述</td>
								<td>操作</td>								
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="list" varStatus="vs">
								<tr class="${vs.index%2==0?'odd':'even'}">
									<td>${vs.count}</td>
									<td>${list.name}</td>
									<td>${list.description}</td>
									<td><a class="glyphicon glyphicon-remove" href="#"></a> <a
										class="glyphicon glyphicon-edit" href="#"></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<a style = "text-align: center" href="${pageContext.request.contextPath}/manage/header.jsp">返回</a>
				</div>
			</div>
		
		
		
	
				
</body>
</html>