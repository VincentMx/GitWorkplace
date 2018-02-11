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
        url: CTX + "/xtDw/findAllXtDw.html",
        data: {},
        dataType: 'json',
        async: false,
        success: function (data) {
            var OptionData = data.results;
             // alert(target + OptionData.length);
            var htmls = "";
            htmls += " <option  style='width: 40%;'   value=''> 无</option>";
            for (var i = 0; i < OptionData.length; i++) {
                    htmls += " <option  style='width: 40%;' value=" + OptionData[i].code + ">" + OptionData[i].name + "</option>";

            }
            $("#" + target).append("").append(htmls);
        },
        error: function (XMLHttpRequest,textStatus) {
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
    $("#XtDwContent").bootstrapTable({
        url: CTX + '/xtDw/getXtDwWithPage.html',
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
            {title:"单位名称",field:"name",align:"left",order:"desc"},
            {title:"简称",field:"shortname",align:"left",order:"desc"},
            {title:"代码",field:"code",align:"left",order:"desc"},
            {title:"上级单位代码",field:"parentkey",align:"left",order:"desc"},
            {title:"单位等级",field:"unitlevel",align:"left",order:"desc"}

        ],
        locale:"zh-CN" //中文支持
    })

}


/***
 * 删除
 * @returns {boolean}
 */

