<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   hello<br>
  访问量： ${accessCount}<br>
   在线人数：${onlineCount}<br>
   登陆人数：${loginCount}
   <form action="b.jsp" method="POST">
     name:<input type="text" name="name">
     <button type="submit" value="提交">提交</button>
   
   
   </form>
</body>
</html>