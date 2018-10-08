$(document).ready(function () {
    LoadingResources();//加载资源
});





/***
 * 加载资源操作
 * @constructor
 */
function LoadingResources() {

    loadToolBars('toolbar');
    $("#Xt_xlhCsContent").bootstrapTable({
        url: CTX + '/sequence/getSequencePageList.html',
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
            {title:"当前值",field:"currentValue",align:"left",order:"desc"},
            {title:"递增值",field:"increment",align:"left",order:"desc"}
        ],
        locale:"zh-CN" //中文支持
    })

}


/***
 * 删除
 * @returns {boolean}
 */

function deleteXlhCs() {
    var skey = null;
    var sels = $("#Xt_xlhCsContent").bootstrapTable('getSelections');
    if(sels.length != 1  ){
        layer.msg("请选择一条需要删除的数据",{icon:2});
        return false;
    }else{
        skey = sels[0].name;
    }
    if(skey == null || skey == '' || skey == undefined){
        layer.msg('请选择您需要删除的数据',{icon: 3});
        return false;
    }
    layer.confirm('确认是否删除',function () {
        $.ajax({
            type: 'POST',
            url: CTX + "/sequence/delete.html",
            data: {name:skey},
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.success){
                    layer.msg('删除成功',{icon:1});
                    $("#Xt_xlhCsContent").bootstrapTable('refresh',{url:CTX+"/sequence/getSequencePageList.html"})
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
function searXlhCs() {
    var index = layer.open({
        title:['查找序列化参数信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['36%','48%'],
        content:'<form role="form" id="XlhCsForms" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">名称</span>\n' +
        '            <input type="text" id="sear_name"  name="name" class="form-control" placeholder="请输入参数名称...." data-bv-notempty data-bv-notempty-message="参数名称为必填项" data-bv-stringlength="100" maxlength="100"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">初始值</span>\n' +
        '            <input type="number" id="sear_value"  name="value" class="form-control" placeholder="请输入参数值...." data-bv-notempty data-bv-notempty-message="参数值为必填项" data-bv-stringlength="100" maxlength="100"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">递增量</span>\n' +
        '            <input type="number" id="sear_increment"  name="increment" class="form-control" placeholder="请输入参数值...." data-bv-notempty data-bv-notempty-message="参数值为必填项" data-bv-stringlength="100" maxlength="100"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '</form>',
        btn:['查找','取消'],
        btn1:function (index) {


            var name = $("#sear_name").val();
            var currentVal = $("#sear_value").val();
            var increment = $("#sear_increment").val();


            var urlParam = "";
            if (name != null && name != ''){
                urlParam += "&name="+name;
            }
            if (currentVal != null && currentVal != ''){
                urlParam += "&currentValue="+currentVal;
            }
            if(increment != null && increment != ''){
                urlParam += "&increment="+increment;
            }



            $("#Xt_xlhCsContent").bootstrapTable('refresh',{url:CTX+"/sequence/getSequencePageList.html?type = 1 "+urlParam})

            layer.close(index);
        },
        btn2:function (index) {
            layer.close(index);
        }

    });


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
function refXlhCs() {
    $("#Xt_xlhCsContent").bootstrapTable('refresh',{url:CTX+"/sequence/getSequencePageList.html "})
}


/***
 * 添加
 */
function addXlhCs() {
    var index = layer.open({
        title:['添加序列化参数信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['36%','44%'],
        content:'<form role="form" id="addXlhCsForms" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">名称</span>\n' +
        '            <input type="text" id="add_name"  name="name" class="form-control" placeholder="请输入参数名称(建议纯英文)...." data-bv-notempty data-bv-notempty-message="参数名称为必填项" data-bv-stringlength="50" maxlength="50"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '     <div class="row">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">初始值</span>\n' +
        '            <input type="number" id="add_value"  name="currentValue" class="form-control" placeholder="请输入参数值...." data-bv-notempty data-bv-notempty-message="参数值为必填项" data-bv-stringlength="11" maxlength="11"   />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">递增量</span>\n' +
        '            <input type="number" id="typecodes"  name="increment" class="form-control"  placeholder="请输入递增量...."   data-bv-stringlength="11" maxlength="11"   />\n' +
        '        </div>\n' +
        '     </div>\n' +
        '</form>',
        btn:['保存','取消'],
        btn1:function (index) {


            var name = $("#add_name").val();
            var typecode = $("#typecodes").val();
            var value = $("#add_value").val();


            $("#addXlhCsForms").bootstrapValidator("validate");
            if ($("#addXlhCsForms").data("bootstrapValidator").isValid()) {
                layer.confirm('确认是否保存', function () {
                    $.ajax({
                        type: 'POST',
                        url: CTX + "/sequence/saveXtSequence.html",
                        data: {name: name, increment: typecode, currentValue: value},
                        dataType: 'json',
                        async: false,
                        success: function (data) {
                            if (data.success) {
                                layer.msg('添加成功', {icon: 1});
                                $("#Xt_xlhCsContent").bootstrapTable('refresh', {url: CTX + "/sequence/getSequencePageList.html "})
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

   // loadingOptions('typecodes');
}


