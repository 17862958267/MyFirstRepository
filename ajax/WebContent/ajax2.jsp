<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/ajax.js"></script>
</head>
<body>        
</body>
<script type="text/javascript">
          var ajax = new Ajax();
          ajax.post("stud3",function(data){
              alert("返回数据："+data)
              },"json");
</script>
</html>