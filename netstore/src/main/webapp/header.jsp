<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上书店</title>
 <link rel="stylesheet" type="text/css" href="${PageContext.request.contextPath}/css/main.css">
 <script type="text/javascript" src="${PageContext.request.context}/js/util.js"></script>
</head>


<body>
    <br/>
    <br/>
    <div style="text-align:center">
    <h3>欢迎光临网上书城</h3>
    </div>
    <br/>
    <br/>
    <div style="text-align:center">
    <a href="${pageContext.request.contextPath}">首页</a>
    <c:if test="${sessionScope.customer==null}">
	    <a href="${pageContext.request.contextPath}/login.jsp">登录</a>
	    <a href="${pageContext.request.contextPath}/regist.jsp">免费注册</a>
    </c:if>
    <c:if test="${sessionScope.customer!=null}">
    	欢迎您：${sessionScope.customer.nickname}
    	<a href="${pageContext.request.contextPath}/logout">注销</a>
    </c:if>
    <a href="${pageContext.request.contextPath}">我的订单</a>
    <a href="${pageContext.request.contextPath}/showCart.jsp">购物车</a>
    </div>
    
     <br/>
  <br/>
</body>
</html>