<%--
  Created by IntelliJ IDEA.
  User: lix
  Date: 2017/11/26
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>管理系统</title>
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/sources/js/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/sources/js/bootstrap-3.3.7/css/bootstrapValidator.min.css">
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/sources/js/bootstrap-3.3.7/css/bootstrap-table.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sources/css/houtai/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sources/js/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sources/css/houtai/font-awesome.min.css">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/sources/image/houtai/icon/icon.png">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/sources/image/houtai/icon/favicon.ico">
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/sources/js/jeDate/jeDate.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/sources/js/jeDate/jeDate.js"></script>
    <script src="${pageContext.request.contextPath}/sources/js/houtai/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/sources/js/system/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/sources/js/layui/layui.all.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/sources/js/houtai/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/sources/js/bootstrap-3.3.7/js/bootstrap-table.min.js"></script>
    <script src="${pageContext.request.contextPath}/sources/js/bootstrap-3.3.7/js/bootstrap-table-zh-CN.min.js"></script>
    <script src="${pageContext.request.contextPath}/sources/js/bootstrap-3.3.7/js/bootbox.min.js"></script>
    <script src="${pageContext.request.contextPath}/sources/js/bootstrap-3.3.7/js/bootstrapValidator.min.js"></script>
    <script src="${pageContext.request.contextPath}/sources/js/houtai/admin-scripts.js"></script>

    <script  type="text/javascript"  src="${pageContext.request.contextPath}/sources/js/system/watermark.js"></script>

    <!--[if lt IE 9]>
    <script>window.location.href='upgrade-browser.html';</script>
    <![endif]-->
    <script>
        var user = null;
        var CTX = '${pageContext.request.contextPath}';
        /*var CTX = $('meta[name=context-path]').attr("content")*/
        $(document).ready(function () {

             user = '${user}';
            var username = '${username}';

            //waterInfo();//加载水印
        });






        /***
         * 传参所用
         *
         * */
        function getUrlParam(name) {
            var reg = new RegExp("(^|&)"  + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null){
                return unescape(r[2]);
            }else{
                return null;
            }
        }


        /**
         * 加载操作按扭
         * */
        function loadToolBars(name){
            var resourceskey = getUrlParam('resourcesKey');
            var resourcesName = getUrlParam('resourcesName');
            resourcesName = decodeURI(resourcesName);
            if(resourceskey == null || resourceskey == ''){
                layer.msg("未获取到参数信息",{icon:5});
            }
            var htmls = '';
            $.ajax({
                type: 'POST',
                url: CTX + "/xtZyCz/getAllXtZyCzByResourcesId.html",
                data: {parentkey:resourceskey},
                dataType: 'json',
                async: false,
                success:function (data) {
                    $("#"+name+"").append("");
                    htmls +=  '<form action="/Comment/checkAll" method="post">' ;
                    htmls +=   '        <h1 class="page-header">'+ resourcesName +' <span class="badge">4</span></h1>' ;
                    htmls +=  '        <ol class="breadcrumb">' ;
                    var opData = data.results;
                    //layer.alert(JSON.stringify(opData));
                    if(opData.length > 0){
                        for(var i = 0; i < opData.length; i++){
                            htmls +=  '<li><a href="javascript:void(0)" onclick="'+opData[i].action+'();">'+opData[i].name+'</a></li>' ;
                        }
                    }
                    htmls +=  '        </ol>' ;
                    htmls +=  '    </form>';
                    $("#"+name+"").append(htmls);
                },error:function () {
                    layer.msg("未获取到相关菜单参数信息");
                }
            });

        }

        /**
         * @desc:我的消息
         * @author:lix
         * @date:2017-11-29
         * */
        function getMyMessage() {
            if(user == null){
                return false;
            }
            var index = layer.open({
               title:['我的消息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
               area:['400px','450px'],
               content:'555555',
               btn:['确认','取消'],
               btn1:function (index) {
                    layer.msg("确认");
               },
               btn2:function (index) {
                   layer.msg("取消");
               }

            });
        }


        /**
         * 加载水印
         */
        function waterInfo() {
            watermark({watermark_txt:'管理系统'});
        }
    </script>
