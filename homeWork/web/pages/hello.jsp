<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/20
  Time: 8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>hello</title>
    <script src="${pageContext.request.contextPath}/sources/js/houtai/jquery-2.1.4.min.js" type="text/javascript"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/sources/css/hello.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/sources/css/fonts/iconfont.css">
    <%--<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/sources/js/layui/css/layui.css">--%>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/sources/js/layui/layui.js"></script>--%>

    <script type="text/javascript">
    </script>
</head>
<body>
<div class="header">

</div>
<div class="content">
    <div class="form_div">
        <form action="<%=path%>/sys/login/login.html" method="post">
            <table >
                <tr>
                    <td>
                        <input title="username" type="text" name="id" placeholder="userId" >
                    </td>
                </tr>
                <tr>
                    <td>
                        <input title="password" type="password" name="password" placeholder="password" />
                    </td>

                </tr>
                <tr>
                    <td  align="center">
                        <button  type="submit"  >登录</button>
                    </td>
                </tr>
            </table>
            <div STYLE="color: red;">
                ${errorInfo}
            </div>
        </form>
    </div>
</div>
<div class="footer"></div>

</form>
</body>
</html>
