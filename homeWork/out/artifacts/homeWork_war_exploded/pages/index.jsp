<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/20
  Time: 8:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://" + request.getServerName() + ":" +request.getServerPort() + path +"/";
%>
<html>
  <head>
    <title>首页</title>


    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/sources/css/index.css">
    <script type="application/javascript"  href="${pageContext.request.contextPath}/sources/js/system/jquery.min.js"></script>
    <script type="application/javascript"  href="${pageContext.request.contextPath}/sources/js/index.js"></script>
  </head>
  <body>
  <div class="header">

  </div>

  <div class="content">

    <div class="form_div">
      <form id="StudentId">
        <table>
          <thead>
            用户注册
          </thead>
          <tbody>
             
          </tbody>
        </table>
      </form>
    </div>
  </div>
  <div class="footer">

  </div>


  </body>
</html>
