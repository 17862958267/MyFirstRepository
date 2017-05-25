<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   helloworld
   <br>
   访问量:${accessCount}<br>
  在线人数:${onlineCount}<br>
  登陆人数:${loginCount}<br>
  <%
  if(session.getAttribute("user")==null && request.getMethod().equals("POST")){
   String name = request.getParameter("name");
  session.setAttribute("user", name);
  }else if(request.getMethod().equals("GET")){
	  session.removeAttribute("user");
  }
  if(session.getAttribute("user")!=null){
  %>
   <a href="b.jsp">退出</a>
  <%
  }
  %>
</body>
</html>