<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
   <%@ page import="java.util.LinkedList"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
String s ="";
	Cookie[] cook =  request.getCookies();
	if(cook!=null){
		for(Cookie c:cook){
			if("test1".equals(c.getName())){
				String str = c.getValue();
				String[] str1=str.split(",");
				
				for(String ss :str1){
					s=s+ss;
				}
				
			}
			
		}
	}
	
	
	

%>


<a href="/cokie/test2?id=1">java</a><br>
<a href="/cookie/test2?id=2">c</a><br>
<a href="/cookie/test2?id=3">c++</a><br>
<a href="/cookie/test2?id=4">php</a><br>
<a href="/cookie/test2?id=5">java</a><br>

您上次访问的三个商品是：<%=s %>
</body>
</html>