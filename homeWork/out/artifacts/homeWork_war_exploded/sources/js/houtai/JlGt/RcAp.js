$(document).ready(function () {
    layer.msg("欢迎访问用户审核页面！")
    loadTable();


    layui.use('form', function(){
        var form = layui.form;
        form.render();

/*

        form.val('example', {
            "username": "贤心" // "name": "value"
            ,"password": "123456"
            ,"interest": 1
            ,"like[write]": true //复选框选中状态
            ,"close": true //开关状态
            ,"sex": "女"
            ,"desc": "我爱 layui"
        })
*/


        //监听提交
        form.on('submit(ggxxsubmit)', function(data){
            layer.msg("88888");
            $("#SpYh_content").bootstrapTable('refresh',{url:CTX+"/XtYhRegister/getXtYhDspPageList.html"})

        });

    });




});

function loadTable() {
    loadToolBars('toolbars');
    $("#SpYh_content").bootstrapTable({
        url: CTX + '/XtYhRegister/getXtYhDspPageList.html',
        sidePagination: "server",
        contentType: "application/x-www-form-urlencoded",
        dataType: "json",
        method: "post",
        dataField: "results",
        totalField: "totalCount",
        pageSize: 10,
        pageList: [10,20,30,50],
        pagination: true,
        height: 500,
        queryParamsType: "limit",
        search: false, //查询参数组织方式
        searchOnEnterKey: false, //回车搜索,
        clickToSelect: true,
        // toolbar: "#toolbar",
        columns:[
            {title:"全选",field: "select",checkbox: true,align:"center",valign:"middle"},
            {title:"用户",field:"id",align:"left",order:"desc"},
            {title:"用户名",field:"name",align:"left",order:"desc"},
            {title:"注册时间",field:"regtime",align:"left",order:"desc"},
            {title:"审批状态",field:"flag",align:"left", formatter: function (value,row,index) {
                return formatYhFlag(value);
            } ,order:"desc"},
        //     {title:"操作结果",field:"operateResult",align:"left",order:"desc"},
        //     {title:"操作时间",field:"operateTime",align:"left",order:"desc"},
        //
        ],
        locale:"zh-CN" //中文支持
    })
}

/**
 * 翻译字段
 * @returns {string}
 */
function formatYhFlag(value) {
    var a = "";
    if(value == "02") {
        var a = '<span style="color:#c12e2a;"><i class="fa fa-times-circle-o" aria-hidden="true"></i>不通过</span>';
    }else if(value == "00"){
        var a = '<span style="color:#3e8f3e"><i class="fa fa-check-circle-o" aria-hidden="true"></i>待审批</span>';
    }
    return a;
}

/***
 * 查找操作日志信息
 */
