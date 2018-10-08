$(document).ready(function () {
    layer.msg("欢迎访问用户发布公告页面！")
    loadTable();


    layui.use('form', function(){
        var form = layui.form;
        form.render();


        //监听提交
        form.on('submit(ggxxsubmit)', function(data){
           var ggbt = $("#ggbt").val();
           var ggnr = $("#ggnr").val();

            if(ggbt == null || "" == ggbt){
              layer.msg("公告标题不能为空！",{icon:2});
              return false;
            }
            if(ggnr == null || "" == ggnr){
                layer.msg("公告内容不能为空！",{icon:2});
                return false;
            }


            layer.confirm('确认是否添加',function () {
                $.ajax({
                    type: 'POST',
                    url: CTX + "/xtgg/saveXtGg.html",
                    data: {ggbt:ggbt,ggnr:ggnr},
                    dataType: 'json',
                    async: false,
                    success: function (data) {
                        if (data.success ){
                            layer.msg("添加成功！",{icon:1});
                            $("#ggbt").val("");
                            $("#ggnr").val("");
                            $("#XtGg_content").bootstrapTable('refresh',{url:CTX+"/xtgg/getXtGgPageList.html"})
                        }else {
                            layer.alert(data.result.msg);
                        }
                    },
                    error: function (XMLHttpRequest,textStatus) {
                        alert(XMLHttpRequest + "---" + textStatus + "添加公告失败")
                    }
                });
            });


            $("#XtGg_content").bootstrapTable('refresh',{url:CTX+"/xtgg/getXtGgPageList.html"})

        });

    });




});

