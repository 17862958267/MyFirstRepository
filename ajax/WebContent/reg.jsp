<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用ajax验证用户名是否重复</title>
</head>
<body>
         <form action="/reg" method="post">
         name:<input type="text" name="name" onblur="_blur(this)">
         <label id="message"></label><br>
         password:<input type="password" name="password"><br>
         <input type="submit" value="注册">      
         </form> 
</body>
<script type="text/javascript">
       var xhr =null;
       xhr = new XMLHttpRequest();
       function _blur(obj){
             if(obj.value !=""){
              xhr.open("POST","validate",true);
              xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
              xhr.onreadystatechange=function(){
                   if(xhr.readyState==4){
                      if(xhr.status==200){
                        var text = xhr.responseText;
                           if(text==0){
                            document.getElementById("message").innerHTML="用户名已经被占用";
                               }else{
                            document.getElementById("message").innerHTML="可以使用";
                                   }
                          }
                       }
                  };
              var param = "name="+obj.value+"&password=1234";
              xhr.send(param);
       }
       }
</script>
</html>