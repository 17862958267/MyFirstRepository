<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link style="text/css" rel="stylesheet" href="<c:url value='assets/css/bootstrap.min.css'/>" >
<script type="text/javascript" src="<c:url value='assets/jquery-3.2.1.min.js'/>"> </script>
<script type="text/javascript" src="<c:url value='assets/js/bootstrap.min.js'/>"> </script>
<style type="text/css">
   .center{
     margin:0px auto;
     width:250px;
     padding-top:100px;
   }
  
</style>
</head>
<body>
     <div class="center">
     <table class="table table-bordered">
      <thead>
          <tr>
            <td>
                          添加学生
            </td>
          </tr>
      </thead>
      <tbody>
        <tr>
          <td>
           姓名：<input type="text" name="name">
          </td>
        </tr>
        <tr>
          <td>
          年龄：<input type="text" name="age">
          </td>
        </tr>
        <tr>
          <td>
          性别： <input type="radio" name="sex" value="1">男
         <input type="radio" name="sex" value="0">女
          </td>
        </tr>
        <tr>
          <td>
          地址：<input type="text" name="addr">
          </td>
        </tr>
        <tr>
          <td>
            <div class="col-sm-offset-3 col-sm-9">
				<button type="submit" class="btn btn-primary">提交</button> 
				<a href="javascript:window.history.go(-1)">返回</a>
			</div>
          </td>
        </tr>
      </tbody>
     </table>
     </div>
</body>
</html>