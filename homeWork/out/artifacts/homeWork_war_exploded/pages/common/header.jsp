<%--
  Created by IntelliJ IDEA.
  User: lix
  Date: 2017/11/24
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html >
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/sources/js/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/sources/js/bootstrap/css/bootstrap.css">
    <script type="text/javascript" rel="${pageContext.request.contextPath}/sources/js/system/IdCardValidate.js"></script>
    <script type="text/javascript" rel="${pageContext.request.contextPath}/sources/js/system/jquery.min.js"></script>
    <script type="text/javascript" rel="${pageContext.request.contextPath}/sources/js/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" rel="${pageContext.request.contextPath}/sources/js/bootstrap/js/bootstrap.bundle.js"></script>
    <script  type="text/javascript"  src="${pageContext.request.contextPath}/sources/js/system/watermark.js"></script>
    <script type="text/javascript">
        window.onload =  function () {
            watermark({watermark_txt:'管理系统'});
        };
    </script>