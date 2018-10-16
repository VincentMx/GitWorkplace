<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <h1><a href="insert.jsp">添加</a></h1>
   <table border=1 width=500>
		<tr>
			<td>用户名</td>
			<td>密码</td>
			<td>电话</td>
			<td>邮箱</td>
			<td>操作</td>
		</tr>
	<c:forEach var="user" items="${users }">
  <tr>
			<td>${user.uname }</td>
			<td>${user.pwd }</td>
			<td>${user.tel }</td>
			<td>${user.email }</td>
			<td><a href="<%=path%>/user/delUser?id=${user.uid}">删除</a><a href="#">更新</a></td>
		</tr>
		</c:forEach>	
	</table>
	<h2><a href="<%=path%>/user/findAllUser?pageNow=1">首页</a><a href="<%=path%>/user/findAllUser?pageNow=${pageNow-1<=0?1:pageNow-1}">上一页</a><a href="<%=path%>/user/findAllUser?pageNow=${pageNow+1>totalPage?totalPage:pageNow+1}">下一页</a><a href="<%=path%>/user/findAllUser?pageNow=${totalPage}">末页</a></h2>
  </body>
</html>
