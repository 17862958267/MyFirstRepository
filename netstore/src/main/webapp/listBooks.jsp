<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
    .table{
    text-align:center
    }
</style>
</head>
<body>
        <div class="table" style="text-align:center">
        <table>
    	<tr>
    		<c:forEach items="${page.records}" var="book">
    			<td align="center">
    				<img src="${pageContext.request.contextPath}/images/${book.path}/${book.filename}" alt="${book.filename}"/><br/>
    				书名：${book.name}<br/>
    				作者：${book.author}<br/>
    				单价：${book.price }<br/>
    				<a href="${pageContext.request.contextPath}/addInCart">加入购物车</a>
    			</td>
    		</c:forEach>
    	</tr>
    	<tr>
    		<td align="center" colspan="3">
    			<%@include file="/common/page.jsp"%>
    		</td>
    	</tr>
    </table>
    </div>
</body>
</html>