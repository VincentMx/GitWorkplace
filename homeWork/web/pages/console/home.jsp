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
    <script type="text/javascript" src="${pageContext.request.contextPath}/sources/js/houtai/XtGl/home.js"></script>

</head>
<body>
    <h1 class="page-header">信息总览</h1>
    <div class="row placeholders">
        <div class="col-xs-6 col-sm-3 placeholder">
            <h4>用户</h4>
            <span class="text-muted" id="">0 条</span> </div>
        <div class="col-xs-6 col-sm-3 placeholder">
            <h4>评论</h4>
            <span class="text-muted">0 条</span> </div>
        <div class="col-xs-6 col-sm-3 placeholder">
            <h4>日志</h4>
            <span class="text-muted" id="text">0 条</span> </div>
        <div class="col-xs-6 col-sm-3 placeholder">
            <h4>访问量</h4>
            <span class="text-muted">0</span> </div>
    </div>
    <h1 class="page-header">状态</h1>
    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <tbody>
            <tr>
                <td>登录者: <span>admin</span>，这是您第 <span>13</span> 次登录</td>
            </tr>
            <tr>
                <td>上次登录时间: 2016-01-08 15:50:28 , 上次登录IP: ::1:55570</td>
            </tr>
            </tbody>
        </table>
    </div>
    <h1 class="page-header">系统信息</h1>
    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <thead>
            <tr> </tr>
            </thead>
            <tbody>
            <tr>
                <td>管理员个数:</td>
                <td>2 人</td>
                <td>服务器软件:</td>
                <td>Apache/2.4.10 (Win32) OpenSSL/1.0.1i mod_fcgid/2.3.9</td>
            </tr>
            <tr>
                <td>浏览器:</td>
                <td>Chrome47</td>
                <td>PHP版本:</td>
                <td>5.6.1</td>
            </tr>
            <tr>
                <td>操作系统:</td>
                <td>Windows 10</td>
                <td>PHP运行方式:</td>
                <td>CGI-FCGI</td>
            </tr>
            <tr>
                <td>登录者IP:</td>
                <td>::1:55570</td>
                <td>MYSQL版本:</td>
                <td>5.5.40</td>
            </tr>
            <tr>
                <td>程序版本:</td>
                <td class="version">YlsatCMS 1.0 <font size="-6" color="#BBB">(20160108160215)</font></td>
                <td>上传文件:</td>
                <td>可以 <font size="-6" color="#BBB">(最大文件：2M ，表单：8M )</font></td>
            </tr>
            <tr>
                <td>程序编码:</td>
                <td>UTF-8</td>
                <td>当前时间:</td>
                <td>2016-01-08 15:50:30</td>
            </tr>
            </tbody>
            <tfoot>
            <tr></tr>
            </tfoot>
        </table>
    </div>
    <footer>
        <h1 class="page-header">程序信息</h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <tbody>
                <tr>
                    <td><span style="display:inline-block; width:8em">版权所有</span> POWERED BY WY ALL RIGHTS RESERVED</td>
                </tr>
                <tr>
                    <td><span style="display:inline-block;width:8em">页面加载时间</span> PROCESSED IN 1.0835s  SECONDS 更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></td>
                </tr>
                </tbody>
            </table>
        </div>
    </footer>
</body>
</html>