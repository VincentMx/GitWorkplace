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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="keywords" content="Custom Signup Form Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
    <script src="${pageContext.request.contextPath}/sources/js/front/register/jquery-3.1.1.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/sources/js/front/register/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/sources/js/front/register/jquery-ui.js" type="text/javascript"></script>



    <!-- //Meta-Tags -->

    <!-- Custom-Style-Sheet -->
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/sources/css/front/register/jquery-ui.css">
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/sources/css/front/register/style.css">

</head>
<!-- //Head -->



<!-- Body -->
<body>

<h1>注册</h1>

<div class="containerw3layouts-agileits">

    <div class="w3imageaits">
        <img class="user" src="${pageContext.request.contextPath}/sources/image/front/register/user.png" alt="Custom Signup Form">
        <h2>点击注册</h2>
        <p>成为我们的一员吧！</p>
    </div>

    <div class="aitsloginwthree w3layouts agileits">
        <form action="#" method="post" id="userRegidterId">
            <input type="text" Name="name" id="name" placeholder="姓名" required="">
            <div class="radio-btns agileits w3layouts">
                <div class="cc-selector wthreeselector">
                    <p>性别</p>
                </div>
                <div class="cc-selector wthreeselector">
                    <input id="visa" type="radio" name="sex" value="man">
                    <label class="drinkcard-cc visa" for="visa"></label>
                </div>
                <div class="cc-selector wthreeselector">
                    <input id="mastercard" type="radio" name="sex" value="woman">
                    <label class="drinkcard-cc mastercard" for="mastercard"></label>
                </div>
            </div>
            <div class="wthreedob">
                <%--<input class="date agileits w3layouts" id="datepicker1" type="text" value="注册时间" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required="">--%>
                    <input type="password" Name="password" id="password1" placeholder="密码" required="">
                    <input type="password" Name="password" id="password2" placeholder="重复密码" required="">
            </div>
            <input class="fill email" type="text" name="email" id="email" placeholder="邮箱" required="">

            <input class="fill tel" name="phone" id="phone" placeholder="电话" required="">
            <input type="text" Name="id" id="sfzh" placeholder="身份证号" required="">
            <div class="send-button wthree agileits">
                <input type="submit" value="注册" id="submits">
            </div>
        </form>
    </div>

    <div class="clear"></div>

</div>

<div class="w3lsfooteragileits">
    <p> &copy; 2017 Custom Signup Form. All Rights Reserved | Design by <a href="#" target="=_blank">lix</a></p>
</div>

<script>
    $(function() {
        $( "#datepicker1" ).datepicker();
        $("#submits").click(function () {
            alert(JSON.stringify($("#userRegidterId").val()));
        })

        var name = $("#name").val();
        var sex = $('input[name="sex"]:checked ').val();
        var password1 = $("#password1").val();
        var password2 = $("#password2").val();
        var email = $("#email").val();
        var phone = $("#phone").val();
        var id = $("#sfzh").val();




    });
</script>
<!-- //Date-Picker-JavaScript -->

<!-- //Necessary-JavaScript-Files-&-Links -->



</body>
<!-- //Body -->



</html>
