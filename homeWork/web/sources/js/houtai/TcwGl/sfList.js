
$(document).ready(function () {

    LoadingResources();
    //  getList();
});


/***
 * 加载资源操作
 * @constructor
 */
function LoadingResources() {
    loadToolBars("toolbars");
    $("#sf_content").bootstrapTable({
        url: CTX + '/yhPark/queryAllParkSfByPage.html',
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
            {title:"开始时间",field:"paKssj",align:"left",order:"desc"},
            {title:"结束时间",field:"paJssj",align:"left",order:"desc"},
            {title:"收费标准",field:"paSfbz",align:"left",order:"desc"},
            {title:"备注",field:"bz",align:"left",order:"desc"}

        ],
        locale:"zh-CN" //中文支持
    })

}

/**
 * 加载select选项
 * @param target
 */
function loadingOptions(target) {
    $.ajax({
        type: 'POST',
        url: CTX + "/xtzy/findAll.html",
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
 * 新增收费信息
 */


function addSf() {
    var index = layer.open({
        title:['新增收费标准','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['400px','46%'],
        content:'<form id="addCwForm"  role="form" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">开始时间</span>\n' +
        '            <input data-bv-notempty data-bv-notempty-message="开始时间为必填项" data-bv-stringlength="20" maxlength="20" type="text" id="startTimeTime" placeholder="开始时间为必填项 " name="paKssj" class="form-control"  readonly />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">结束时间</span>\n' +
        '            <input  data-bv-notempty data-bv-notempty-message="结束时间为必填项" data-bv-stringlength="20" maxlength="21"   type="text" id="endTime"  name="paJssj" class="form-control"  placeholder="结束时间必填项  " readonly />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">收费标准</span>\n' +
        '            <input data-bv-notempty data-bv-notempty-message="收费标准为必填项" data-bv-stringlength="11" maxlength="11"  onkeyup="if(isNaN(value))execCommand(\'undo\')" onafterpaste="if(isNaN(value))execCommand(\'undo\')"    type="text" id="paSfbz" name="paSfbz" placeholder="收费标准为必填项 如 0.8元每小时 " class="form-control"  />\n' +
        '            <span class="input-group-addon">每小时</span>  \n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">备注</span>\n' +
        '            <textarea type="text" id="bz" name="bz" maxlength="100" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '</form>',
        btn:['保存','取消'],
        btn1:function (index) {

            var paKssj = $("#startTime").val();
            var paJssj = $("#endTime").val();
            var paSfbz = $("#paSfbz").val();
            var bz = $("#bz").val();
            // var paFlag = $('input:radio:checked').val();
            //var paFlag = $("#paFlag option:selected").val();




            $("#addCwForm").bootstrapValidator("validate");
            if ($("#addCwForm").data("bootstrapValidator").isValid()){
                layer.confirm('确认是否添加',function () {
                    $.ajax({
                        type: 'POST',
                        url: CTX + "/yhPark/addSf.html",
                        data: {paKssj:paKssj,paJssj:paJssj,paSfbz:paSfbz,bz:bz},
                        dataType: 'json',
                        async: false,
                        success: function (data) {
                            if (data.success ){
                                layer.msg("添加成功！",{icon:1});
                                $("#sf_content").bootstrapTable('refresh',{url:CTX+"/yhPark/queryAllParkSfByPage.html?1=1 "})
                            }else {
                                layer.alert(data.result.msg);
                                layer.close(index);
                            }
                        },
                        error: function (XMLHttpRequest,textStatus) {
                            alert(XMLHttpRequest + "---" + textStatus + "添加收费信息失败，请联系管理员！")
                        }
                    });
                });
            }
        },
        btn2:function (index) {
            layer.close(index);
        }
    });



    var start = {
        zIndex:66668888,
        dateCell: '#startTime',
        format: 'hh:mm:ss',
        minDate: '00:00:00',
        festival:true,
        maxDate: '23:59:59',
        isTime:true,
        choosefun:function (datas) {
            end.minDate = datas;
        }

    };

    var end = {
        zIndex:66668888,
        dateCell: '#endTime',
        format: 'hh:mm:ss',
        minDate: '00:00:00',
        festival:true,
        maxDate: '00:00:00',
        isTime:true,
        choosefun:function (datas) {
            start.maxDate = datas;
        }

    };

    jeDate(start);
    jeDate(end);

}


/***
 * 查找资源
 */
function searchSf() {
    var index = layer.open({
        title:['查找收费标准','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['400px','260px'],
        content:'<form role="form" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">车位名称</span>\n' +
        '            <input type="text" id="sear_paMc"  name="paMc" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">状态</span>\n' +
        '            <select type="text" id="sear_paFlag"  name="paFlag" class="form-control"  ><option value="1">已启用</option><option value="0">未启用</option></select>\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">备注</span>\n' +
        '            <textarea type="text" id="sear_bz"  name="bz" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '</form>',
        btn:['查找','取消'],
        btn1:function (index) {

            var paMc = $("#sear_paMc").val();
            var bz = $("#sear_bz").val();
            var paFlag = $("#sear_paFlag option:selected").val();


            var urlParam = "";
            if (paMc != null && paMc != ''){
                urlParam += "&paMc="+paMc;
            }
            if (paFlag != null && paFlag != ''){
                urlParam += "&paFlag="+paFlag;
            }
            if (bz != null && bz != ''){
                urlParam += "&bz="+bz;
            }

            $("#sf_content").bootstrapTable('refresh',{url:CTX+"/yhPark/queryAllParkSfCwByPage.html?type = 1 "+urlParam})

            layer.close(index);
        },
        btn2:function (index) {
            layer.close(index);
        }

    });
}

/***
 * 资源详情c
 * @constructor
 */
function sfMsg() {
    var skey = "";
    var selections = $("#sf_content").bootstrapTable('getSelections');
    if(selections.length == 1){
        skey = selections[0].skey;
    }else{
        layer.msg("请选择单条数据！");
        return false;
    }
    if(  skey == "" || skey == null ){
        layer.msg("未获取到相关信息！");
        return false;
    }else{
        $.ajax({
            type: 'POST',
            url: CTX + "/yhPark/getParkSfBySkey.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success:function (data) {
                if(data.success){
                    var index = layer.open({
                        title:['收费标准','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
                        area:['400px','46%'],
                        content:'<form id="addCwForm"  role="form" action="javascript:void(0)">\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">开始时间</span>\n' +
                        '            <input data-bv-notempty data-bv-notempty-message="开始时间为必填项" data-bv-stringlength="20" maxlength="20" type="text" id="de_startTime" placeholder="开始时间为必填项 " name="paKssj" class="form-control"  readonly />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">结束时间</span>\n' +
                        '            <input  data-bv-notempty data-bv-notempty-message="结束时间为必填项" data-bv-stringlength="20" maxlength="21"   type="text" id="de_endTime"  name="paJssj" class="form-control"  placeholder="结束时间必填项  " readonly />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">收费标准</span>\n' +
                        '            <input data-bv-notempty data-bv-notempty-message="收费标准为必填项" data-bv-stringlength="11" maxlength="11"  onkeyup="if(isNaN(value))execCommand(\'undo\')" onafterpaste="if(isNaN(value))execCommand(\'undo\')"    type="text" id="de_paSfbz" name="paSfbz" placeholder="收费标准为必填项 如 0.8元每小时 " class="form-control"  />\n' +
                        '            <span class="input-group-addon">每小时</span>  \n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">备注</span>\n' +
                        '            <textarea type="text" id="de_bz" name="bz" maxlength="100" class="form-control"  />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '</form>',
                        btn:['关闭'],
                        btn1:function (index) {
                            layer.close(index);
                        }
                    });



                    var start = {
                        zIndex:66668888,
                        dateCell: '#startTime',
                        format: 'hh:mm:ss',
                        minDate: '00:00:00',
                        festival:true,
                        maxDate: '23:59:59',
                        isTime:true,
                        choosefun:function (datas) {
                            end.minDate = datas;
                        }

                    };

                    var end = {
                        zIndex:66668888,
                        dateCell: '#endTime',
                        format: 'hh:mm:ss',
                        minDate: '00:00:00',
                        festival:true,
                        maxDate: '00:00:00',
                        isTime:true,
                        choosefun:function (datas) {
                            start.maxDate = datas;
                        }

                    };

                    jeDate(start);
                    jeDate(end);

                    var datas = data.results[0];

                    $("#de_startTime").val("").val(datas.paKssj);
                    $("#de_endTime").val("").val(datas.paJssj);
                    $("#de_paSfbz").val("").val(datas.paSfbz);
                    $("#de_bz").val("").val(datas.bz);

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
 * 刷新资源
 */
function refSf() {
    window.location.reload();
}

/***
 * 删除资源
 */
function removeSf() {
    var skey = null;
    var sels = $("#sf_content").bootstrapTable('getSelections');
    if(sels.length != 1  ){
        layer.msg("请选择一条需要删除的数据",{icon:2});
        return false;
    }else{
        skey = sels[0].skey;
    }
    if(skey == null || skey == '' || skey == undefined){
        layer.msg('请选择您需要删除的数据',{icon: 2});
        return false;
    }
    layer.confirm('确认是否删除',function () {
        $.ajax({
            type: 'POST',
            url: CTX + "/yhPark/deleteSf.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.success){
                    layer.msg('删除成功',{icon:1});
                    $("#sf_content").bootstrapTable('refresh',{url:CTX+'/yhPark/queryAllParkSfByPage.html'});
                }else{
                    layer.alert('删除失败'+data.msg);
                }
            },
            error: function () {
                alert(XMLHttpRequest + "---" + textStatus );
            }
        });
    });

}


function updateSf() {
    var skey = "";
    var selections = $("#sf_content").bootstrapTable('getSelections');
    if(selections.length == 1){
        skey = selections[0].skey;
    }else{
        layer.msg("请选择单条数据！");
        return false;
    }
    if(  skey == "" || skey == null ){
        layer.msg("未获取到相关信息！");
        return false;
    }else{
        $.ajax({
            type: 'POST',
            url: CTX + "/yhPark/getParkSfBySkey.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success:function (data) {
                if(data.success){
                    var index = layer.open({
                        title:['收费标准','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
                        area:['400px','46%'],
                        content:'<form id="addCwForm"  role="form" action="javascript:void(0)">\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">开始时间</span>\n' +
                        '            <input data-bv-notempty data-bv-notempty-message="开始时间为必填项" data-bv-stringlength="20" maxlength="20" type="text" id="de_startTime" placeholder="开始时间为必填项 " name="paKssj" class="form-control"  readonly />\n' +
                        '            <input  type="hidden" id="de_skey"  name = "skey"  />       \n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">结束时间</span>\n' +
                        '            <input  data-bv-notempty data-bv-notempty-message="结束时间为必填项" data-bv-stringlength="20" maxlength="21"   type="text" id="de_endTime"  name="paJssj" class="form-control"  placeholder="结束时间必填项  " readonly />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">收费标准</span>\n' +
                        '            <input data-bv-notempty data-bv-notempty-message="收费标准为必填项" data-bv-stringlength="11" maxlength="11"  onkeyup="if(isNaN(value))execCommand(\'undo\')" onafterpaste="if(isNaN(value))execCommand(\'undo\')"    type="text" id="de_paSfbz" name="paSfbz" placeholder="收费标准为必填项 如 0.8元每小时 " class="form-control"  />\n' +
                        '            <span class="input-group-addon">每小时</span>  \n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">备注</span>\n' +
                        '            <textarea type="text" id="de_bz" name="bz" maxlength="100" class="form-control"  />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '</form>',
                        btn:['修改', '关闭'],
                        btn1:function (index) {

                            var paKssj = $("#de_startTime").val();
                            var paJssj = $("#de_endTime").val();
                            var paSfbz = $("#de_paSfbz").val();
                            var bz = $("#de_bz").val();
                            // var paFlag = $('input:radio:checked').val();
                            //var paFlag = $("#de_paFlag option:selected").val();
                            var Skey = $("#de_skey").val();



                            $("#addCwForm").bootstrapValidator("validate");
                            if ($("#addCwForm").data("bootstrapValidator").isValid()){
                                layer.confirm('确认是否修改',function () {
                                    $.ajax({
                                        type: 'POST',
                                        url: CTX + "/yhPark/updateSf.html",
                                        data: {paKssj :paKssj,paJssj:paJssj,paSfbz:paSfbz,bz:bz,Skey:skey},
                                        dataType: 'json',
                                        async: false,
                                        success: function (data) {
                                            if (data.success ){
                                                layer.msg("修改成功！",{icon:1});
                                                $("#sf_content").bootstrapTable('refresh',{url:CTX+"/yhPark/queryAllParkSfByPage.html?1=1 "})
                                            }else {
                                                layer.alert(data.result.msg);
                                                layer.close(index);
                                            }
                                        },
                                        error: function (XMLHttpRequest,textStatus) {
                                            alert(XMLHttpRequest + "---" + textStatus + "修改车位失败，请联系管理员！")
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

                    $("#de_startTime").val("").val(datas.paKssj);
                    $("#de_endTime").val("").val(datas.paJssj);
                    $("#de_paSfbz").val("").val(datas.paSfbz);
                    $("#de_bz").val("").val(datas.bz);
                    $("#de_skey").val("").val(datas.skey);



                    var start = {
                        zIndex:66668888,
                        dateCell: '#de_startTime',
                        format: 'hh:mm:ss',
                        minDate: '00:00:00',
                        festival:true,
                        maxDate: '23:59:59',
                        isTime:true,
                        choosefun:function (datas) {
                            end.minDate = datas;
                        }

                    };

                    var end = {
                        zIndex:66668888,
                        dateCell: '#de_endTime',
                        format: 'hh:mm:ss',
                        minDate: '00:00:00',
                        festival:true,
                        maxDate: '00:00:00',
                        isTime:true,
                        choosefun:function (datas) {
                            start.maxDate = datas;
                        }

                    };

                    jeDate(start);
                    jeDate(end);



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
