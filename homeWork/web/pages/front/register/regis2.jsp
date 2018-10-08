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
    <script src="${pageContext.request.contextPath}/sources/js/front/register/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/sources/js/front/register/regist.js" type="text/javascript"></script>

    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/sources/css/front/register/login.css">
</head>
<body class="login_bj" >

<div class="zhuce_body">
    <%--<div class="logo"><a href="#"><img src="${pageContext.request.contextPath}/sources/image/front/register/logo.png" width="114" height="54" border="0"></a></div>--%>
    <div class="zhuce_kong">
        <div class="zc">
            <div class="bj_bai">
                <h3>欢迎注册</h3>
                <form action="">
                    <input name="name" id="name" type="text" class="kuang_txt phone" placeholder="姓名">
                    <input name="id" id="id" type="text" class="kuang_txt possword" placeholder="身份证号">
                <%--<input name="sex" id="sex" type="text" class="kuang_txt yanzm" placeholder="性别">--%>
                    <input name="phone" id="phone" type="text" class="kuang_txt email" placeholder="联系电话">
                    <input name="password" id="password" type="text" class="kuang_txt possword" placeholder="密码">
                    <input name="password2" id="password2" type="text" class="kuang_txt possword" placeholder="确认密码">
                    <input name="unit" id="unitName" type="text" onclick="unitTree()" class="kuang_txt yanzm" placeholder="点击选择单位" readonly>
                    <input name="unit" id="unitId" type="hidden"  class="kuang_txt yanzm" placeholder="单位">

                    <div>
                        <input name="" type="checkbox" value=""><span>已阅读并同意<a href="#" target="_blank"><span class="lan">《XXXXX使用协议》</span></a></span>
                    </div>
                    <input name="注册" type="button" class="btn_zhuce" value="注册" onclick="registerYhInfo();">

                </form>
            </div>
            <div class="bj_right">
                <%--<p>使用以下账号直接登录</p>--%>
                <%--<a href="#" class="zhuce_qq">QQ注册</a>--%>
                <%--<a href="#" class="zhuce_wb">微博注册</a>--%>
                <%--<a href="#" class="zhuce_wx">微信注册</a>--%>
                <p style="margin-top: 90%;">已有账号？<br /> <a href="login.jsp">立即登录</a></p>

            </div>
        </div>
        <P>lix.com&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎注册  木子管理系统：<a href="../../hello.jsp" target="_blank">木子管理</a></P>
    </div>

</div>


</body>
<script type="text/javascript">
    var layerIndex;
    function unitTree() {
        layerIndex = layer.open({
            type:2,
            title:['政府机构','background-color : #26A96A; color : #fff; font-size : 18px; font-weight : 700 '],
            area: ['40%','60%'],
            shade:0,
            maxmin:true,
            scrollbar: false,
            content:'../../console/XtGl/DwTree.jsp',
            btn:['确认','重置','关闭'],
            yes:function () {
                $("#unitName").val($("iframe").contents().find("#unitName").val());
                $("#unitId").val($("iframe").contents().find("#unitId").val());
                layer.close(layerIndex);
            },
            btn2: function () {
                $("#parentname").val("");
                $("#parentkey").val("");
                layer.close(layerIndex);
            },
            btn3: function () {
                layer.closeAll();
            },
            zIndex: layer.zIndex, //重点1
            success: function (layero) {
                layer.setTop(layero); //重点2
            }

        });
    };



    function registerYhInfo() {

        var  name = $("#name").val();
        var id = $("#id").val();
        var unit = $("#unitId").val();
        var phone = $("#phone").val();
        var password = $("#password").val();
        var password2 = $("#password2").val();

          if("" == name  || undefined == name || null == name){
              layer.alert("姓名不能为空");
              return;
          }
        if("" == id  || undefined == id || null == id){
            layer.alert("身份证号不能为空");
            return;
        }if("" == unit  || undefined == unit || null == unit){
            layer.alert("单位不能为空");
            return;
        }
        if("" == phone  || undefined == phone || null == phone){
            layer.alert("电话不能为空");
            return;
        }
        if("" == password  || undefined == password || null == password){
            layer.alert("密码不能为空");
            return;
        }
        if("" == password2  || undefined == password2 || null == password2){
            layer.alert("确认密码不能为空");
            return;
        }
        if(password != password2){
            layer.alert("两次密码不相同、请重新输入");
            return;
        }


        $.ajax({
            type: 'POST',
            url: CTX + "/XtYhRegister/saveXtYhDsp.html",
            data: {name:name,id:id,password:password,unit:unit,phone:phone},
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.success ){
                    layer.msg("注册成功，请联系管理员及时审批！",{icon:1},function (e) {
                        location.href= '../../hello.jsp';
                    });

                }else {
                    layer.alert(data.result.msg);
                    layer.close(index);
                }
            },
            error: function (XMLHttpRequest,textStatus) {
                alert(XMLHttpRequest + "---" + textStatus + "注册失败，请联系管理员！")
            }
        });







    }







</script>
</html>