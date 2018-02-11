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
            var OptionData = data.results;
             // alert(target + OptionData.length);
            var htmls = "";
            htmls += " <option value=''> 无</option>";
            for (var i = 0; i < OptionData.length; i++) {
                    htmls += " <option value=" + OptionData[i].code + ">" + OptionData[i].name + "</option>";

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

    loadToolBars('toolbar');
    $("#XtCsContent").bootstrapTable({
        url: CTX + '/xtCs/getXtCsWithPage.html',
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
            {title:"参数名称",field:"name",align:"left",order:"desc"},
            {title:"参数类型",field:"typecode",align:"left",order:"desc"},
            {title:"参数值",field:"value",align:"left",order:"desc"},
            {title:"创建时间",field:"creattime",align:"left",order:"desc"},
            {title:"备注1",field:"filed1",align:"left",order:"desc"},
            {title:"备注2",field:"filed2",align:"left",order:"desc"},
            {title:"备注2",field:"filed3",align:"left",order:"desc"}
            // {title:"备注4",field:"filed4",align:"left",order:"desc"}
        ],
        locale:"zh-CN" //中文支持
    })

}


/***
 * 删除
 * @returns {boolean}
 */

function deleteCs() {
    var skey = null;
    var sels = $("#XtCsContent").bootstrapTable('getSelections');
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
            url: CTX + "/xtCs/deleteXtCs.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.success){
                    layer.msg('删除成功',{icon:1});
                    $("#XtCsContent").bootstrapTable('refresh',{url:CTX+"/xtCs/getXtCsWithPage.html?type = 1 "})
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


/**
 * 查询
 */
function searchCs() {
    var index = layer.open({
        title:['查找参数信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['36%','68%'],
        content:'<form role="form" id="addXtCsForms" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">名称</span>\n' +
        '            <input type="text" id="sear_name"  name="name" class="form-control" placeholder="请输入参数名称...." data-bv-notempty data-bv-notempty-message="参数名称为必填项" data-bv-stringlength="100" maxlength="100"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">参数值</span>\n' +
        '            <input type="text" id="sear_value"  name="value" class="form-control" placeholder="请输入参数值...." data-bv-notempty data-bv-notempty-message="参数值为必填项" data-bv-stringlength="100" maxlength="100"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">所属类型</span>\n' +
        '            <select type="text" id="typecodess"  name="typecode" class="form-control"     data-bv-stringlength="31" maxlength="31"   />\n' +
        '        </div>\n' +
        '     </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">排序</span>\n' +
        '            <input type="text" id="sear_seq"  name="seq" class="form-control"    placeholder="请输入参数排序...." pattern="^[0-9]*$" data-bv-regexp-message="只能输入数字" data-bv-notempty data-bv-notempty-message="参数类型代码为必填项" data-bv-stringlength="10" maxlength="10"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">创建时间从</span>\n' +
        '            <input type="text" id="sear_filed1"  name="startTime" class="form-control" placeholder="请输入备注1信息...."  data-bv-stringlength="32" maxlength="32"  readonly />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">至</span>\n' +
        '            <input type="text" id="sear_filed2"  name="endTime" class="form-control" placeholder="请输入备注2信息...."  data-bv-stringlength="10" maxlength="10" readonly  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '</form>',
        btn:['查找','取消'],
        btn1:function (index) {


            var name = $("#sear_name").val();
            var typecode = $("#typecodess").val();
            var value = $("#sear_value").val();
            var seq = $("#sear_seq").val();
            var starttime = $("#sear_filed1").val();
            var endtime = $("#sear_filed2").val();


            var urlParam = "";
            if (name != null && name != ''){
                urlParam += "&name="+name;
            }
            if (typecode != null && typecode != ''){
                urlParam += "&typecode="+typecode;
            }
            if (starttime != null && starttime != ''){
                urlParam += "&startTime="+starttime;
            }
            if (endtime != null && endtime != ''){
                urlParam += "&endTime="+endtime;
            }
            if (value != null && value != ''){
                urlParam += "&value="+value;
            }
            if (seq != null && seq != ''){
                urlParam += "&seq="+seq;
            }

            $("#XtCsContent").bootstrapTable('refresh',{url:CTX+"/xtCs/getXtCsWithPage.html?type = 1 "+urlParam})

            layer.close(index);
        },
        btn2:function (index) {
            layer.close(index);
        }

    });

    //加载下拉选
    loadingOptions('typecodess');


    //加载时间
    var start = {
        zIndex:66668888,
        dateCell: '#sear_filed1',
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
        dateCell: '#sear_filed2',
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

/***
 * 刷新
 */
function refCs() {
    $("#XtCsContent").bootstrapTable('refresh',{url:CTX+"/xtCs/getXtCsWithPage.html?type = 1 "})
}


/***
 * 修改
 */
function updateCs() {
    var skey = null;
    var sels = $("#XtCsContent").bootstrapTable('getSelections');
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
        url: CTX + "/xtCs/getXtCsByPara.html",
        data: {skey:skey},
        dataType: 'json',
        async: false,
        success: function (data) {
            if (data.success){


                var index = layer.open({
                    title:['修改参数信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
                    area:['36%','68%'],
                    content:'<form role="form" id="updateXtCsForms" action="javascript:void(0)">\n' +
                    '    <div class="row">\n' +
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">名称</span>\n' +
                    '            <input type="text" id="upd_name"  name="name" class="form-control" placeholder="请输入参数名称...." data-bv-notempty data-bv-notempty-message="参数名称为必填项" data-bv-stringlength="100" maxlength="100"   />\n' +
                    '        </div>\n' +
                    '    </div>\n' +
                    '     <div class="row">  \n'+
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">参数值</span>\n' +
                    '            <input type="text" id="upd_value"  name="value" class="form-control" placeholder="请输入参数值...." data-bv-notempty data-bv-notempty-message="参数值为必填项" data-bv-stringlength="100" maxlength="100"   />\n' +
                    '        </div>\n' +
                    '    </div>\n' +
                    '    <div class="row">\n' +
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">所属类型</span>\n' +
                    '            <select type="text" id="typecode"  name="typecode" class="form-control"     data-bv-stringlength="31" maxlength="31"   />\n' +
                    '        </div>\n' +
                    '     </div>\n' +
                    '     <div class="row">  \n'+
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">排序</span>\n' +
                    '            <input type="text" id="upd_seq"  name="seq" class="form-control"    placeholder="请输入参数排序...." pattern="^[0-9]*$" data-bv-regexp-message="只能输入数字" data-bv-notempty data-bv-notempty-message="参数类型代码为必填项" data-bv-stringlength="10" maxlength="10"   />\n' +
                    '        </div>\n' +
                    '    </div>\n' +
                    '     <div class="row">  \n'+
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">备注1</span>\n' +
                    '            <input type="text" id="upd_filed1"  name="filed1" class="form-control" placeholder="请输入备注1信息...."  data-bv-stringlength="32" maxlength="32"   />\n' +
                    '        </div>\n' +
                    '    </div>\n' +
                    '     <div class="row">  \n'+
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">备注2</span>\n' +
                    '            <input type="text" id="upd_filed2"  name="filed2" class="form-control" placeholder="请输入备注2信息...."  data-bv-stringlength="10" maxlength="10"   />\n' +
                    '        </div>\n' +
                    '    </div>\n' +
                    '     <div class="row">  \n'+
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">备注3</span>\n' +
                    '            <input type="text" id="upd_filed3"  name="filed3" class="form-control" placeholder="请输入备注3信息...."  data-bv-stringlength="10" maxlength="10"   />\n' +
                    '            <input type="hidden" id="upd_skey"  name="skey" class="form-control"    />\n' +
                    '        </div>\n' +
                    '    </div>\n' +
                    '</form>',
                    btn:['修改','取消'],
                    btn1:function (index) {


                        var name = $("#upd_name").val();
                        var typecode = $("#typecode").val();
                        var value = $("#upd_value").val();
                        var seq = $("#upd_seq").val();
                        var filed1 = $("#upd_filed1").val();
                        var filed2 = $("#upd_filed2").val();
                        var filed3 = $("#upd_filed3").val();
                        var skey = $("#upd_skey").val();


                        $("#updateXtCsForms").bootstrapValidator("validate");
                        if ($("#updateXtCsForms").data("bootstrapValidator").isValid()) {
                            layer.confirm('确认是否保存', function () {
                                $.ajax({
                                    type: 'POST',
                                    url: CTX + "/xtCs/saveOrUpdateXtCs.html",
                                    data: {name: name, typecode: typecode, value: value,seq:seq,filed1:filed1,filed2:filed2,filed3:filed3,skey:skey},
                                    dataType: 'json',
                                    async: false,
                                    success: function (data) {
                                        if (data.success) {
                                            layer.msg('修改成功', {icon: 1});
                                            $("#XtCsContent").bootstrapTable('refresh', {url: CTX + "/xtCs/getXtCsWithPage.html?type = 1 "})
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
                        // layer.close(index);
                    },
                    btn2:function (index) {
                        layer.close(index);
                    }
                });

                loadingOptions('typecode');

                var datas = data.results[0];
                // alert(JSON.stringify(datas));
                $("#upd_name").val("").val(datas.name);
                $("#typecode").val("").val(datas.typecode);
                $("#upd_value").val("").val(datas.value);
                $("#upd_seq").val("").val(datas.seq);
                $("#upd_filed1").val("").val(datas.filed1);
                $("#upd_filed2").val("").val(datas.filed2);
                $("#upd_filed3").val("").val(datas.filed3);
                $("#upd_skey").val("").val(datas.skey);



            }else{
                layer.msg('修改失败'+data.msg,{icon:2});
            }
        },
        error: function () {
            alert("未能正常情求信息，请联系管理员解决问题。");
        }
    });
}


/***
 * 添加
 */
function addCs() {
    var index = layer.open({
        title:['添加参数信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['36%','68%'],
        content:'<form role="form" id="addXtCsForms" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">名称</span>\n' +
        '            <input type="text" id="add_name"  name="name" class="form-control" placeholder="请输入参数名称...." data-bv-notempty data-bv-notempty-message="参数名称为必填项" data-bv-stringlength="100" maxlength="100"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">参数值</span>\n' +
        '            <input type="text" id="add_value"  name="value" class="form-control" placeholder="请输入参数值...." data-bv-notempty data-bv-notempty-message="参数值为必填项" data-bv-stringlength="100" maxlength="100"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">所属类型</span>\n' +
        '            <select type="text" id="typecodes"  name="typecode" class="form-control"     data-bv-stringlength="31" maxlength="31"   />\n' +
        '        </div>\n' +
        '     </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">排序</span>\n' +
        '            <input type="text" id="add_seq"  name="seq" class="form-control"    placeholder="请输入参数排序...." pattern="^[0-9]*$" data-bv-regexp-message="只能输入数字" data-bv-notempty data-bv-notempty-message="参数类型代码为必填项" data-bv-stringlength="10" maxlength="10"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">备注1</span>\n' +
        '            <input type="text" id="add_filed1"  name="filed1" class="form-control" placeholder="请输入备注1信息...."  data-bv-stringlength="32" maxlength="32"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">备注2</span>\n' +
        '            <input type="text" id="add_filed2"  name="filed2" class="form-control" placeholder="请输入备注2信息...."  data-bv-stringlength="10" maxlength="10"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">备注3</span>\n' +
        '            <input type="text" id="add_filed3"  name="filed3" class="form-control" placeholder="请输入备注3信息...."  data-bv-stringlength="10" maxlength="10"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '</form>',
        btn:['保存','取消'],
        btn1:function (index) {


            var name = $("#add_name").val();
            var typecode = $("#typecodes").val();
            var value = $("#add_value").val();
            var seq = $("#add_seq").val();
            var filed1 = $("#add_filed1").val();
            var filed2 = $("#add_filed2").val();
            var filed3 = $("#add_filed3").val();

            $("#addXtCsForms").bootstrapValidator("validate");
            if ($("#addXtCsForms").data("bootstrapValidator").isValid()) {
                layer.confirm('确认是否保存', function () {
                    $.ajax({
                        type: 'POST',
                        url: CTX + "/xtCs/saveOrUpdateXtCs.html",
                        data: {name: name, typecode: typecode, value: value,seq:seq,filed_1:filed1,filed_2:filed2,filed_3:filed3},
                        dataType: 'json',
                        async: false,
                        success: function (data) {
                            if (data.success) {
                                layer.msg('添加成功', {icon: 1});
                                $("#XtCsContent").bootstrapTable('refresh', {url: CTX + "/xtCs/getXtCsWithPage?type = 1 "})
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
            // layer.close(index);
        },
        btn2:function (index) {
            layer.close(index);
        }
    });

    loadingOptions('typecodes');
}


