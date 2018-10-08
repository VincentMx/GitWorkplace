
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
    $("#cw_content").bootstrapTable({
        url: CTX + '/yhPark/queryAllCwByPage.html',
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
            {title:"车位名称",field:"paMc",align:"left",order:"desc"},
            {title:"长度",field:"paCd",align:"left", formatter:function(value){
              return formateCd(value);
            }, order:"desc"},
            {title:"宽度",field:"paKd",align:"left", formatter: function (value) {
              return formateKd(value);
            }, order:"desc"},
            {title:"经度",field:"bdjd",align:"left",order:"desc"},
            {title:"纬度",field:"bdwd",align:"left",order:"desc"},
            {title:"状态",field:"paFlag",align:"left", formatter:function (value) {
              return formateCwFlag(value);
            }, order:"desc"},
            {title:"备注",field:"bz",align:"left",order:"desc"}

        ],
        locale:"zh-CN" //中文支持
    })

};

/***
 * 翻译长度
 */
function formateCd(value) {
    return value + "米";
};
/***
 * 翻译宽度
 */
function formateKd(value) {
    return value + "米";
}


/**
 * 车位状态字段列表
 * @param value
 * @returns {string}
 */
function formateCwFlag(value) {
    var a = "";
    if(value == "0") {
        var a = '<span style="color:#c12e2a;"><i class="fa fa-times-circle-o" aria-hidden="true"></i>未启用</span>';
    }else if(value == "1"){
        var a = '<span style="color:#3e8f3e"><i class="fa fa-check-circle-o" aria-hidden="true"></i>已启用</span>';
    }
    return a;
}


/**
 * 加载select选项
 * @param target
 */
