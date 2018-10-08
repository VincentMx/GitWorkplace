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
    <script type="text/javascript" src="${pageContext.request.contextPath}/sources/js/layui/layui.all.js"></script>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/sources/js/layui/css/layui.css">

    <script language="javascript">
     $(function () {
         wztj();
         wztjs();
     })
    </script>

</head>
<body>

     <blockquote class="layui-elem-quote" style="margin-top: 4%">总览</blockquote>
    <div class="row ">
        <div class="col-xs-6 col-sm-3 " >
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col width="30%">
                    <col width="70%">

                </colgroup>
                <thead>
                <tr>
                    <th>统计</th>
                    <th></th>

                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>用户</td>
                    <td><span class="text-muted" id="xtYhCountId">0 条</span></td>

                </tr>
                <tr>
                    <td>登录</td>
                    <td> <span class="text-muted" id="dlCountId">0 条</span></td>

                </tr>
                <tr>
                    <td>操作</td>
                    <td>  <span class="text-muted"  id="czCountId">0 条</span> </td>

                </tr>
                <tr>
                    <td>访问量</td>
                    <td> <span class="text-muted" id="yhFwlId">0</span></td>

                </tr>
                </tbody>
            </table>
        </div>

     <div class="col-xs-6 col-sm-3 " >
         <table class="layui-table" lay-skin="line">
             <colgroup>
                 <col width="100%">

             </colgroup>
             <thead>
             <tr>
                 <th>日程安排</th>

             </tr>
             </thead>
             <tbody>
             <tr>
                 <td>用户</td>

             </tr>
             <tr>
                 <td>登录</td>

             </tr>
             <tr>
                 <td>操作</td>

         </tr>
         <tr>
         <td>访问量</td>

     </tr>
     </tbody>
     </table>
     </div>

        <div class="col-xs-6 col-sm-3 ">
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col width="100%">

                </colgroup>
                <thead>
                <tr>
                    <th>待办事项</th>

                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>用户</td>

                </tr>
                <tr>
                    <td>登录</td>

                </tr>
                <tr>
                    <td>操作</td>

                </tr>
                <tr>
                    <td>访问量</td>

                </tr>
                </tbody>
            </table>
        </div>

        <div class="col-xs-6 col-sm-3 ">
            <div class="layui-card" style="margin-top: 4%">
                <div class="layui-card-body">
                    <iframe id="fancybox-frame" name="fancybox-frame1536219437819" frameborder="0" scrolling="no" hspace="0"  src="http://i.tianqi.com/index.php?c=code&a=getcode&id=7&h=90&w=225"></iframe>
                </div>
            </div>
        </div>
    </div>

     <blockquote class="layui-elem-quote" >状态</blockquote>
    <div class="layui-row">
        <div class="layui-col-md6">
          <table class="layui-table" lay-skin="line">
            <colgroup>
                <col width="100%">

            </colgroup>
            <thead>
            <tr>
                <th> 管理员详情</th>

            </tr>
            </thead>
            <tbody>
            <tr>
                <th>登录者: <span id="xtYhXmId">admin</span></th>

            </tr>
            <tr>
                <td>这是您第 <span id="yhDlCountId">13</span> 次登录</td>

            </tr>
            <tr>
                <td id="lastLoginTimeId">登录</td>

            </tr>
            <tr>
                <td>当前时间：<span id="clock" /></td>

            </tr>
            </tbody>
          </table>
        </div>
        <div class="layui-col-md6">
            <div id="tjid" STYLE="height: 200px;width: 600px;"></div>
        </div>

    </div>
    <div class="layui-row">
        <div class="layui-col-md6">
            <table class="layui-table" lay-skin="line">
                <colgroup>
                    <col width="50%">
                    <col width="50%">
                </colgroup>
                <thead>
                <tr>
                    <th> 系统详情</th>
                    <th>  </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th>用户名: <span id="yhm"> </span></th>
                    <th>地址: <span id="dz"> </span></th>
                </tr>
                <tr>
                    <td>处理器： <span id="clq">13</span>  </td>

                    <td>处理器结构： <span id="clqjg">13</span>  </td>

                </tr>
                <tr>
                    <td>处理器数量： <span id="clqsl">13</span> 个</td>

                    <td>操作系统： <span id="czxt">13</span>  </td>
                </tr>
                <tr>
                    <td>计算机名：<span id="jsjm" /></td>
                    <td>域控制器：<span id="ykzq" /></td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="layui-col-md6">
            <div id="tjids" STYLE="height: 80%;width: 90%;"></div>
        </div>
    </div>





</body>
</html>