function loadTable() {
    loadToolBars('toolbars');
    $("#XtGg_content").bootstrapTable({
        url: CTX + '/xtgg/getXtGgPageList.html',
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
            {title:"标题",field:"ggbt",align:"left",order:"desc"},
            {title:"发布人",field:"fbyh",align:"left",order:"desc"},
            {title:"发布时间",field:"fbsj",align:"left",order:"desc"},
            {title:"状态",field:"flag",align:"left", formatter: function (value,row,index) {
                return formatYhFlag(value);
            } ,order:"desc"}
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
    if(value == "00") {
        var a = '<span style="color:#c12e2a;"><i class="fa fa-times-circle-o" aria-hidden="true"></i>待发布</span>';
    }else if(value == "01"){
        var a = '<span style="color:#3e8f3e"><i class="fa fa-check-circle-o" aria-hidden="true"></i>已发布</span>';
    }
    return a;
}

/***
 * 查找操作日志信息
 */
function searGg() {
    var index = layer.open({
        title:['查找公告信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['400px','40%'],
        content:'<form role="form" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">公告名称</span>\n' +
        '            <input type="text" id="sear_ggbt"  name="ggbt" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">公告内容</span>\n' +
        '            <input type="text" id="sear_ggnr"  name="ggnr" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '</form>',
        btn:['查找','取消'],
        btn1:function (index) {


            var ggbt = $("#sear_ggbt").val();
            var ggnr = $("#sear_ggnr").val();


            var urlParam = "";

            if (ggbt != null && ggbt != ''){
                urlParam += "&ggbt="+ggbt;
            }
            if (ggnr != null && ggnr != ''){
                urlParam += "&ggnr="+ggnr;
            }


            $("#XtGg_content").bootstrapTable('refresh',{url:CTX+"/xtgg/getXtGgPageList.html?type = 1 "+urlParam})

            layer.close(index);
        },
        btn2:function (index) {
            layer.close(index);
        }

    });



};

/**
 * 刷新操作
 */
function refGg() {
    $("#XtGg_content").bootstrapTable('refresh',{url:CTX+"/xtgg/getXtGgPageList.html "})

}

/**
 * 删除操作
 */
function deleteGg() {
    var skey = null;
    var ggFlag = null;
    var sels = $("#XtGg_content").bootstrapTable('getSelections');
    if(sels.length != 1  ){
        layer.msg("请选择一条需要发布的数据",{icon:2});
        return false;
    }else{
        skey = sels[0].skey;
        ggFlag = sels[0].flag;
    }
    if(skey == null || skey == '' || skey == undefined){
        layer.msg('请选择您需要发布的数据',{icon: 3});
        return false;
    }
    if(ggFlag == "01"){
        layer.msg('已经发布的公告信息不能修改',{icon: 2});
        return false;
    }
    layer.confirm('确认是否删除',function () {
        $.ajax({
            type: 'POST',
            url: CTX + "/xtgg/deleteGg.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.success){
                    layer.msg('删除成功',{icon:1});
                    $("#XtGg_content").bootstrapTable('refresh',{url:CTX+"/xtgg/getXtGgPageList.html"})
                }else{
                    layer.msg('删除失败'+data.msg,{icon:2});
                }
            },
            error: function () {
                alert("操作失败，请联系管理员");
            }
        });
    });

}

/**
 * 清空操作
 */
function deleteAllRzCz() {

}



/***
 * 详情
 * @constructor
 */
function GgXxxx() {
    var skey = null;
    var sels = $("#XtGg_content").bootstrapTable('getSelections');
    if(sels.length != 1  ){
        layer.msg("请选择一条需要发布的数据",{icon:2});
        return false;
    }else{
        skey = sels[0].skey;
    }
    if(skey == null || skey == '' || skey == undefined){
        layer.msg('请选择您需要发布的数据',{icon: 3});
        return false;
    }else{
        $.ajax({
            type: 'POST',
            url: CTX + "/xtgg/getXtGgById.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success:function (data) {
                if(data.success){
                    var index = layer.open({
                        title:['公告信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
                        area:['400px','65%'],
                        content:'<form id="addCwForm"  role="form" action="javascript:void(0)">\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">公告名称</span>\n' +
                        '            <input data-bv-notempty data-bv-notempty-message="公告名称为必填项" data-bv-stringlength="50" maxlength="50" type="text" id="de_paMc"  name="paMc" class="form-control"  />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">发布用户</span>\n' +
                        '            <input  data-bv-notempty data-bv-notempty-message="发布用户为必填项" data-bv-stringlength="11" maxlength="11"  onkeyup="if(isNaN(value))execCommand(\'undo\')" onafterpaste="if(isNaN(value))execCommand(\'undo\')" type="text" id="de_fbyh"  name="paCd" class="form-control"  placeholder="发布用户为必填项 如 ： 2.3 " readonly />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">发布时间</span>\n' +
                        '            <input data-bv-notempty data-bv-notempty-message="发布用户为必填项" data-bv-stringlength="11" maxlength="11"  onkeyup="if(isNaN(value))execCommand(\'undo\')" onafterpaste="if(isNaN(value))execCommand(\'undo\')"    type="text" id="de_fbsj" name="paKd" placeholder="发布时间为必填项、如 ： 2.3 " class="form-control"  readonly />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">公告状态</span>\n' +
                        '            <input  type="text" id="de_paFlag"  name="paFlag" class="form-control" readonly /> \n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">公告内容</span>\n' +
                        '            <textarea type="text" id="de_bz" name="bz" maxlength="100" class="form-control"  />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '</form>',
                        btn:['关闭'],
                        btn1:function (index) {
                            layer.close(index);
                        }
                    });
                    var datas = data.results[0];

                    $("#de_paMc").val("").val(datas.ggbt);
                    $("#de_fbyh").val("").val(datas.fbyh);
                    $("#de_fbsj").val("").val(datas.fbsj);
                    if(datas.flag == "00"){
                        $("#de_paFlag").val("").val("待发布");

                    }else if(datas.flag == "01"){
                        $("#de_paFlag").val("").val("已发布");

                    }
                    $("#de_bz").val("").val(datas.ggnr);

                }else {
                    layer.msg("获取失败！");
                }
            },
            error:function (results) {
                layer.alert("查询相关信息出错，请联系管理员！");
            }
        });
    };


}

/***
 * 修改
 * @returns {boolean}
 */
function updateGg() {
    var skey = null;
    var ggFlag = null;
    var sels = $("#XtGg_content").bootstrapTable('getSelections');
    if(sels.length != 1  ){
        layer.msg("请选择一条需要发布的数据",{icon:2});
        return false;
    }else{
        skey = sels[0].skey;
        ggFlag = sels[0].flag;
    }
    if(ggFlag == "01"){
        layer.msg('已经发布的公告信息不能修改',{icon: 2});
        return false;
    }
    if(skey == null || skey == '' || skey == undefined){
        layer.msg('请选择您需要发布的数据',{icon: 3});
        return false;
    }else{
        $.ajax({
            type: 'POST',
            url: CTX + "/xtgg/getXtGgById.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success:function (data) {
                if(data.success){
                    var index = layer.open({
                        title:['公告信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
                        area:['400px','50%'],
                        content:'<form id="addGgForm"  role="form" action="javascript:void(0)">\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">公告名称</span>\n' +
                        '            <input data-bv-notempty data-bv-notempty-message="公告名称为必填项" data-bv-stringlength="50" maxlength="50" type="text" id="de_paMc"  name="ggbt" class="form-control"  />\n' +
                        '            <input type = "hidden" id = "de_skey" name = "skey" />      \n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">备注</span>\n' +
                        '            <textarea type="text" id="de_ggnr" name="ggnr" maxlength="100" class="form-control"  />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '</form>',
                        btn:['修改', '关闭'],
                        btn1:function (index) {

                            var ggbt = $("#de_paMc").val();
                            var ggnr = $("#de_ggnr").val();
                            var skey = $("#de_skey").val();

                            $("#addGgForm").bootstrapValidator("validate");
                            if ($("#addGgForm").data("bootstrapValidator").isValid()){
                                layer.confirm('确认是否修改',function () {
                                    $.ajax({
                                        type: 'POST',
                                        url: CTX + "/xtgg/saveXtGg.html",
                                        data: {ggbt:ggbt,ggnr:ggnr,skey:skey},
                                        dataType: 'json',
                                        async: false,
                                        success: function (data) {
                                            if (data.success ){
                                                layer.msg("修改成功！",{icon:1});
                                                $("#XtGg_content").bootstrapTable('refresh',{url:CTX+"/xtgg/getXtGgPageList.html"})
                                            }else {
                                                layer.alert(data.result.msg);
                                                layer.close(index);
                                            }
                                        },
                                        error: function (XMLHttpRequest,textStatus) {
                                            alert(XMLHttpRequest + "---" + textStatus + "修改公告失败，请联系管理员！")
                                        }
                                    });
                                });
                            }

                        },
                        btn2:function (index) {
                            layer.close(index);
                        }
                    });




                    var datas = data.results[0];

                    $("#de_paMc").val("").val(datas.ggbt);
                    $("#de_ggnr").val("").val(datas.ggnr);
                    $("#de_skey").val("").val(datas.skey);


                }else {
                    layer.msg("获取失败！");
                }
            },
            error:function (results) {
                layer.alert("查询相关信息出错，请联系管理员！");
            }
        });
    };


}


/***
 * 发布
 * @constructor
 */
function spGg() {

    var skey = null;
    var sels = $("#XtGg_content").bootstrapTable('getSelections');
    if(sels.length != 1  ){
        layer.msg("请选择一条需要发布的数据",{icon:2});
        return false;
    }else{
        skey = sels[0].skey;
    }
    if(skey == null || skey == '' || skey == undefined){
        layer.msg('请选择您需要发布的数据',{icon: 3});
        return false;
    }

    layer.prompt({
        formType: 1,
        value: '',
        title: '请输入管理员口令',
    }, function(value, index, elem){

        $.ajax({
            type: 'POST',
            url: CTX + "/xtgg/checkuser.html",
            data: {token:value},
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.success == "true"){

                    $.ajax({
                        type: 'POST',
                        url: CTX + "/xtgg/SpGgXX.html",
                        data: {skey:skey},
                        dataType: 'json',
                        async: false,
                        success: function (data) {
                            if (data.success == "true"){
                                layer.msg('发布成功',{icon:1});
                                $("#XtGg_content").bootstrapTable('refresh',{url:CTX+"/xtgg/getXtGgPageList.html"})
                            }else{
                                layer.msg('发布失败'+data.msg,{icon:2});
                            }
                        },
                        error: function () {
                            layer.alert("请求失败、请联系管理员");
                        }
                    });
                 }else{
                    layer.msg('发布失败'+data.msg,{icon:2});
                }
            },
            error: function () {
                alert(XMLHttpRequest + "---" + textStatus );
            }
        });

        layer.close(index);

    });
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