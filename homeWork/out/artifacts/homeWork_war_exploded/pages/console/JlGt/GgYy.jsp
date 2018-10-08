<%--
  Created by IntelliJ IDEA.
  User: lix
  Date: 2017/12/6
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/cheader.jsp"%>
<html>
<head>
    <title>公告运营管理</title>

    <script type="text/javascript" src="${pageContext.request.contextPath}/sources/js/houtai/JlGt/GgYy.js"></script>


</head>
<body>
<div id="toolbars" ></div>
<div class="layui-row">
    <div class="layui-col-xs6">
        <%--//列表展示--%>
        <table id="XtGg_content" ></table>
     </div>
    <div class="layui-col-xs5">
        <%--//公告添加界面--%>
        <form class="layui-form"    lay-filter="example">
            <div class="layui-form-item">
                <label class="layui-form-label">标题</label>
                <div class="layui-input-block">
                    <input type="text" name="ggbt" id="ggbt" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input" lay-size="50">
                </div>
            </div>
        <%--    <div class="layui-form-item">
                <label class="layui-form-label">密码框</label>
                <div class="layui-input-block">
                    <input type="password" name="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">选择框</label>
                <div class="layui-input-block">
                    <select name="interest" lay-filter="aihao">
                        <option value=""></option>
                        <option value="0">写作</option>
                        <option value="1">阅读</option>
                        <option value="2">游戏</option>
                        <option value="3">音乐</option>
                        <option value="4">旅行</option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">复选框</label>
                <div class="layui-input-block">
                    <input type="checkbox" name="like[write]" title="写作">
                    <input type="checkbox" name="like[read]" title="阅读">
                    <input type="checkbox" name="like[daze]" title="发呆">
                </div>
            </div>
--%>
           <%-- <div class="layui-form-item">
                <label class="layui-form-label">发布</label>
                <div class="layui-input-block">
                    <input type="flag" id="flag" name="close" lay-skin="switch" lay-text="ON|OFF">
                </div>
            </div>
--%>
         <%--   <div class="layui-form-item">
                <label class="layui-form-label">单选框</label>
                <div class="layui-input-block">
                    <input type="radio" name="sex" value="男" title="男" checked="">
                    <input type="radio" name="sex" value="女" title="女">
                </div>
            </div>--%>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">内容</label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入内容" class="layui-textarea" id="ggnr"   name="ggnr"></textarea>
                </div>
            </div>


        </form>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="ggxxsubmit">提交</button>
                </div>
            </div>
    </div>
</div>
</body>

</html>
