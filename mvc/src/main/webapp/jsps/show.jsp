<%@page import="cn.mvc.domain.Stud"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/pubs.css">
<title>Insert title here</title>
</head>
<body>
	<p>以下是所有学生：</p>
	<div>
		<a href="">增加学生</a>|
		<a href="">删除</a>
	</div>
	<table class="table">
		<tr>
			<td>
				<input type="checkbox">
			</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>性别</td>
			<td>地址</td>
			<td>
			</td>
		</tr>
		<%
			List<Stud> list = (List<Stud>)request.getAttribute("list");
			for(Stud stud:list){
		%>
				<tr>
					<td>
						<input type="checkbox">
					</td>
					<td>
						<%=stud.getName()%>
					</td>
						<td>
						<%=stud.getAge()%>
					</td>
						<td>
						<%=stud.getSex()%>
					</td>
						<td>
						<%=stud.getAddr()%>
					</td>
					<td>
						<button>修改</button>
					</td>
					
				</tr>
		<%
			}
		%>
	</table>
</body>
</html>