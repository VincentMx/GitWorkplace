
$(document).ready(function () {

   LoadingResources();
  //  getList();
});


/***
 * 加载资源操作
 * @constructor
 */
function LoadingResources() {
    loadToolBars("toolbar");
    $("#xtZyContent").bootstrapTable({
        url: CTX + '/xtzy/getXtZyPageList.html',
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
            {title:"资源名称",field:"name",align:"left",order:"desc"},
            {title:"路径",field:"url",align:"left",order:"desc"},
            {title:"是否父节点",field:"isparent",align:"left",order:"desc"},
            {title:"父节点",field:"parentkey",align:"left",order:"desc"},
            {title:"备注",field:"file1",align:"left",order:"desc"}

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
 * 新增资源
 */
function addResources() {
    var index = layer.open({
        title:['新增资源','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['400px','490px'],
        content:'<form id="addResourcesForm"  role="form" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">名称</span>\n' +
        '            <input data-bv-notempty data-bv-notempty-message="资源名称为必填项" data-bv-stringlength="32" maxlength="32" type="text" id="name"  name="name" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">url</span>\n' +
        '            <input  data-bv-notempty data-bv-notempty-message="资源路径为必填项" data-bv-stringlength="100" maxlength="100"   type="text" id="url"  name="url" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">资源图标</span>\n' +
        '            <input type="text" id="icon" name="icon" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">是否为父级资源</span> &nbsp;&nbsp;&nbsp; \n' +
        '           <label class="radio-inline">' +
        '           <input type="radio"   name="isparent" value="1" checked> 是 \n' +
        '          </label>\n' +
        '           <label class="radio-inline">' +
        '           <input type="radio" name="isparent" value="0"> 不是 \n' +
        '          </label>\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">选择父资源</span>\n' +
        '            <select type="text" id="parentkey" name="parentkey" class="form-control"  > \n' +
        '            </select>\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">排序</span>\n' +
        '            <input type="text" id="seq" name="seq" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">备注</span>\n' +
        '            <textarea type="text" id="field1" name="file1" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '</form>',
        btn:['保存','取消'],
        btn1:function (index) {

            var name = $("#name").val();
            var url = $("#url").val();
            var icon = $("#icon").val();
            var seq = $("#seq").val();
            var file = $("#field1").val();
            var isparent = $('input:radio:checked').val();
            var parentkey = $("#parentkey option:selected").val();


            if(isparent == '0'){
                if(parentkey == null || parentkey == ''){
                    layer.alert("如果不属于父级资源，则必须选择所属父级资源",{icon:2});
                    return false;
                }
            }else if(isparent == '1'){
                if( parentkey != ''){
                    layer.alert("如果属于父级资源，则不能选择所属父级资源",{icon:2});
                    return false;
                }
            }

            $("#addResourcesForm").bootstrapValidator("validate");
            if ($("#addResourcesForm").data("bootstrapValidator").isValid()){
                layer.confirm('确认是否添加',function () {
                    $.ajax({
                        type: 'POST',
                        url: CTX + "/xtzy/saveXtZy.html",
                        data: {name:name,url:url,icon:icon,seq:seq,file1:file,isparent:isparent,parentkey:parentkey},
                        dataType: 'json',
                        async: false,
                        success: function (data) {
                            if (data.success ){
                                layer.msg("添加成功！",{icon:1});
                                $("#xtZyContent").bootstrapTable('refresh',{url:CTX+"/xtzy/getXtZyPageList.html?1=1 "})
                            }else {
                                layer.alert(data.result.msg);
                                layer.close(index);
                            }
                        },
                        error: function (XMLHttpRequest,textStatus) {
                            alert(XMLHttpRequest + "---" + textStatus + "添加资源失败")
                        }
                    });
                });
            }
        },
        btn2:function (index) {
           layer.close(index);
        }
    });
    //加载下拉选项
    loadingOptions('parentkey');
}


/***
 * 查找资源
 */
function searchResources() {
    var index = layer.open({
        title:['我的消息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['400px','430px'],
        content:'<form role="form" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">名称</span>\n' +
        '            <input type="text" id="sear_name"  name="name" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">url</span>\n' +
        '            <input type="text" id="sear_url"  name="url" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">icon</span>\n' +
        '            <input type="text" id="sear_icon"  name="icon" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">是否为父级资源</span> &nbsp;&nbsp;&nbsp; \n' +
        '           <label class="radio-inline">' +
        '           <input type="radio"   name="isparents" value="1" checked> 是 \n' +
        '          </label>\n' +
        '           <label class="radio-inline">' +
        '           <input type="radio" name="isparents" value="0"> 不是 \n' +
        '          </label>\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">选择父资源</span>\n' +
        '            <select type="text" id="sear_parentkey" name="parentkey" class="form-control"  ></select>\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">备注</span>\n' +
        '            <textarea type="text" id="sear_field1" name="field1" class="form-control"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '</form>',
        btn:['查找','取消'],
        btn1:function (index) {

            var name = $("#sear_name").val();
            var url = $("#sear_url").val();
            var icon = $("#sear_icon").val();
            // var seq = $("#sear_seq").val();
            var field = $("#sear_field1").val();
            var isparent = $("input[name='isparents']:checked").val();
            var parentkey = $("#sear_parentkey").val();


            var urlParam = "";
            if (name != null && name != ''){
                urlParam += "&name="+name;
            }
            if (url != null && url != ''){
                urlParam += "&url="+url;
            }
            if (icon != null && icon != ''){
                urlParam += "&icon="+icon;
            }
            if (field != null && field != ''){
                urlParam += "&field="+field;
            }
            if (isparent != null && isparent != ''){
                urlParam += "&isparent="+isparent;
            }
            if (parentkey != null && parentkey != ''){
                urlParam += "&parentkey="+parentkey;
            }


            $("#xtZyContent").bootstrapTable('refresh',{url:CTX+"/xtzy/getXtZyPageList.html?type = 1 "+urlParam})

            layer.close(index);
        },
        btn2:function (index) {
            layer.close(index);
        }

    });
    loadingOptions('sear_parentkey');
}

/***
 * 资源详情
 * @constructor
 */
function ResourcesMsg() {
    var skey = "";
    var selections = $("#xtZyContent").bootstrapTable('getSelections');
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
            url: CTX + "/xtzy/getZyXxById.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success:function (data) {
                 if(data.success){
                     var index = layer.open({
                         title:['我的消息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
                         area:['400px','490px'],
                         content:'<form role="form" action="javascript:void(0)">\n' +
                         '    <div class="row">\n' +
                         '        <div class="form-group input-group">\n' +
                         '            <span class="input-group-addon">名称</span>\n' +
                         '            <input type="text" id="se_name"  name="name" class="form-control"  />\n' +
                         '        </div>\n' +
                         '    </div>\n' +
                         '    <div class="row">\n' +
                         '        <div class="form-group input-group">\n' +
                         '            <span class="input-group-addon">url</span>\n' +
                         '            <input type="text" id="se_url"  name="url" class="form-control"  />\n' +
                         '        </div>\n' +
                         '    </div>\n' +
                         '    <div class="row">\n' +
                         '        <div class="form-group input-group">\n' +
                         '            <span class="input-group-addon">资源图标</span>\n' +
                         '            <input type="text" id="se_icon" name="icon" class="form-control"  />\n' +
                         '        </div>\n' +
                         '    </div>\n' +
                         '    <div class="row">\n' +
                         '        <div class="form-group input-group">\n' +
                         '            <span class="input-group-addon">是否为父级资源</span> &nbsp;&nbsp;&nbsp; \n' +
                         '           <label class="radio-inline">' +
                         '           <input type="radio"  id="se_isparent1"  name="isparent1" value="1" checked> 是 \n' +
                         '          </label>\n' +
                         '           <label class="radio-inline">' +
                         '           <input type="radio"  id="se_isparent2"  name="isparent2" value="0" checked> 不是 \n' +
                         '          </label>\n' +
                         '        </div>\n' +
                         '    </div>\n' +
                         '    <div class="row">\n' +
                         '        <div class="form-group input-group">\n' +
                         '            <span class="input-group-addon">选择父资源</span>\n' +
                         '            <select type="text" id="se_parentkey" name="parentkey" class="form-control"  ></select>\n' +
                         '        </div>\n' +
                         '    </div>\n' +
                         '    <div class="row">\n' +
                         '        <div class="form-group input-group">\n' +
                         '            <span class="input-group-addon">排序</span>\n' +
                         '            <input type="text" id="se_seq" name="seq" class="form-control"  />\n' +
                         '        </div>\n' +
                         '    </div>\n' +
                         '    <div class="row">\n' +
                         '        <div class="form-group input-group">\n' +
                         '            <span class="input-group-addon">备注</span>\n' +
                         '            <textarea type="text" id="se_field1" name="field1" class="form-control"  />\n' +
                         '        </div>\n' +
                         '    </div>\n' +
                         '</form>',
                         btn:['关闭'],
                         btn1:function (index) {
                             layer.close(index);
                         }
                     });
                      var datas = data.results[0];

                     $("#se_name").val("").val(datas.name);
                      $("#se_url").val("").val(datas.url);
                      $("#se_icon").val("").val(datas.icon);
                      $("#se_seq").val("").val(datas.seq);
                      $("#se_field1").val("").val(datas.file1);
                      if(datas.isparent == "0"){
                          $('input[name="isparent1"]:checked').attr("checked",false);
                          $('input[name="isparent2"]:checked').attr("checked",true);
                      }else{
                          $('input[name="isparent2"]:checked').attr("checked",false);
                          $('input[name="isparent1"]:checked').attr("checked",true);

                      }
                      $("#se_parentkey").val("").val(datas.parentkey);

                 }else {
                         layer.msg("获取失败！");
                     }
             },
            error:function (results) {
                 layer.alert("查询相关参数出错，请联系管理员！");
            }
        });
    };

    //加载select的选项
    loadingOptions('se_parentkey');
}

/***
 * 刷新资源
 */
function refResources() {
  window.location.reload();
}

/***
 * 删除资源
 */
function delResources() {
   var skey = null;
   var sels = $("#xtZyContent").bootstrapTable('getSelections');
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
           url: CTX + "/xtzy/delete.html",
           data: {skey:skey},
           dataType: 'json',
           async: false,
           success: function (data) {
               if (data.success){
                   layer.msg('删除成功',{icon:1});
                   $("#xtZyContent").bootstrapTable('refresh',{url:CTX+'/xtzy/getXtZyPageList.html'});
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

/**
 * 操作资源
 * */
function operateResources() {
    // var skey = $("input[name='skey']:checked").val();
    var skey = $("#xtZyContent").bootstrapTable('getSelections');
    var parentKey = null;
    var resourceName = null;
    var isparent = null;

    if(skey == null || skey == '' || skey == undefined){
        layer.msg('未获取到任何参数信息',{icon: 1});
        return false;
    }else if(skey.length != 1 ){
        layer.msg("请选择一条数据进行操作",{icon:2});
        return false;
    }else{
        parentKey = skey[0].skey;
        resourceName = skey[0].name;
        isparent = skey[0].isparent;
    };
    if(isparent == '1'){
        layer.msg('此节点为父级节点，无需进行资源操作',{icon:2});
        return false;
    }
    //请求后台数据
    $.ajax({
        type: 'POST',
        url: CTX + "/xtZyCz/getAllXtZyCzByResourcesId.html",
        data: {parentkey:parentKey},
        dataType: 'json',
        async: false,
        success: function (data) {
            var OptionData = data.results;
            // alert(JSON.stringify(OptionData));
            var that = this;
            //多窗口模式，层叠置顶
           var thisIndex =  layer.open({
                type: 2, //此处以iframe举例
                title:['【'+ resourceName +'】操作','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
                area: ['600px','480px']
                ,shade: 0
                ,maxmin: true
               ,content:CTX + '/pages/console/XtZy/XtZyOperate.jsp?skey='+parentKey
                ,btn: ['保存', '关闭'] //只是为了演示
                ,yes: function(thisIndex){
                    layer.msg("保存成功",{icon:1});
                    layer.close(thisIndex);
                }
                ,btn2: function(thisIndex){
                    layer.close(thisIndex);
                }
                ,cancel:function (thisIndex,layero) {
                    if(confirm('确定要关闭么')){ //只有当点击confirm框的确定时，该层才会关闭
                        layer.close(thisIndex)
                    }
                    return false;
                }
            });

           //将加载的数据放置在表单中；
           var htmls = '';
           if(OptionData.length > 0){
               for (var i = 0; i < OptionData.length; i++){
                   htmls +='<tr><td><input type="radio" class="input-control" id="operate_resources_skey" name="checkbox[]" value="'+OptionData[i].skey+'" /></td><td>'+OptionData[i].name+'</td><td>'+OptionData[i].action+'</td><td>'+OptionData[i].icon+'</td><td>'+OptionData[i].style+'</td></tr>';
               }
           }else{
               htmls += '<tr><td colspan="4">没有记录！</td></tr>';
           }
           $("#operate_resources_body").append("").append(htmls);

        },
        error: function () {
            alert("获取资源失败")
        }
    });
}


function updateResources() {
    var skey = "";
    var selections = $("#xtZyContent").bootstrapTable('getSelections');
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
            url: CTX + "/xtzy/getZyXxById.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success:function (data) {
                if(data.success){
                    var index = layer.open({
                        title:['我的消息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
                        area:['400px','490px'],
                        content:'<form id="updResourcesForm" role="form" action="javascript:void(0)">\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">名称</span>\n' +
                        '            <input type="text" id="up_name"  name="name" class="form-control"  />\n' +
                        '            <input type="hidden" id="up_skey"  name="name" class="form-control"  />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">url</span>\n' +
                        '            <input type="text" id="up_url"  name="url" class="form-control"  />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">资源图标</span>\n' +
                        '            <input type="text" id="up_icon" name="icon" class="form-control"  />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">是否为父级资源</span> &nbsp;&nbsp;&nbsp; \n' +
                        '           <label class="radio-inline">' +
                        '           <input type="radio"  id="up_isparent1"  name="isparent1" value="1" checked> 是 \n' +
                        '          </label>\n' +
                        '           <label class="radio-inline">' +
                        '           <input type="radio"  id="up_isparent2"  name="isparent2" value="0" checked> 不是 \n' +
                        '          </label>\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">选择父资源</span>\n' +
                        '            <select type="text" id="up_parentkey" name="parentkey" class="form-control"  ></select>\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">排序</span>\n' +
                        '            <input type="text" id="up_seq" name="seq" class="form-control"  />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">备注</span>\n' +
                        '            <textarea type="text" id="up_field1" name="field1" class="form-control"  />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '</form>',
                        btn:['修改','关闭'],
                        btn1:function (index) {
                            layer.alert('敬请期待');
                            var name = $("#up_name").val();
                            var skey = $("#up_skey").val();
                            var url = $("#up_url").val();
                            var icon = $("#up_icon").val();
                            var seq = $("#up_seq").val();
                            var file = $("#up_field1").val();
                            var isparent = $('input:radio:checked').val();
                            var parentkey = $("#up_parentkey option:selected").val();


                            if(isparent == '0'){
                                if(parentkey == null || parentkey == ''){
                                    layer.alert("如果不属于父级资源，则必须选择所属父级资源",{icon:2});
                                    return false;
                                }
                            }else if(isparent == '1'){
                                if( parentkey != ''){
                                    layer.alert("如果属于父级资源，则不能选择所属父级资源",{icon:2});
                                    return false;
                                }
                            }

                            $("#updResourcesForm").bootstrapValidator("validate");
                            if ($("#updResourcesForm").data("bootstrapValidator").isValid()){
                                layer.confirm('确认是否添加',function () {
                                    $.ajax({
                                        type: 'POST',
                                        url: CTX + "/xtzy/saveXtZy.html",
                                        data: {skey:skey,name:name,url:url,icon:icon,seq:seq,file1:file,isparent:isparent,parentkey:parentkey},
                                        dataType: 'json',
                                        async: false,
                                        success: function (data) {
                                            if (data.success ){
                                                layer.msg("添加成功！",{icon:1});
                                                $("#xtZyContent").bootstrapTable('refresh',{url:CTX+"/xtzy/getXtZyPageList.html?1=1 "})
                                            }else {
                                                layer.alert(data.result.msg);
                                                layer.close(index);
                                            }
                                        },
                                        error: function (XMLHttpRequest,textStatus) {
                                            alert(XMLHttpRequest + "---" + textStatus + "添加资源失败")
                                        }
                                    });
                                });
                            }
                            //saveXtZy

                        },
                        btn2:function (index) {
                            layer.close(index);
                        }

                    });
                    var datas = data.results[0];


                    $("#up_name").val("").val(datas.name);
                    $("#up_url").val("").val(datas.url);
                    $("#up_icon").val("").val(datas.icon);
                    $("#up_seq").val("").val(datas.seq);
                    $("#up_field1").val("").val(datas.file1);
                    $("#up_skey").val("").val(datas.skey);
                    if(datas.isparent == "0"){
                        $('input[name="isparent1"]:checked').attr("checked",false);
                        $('input[name="isparent2"]:checked').attr("checked",true);
                    }else{
                        $('input[name="isparent2"]:checked').attr("checked",false);
                        $('input[name="isparent1"]:checked').attr("checked",true);

                    }
                    $("#up_parentkey").val("").val(datas.parentkey);

                }else {
                    layer.msg("获取失败！");
                }
            },
            error:function (results) {
                layer.alert("查询相关参数出错，请联系管理员！");
            }
        });
    };

    //加载select的选项
    loadingOptions('up_parentkey');
}
