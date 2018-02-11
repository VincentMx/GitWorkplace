$(document).ready(function () {
   layer.msg('欢迎访问登录日志',{icon:1});
   loadPage();
});

function loadPage() {
    loadToolBars('toolbar');
    $("#dlrzTable").bootstrapTable({
        url: CTX + '/xtRzDl/queryAllDataByPage.html',
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
            {title:"用户名",field:"userName",align:"left",order:"desc"},
            {title:"身份证号",field:"userId",align:"left",order:"desc"},
            {title:"ip地址",field:"ipAddress",align:"left",order:"desc"},
            {title:"系统类型",field:"sysType",align:"left",order:"desc"},
            {title:"用户单位",field:"unitName",align:"left",order:"desc"},
            {title:"登录时间",field:"loginTime",align:"left",order:"desc"},
            {title:"退出时间",field:"logoutTime",align:"left",order:"desc"}
            ],
        locale:"zh-CN" //中文支持
    })
}


/***
 * 查找操作日志信息
 */
function searchRzDl() {
    var index = layer.open({
        title:['查找登陆日志','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['400px','420px'],
        content:'<form role="form" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">登录开始时间</span>\n' +
        '            <input type="text" id="startTime" name="startTime" class="form-control" placeholder="开始时间..."  readonly />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">登录结束时间</span>\n' +
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
        '            <span class="input-group-addon">IP地址</span>\n' +
        '            <input type="text" id="sear_ipaddress"  name="ipAddress" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '</form>',
        btn:['查找','取消'],
        btn1:function (index) {

            var starttime = $("#startTime").val();
            var endtime = $("#endTime").val();
            var userName = $("#sear_name").val();
            var userId = $("#sear_id").val();
            var ipAddress = $("#sear_ipaddress").val();


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
            if (ipAddress != null && ipAddress != ''){
                urlParam += "&ipAddress="+ipAddress;
            }


            $("#dlrzTable").bootstrapTable('refresh',{url:CTX+"/xtRzDl/queryAllDataByPage.html?type = 1 "+urlParam})

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
function refRzDl() {
    $("#dlrzTable").bootstrapTable('refresh',{url:CTX+"/xtRzDl/queryAllDataByPage.html"})

}

/**
 * 删除操作
 */
function deleteRzDl() {
    var skey = null;
    var sels = $("#dlrzTable").bootstrapTable('getSelections');
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
            url: CTX + "/xtRzDl/delete.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.success){
                    layer.msg('删除成功',{icon:1});
                    $("#dlrzTable").bootstrapTable('refresh',{url:CTX+"/xtRzDl/queryAllDataByPage.html"})
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