function searchYhSp() {
    var index = layer.open({
        title:['查找操作日志','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['400px','520px'],
        content:'<form role="form" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">开始时间</span>\n' +
        '            <input type="text" id="startTime" name="startTime" class="form-control" placeholder="开始时间..."  readonly />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">结束时间</span>\n' +
        '            <input type="text" id="endTime" name="endTime" class="form-control" placeholder="结束时间..." readonly   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">用户名</span>\n' +
        '            <input type="text" id="sear_name"  name="userName" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">用户身份证号</span>\n' +
        '            <input type="text" id="sear_id"  name="userId" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">操作名称</span>\n' +
        '            <input type="text" id="sear_operateName"  name="operateName" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">操作类型</span>\n' +
        '            <input type="text" id="sear_type"  name="operateType" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">操作内容</span>\n' +
        '            <input type="text" id="sear_conditon" name="operateCondition" class="form-control"  ></input>\n' +
        '        </div>\n' +
        '    </div>\n' +
        '</form>',
        btn:['查找','取消'],
        btn1:function (index) {

            var starttime = $("#startTime").val();
            var endtime = $("#endTime").val();
            var userName = $("#sear_name").val();
            var userId = $("#sear_id").val();
            var operateName = $("#sear_operateName").val();
            var operateType = $("#sear_type").val();
            var operateCondition = $("#sear_conditon").val();


            var urlParam = "";
            if (userName != null && userName != ''){
                urlParam += "&userName="+userName;
            }
            if (userId != null && userId != ''){
                urlParam += "&userId="+userId;
            }
            if (starttime != null && starttime != ''){
                urlParam += "&startTime="+starttime;
            }
            if (endtime != null && endtime != ''){
                urlParam += "&endTime="+endtime;
            }
            if (operateName != null && operateName != ''){
                urlParam += "&operateName="+operateName;
            }
            if (operateType != null && operateType != ''){
                urlParam += "&operateType="+operateType;
            }
            if (operateCondition != null && operateCondition != ''){
                urlParam += "&operateCondition="+operateCondition;
            }

            $("#RzCz_Content").bootstrapTable('refresh',{url:CTX+"/xtRzCz/queryAllByPage.html?type = 1 "+urlParam})

            layer.close(index);
        },
        btn2:function (index) {
            layer.close(index);
        }

    });



    var start = {
        zIndex:66668888,
        dateCell: '#startTime',
        format: 'YYYY-MM-DD hh:mm:ss',
        minDate: '2018-01-01 00:00:00',
        festival:true,
        maxDate: '2099-01-01 00:00:00',
        isTime:true,
        choosefun:function (datas) {
            end.minDate = datas;
        }

    };

    var end = {
        zIndex:66668888,
        dateCell: '#endTime',
        format: 'YYYY-MM-DD hh:mm:ss',
        minDate: '2018-01-01 00:00:00',
        festival:true,
        maxDate: '2099-01-01 00:00:00',
        isTime:true,
        choosefun:function (datas) {
            start.maxDate = datas;
        }

    };

    jeDate(start);
    jeDate(end);

};

/**
 * 刷新操作
 */
function refYhSp() {
    $("#SpYh_content").bootstrapTable('refresh',{url:CTX+"/XtYhRegister/getXtYhDspPageList.html?type = 1 "})

}

/**
 * 删除操作
 */
function deleteYhSp() {
    var skey = null;
    var sels = $("#SpYh_content").bootstrapTable('getSelections');
    if(sels.length != 1  ){
        layer.msg("请选择一条需要删除的数据",{icon:2});
        return false;
    }else{
        skey = sels[0].skey;
    }
    if(skey == null || skey == '' || skey == undefined){
        layer.msg('请选择您需要删除的数据',{icon: 3});
        return false;
    }
    layer.confirm('确认是否删除',function () {
        $.ajax({
            type: 'POST',
            url: CTX + "/XtYhRegister/delete.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.success){
                    layer.msg('删除成功',{icon:1});
                    $("#SpYh_content").bootstrapTable('refresh',{url:CTX+"/XtYhRegister/getXtYhDspPageList.html?type = 1 "})
                }else{
                    layer.msg('删除失败'+data.msg,{icon:2});
                }
            },
            error: function () {
                alert(XMLHttpRequest + "---" + textStatus );
            }
        });
    });

}

/**
 * 清空操作
 */
function deleteAllRzCz() {

}


