$(document).ready(function () {
    LoadingResources();//加载资源
});

/**
 * 加载select选项
 * @param target
 */
function loadingOptions(target) {
    $.ajax({
        type: 'POST',
        url: CTX + "/xtCsLx/getAllXtCsLx.html",
        data: {},
        dataType: 'json',
        async: false,
        success: function (data) {
            var OptionData = data.result;
            //alert(target + JSON.stringify(OptionData));
            var htmls = "";
            htmls += " <option value=''> 无</option>";
            for (var i = 0; i < OptionData.length; i++) {
                if (OptionData[i].isparent == '1') {
                    htmls += " <option value=" + OptionData[i].skey + ">" + OptionData[i].name + "</option>";

                }
            }
            $("#" + target).append("").append(htmls);
        },
        error: function () {
            alert(XMLHttpRequest + "---" + textStatus + "获取资源失败")
        }
    });
}

/***
 * 加载资源操作
 * @constructor
 */
function LoadingResources() {

    loadToolBars('toolbars');
    $("#xtCsLxContent").bootstrapTable({
        url: CTX + '/xtCsLx/getXtCsLxWithPage.html',
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
            {title:"名称",field:"name",align:"left",order:"desc"},
            {title:"代码",field:"code",align:"left",order:"desc"},
            {title:"描述",field:"descr",align:"left",order:"desc"},
        ],
        locale:"zh-CN" //中文支持
    })

}



/**
 * 刷新操作
 */
function refCsLx() {
    $("#xtCsLxContent").bootstrapTable('refresh',{url:CTX+"/xtCsLx/getXtCsLxWithPage.html?type = 1 "})

}

/**
 * 删除操作
 */
function deleteCsLx() {
    var skey = null;
    var sels = $("#xtCsLxContent").bootstrapTable('getSelections');
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
            url: CTX + "/xtCsLx/deleteXtCsLx.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.success){
                    layer.msg('删除成功',{icon:1});
                    $("#xtCsLxContent").bootstrapTable('refresh',{url:CTX+"/xtCsLx/getXtCsLxWithPage.html?type = 1 "})
                }else{
                    layer.msg('删除失败'+data.msg,{icon:2});
                }
            },
            error: function () {
                alert("未能正常情求信息，请联系管理员解决问题。");
            }
        });
    });

}


/***
 * 查找参数类型
 */
