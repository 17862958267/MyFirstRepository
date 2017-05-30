<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
       <button onclick="_go();">Go</button>
       <div id="div1"></div>
</body>
<script type="text/javascript">
var xhr = new XMLHttpRequest();
function _go(){
	xhr.open("GET","stud1",true);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var dom = xhr.responseXML;//XML=DOM
				div1.innerHTML="";
				//使用jquery
				$(dom).find("stud").each(function(index,ele){
					var nm = $(ele).find("name").text();
					var age = $(ele).find("age").text();
					$("#div1").append(nm+","+age+"<br>");
				});
			}else{
				alert("出错了:"+xhr.status);
			}
		}
	};
	xhr.send();
}   
</script>
</html>