function checkYh() {
    var skey = null;
    var sels = $("#SpYh_content").bootstrapTable('getSelections');
    if(sels.length != 1  ){
        layer.msg("请选择一条需要修改的数据",{icon:2});
        return false;
    }else{
        skey = sels[0].skey;
    }
    if(skey == null || skey == '' || skey == undefined){
        layer.msg('请选择您需要修改的数据',{icon: 3});
        return false;
    }
    $.ajax({
        type: 'POST',
        url: CTX + "/XtYhRegister/findById.html",
        data: {skey:skey},
        dataType: 'json',
        async: false,
        success: function (data) {
            if (data.success){
                var index = layer.open({
                    title:['审核用户信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
                    area:['60%','68%'],
                    content:'<form role="form" action="javascript:void(0)">\n' +
                    '    <div class="row">\n' +
                    '     <div class="col-xs-6">  \n'+
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">用户名</span>\n' +
                    '            <input type="text" id="upd_name"  name="name" class="form-control" placeholder="请输入用户名称...." readonly=readonly   />\n' +
                    '            <input type="hidden" id="upd_skey"  name="skey" class="form-control"  />\n' +
                    '        </div>\n' +
                    '     </div>\n' +
                    '     <div class="col-xs-6">  \n'+
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">身份证号</span>\n' +
                    '            <input type="text" id="upd_id"  name="id" class="form-control" placeholder="请输入用户身份证号码...." readonly />\n' +
                    '        </div>\n' +
                    '    </div>\n' +
                    '    </div>\n' +
                    '    <div class="row">\n' +
                    '     <div class="col-xs-6">  \n'+
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">联系电话</span>\n' +
                    '            <input type="text" id="upd_phone"  name="phone" class="form-control"  placeholder="请输入联系电话...." readonly   />\n' +
                    '        </div>\n' +
                    '     </div>\n' +
                    '     <div class="col-xs-6">  \n'+
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">联系手机</span>\n' +
                    '            <input type="text" id="upd_mobile" name="mobile" class="form-control"  placeholder="请输入联系手机...." readonly  />\n' +
                    '        </div>\n' +
                    '     </div>\n' +
                    '    </div>\n' +
                    '    <div class="row">\n' +
                    '     <div class="col-xs-6">  \n'+
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">联系邮箱</span>\n' +
                    '            <input type="text" id="upd_email" name="email" class="form-control"  placeholder="请输入用户邮箱...."  readonly   />\n' +
                    '        </div>\n' +
                    '     </div>\n' +
                    '     <div class="col-xs-6">  \n'+
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">性别</span>\n' +
                    '            <input type="text" id="upd_sex" name="sex" class="form-control"  placeholder="请选择性别信息...."readonly  />\n' +
                    '        </div>\n' +
                    '     </div>\n' +
                    '    </div>\n' +
                    '    <div class="row">\n' +
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">单位</span>\n' +
                    '            <input type="text" id="upd_unit"  name="unit" class="form-control"  placeholder="请输入单位信息...." readonly />\n' +
                    '        </div>\n' +
                    '    </div>\n' +
                    '    <div class="row">\n' +
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">联系地址</span>\n' +
                    '            <input type="text" id="upd_address" name="address" class="form-control"  placeholder="请输入联系地址信息...." readonly />\n' +
                    '        </div>\n' +
                    '    </div>\n' +

                    '    <div class="row">\n' +
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">审批意见</span>\n' +
                    '            <textarea type="text" id="upd_bz" name="bz" class="form-control"  placeholder="请输入备注信息..."/>\n' +
                    '        </div>\n' +
                    '    </div>\n' +
                    '</form>',
                    btn:['通过','不通过','关闭'],
                    btn1:function (index) {

                        // var name = $("#upd_name").val();
                        // var id = $("#upd_id").val();
                        // var unit = $("#upd_unit").val();
                        // var phone = $("#upd_phone").val();
                        // var address = $("#upd_address").val();
                        // var mobile = $("#upd_mobile").val();
                        // var email = $("#upd_email").val();
                         var bz = $("#upd_bz").val();
                        // var sex = $("#upd_sex").val();
                        var skey = $("#upd_skey").val();


                        layer.confirm('确认是否修改',function () {
                            $.ajax({
                                type: 'POST',
                                url: CTX + "/xt/user/SpXtYh.html",
                                data: {skey:skey,bz:bz,flag:'001'},
                                dataType: 'json',
                                async: false,
                                success: function (data) {
                                    if (data.success){
                                        layer.msg('审批成功',{icon:1});
                                        $("#SpYh_content").bootstrapTable('refresh',{url:CTX+"/XtYhRegister/getXtYhDspPageList.html"})
                                    }else{
                                        layer.msg('审批失败'+data.msg,{icon:2});
                                    }
                                },
                                error: function () {
                                    alert("未能正常情求信息，请联系管理员解决问题。");
                                }
                            });
                        });
                        layer.close(index);
                    },
                    btn2:function (index) {
                        var skey = $("#upd_skey").val();
                        var bz = $("#upd_bz").val();


                        layer.confirm('确认是否修改',function () {
                            $.ajax({
                                type: 'POST',
                                url: CTX + "/xt/user/SpXtYh.html",
                                data: {skey:skey,bz:bz,flag:'002'},
                                dataType: 'json',
                                async: false,
                                success: function (data) {
                                    if (data.success){
                                        layer.msg('审批成功',{icon:1});
                                        $("#SpYh_content").bootstrapTable('refresh',{url:CTX+"/XtYhRegister/getXtYhDspPageList.html"})
                                    }else{
                                        layer.msg('审批失败'+data.msg,{icon:2});
                                    }
                                },
                                error: function () {
                                    alert("未能正常情求信息，请联系管理员解决问题。");
                                }
                            });
                        });
                        layer.close(index);
                    },
                    btn3: function (index) {
                        layer.close(index);
                    }

                });




                var start = {
                    zIndex:66668888,
                    dateCell: '#startTime',
                    format: 'YYYY-MM-DD hh:mm:ss',
                    minDate: '2018-01-01 00:00:00',
                    festival:true,
                    maxDate: '2099-01-01 00:00:00',
                    isTime:true,
                    choosefun:function (datas) {
                        end.minDate = datas;
                    }

                };

                var end = {
                    zIndex:66668888,
                    dateCell: '#endTime',
                    format: 'YYYY-MM-DD hh:mm:ss',
                    minDate: '2018-01-01 00:00:00',
                    festival:true,
                    maxDate: '2099-01-01 00:00:00',
                    isTime:true,
                    choosefun:function (datas) {
                        start.maxDate = datas;
                    }

                };

                jeDate(start);
                jeDate(end);


                var datas = data.results[0];

                $("#upd_name").val("").val(datas.name);
                $("#upd_id").val("").val(datas.id);
                $("#upd_unit").val("").val(datas.unit);
                $("#upd_phone").val("").val(datas.phone);
                $("#upd_address").val("").val(datas.address);
                $("#upd_mobile").val("").val(datas.mobile);
                $("#upd_email").val("").val(datas.email);
                $("#upd_bz").val("").val(datas.bz);
                $("#upd_sex").val("").val(datas.sex);
                $("#upd_skey").val("").val(datas.skey);
            }else{
                layer.msg('删除失败'+data.msg,{icon:2});
            }
        },
        error: function () {
            alert("未能正常情求信息，请联系管理员解决问题。");
        }
    });
}