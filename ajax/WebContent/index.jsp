<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
         Name:<input type="text" name="name" id="name">
         <button id="btn1" onclick="send1();">send</button>
         
</body>
<!-- 创建xhr对象 -->
<script type="text/javascript">
       var xhr = null;
       if(window.XMLHttpRequest){
          xhr = new XMLHttpRequest();//常规浏览器
           }else{
           xhr = new ActiveXObject("Microsoft.XMLHttp");//对于IE8以下的版本
               }
       alert(xhr);
       function send1(){
           //1.获取参数
            var nm = document.getElementById("name").value;
            //2.编码
            name = encodeURI(nm);
            //3.组url
           var url = "first?name="+name;
           alert(url);
           //4.准备向服务器发送请求
           xhr.open("GET",url,true);
           //5.设置xhr属性
           xhr.onreadystatechange=function(){
                if(xhr.readyState==4){
                   if(xhr.status==200){
                        //6.获取服务器返回的数据
                       var txt = xhr.responseText;
                       alert(txt);
                       }
                    }
               };
               //发送请求
               xhr.send();
           }
</script>
</html>