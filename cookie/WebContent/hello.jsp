<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name="";
String ps="";
Cookie[] cook =  request.getCookies();
if(cook!=null){
	for(Cookie c:cook){
		if("test".equals(c.getName())){
			String str = c.getValue();
			String[] str1=str.split(",");
			name +=str1[0];
			ps +=str1[1];
		}
		
	}
	
}

%>
<form action="test">
用户名：<input type="text" name="name" value="<%=name%>"><br>
密码：<input type="password" name="ps" value="<%=ps%>"><br>
记住密码：<input type="checkbox" name="che" value="1"><br>
<input type="submit" value="提交">


</form>
</body>
</html>