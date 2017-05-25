<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://qlu.com" prefix="qlu"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="${PageContext.request.ContextPath}/reg" method="post">
   <qlu:token/>
   name:<input type="text" name="name"><br>
   <input type = "submit" value="提交">
   </form>
</body>
</html>