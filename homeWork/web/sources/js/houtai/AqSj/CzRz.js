$(document).ready(function () {
    loadPage();
});

function loadPage() {
    loadToolBars('toolBar');
    $("#RzCz_Content").bootstrapTable({
        url: CTX + '/xtRzCz/queryAllByPage.html',
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
            {title:"用户",field:"userId",align:"left",order:"desc"},
            {title:"用户名",field:"userName",align:"left",order:"desc"},
            {title:"用户单位",field:"unitKey",align:"left",order:"desc"},
            // {title:"系统类型",field:"regId",align:"left",order:"desc"},
            // {title:"操作类型",field:"operateType",align:"left",order:"desc"},
            {title:"操作名称",field:"operateName",align:"left",order:"desc"},
            {title:"操作内容",field:"operateCondition",align:"left",order:"desc"},
            {title:"操作结果",field:"operateResult", formatter: function (value) {
              return formateFlag(value);
            }, align:"left",order:"desc"},
            {title:"操作时间",field:"operateTime",align:"left",order:"desc"},
        ],
        locale:"zh-CN" //中文支持
    })
}

/**
 * 翻译字段
 * @param value
 */
function formateFlag(value) {
    var a = "";
    if(value == "0") {
        var a = '<span style="color:#c12e2a;"><i class="fa fa-times-circle-o" aria-hidden="true"></i>失败</span>';
    }else if(value == "1"){
        var a = '<span style="color:#3e8f3e"><i class="fa fa-check-circle-o" aria-hidden="true"></i>成功</span>';
    }
    return a;
}

/***
 * 查找操作日志信息
 */
function searchRzCz() {
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
function refRzCz() {
    $("#RzCz_Content").bootstrapTable('refresh',{url:CTX+"/xtRzCz/queryAllByPage.html?type = 1 "})

}

/**
 * 删除操作
 */
function deleteCzRz() {
    var skey = null;
    var sels = $("#RzCz_Content").bootstrapTable('getSelections');
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
            url: CTX + "/xtRzCz/deleteRzCz.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.success){
                    layer.msg('删除成功',{icon:1});
                    $("#RzCz_Content").bootstrapTable('refresh',{url:CTX+"/xtRzCz/queryAllByPage.html?type = 1 "})
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
