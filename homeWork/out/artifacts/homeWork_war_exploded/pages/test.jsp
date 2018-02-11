<%--
  Created by IntelliJ IDEA.
  User: lix
  Date: 2017/11/27
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://" + request.getServerName() + ":" +request.getServerPort() + path +"/";
%>
<html>
<head>
    <title>222</title>
    <script src="${pageContext.request.contextPath}/sources/js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script>
        $(document).ready(function () {
            $.ajax({
                type:'POST',
                url:'${pageContext.request.contextPath}/xtzy/findAll.html',
                data:{},
                async:false,
                success:function (data) {
                    alert(JSON.stringify(data));
                },
                error:function (XMLHttpRequest,textStatus) {
                    alert(XMLHttpRequest+"---"+textStatus+"获取资源失败")
                    //alert(JSON.stringify(data));
                }

            });
        })
    </script>
</head>
<body>

</body>
</html>