function deleteDw() {
    var skey = null;
    var sels = $("#XtDwContent").bootstrapTable('getSelections');
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
            url: CTX + "/xtDw/deleteXtDw.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.success){
                    layer.msg('删除成功',{icon:1});
                    $("#XtDwContent").bootstrapTable('refresh',{url:CTX+"/xtDw/getXtDwWithPage.html?type = 1 "})
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
function searchDw() {
    var index = layer.open({
        title:['查找参数信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['36%','68%'],
        content:'<form role="form" id="addXtCsForms" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">名称</span>\n' +
        '            <input type="text" id="sear_name"  name="name" class="form-control" placeholder="请输入单位名称...." data-bv-notempty data-bv-notempty-message="单位名称为必填项" data-bv-stringlength="128" maxlength="128"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">简称</span>\n' +
        '            <input type="text" id="sear_shortname"  name="shortname" class="form-control" placeholder="请输入单位简称...." data-bv-notempty data-bv-notempty-message="单位简称为必填项" data-bv-stringlength="128" maxlength="128"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">上级代码</span>\n' +
        '            <select type="text" id="typecodess"   name="parentkey" class="form-control"     data-bv-stringlength="32" maxlength="32"   />\n' +
        '        </div>\n' +
        '     </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">代码</span>\n' +
        '            <input type="text" id="sear_code"  name="code" class="form-control"    placeholder="请输入单位代码...." pattern="^[0-9]*$" data-bv-regexp-message="只能输入数字" data-bv-notempty data-bv-notempty-message="参数类型代码为必填项" data-bv-stringlength="10" maxlength="10"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">有效时间从</span>\n' +
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
            var code = $("#sear_code").val();
            var shortname = $("#sear_shortname").val();
            var starttime = $("#sear_filed1").val();
            var endtime = $("#sear_filed2").val();


            var urlParam = "";
            if (name != null && name != ''){
                urlParam += "&name="+name;
            }
            if (typecode != null && typecode != ''){
                urlParam += "&parentkey="+typecode;
            }
            if (starttime != null && starttime != ''){
                urlParam += "&startTime="+starttime;
            }
            if (endtime != null && endtime != ''){
                urlParam += "&endTime="+endtime;
            }
            if (code != null && code != ''){
                urlParam += "&code="+code;
            }
            if (shortname != null && shortname != ''){
                urlParam += "&shortname="+shortname;
            }

            $("#XtDwContent").bootstrapTable('refresh',{url:CTX+"/xtDw/getXtDwWithPage.html?type = 1 "+urlParam})

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
function refDw() {
    $("#XtDwContent").bootstrapTable('refresh',{url:CTX+"/xtDw/getXtDwWithPage.html?type = 1 "})
}


/**
 * 下拉框输入文字选择
 */
function getDwInfo(o) {
    layer.msg(13+JSON.stringify(o));
}

/***
 * 修改
 */
function updateDw() {
    var skey = null;
    var sels = $("#XtDwContent").bootstrapTable('getSelections');
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
        url: CTX + "/xtDw/getXtDwByPara.html",
        data: {skey:skey},
        dataType: 'json',
        async: false,
        success: function (data) {
            if (data.success){
                  alert(JSON.stringify(data));

                var index = layer.open({
                    title:['修改单位信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
                    area:['36%','68%'],
                    content:'<form role="form" id="addXtDwForms" action="javascript:void(0)">\n' +
                    '    <div class="row">\n' +
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">名称</span>\n' +
                    '            <input type="text" id="UPD_name"  name="name" class="form-control" placeholder="请输入单位名称...." data-bv-notempty data-bv-notempty-message="单位名称为必填项" data-bv-stringlength="128" maxlength="128"   />\n' +
                    '        </div>\n' +
                    '    </div>\n' +
                    '     <div class="row">  \n'+
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">代码</span>\n' +
                    '            <input type="text" id="UPD_code"  name="code" class="form-control" placeholder="请输入单位代码...." data-bv-notempty data-bv-notempty-message="单位代码为必填项" data-bv-stringlength="32" maxlength="32"   />\n' +
                    '        </div>\n' +
                    '    </div>\n' +
                    '    <div class="row">\n' +
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">所属代码</span>\n' +
                    '            <select type="text" id="typecodes"  name="parentkey" class="form-control"     data-bv-stringlength="31" maxlength="31"   />\n' +
                    '        </div>\n' +
                    '     </div>\n' +
                    '     <div class="row">  \n'+
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">简称</span>\n' +
                    '            <input type="text" id="UPD_shortname"  name="shortname" class="form-control"    placeholder="请输入名称简称...."  data-bv-notempty data-bv-notempty-message="单位简称为必填项" data-bv-stringlength="128" maxlength="128"   />\n' +
                    '        </div>\n' +
                    '    </div>\n' +
                    '     <div class="row">  \n'+
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">单位等级</span>\n' +
                    '            <input type="text" id="UPD_unitlevel"  name="unitlevel" class="form-control" placeholder="请输入单位登记信息...."  data-bv-stringlength="4" maxlength="4"   />\n' +
                    '        </div>\n' +
                    '    </div>\n' +
                    '     <div class="row">  \n'+
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">排序</span>\n' +
                    '            <input type="text" id="UPD_seq"  name="seq" class="form-control" placeholder="请输入排序信息...."  data-bv-stringlength="11" maxlength="11"   />\n' +
                    '        </div>\n' +
                    '    </div>\n' +
                    '     <div class="row">  \n'+
                    '        <div class="form-group input-group">\n' +
                    '            <span class="input-group-addon">有效期</span>\n' +
                    '            <input type="text" id="UPD_yxdate"  name="yxdate" class="form-control" placeholder="请选择有效期信息...."  data-bv-stringlength="32" maxlength="32"  readonly />\n' +
                    '            <input type="hidden" id="upd_skey"  name="skey" class="form-control" placeholder="请输入备注3信息...."    />\n' +
                    '        </div>\n' +
                    '    </div>\n' +
                    '</form>',
                    btn:['保存','取消'],
                    btn1:function (index) {


                        var name = $("#UPD_name").val();
                        var parentkey = $("#typecodes").val();
                        var code = $("#UPD_code").val();
                        var seq = $("#UPD_seq").val();
                        var unitlevel = $("#UPD_unitlevel").val();
                        var yxdate = $("#UPD_yxdate").val();
                        var shortname = $("#UPD_shortname").val();
                        var skey = $("#upd_skey").val();


                        $("#addXtDwForms").bootstrapValidator("validate");
                        if ($("#addXtDwForms").data("bootstrapValidator").isValid()) {
                            layer.confirm('确认是否修改', function () {
                                $.ajax({
                                    type: 'POST',
                                    url: CTX + "/xtDw/saveOrUpdateXtDw.html",
                                    data: {name: name,skey:skey, parentkey: parentkey, code: code,seq:seq,unitlevel:unitlevel,yxdate:yxdate,shortname:shortname},
                                    dataType: 'json',
                                    async: false,
                                    success: function (data) {
                                        if (data.success) {
                                            layer.msg('修改成功', {icon: 1});
                                            $("#XtDwContent").bootstrapTable('refresh', {url: CTX + "/xtDw/getXtCsWithPage?type = 1 "})
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

                loadingOptions('typecodes');
                var start = {
                    zIndex:66668888,
                    dateCell: '#UPD_yxdate',
                    format: 'YYYY-MM-DD hh:mm:ss',
                    minDate: '2018-01-01 00:00:00',
                    festival:true,
                    maxDate: '2099-01-01 00:00:00',
                    isTime:true,
                    choosefun:function (datas) {
                        end.minDate = datas;
                    }

                };
                jeDate(start);


                var datas = data.results[0];
                // alert(JSON.stringify(datas));
                 $("#UPD_name").val("").val(datas.name);
                 $("#typecodes").val("").val(datas.parentkey);
                 $("#UPD_code").val("").val(datas.code);
                 $("#UPD_seq").val("").val(datas.seq);
                 $("#UPD_unitlevel").val("").val(datas.unitlevel);
                 $("#UPD_yxdate").val("").val(datas.yxdate);
                 $("#UPD_shortname").val("").val(datas.shortname);
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
function addDw() {
    var index = layer.open({
        title:['添加单位信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['36%','68%'],
        content:'<form role="form" id="addXtDwForms" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">名称</span>\n' +
        '            <input type="text" id="add_name"  name="name" class="form-control" placeholder="请输入单位名称...." data-bv-notempty data-bv-notempty-message="单位名称为必填项" data-bv-stringlength="100" maxlength="100"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">代码</span>\n' +
        '            <input type="text" id="add_code"  name="code" class="form-control" placeholder="请输入单位代码...." data-bv-notempty data-bv-notempty-message="单位代码为必填项" data-bv-stringlength="100" maxlength="100"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">所属代码</span>\n' +
        '            <select type="text" id="typecodes"  name="parentkey" class="form-control"     data-bv-stringlength="31" maxlength="31"   />\n' +
        '        </div>\n' +
        '     </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">简称</span>\n' +
        '            <input type="text" id="add_shortname"  name="shortname" class="form-control"    placeholder="请输入名称简称...."  data-bv-notempty data-bv-notempty-message="单位简称为必填项" data-bv-stringlength="10" maxlength="10"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">单位等级</span>\n' +
        '            <input type="text" id="add_unitlevel"  name="unitlevel" class="form-control" placeholder="请输入单位等级信息...."  data-bv-stringlength="4" maxlength="4"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">排序</span>\n' +
        '            <input type="text" id="add_seq"  name="seq" class="form-control" placeholder="请输入排序信息...."  data-bv-stringlength="11" maxlength="11"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">有效期</span>\n' +
        '            <input type="text" id="add_yxdate"  name="yxdate" class="form-control" placeholder="请选择有效期信息...."  readonly />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '</form>',
        btn:['保存','取消'],
        btn1:function (index) {


            var name = $("#add_name").val();
            var parentkey = $("#typecodes").val();
            var code = $("#add_code").val();
            var seq = $("#add_seq").val();
            var unitlevel = $("#add_unitlevel").val();
            var yxdate = $("#add_yxdate").val();
            var shortname = $("#add_shortname").val();

            $("#addXtDwForms").bootstrapValidator("validate");
            if ($("#addXtDwForms").data("bootstrapValidator").isValid()) {
                layer.confirm('确认是否保存', function () {
                    $.ajax({
                        type: 'POST',
                        url: CTX + "/xtDw/saveOrUpdateXtDw.html",
                        data: {name: name, parentkey: parentkey, code: code,seq:seq,unitlevel:unitlevel,yxdate:yxdate,shortname:shortname},
                        dataType: 'json',
                        async: false,
                        success: function (data) {
                            if (data.success) {
                                layer.msg('添加成功', {icon: 1});
                                $("#XtDwContent").bootstrapTable('refresh', {url: CTX + "/xtDw/getXtCsWithPage?type = 1 "})
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
    var start = {
        zIndex:66668888,
        dateCell: '#add_yxdate',
        format: 'YYYY-MM-DD hh:mm:ss',
        minDate: '2018-01-01 00:00:00',
        festival:true,
        maxDate: '2099-01-01 00:00:00',
        isTime:true,
        choosefun:function (datas) {
            end.minDate = datas;
        }

    };
    jeDate(start);
}