function loadingOptions(target) {
    $.ajax({
        type: 'POST',
        url: CTX + "/yhPark/findAll.html",
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
 * 新增资源
 */
function addCw() {
    var index = layer.open({
        title:['新增车位','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['36%','73%'],
        content:'<form id="addCwForm"  role="form" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">车位名称</span>\n' +
        '            <input data-bv-notempty data-bv-notempty-message="车位名称为必填项" data-bv-stringlength="50" maxlength="50" type="text" id="paMc"  name="paMc" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">车位长度</span>\n' +
        '            <input  data-bv-notempty data-bv-notempty-message="车位长度为必填项" data-bv-stringlength="11" maxlength="11"  onkeyup="if(isNaN(value))execCommand(\'undo\')" onafterpaste="if(isNaN(value))execCommand(\'undo\')" type="text" id="paCd"  name="paCd" class="form-control"  placeholder="车位长度为必填项 如 ： 2.3 " />\n' +
        '             <span class="input-group-addon">米</span> \n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">车位宽度</span>\n' +
        '            <input data-bv-notempty data-bv-notempty-message="车位宽度为必填项" data-bv-stringlength="11" maxlength="11"  onkeyup="if(isNaN(value))execCommand(\'undo\')" onafterpaste="if(isNaN(value))execCommand(\'undo\')"    type="text" id="paKd" name="paKd" placeholder="车位宽度为必填项、如 ： 2.3 " class="form-control"  />\n' +
        '            <span class="input-group-addon">米</span>  \n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">百度经度</span>\n' +
        '            <input type="text" id="bdjd"  onkeyup="if(isNaN(value))execCommand(\'undo\')" onafterpaste="if(isNaN(value))execCommand(\'undo\')" name="bdjd" class="form-control"  > \n' +
        '            </input>\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">百度纬度</span>\n' +
        '            <input type="text" id="bdwd"  onkeyup="if(isNaN(value))execCommand(\'undo\')" onafterpaste="if(isNaN(value))execCommand(\'undo\')" name="bdwd" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">车位状态</span>\n' +
        '            <select  type="text" id="paFlag"  name="paFlag" class="form-control"  > <option value="0">不启用</option><option value="1">启用</optionva> </select>\n' +
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

            var paMc = $("#paMc").val();
            var paCd = $("#paCd").val();
            var paKd = $("#paKd").val();
            var bdjd = $("#bdjd").val();
            var bdwd = $("#bdwd").val();
            var bz = $("#bz").val();
           // var paFlag = $('input:radio:checked').val();
            var paFlag = $("#paFlag option:selected").val();




            $("#addCwForm").bootstrapValidator("validate");
            if ($("#addCwForm").data("bootstrapValidator").isValid()){
                layer.confirm('确认是否添加',function () {
                    $.ajax({
                        type: 'POST',
                        url: CTX + "/yhPark/addCw.html",
                        data: {paMc:paMc,paKd:paKd,paCd:paCd,bdjd:bdjd,bdwd:bdwd,bz:bz,paFlag:paFlag},
                        dataType: 'json',
                        async: false,
                        success: function (data) {
                            if (data.success ){
                                layer.msg("添加成功！",{icon:1});
                                $("#cw_content").bootstrapTable('refresh',{url:CTX+"/yhPark/queryAllCwByPage.html?1=1 "})
                            }else {
                                layer.alert(data.result.msg);
                                layer.close(index);
                            }
                        },
                        error: function (XMLHttpRequest,textStatus) {
                            alert(XMLHttpRequest + "---" + textStatus + "添加车位失败，请联系管理员！")
                        }
                    });
                });
            }
        },
        btn2:function (index) {
            layer.close(index);
        }
    });
}


/***
 * 查找资源
 */
function searchCw() {
    var index = layer.open({
        title:['查找车位','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
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

            $("#cw_content").bootstrapTable('refresh',{url:CTX+"/yhPark/queryAllCwByPage.html?type = 1 "+urlParam})

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
function cwMsg() {
    var skey = "";
    var selections = $("#cw_content").bootstrapTable('getSelections');
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
            url: CTX + "/yhPark/getCwxxBySkey.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success:function (data) {
                if(data.success){
                    var index = layer.open({
                        title:['车位信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
                        area:['400px','65%'],
                        content:'<form id="addCwForm"  role="form" action="javascript:void(0)">\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">车位名称</span>\n' +
                        '            <input data-bv-notempty data-bv-notempty-message="车位名称为必填项" data-bv-stringlength="50" maxlength="50" type="text" id="de_paMc"  name="paMc" class="form-control"  />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">车位长度</span>\n' +
                        '            <input  data-bv-notempty data-bv-notempty-message="车位长度为必填项" data-bv-stringlength="11" maxlength="11"  onkeyup="if(isNaN(value))execCommand(\'undo\')" onafterpaste="if(isNaN(value))execCommand(\'undo\')" type="text" id="de_paCd"  name="paCd" class="form-control"  placeholder="车位长度为必填项 如 ： 2.3 " />\n' +
                        '             <span class="input-group-addon">米</span> \n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">车位宽度</span>\n' +
                        '            <input data-bv-notempty data-bv-notempty-message="车位宽度为必填项" data-bv-stringlength="11" maxlength="11"  onkeyup="if(isNaN(value))execCommand(\'undo\')" onafterpaste="if(isNaN(value))execCommand(\'undo\')"    type="text" id="de_paKd" name="paKd" placeholder="车位宽度为必填项、如 ： 2.3 " class="form-control"  />\n' +
                        '            <span class="input-group-addon">米</span>  \n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">百度经度</span>\n' +
                        '            <input type="text" id="de_bdjd"  onkeyup="if(isNaN(value))execCommand(\'undo\')" onafterpaste="if(isNaN(value))execCommand(\'undo\')" name="bdjd" class="form-control"  > \n' +
                        '            </input>\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">百度纬度</span>\n' +
                        '            <input type="text" id="de_bdwd"  onkeyup="if(isNaN(value))execCommand(\'undo\')" onafterpaste="if(isNaN(value))execCommand(\'undo\')" name="bdwd" class="form-control"  />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">车位状态</span>\n' +
                        '            <select  type="text" id="de_paFlag"  name="paFlag" class="form-control"  > <option value="0">不启用</option><option value="1">启用</optionva> </select>\n' +
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
                    var datas = data.results[0];

                    $("#de_paMc").val("").val(datas.paMc);
                    $("#de_paCd").val("").val(datas.paCd);
                    $("#de_paKd").val("").val(datas.paKd);
                    $("#de_bdjd").val("").val(datas.bdjd);
                    $("#de_bdwd").val("").val(datas.bdwd);
                    $("#de_paFlag").val("").val(datas.paFlag);
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
function refCw() {
    window.location.reload();
}

/***
 * 删除资源
 */
function deleteCw() {
    var skey = null;
    var sels = $("#cw_content").bootstrapTable('getSelections');
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
            url: CTX + "/yhPark/deleteCw.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.success){
                    layer.msg('删除成功',{icon:1});
                    $("#cw_content").bootstrapTable('refresh',{url:CTX+'/yhPark/queryAllCwByPage.html'});
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


function updateCw() {
    var skey = "";
    var selections = $("#cw_content").bootstrapTable('getSelections');
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
            url: CTX + "/yhPark/getCwxxBySkey.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success:function (data) {
                if(data.success){
                    var index = layer.open({
                        title:['车位信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
                        area:['400px','65%'],
                        content:'<form id="addCwForm"  role="form" action="javascript:void(0)">\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">车位名称</span>\n' +
                        '            <input data-bv-notempty data-bv-notempty-message="车位名称为必填项" data-bv-stringlength="50" maxlength="50" type="text" id="de_paMc"  name="paMc" class="form-control"  />\n' +
                        '            <input type = "hidden" id = "de_skey" name = "skey" />      \n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">车位长度</span>\n' +
                        '            <input  data-bv-notempty data-bv-notempty-message="车位长度为必填项" data-bv-stringlength="11" maxlength="11"  onkeyup="if(isNaN(value))execCommand(\'undo\')" onafterpaste="if(isNaN(value))execCommand(\'undo\')" type="text" id="de_paCd"  name="paCd" class="form-control"  placeholder="车位长度为必填项 如 ： 2.3 " />\n' +
                        '             <span class="input-group-addon">米</span> \n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">车位宽度</span>\n' +
                        '            <input data-bv-notempty data-bv-notempty-message="车位宽度为必填项" data-bv-stringlength="11" maxlength="11"  onkeyup="if(isNaN(value))execCommand(\'undo\')" onafterpaste="if(isNaN(value))execCommand(\'undo\')"    type="text" id="de_paKd" name="paKd" placeholder="车位宽度为必填项、如 ： 2.3 " class="form-control"  />\n' +
                        '            <span class="input-group-addon">米</span>  \n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">百度经度</span>\n' +
                        '            <input type="text" id="de_bdjd"  onkeyup="if(isNaN(value))execCommand(\'undo\')" onafterpaste="if(isNaN(value))execCommand(\'undo\')" name="bdjd" class="form-control"  > \n' +
                        '            </input>\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">百度纬度</span>\n' +
                        '            <input type="text" id="de_bdwd"  onkeyup="if(isNaN(value))execCommand(\'undo\')" onafterpaste="if(isNaN(value))execCommand(\'undo\')" name="bdwd" class="form-control"  />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">车位状态</span>\n' +
                        '            <select  type="text" id="de_paFlag"  name="paFlag" class="form-control"  > <option value="0">不启用</option><option value="1">启用</optionva> </select>\n' +
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

                            var paMc = $("#de_paMc").val();
                            var paCd = $("#de_paCd").val();
                            var paKd = $("#de_paKd").val();
                            var bdjd = $("#de_bdjd").val();
                            var bdwd = $("#de_bdwd").val();
                            var bz = $("#de_bz").val();
                            // var paFlag = $('input:radio:checked').val();
                            var paFlag = $("#de_paFlag option:selected").val();
                            var Skey = $("#de_skey").val();



                            $("#addCwForm").bootstrapValidator("validate");
                            if ($("#addCwForm").data("bootstrapValidator").isValid()){
                                layer.confirm('确认是否修改',function () {
                                    $.ajax({
                                        type: 'POST',
                                        url: CTX + "/yhPark/updateCw.html",
                                        data: {paMc:paMc,paKd:paKd,paCd:paCd,bdjd:bdjd,bdwd:bdwd,bz:bz,paFlag:paFlag,Skey:skey},
                                        dataType: 'json',
                                        async: false,
                                        success: function (data) {
                                            if (data.success ){
                                                layer.msg("修改成功！",{icon:1});
                                                $("#cw_content").bootstrapTable('refresh',{url:CTX+"/yhPark/queryAllCwByPage.html?1=1 "})
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

                    $("#de_paMc").val("").val(datas.paMc);
                    $("#de_paCd").val("").val(datas.paCd);
                    $("#de_paKd").val("").val(datas.paKd);
                    $("#de_bdjd").val("").val(datas.bdjd);
                    $("#de_bdwd").val("").val(datas.bdwd);
                    $("#de_paFlag").val("").val(datas.paFlag);
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
