<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${PageContext.request.contextPath}/css/main.css">
<script type="text/javascript" src="${PageContext.request.contextPath}/js/util.js"></script>
<style type="text/css">
    .type{
    text-align:center;
    }
</style>
</head>
<body>
     <br>
     <br>
     <div style="text-align:center;"><h2>后台管理</h2></div>
     <br>
    <div class="type">
    <a href="${pageContext.request.contextPath}/manage/addCategory.jsp">添加分类</a>
    <a href="${pageContext.request.contextPath}/queryCategory">查询分类</a>
    <a href="${pageContext.request.contextPath}/manage/addBook.jsp">添加图书</a>
    <a href="${pageContext.request.contextPath}/queryBooks">查询图书</a>
    <a href="">待处理订单</a>
    <a href="">已处理订单</a>
    </div>
</body>
</html>