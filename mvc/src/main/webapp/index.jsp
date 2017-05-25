<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.form {
	width: 400px;
	margin: 0px auto;
	font-size: 85%;
}
</style>
</head>
<body>
	<form action="<%=request.getContextPath()%>/login" method="post" class="form">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" id="name" name="name" value="<%=request.getParameter("name")%>"></td>

			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<%
				String error = (String)request.getAttribute("error");
				if(error!=null){
			%>
				<tr>
					<td colspan="2">
						<font color="red"><%=error%></font>
					</td>
				</tr>
			<% 
				}
			%>
			<tr>
				<td colspan="2"><input type="submit" value="登录"> <a
					href="reg.html">注册</a></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	var cs = document.cookie;
	if (cs) {
		//根据; 
		cs = cs.split("; ");
		//再遍历数组
		for (var i = 0; i < cs.length; i++) {
			var c = cs[i].split("=");
			if (c[0] == 'loginName') {
				document.getElementById("name").value = c[1];
				break;
			}
		}
	}
</script>
</html>