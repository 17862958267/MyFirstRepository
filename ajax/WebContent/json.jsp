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
	xhr.open("GET","stud2",true);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var str = xhr.responseText
				var json = eval("("+str+")");
				$.each(json,function(index,stud){
					$("#div1").append(stud.name+","+stud.age+"<br>");
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