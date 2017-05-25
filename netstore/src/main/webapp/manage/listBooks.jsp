<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" style="text/css" href="<c:url value='/css/bootstrap.min.css'/>">
<script type="text/javascript" src="<c:url value='/js/bootstrap.min.js'/>"></script>
<style type="text/css">
   .row{
    width:1000px;
    margin:0 auto;
    padding:20px;
   }
</style>
</head>
<body>
     <div class="row">
        <div class="col-md-12">
           <table style="text-align: center" class="table table-bordered table-striped table-hover">
             <thead>
               <tr>             
                 <td>编号</td>     
                 <td>图片</td>     
                 <td>书名</td>     
                 <td>作者</td>     
                 <td>单价</td>     
                 <td>描述</td>                         
                 <td>操作</td>     
               </tr>
             </thead>
             <c:forEach items="${page.records}" var="b" varStatus="vs">
             <tbody>
                <tr class="${vs.index%2==0? 'odd':'even'}">
                 <td>${vs.count}</td>
                 <td>
                 <img src="${pageContext.request.contextPath}/images/${b.path}/${b.filename}" alt="${b.filename}"/>
                 </td>
                 <td>${b.name}</td>
                 <td>${b.author}</td>
                 <td>${b.price}</td>
                 <td>${b.description}</td>                             
                 <td>
                   <a href="#">修改</a>
	    		   <a href="#">删除</a>
	    		   
                 </td>   
               </tr>
             </c:forEach>
               <tr>
    		    <td align="center" colspan="8">
    			 <%@include file="/common/page.jsp"%>
    		    </td>
    	     </tr>
             </tbody>
           </table>
        </div>
     </div>
</body>
</html>