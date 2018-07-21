<%--
  Created by IntelliJ IDEA.
  User: lix
  Date: 2018/2/24
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../console/common/cheader.jsp"%>
<head>

    <title>userRegister</title>

    <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="${pageContext.request.contextPath}/sources/js/front/register/jquery-3.1.1.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/sources/js/front/register/jquery-2.1.4.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/sources/css/front/register/login.css">
</head>
<body class="login_bj" >
<div class="zhuce_body">
    <%--<div class="logo"><a href="#"><img src="${pageContext.request.contextPath}/sources/image/front/register/logo.png" width="114" height="54" border="0"></a></div>--%>
    <div class="zhuce_kong login_kuang">
        <div class="zc">
            <div class="bj_bai">
                <h3>登录</h3>
                <form action="" method="post">
                    <input name="" type="text" class="kuang_txt phone" placeholder="手机号">
                    <input name="" type="text" class="kuang_txt possword" placeholder="密码">
                    <div>
                        <a href="#">忘记密码？</a><input name="" type="checkbox" value="" checked><span>记住我</span>
                    </div>
                    <input name="登录" type="button" class="btn_zhuce" value="登录">
                </form>
            </div>
            <div class="bj_right">
                <%--<p>使用以下账号直接登录</p>--%>
                <%--<a href="#" class="zhuce_qq">QQ注册</a>--%>
                <%--<a href="#" class="zhuce_wb">微博注册</a>--%>
                <%--<a href="#" class="zhuce_wx">微信注册</a>--%>
                <p style="margin-top: 80%;">没有账号？ <br /><a href="regis2.jsp">立即注册</a></p>

            </div>
        </div>
        <P>lix.com&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您登录  未知系统：<a href="#" target="_blank">未知系统</a></P>
    </div>

</div>

</body>
</html>