function searchCsLx() {
    var index = layer.open({
        title:['查找参数类型信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['28%','44%'],
        content:'<form role="form" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">名称</span>\n' +
        '            <input type="text" id="sear_name"  name="name" class="form-control" placeholder="请输入参数名称...." />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">代码</span>\n' +
        '            <input type="text" id="sear_code"  name="code" class="form-control" placeholder="请输入参数值...."  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">描述</span>\n' +
        '            <input type="text" id="sear_desc"  name="descr" class="form-control"  placeholder="请选择所属类型...."    />\n' +
        '        </div>\n' +
        '     </div>\n' +
        '</form>',
        btn:['查找','取消'],
        btn1:function (index) {


            var name = $("#sear_name").val();
            var code = $("#sear_code").val();
            var desc = $("#sear_desc").val();

            var urlParam = "";
            if (name != null && name != ''){
                urlParam += "&name="+name;
            }
            if (code != null && code != ''){
                urlParam += "&code="+code;
            }
            if (desc != null && desc != ''){
                urlParam += "&descr="+desc;
            }

            $("#xtCsLxContent").bootstrapTable('refresh',{url:CTX+"/xtCsLx/getXtCsLxWithPage.html?type = 1 "+urlParam})

            layer.close(index);
        },
        btn2:function (index) {
            layer.close(index);
        }

    });
};


/**
 * 添加参数类型信息
 */
function addCsLx() {
    var index = layer.open({
        title:['查找参数类型信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['28%','44%'],
        content:'<form role="form" id="XtCsLxForm" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">名称</span>\n' +
        '            <input type="text" id="add_name"  name="name" class="form-control" placeholder="请输入参数类型名称...." data-bv-notempty data-bv-notempty-message="参数类型名称为必填项" data-bv-stringlength="32" maxlength="32"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">代码</span>\n' +
        '            <input type="text" id="add_code"  name="code" class="form-control" placeholder="请输入参数类型代码...." data-bv-notempty data-bv-notempty-message="参数类型代码为必填项" data-bv-stringlength="20" maxlength="20"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">描述</span>\n' +
        '            <textarea type="text" id="add_desc"  name="descr" class="form-control"  placeholder="请输入参数类型描述...."   data-bv-stringlength="32" maxlength="32"   />\n' +
        '        </div>\n' +
        '     </div>\n' +
        '</form>',
        btn:['保存','取消'],
        btn1:function (index) {


            var name = $("#add_name").val();
            var code = $("#add_code").val();
            var desc = $("#add_desc").val();


            $("#XtCsLxForm").bootstrapValidator("validate");
            if ($("#XtCsLxForm").data("bootstrapValidator").isValid()) {
                layer.confirm('确认是否保存', function () {
                    $.ajax({
                        type: 'POST',
                        url: CTX + "/xtCsLx/saveXtCsLx.html",
                        data: {name: name, code: code, descr: desc},
                        dataType: 'json',
                        async: false,
                        success: function (data) {
                            if (data.success) {
                                layer.msg('添加成功', {icon: 1});
                                $("#xtCsLxContent").bootstrapTable('refresh', {url: CTX + "/xtCsLx/getXtCsLxWithPage.html?type = 1 "})
                            } else {
                                layer.msg('添加失败' + data.msg, {icon: 2});
                            }
                        },
                        error: function () {
                            alert("未能正常情求信息，请联系管理员解决问题。");
                        }
                    });
                });
            }


            layer.close(index);
        },
        btn2:function (index) {
            layer.close(index);
        }

    });
}

/***
 * 修改参数类型信息
 */
function updateCsLx() {
    var skey = null;
    var sels = $("#xtCsLxContent").bootstrapTable('getSelections');
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
            url: CTX + "/xtCsLx/getXtCsLxByPara.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.success){


                    var index = layer.open({
                        title:['查找参数类型信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
                        area:['28%','44%'],
                        content:'<form role="form" id="XtCsLxForm" action="javascript:void(0)">\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">名称</span>\n' +
                        '            <input type="text" id="upd_name"  name="name" class="form-control" placeholder="请输入参数类型名称...." data-bv-notempty data-bv-notempty-message="参数类型名称为必填项" data-bv-stringlength="32" maxlength="32"   />\n' +
                        '            <input type="hidden" name = "skey" id="upd_skey"                 />       \n'+
                        '        </div>\n' +
                        '    </div>\n' +
                        '     <div class="row">  \n'+
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">代码</span>\n' +
                        '            <input type="text" id="upd_code"  name="code" class="form-control" placeholder="请输入参数类型代码...." data-bv-notempty data-bv-notempty-message="参数类型代码为必填项" data-bv-stringlength="20" maxlength="20"   />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">描述</span>\n' +
                        '            <textarea type="text" id="upd_desc"  name="descr" class="form-control"  placeholder="请输入参数类型描述...."   data-bv-stringlength="32" maxlength="32"   />\n' +
                        '        </div>\n' +
                        '     </div>\n' +
                        '</form>',
                        btn:['修改','取消'],
                        btn1:function (index) {


                            var name = $("#upd_name").val();
                            var code = $("#upd_code").val();
                            var desc = $("#upd_desc").val();
                            var skey = $("#upd_skey").val();

                            $("#XtCsLxForm").bootstrapValidator("validate");
                            if ($("#XtCsLxForm").data("bootstrapValidator").isValid()) {
                                layer.confirm('确认是否修改', function () {
                                    $.ajax({
                                        type: 'POST',
                                        url: CTX + "/xtCsLx/saveXtCsLx.html",
                                        data: {name: name, code: code, descr: desc,skey:skey},
                                        dataType: 'json',
                                        async: false,
                                        success: function (data) {
                                            if (data.success) {
                                                layer.msg('修改成功', {icon: 1});
                                                $("#xtCsLxContent").bootstrapTable('refresh', {url: CTX + "/xtCsLx/getXtCsLxWithPage.html?type = 1 "})
                                            } else {
                                                layer.msg('修改失败' + data.msg, {icon: 2});
                                            }
                                        },
                                        error: function () {
                                            alert("未能正常情求信息，请联系管理员解决问题。");
                                        }
                                    });
                                });
                            }


                            layer.close(index);
                        },
                        btn2:function (index) {
                            layer.close(index);
                        }

                    });

                    var datas = data.results[0];
                     $("#upd_name").val("").val(datas.name);
                     $("#upd_code").val("").val(datas.code);
                     $("#upd_desc").val("").val(datas.descr);
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
