<%--
  Created by IntelliJ IDEA.
  User: lix
  Date: 2017/11/29
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/cheader.jsp"%>


<html>
<head>
    <meta charset="utf-8">
    <title>管理系统</title>
    <script src="${pageContext.request.contextPath}/sources/js/houtai/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/sources/js/houtai/XtGl/home.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/sources/tools/echarts/echarts.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/sources/js/houtai/XtGl/tj.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/sources/js/system/TimeNow.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/sources/js/system/zzt.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/sources/js/system/colorRandom.js"></script>

    <script language="javascript">
     $(function () {
         wztj();
         wztjs();
     })
    </script>

</head>
<body>
    <h1 class="page-header">信息总览</h1>
    <div class="row placeholders">
        <div class="col-xs-6 col-sm-3 placeholder">
            <h4>用户</h4>
            <span class="text-muted" id="xtYhCountId">0 条</span> </div>
        <div class="col-xs-6 col-sm-3 placeholder">
            <h4>登录</h4>
            <span class="text-muted" id="dlCountId">0 条</span> </div>
        <div class="col-xs-6 col-sm-3 placeholder">
            <h4>操作</h4>
            <span class="text-muted"  id="czCountId">0 条</span> </div>
        <div class="col-xs-6 col-sm-3 placeholder">
            <h4>访问量 </h4>
            <span class="text-muted" id="yhFwlId">0</span> </div>
    </div>
    <h1 class="page-header">状态</h1>
    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <tbody>
            <tr>
                <td>登录者: <span id="xtYhXmId">admin</span>，这是您第 <span id="yhDlCountId">13</span> 次登录</td>
            </tr>
            <tr>
                <td id="lastLoginTimeId">上次登录时间: 2016-01-08 15:50:28 , 上次登录IP: ::1:55570</td>
            </tr>
            <tr>
                <td> 当前时间：<h4 id="clock" /> </td>
            </tr>
            </tbody>
        </table>
    </div>
    <div id="tjid" STYLE="height: 200px;width: 600px;"></div>
    <div id="tjids" STYLE="height: 80%;width: 90%;"></div>



</body>
</html>
