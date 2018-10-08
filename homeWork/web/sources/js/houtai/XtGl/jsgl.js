$(document).ready(function () {
    LoadingResources();//加载资源
});


/***
 * 加载资源操作
 * @constructor
 */
function LoadingResources() {

    loadToolBars('toolbar');
    $("#XtJsContent").bootstrapTable({
        url: CTX + '/xtjs/findAll.html',
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
            {title:"角色名称",field:"name",align:"left",order:"desc"},
            {title:"角色描述",field:"desc",align:"left",order:"desc"},
            {title:"状态",field:"flag",align:"left",order:"desc"}
        ],
        locale:"zh-CN" //中文支持
    })

}

function operateJs() {
    var layerIndex;

    layerIndex = layer.open({
        type:2,
        title:['我的资源','background-color : #26A96A; color : #fff; font-size : 18px; font-weight : 700 '],
        area: ['30%','60%'],
        shade:0,
        maxmin:true,
        scrollbar: false,
        content:'../../console/XtGl/XtZyTree.jsp',
        btn:['确认','重置','关闭'],
        yes:function () {
            $("#xtzyName").val($("iframe").contents().find("#xtzyName").val());
            $("#xtzyId").val($("iframe").contents().find("#xtzyId").val());
            alert($("iframe").contents().find("#xtzyId").val() +"---");
            layer.close(layerIndex);
        },
        btn2: function () {
            $("#parentname").val("");
            $("#parentkey").val("");
            layer.close(layerIndex);
        },
        btn3: function () {
            layer.closeAll();
        },
        zIndex: layer.zIndex, //重点1
        success: function (layero) {
            layer.setTop(layero); //重点2
        }

    });
}



function operateJss() {

    var index = layer.open({
        title:['我的树','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['400px','500px'],
        content:'<div class="treeview" id="treejs" >\n' +

        '</div>',
        btn:['查找','取消'],
        btn1:function (index) {


            layer.close(index);
        },
        btn2:function (index) {
            layer.close(index);
        }

    });

    // $.ajax({
    //     type: 'POST',
    //     url: CTX + "/xtzy/getZyTree.html",
    //     data: {id:''},
    //     dataType: 'json',
    //     async: false,
    //     success: function (data) {
    //    alert(JSON.stringify(data));
    //     },
    //     error:function (data) {
    //         alert(JSON.stringify(data));
    //     }
    // });

    var name = '',id = '';
    $("#treejs").jstree({
        plugins:[
            'wholerow','checkbox'
        ],
        core:{
            strings:{
                'Loding....':'加载中'
            },
            data:{
                url:CTX + '/xtzy/getZyTree.html',
                "data":function (node) {
                    return {id:node.id}
                }
            }
        }
    });

    $("#treejs").on("changed.jstree",function (e,data) {
        if(data.node){
            name = data.node.text;
            id = data.node.id;
        }else{
            name = '';
            id = '';
        }
    });



}


function addJs() {
 layer.alert("欢迎添加角色");
}