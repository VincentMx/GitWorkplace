<%--
  Created by IntelliJ IDEA.
  User: lix
  Date: 2017/12/1
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/cheader.jsp"%>
<html>
<head>
    <title>资源管理</title>
    <script>
        var parentkey = null;
        $(document).ready(function () {
            parentkey = getUrlParam('skey');
            getOperateData(parentkey);
        });

        /**
         * 获取资源操作数据
         */
        function getOperateData(parentkey) {
            $("#xtZyoperate_content").bootstrapTable({
                url: CTX + '/xtZyCz/getAllXtZyCzByResourcesId.html?parentkey='+parentkey,
                sidePagination: "server",
                contentType: "application/x-www-form-urlencoded",
                dataType: "json",
                method: "post",
                dataField: "results",
                totalField: "totalCount",
                pageSize: 10,
                pageList: [10,20,30,50],
                pagination: false,
                height: 380,
                queryParamsType: "limit",
                search: false, //查询参数组织方式
                searchOnEnterKey: false, //回车搜索,
                clickToSelect: true,
                // toolbar: "#toolbar",
                columns:[
                    {title:"全选",field: "select",checkbox: true,align:"center",valign:"middle"},
                    {title:"名称",field:"name",align:"left",order:"desc"},
                    {title:"操作",field:"action",align:"left",order:"desc"},
                    {title:"图标",field:"icon",align:"left",order:"desc"},
                    {title:"样式",field:"style",align:"left",order:"desc"}

                ],
                locale:"zh-CN" //中文支持
            })
        }


        /**
         * 添加资源操作按钮
         */
        function addResOurcesOperateAction(parentKey) {
            // layer.msg("-->"+parentKey);
            var that = this;
            //多窗口模式，层叠置顶
            layer.open({
                title:['资源操作','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
                area:['400px','380px'],
                shade: 0
                ,maxmin: true
                ,content: '<form role="form" id="resources_operate" action="javascript:void(0)">\n' +
                '    <div class="row">\n' +
                '        <div class="form-group input-group">\n' +
                '            <span class="input-group-addon">名称</span>\n' +
                '            <input type="text" id="op_name"  name="name" class="form-control" data-bv-notempty data-bv-notempty-message="操作名称为必填项" data-bv-stringlength="32" maxlength="32"  />\n' +
                '        </div>\n' +
                '    </div>\n' +
                '    <div class="row">\n' +
                '        <div class="form-group input-group">\n' +
                '            <span class="input-group-addon">动作</span>\n' +
                '            <input type="text" id="op_action"  name="action" class="form-control"  data-bv-notempty data-bv-notempty-message="操作动作为必填项" data-bv-stringlength="20" maxlength="20"  />\n' +
                '        </div>\n' +
                '    </div>\n' +
                '    <div class="row">\n' +
                '        <div class="form-group input-group">\n' +
                '            <span class="input-group-addon">图标</span>\n' +
                '            <input type="text" id="op_icon" name="icon" class="form-control" data-bv-stringlength="30" maxlength="30" />\n' +
                '        </div>\n' +
                '    </div>\n' +
                '    <div class="row">\n' +
                '        <div class="form-group input-group">\n' +
                '            <span class="input-group-addon">样式</span>  \n' +
                '            <input type="text" id="op_style" name="style" class="form-control"   data-bv-stringlength="32" maxlength="32" />  \n' +
                '        </div>\n' +
                '    </div>\n' +
                '    <div class="row">\n' +
                '        <div class="form-group input-group">\n' +
                '            <span class="input-group-addon">排序</span>\n' +
                '            <input type="text" id="op_seq" name="seq" class="form-control" maxlength="2" ></input>\n' +
                '        </div>\n' +
                '    </div>\n' +
                '</form>'
                ,btn:['保存','关闭'],
                btn1:function () {

                    var name = $("#op_name").val();
                    var action = $("#op_action").val();
                    var seq = $("#op_seq").val();
                    var style = $("#op_style").val();
                    var icon = $("#op_icon").val();


                    $("#resources_operate").bootstrapValidator("validate");
                    if ($("#resources_operate").data("bootstrapValidator").isValid()){
                        layer.confirm('确认是否添加',function () {
                            $.ajax({
                                type: 'POST',
                                url: CTX + "/xtZyCz/saveOrUpdateXtZyCzInfo.html",
                                data: {name:name,action:action,icon:icon,seq:seq,style:style,parentkey:parentkey},
                                dataType: 'json',
                                async: false,
                                success: function (data) {
                                    if (data.success ){
                                        layer.msg("添加成功",{icon:1});
                                        $("#xtZyoperate_content").bootstrapTable('refresh',{url:CTX+'/xtZyCz/getAllXtZyCzByResourcesId.html?parentkey='+parentkey});
                                    }else {
                                        layer.msg("添加失败"+data.result.msg,{icon:2});
                                        layer.close(this);
                                    }
                                },
                                error: function () {
                                    alert(XMLHttpRequest + "---" + textStatus + "添加资源失败")
                                }
                            });
                        });
                    }


                },btn2:function (   ) {
                    layer.msg("关闭操作");
                }

                ,zIndex: layer.zIndex //重点1
                ,success: function(layero){
                    layer.setTop(layero); //重点2
                },cancel: function(index, layero){
                    if(confirm('确定要关闭么')){ //只有当点击confirm框的确定时，该层才会关闭
                        layer.close(index)
                    }
                    return false;
                }
            });




        }


        /**
         * 删除资源操作按钮
         */
        function deleteResOurcesOperateAction() {
            var sels = $("#xtZyoperate_content").bootstrapTable('getSelections');
            var skeys = null;
            if(sels == null || sels == '' || sels.length == 0){
                layer.msg('未获取到相关信息',{icon:2});
                return false;
            }else if(sels.length > 1){
                layer.msg('请选择单条数据');
                return false;
            }else{
                skeys = sels[0].skey;
            }
            layer.confirm('确认是否删除',function () {
                $.ajax({
                    type: 'POST',
                    url: CTX + "/xtZyCz/deleteXtZyCzInfo.html",
                    data: {skey:skeys},
                    dataType: 'json',
                    async: false,
                    success: function (data) {
                        if (data.success ){
                            layer.msg("删除成功",{icon:1});
                            $("#xtZyoperate_content").bootstrapTable('refresh',{url:CTX+'/xtZyCz/getAllXtZyCzByResourcesId.html?parentkey='+parentkey});
                        }else {
                            layer.msg("删除失败"+data.result.msg,{icon:2});
                        }
                    },
                    error: function () {
                        alert(XMLHttpRequest + "---" + textStatus + "添加资源失败")
                    }
                });
            });
        }


        /***
         * 修改资源操作按钮
         */
        function updateResOurcesOperateAction() {
            var sels = $("#xtZyoperate_content").bootstrapTable('getSelections');
            var skey = null;
            if(sels == null || sels == '' || sels.length == 0){
                layer.msg('未获取到相关信息',{icon:2});
                return false;
            }else if(sels.length > 1){
                layer.msg('请选择单条数据');
                return false;
            }else{
                skey = sels[0].skey;
            }

            $.ajax({
                type: 'POST',
                url: CTX + "/xtZyCz/findXtZyCzInfo.html",
                data: {skey:skey},
                dataType: 'json',
                async: false,
                success: function (data) {
                    if (data.success ){
                        var opdata = data.results;
                        if(opdata.length == 1){

                            var that = this;
                            //多窗口模式，层叠置顶
                            layer.open({
                                title:['操作修改','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
                                area:['400px','380px'],
                                shade: 0
                                ,maxmin: true
                                ,content: '<form role="form" id="resources_operate" action="javascript:void(0)">\n' +
                                '    <div class="row">\n' +
                                '        <div class="form-group input-group">\n' +
                                '            <span class="input-group-addon">名称</span>\n' +
                                '            <input type="text" id="up_name"  name="name" class="form-control"  />\n' +
                                '            <input type="hidden" id="up_skey"  name="skey"  class="form-control"  />\n' +
                                '        </div>\n' +
                                '    </div>\n' +
                                '    <div class="row">\n' +
                                '        <div class="form-group input-group">\n' +
                                '            <span class="input-group-addon">动作</span>\n' +
                                '            <input type="text" id="up_action"  name="action" class="form-control"  />\n' +
                                '        </div>\n' +
                                '    </div>\n' +
                                '    <div class="row">\n' +
                                '        <div class="form-group input-group">\n' +
                                '            <span class="input-group-addon">图标</span>\n' +
                                '            <input type="text" id="up_icon" name="icon" class="form-control"  />\n' +
                                '        </div>\n' +
                                '    </div>\n' +
                                '    <div class="row">\n' +
                                '        <div class="form-group input-group">\n' +
                                '            <span class="input-group-addon">样式</span>  \n' +
                                '            <input type="text" id="up_style" name="style" class="form-control"  />  \n' +
                                '        </div>\n' +
                                '    </div>\n' +
                                '    <div class="row">\n' +
                                '        <div class="form-group input-group">\n' +
                                '            <span class="input-group-addon">排序</span>\n' +
                                '            <input type="text" id="up_seq" name="seq" class="form-control"  ></input>\n' +
                                '        </div>\n' +
                                '    </div>\n' +
                                '</form>'
                                ,btn:['修改','取消'],
                                btn1:function () {

                                    var name = $("#up_name").val();
                                    var action = $("#up_action").val();
                                    var seq = $("#up_seq").val();
                                    var style = $("#up_style").val();
                                    var icon = $("#up_icon").val();
                                    var skey = $("#up_skey").val();


                                    $("#resources_operate").bootstrapValidator("validate");
                                    if ($("#resources_operate").data("bootstrapValidator").isValid()){
                                        layer.confirm('确认是否修改',function () {
                                            $.ajax({
                                                type: 'POST',
                                                url: CTX + "/xtZyCz/saveOrUpdateXtZyCzInfo.html",
                                                data: {name:name,action:action,icon:icon,seq:seq,style:style,parentkey:parentkey,skey:skey},
                                                dataType: 'json',
                                                async: false,
                                                success: function (data) {
                                                    if (data.success ){
                                                        layer.msg("修改成功",{icon:1});
                                                        $("#xtZyoperate_content").bootstrapTable('refresh',{url:CTX+'/xtZyCz/getAllXtZyCzByResourcesId.html?parentkey='+parentkey});
                                                    }else {
                                                        layer.msg("修改失败"+data.result.msg,{icon:2});
                                                        layer.close(this);
                                                    }
                                                },
                                                error: function () {
                                                    alert(XMLHttpRequest + "---" + textStatus + "添加资源失败")
                                                }
                                            });
                                        });
                                    }


                                },btn2:function (index) {
                                    layer.close(index);
                                }

                                ,zIndex: layer.zIndex //重点1
                                ,success: function(layero){
                                    layer.setTop(layero); //重点2
                                },cancel: function(index, layero){
                                    if(confirm('确定要关闭么')){ //只有当点击confirm框的确定时，该层才会关闭
                                        layer.close(index)
                                    }
                                    return false;
                                }
                            });
                        }

                        //给input赋值
                         $("#up_name").val("").val(opdata[0].name);
                         $("#up_action").val("").val(opdata[0].action);
                         $("#up_seq").val("").val(opdata[0].seq);
                         $("#up_style").val("").val(opdata[0].style);
                         $("#up_icon").val("").val(opdata[0].icon);
                         $("#up_skey").val("").val(opdata[0].skey);

                    }else {
                        layer.msg("获取失败"+data.result.msg,{icon:2});
                    }
                },
                error: function (XMLHttpRequest,textStatus) {
                    alert(XMLHttpRequest + "---" + textStatus + "获取资源失败")
                }
            });








        }


    </script>
</head>
<body>
 <ol  class="breadcrumb" style="margin-bottom: 1%;">
         <li><a href="javascript:void(0)"  onclick="addResOurcesOperateAction();" >添加</a> </li>
         <li><a href="javascript:void(0)" onclick="deleteResOurcesOperateAction();" >删除</a> </li>
         <li><a href="javascript:void(0)" onclick="updateResOurcesOperateAction();" >修改</a> </li>
      </ol>

<table id="xtZyoperate_content"></table>



</body>
</html>
