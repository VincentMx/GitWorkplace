$(document).ready(function () {
   layer.msg("欢迎访问用户管理页面！")
    loadTable();
});

function loadTable() {
    loadToolBars('toolbars');
    $("#XtYh_content").bootstrapTable({
        url: CTX + '/xt/user/queryAllXtYhByPage.html',
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
            {title:"用户",field:"id",align:"left",order:"desc"},
            {title:"用户名",field:"name",align:"left",order:"desc"},
            {title:"单位",field:"unit",align:"left",order:"desc"},
            {title:"联系电话",field:"phone",align:"left",order:"desc"},
            {title:"联系地址",field:"address",align:"left",order:"desc"},
            {title:"邮箱",field:"email",align:"left",order:"desc"},
            {title:"联系手机",field:"mobile",align:"left",order:"desc"},
            {title:"上次登录IP",field:"lastip",align:"left",order:"desc"},
            {title:"上次登录时间",field:"lasttime",align:"left",order:"desc"},
            {title:"注册时间",field:"regtime",align:"left",order:"desc"},
            {title:"备注",field:"bz",align:"left",order:"desc"}

        ],
        locale:"zh-CN" //中文支持
    })
}

/***
 * 查找用户信息
 */
function searchYh() {
    var index = layer.open({
        title:['查找用户信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['60%','68%'],
        content:'<form role="form" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '     <div class="col-xs-5">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">用户名</span>\n' +
        '            <input type="text" id="sear_name"  name="name" class="form-control" placeholder="请输入用户名称...." />\n' +
        '        </div>\n' +
        '     </div>\n' +
        '     <div class="col-xs-7">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">用户身份证号</span>\n' +
        '            <input type="text" id="sear_id"  name="id" class="form-control" placeholder="请输入用户身份证号码...."  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '     <div class="col-xs-6">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">联系电话</span>\n' +
        '            <input type="text" id="sear_phone"  name="phone" class="form-control"  placeholder="请输入联系电话...."    />\n' +
        '        </div>\n' +
        '     </div>\n' +
        '     <div class="col-xs-6">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">联系手机</span>\n' +
        '            <input type="text" id="sear_mobile" name="mobile" class="form-control"  placeholder="请输入联系手机...."   />\n' +
        '        </div>\n' +
        '     </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '      <div class="col-xs-6">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">注册时间从</span>\n' +
        '            <input type="text" id="startTime" name="startTime" class="form-control" placeholder="点击选择开始时间..."  readonly />\n' +
        '        </div>\n' +
        '      </div>      \n'+
        '     <div class="col-xs-6">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">到</span>\n' +
        '            <input type="text" id="endTime" name="endTime" class="form-control" placeholder="点击选择结束时间..." readonly />\n' +
        '        </div>\n' +
        '     </div>  \n'+
        '    </div>\n' +
        '    <div class="row">\n' +
        '     <div class="col-xs-6">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">联系邮箱</span>\n' +
        '            <input type="text" id="sear_email" name="email" class="form-control"  placeholder="请输入用户邮箱...."     />\n' +
        '        </div>\n' +
        '     </div>\n' +
        '     <div class="col-xs-6">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">上次登录IP</span>\n' +
        '            <input type="text" id="sear_lastip" name="lastip" class="form-control"  placeholder="请输入上次登录IP信息...." />\n' +
        '        </div>\n' +
        '     </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">单位</span>\n' +
        '            <input type="text" id="sear_unit"  name="unit" class="form-control"  placeholder="请输入单位信息...." />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">联系地址</span>\n' +
        '            <input type="text" id="sear_address" name="address" class="form-control"  placeholder="请输入联系地址信息...."/>\n' +
        '        </div>\n' +
        '    </div>\n' +

        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">备注</span>\n' +
        '            <input type="text" id="sear_bz" name="bz" class="form-control"  placeholder="请输入备注信息..."/>\n' +
        '        </div>\n' +
        '    </div>\n' +
        '</form>',
        btn:['查找','取消'],
        btn1:function (index) {

            var starttime = $("#startTime").val();
            var endtime = $("#endTime").val();
            var name = $("#sear_name").val();
            var id = $("#sear_id").val();
            var unit = $("#sear_unit").val();
            var phone = $("#sear_phone").val();
            var address = $("#sear_address").val();
            var mobile = $("#sear_mobile").val();
            var email = $("#sear_email").val();
            var bz = $("#sear_bz").val();
            var lastip = $("#sear_lastip").val();

            var urlParam = "";
            if (name != null && name != ''){
                urlParam += "&name="+name;
            }
            if (id != null && id != ''){
                urlParam += "&id="+id;
            }
            if (starttime != null && starttime != ''){
                urlParam += "&startTime="+starttime;
            }
            if (endtime != null && endtime != ''){
                urlParam += "&endTime="+endtime;
            }
            if (unit != null && unit != ''){
                urlParam += "&unit="+unit;
            }
            if (phone != null && phone != ''){
                urlParam += "&phone="+phone;
            }
            if (address != null && address != ''){
                urlParam += "&address="+address;
            }
            if (mobile != null && mobile != ''){
                urlParam += "&mobile="+mobile;
            }
            if (email != null && email != ''){
                urlParam += "&email="+email;
            }
            if (bz != null && bz != ''){
                urlParam += "&bz="+bz;
            }
            if (lastip != null && lastip != ''){
                urlParam += "&lastip="+lastip;
            }

            $("#XtYh_content").bootstrapTable('refresh',{url:CTX+"/xt/user/queryAllXtYhByPage.html?type = 1 "+urlParam})

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
function refYh() {
    $("#XtYh_content").bootstrapTable('refresh',{url:CTX+"/xt/user/queryAllXtYhByPage.html?type = 1 "})

}

/**
 * 删除操作
 */
function deleteYh() {
    var skey = null;
    var sels = $("#XtYh_content").bootstrapTable('getSelections');
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
            url: CTX + "/xt/user/deleteXtYh.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.success){
                    layer.msg('删除成功',{icon:1});
                    $("#XtYh_content").bootstrapTable('refresh',{url:CTX+"/xt/user/queryAllXtYhByPage.html?type = 1 "})
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
 * 注销操作
 */
function removeYh() {
    var skey = null;
    var sels = $("#XtYh_content").bootstrapTable('getSelections');
    if(sels.length != 1  ){
        layer.msg("请选择一条需要注销的数据",{icon:2});
        return false;
    }else{
        skey = sels[0].skey;
    }
    if(skey == null || skey == '' || skey == undefined){
        layer.msg('请选择您需要注销的数据',{icon: 3});
        return false;
    }
    layer.confirm('确认是否注销',function () {
        $.ajax({
            type: 'POST',
            url: CTX + "/xt/user/removeXtYh.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.success){
                    layer.msg('注销成功',{icon:1});
                    $("#XtYh_content").bootstrapTable('refresh',{url:CTX+"/xt/user/queryAllXtYhByPage.html?type = 1 "})
                }else{
                    layer.msg('注销失败'+data.msg,{icon:2});
                }
            },
            error: function () {
                alert("未能正常情求信息，请联系管理员解决问题。");
            }
        });
    });
}


/***
 * 修改用户信息
 */
function updateYh() {
    var skey = null;
    var sels = $("#XtYh_content").bootstrapTable('getSelections');
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
            url: CTX + "/xt/user/getUserInfo.html",
            data: {skey:skey},
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.success){
                    var index = layer.open({
                        title:['修改用户信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
                        area:['60%','68%'],
                        content:'<form role="form" action="javascript:void(0)">\n' +
                        '    <div class="row">\n' +
                        '     <div class="col-xs-6">  \n'+
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">用户名</span>\n' +
                        '            <input type="text" id="upd_name"  name="name" class="form-control" placeholder="请输入用户名称...." />\n' +
                        '            <input type="hidden" id="upd_skey"  name="skey" class="form-control"  />\n' +
                        '        </div>\n' +
                        '     </div>\n' +
                        '     <div class="col-xs-6">  \n'+
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">身份证号</span>\n' +
                        '            <input type="text" id="upd_id"  name="id" class="form-control" placeholder="请输入用户身份证号码...."  />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '     <div class="col-xs-6">  \n'+
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">联系电话</span>\n' +
                        '            <input type="text" id="upd_phone"  name="phone" class="form-control"  placeholder="请输入联系电话...."    />\n' +
                        '        </div>\n' +
                        '     </div>\n' +
                        '     <div class="col-xs-6">  \n'+
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">联系手机</span>\n' +
                        '            <input type="text" id="upd_mobile" name="mobile" class="form-control"  placeholder="请输入联系手机...."   />\n' +
                        '        </div>\n' +
                        '     </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '     <div class="col-xs-6">  \n'+
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">联系邮箱</span>\n' +
                        '            <input type="text" id="upd_email" name="email" class="form-control"  placeholder="请输入用户邮箱...."     />\n' +
                        '        </div>\n' +
                        '     </div>\n' +
                        '     <div class="col-xs-6">  \n'+
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">性别</span>\n' +
                        '            <input type="text" id="upd_sex" name="sex" class="form-control"  placeholder="请选择性别信息...." />\n' +
                        '        </div>\n' +
                        '     </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">单位</span>\n' +
                        '            <input type="text" id="upd_unit"  name="unit" class="form-control"  placeholder="请输入单位信息...." />\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">联系地址</span>\n' +
                        '            <input type="text" id="upd_address" name="address" class="form-control"  placeholder="请输入联系地址信息...."/>\n' +
                        '        </div>\n' +
                        '    </div>\n' +

                        '    <div class="row">\n' +
                        '        <div class="form-group input-group">\n' +
                        '            <span class="input-group-addon">备注</span>\n' +
                        '            <textarea type="text" id="upd_bz" name="bz" class="form-control"  placeholder="请输入备注信息..."/>\n' +
                        '        </div>\n' +
                        '    </div>\n' +
                        '</form>',
                        btn:['修改','取消'],
                        btn1:function (index) {

                            var name = $("#upd_name").val();
                            var id = $("#upd_id").val();
                            var unit = $("#upd_unit").val();
                            var phone = $("#upd_phone").val();
                            var address = $("#upd_address").val();
                            var mobile = $("#upd_mobile").val();
                            var email = $("#upd_email").val();
                            var bz = $("#upd_bz").val();
                            var sex = $("#upd_sex").val();
                            var skey = $("#upd_skey").val();

                            layer.confirm('确认是否修改',function () {
                                $.ajax({
                                    type: 'POST',
                                    url: CTX + "/xt/user/addXtYh.html",
                                    data: {skey:skey,name:name,id:id,unit:unit,phone:phone,address:address,mobile:mobile,email:email,bz:bz,sex:sex},
                                    dataType: 'json',
                                    async: false,
                                    success: function (data) {
                                        if (data.success){
                                            layer.msg('修改成功',{icon:1});
                                            $("#XtYh_content").bootstrapTable('refresh',{url:CTX+"/xt/user/queryAllXtYhByPage.html?type = 1 "})
                                        }else{
                                            layer.msg('修改失败'+data.msg,{icon:2});
                                        }
                                    },
                                    error: function () {
                                        alert("未能正常情求信息，请联系管理员解决问题。");
                                    }
                                });
                            });
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


                    var datas = data.results[0];

                    $("#upd_name").val("").val(datas.name);
                    $("#upd_id").val("").val(datas.id);
                    $("#upd_unit").val("").val(datas.unit);
                    $("#upd_phone").val("").val(datas.phone);
                    $("#upd_address").val("").val(datas.address);
                    $("#upd_mobile").val("").val(datas.mobile);
                    $("#upd_email").val("").val(datas.email);
                    $("#upd_bz").val("").val(datas.bz);
                    $("#upd_sex").val("").val(datas.sex);
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

/**
 * 用户详情
 */
function detailXtYh() {
    layer.msg("详情");
}

/**
 * 添加用户
 */
function addYh() {
    var index = layer.open({
        title:['查找用户信息','background-color : #26A69A ; color : #fff; font-size : 14 px; font-weight : 700; text-align : center'],
        area:['60%','65%'],
        content:'<form role="form" id="XtYhAddInfoForms" action="javascript:void(0)">\n' +
        '    <div class="row">\n' +
        '     <div class="col-xs-5">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">用户名</span>\n' +
        '            <input type="text" id="sear_name"  name="name" class="form-control" placeholder="请输入用户名称...."  data-bv-notempty data-bv-notempty-message="用户名为必填项" data-bv-stringlength="32" maxlength="32"  />\n' +
        '        </div>\n' +
        '     </div>\n' +
        '     <div class="col-xs-7">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">用户身份证号</span>\n' +
        '            <input type="text" id="sear_id"  name="id" class="form-control" placeholder="请输入用户身份证号码...." pattern="^[0-9]*$" data-bv-regexp-message="请输入正确的格式"  data-bv-notempty data-bv-notempty-message="身份证件号为必填项" data-bv-stringlength="19" maxlength="19"  />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '     <div class="col-xs-6">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">联系电话</span>\n' +
        '            <input type="text" id="sear_phone"  name="phone" class="form-control"  placeholder="请输入联系电话...." pattern="^[0-9]*$" data-bv-regexp-message="请输入正确的格式"    />\n' +
        '        </div>\n' +
        '     </div>\n' +
        '     <div class="col-xs-6">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">联系手机</span>\n' +
        '            <input type="text" id="sear_mobile" name="mobile" class="form-control"  placeholder="请输入联系手机...." pattern="^[0-9]*$" data-bv-regexp-message="请输入正确的格式"  />\n' +
        '        </div>\n' +
        '     </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '     <div class="col-xs-6">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">联系邮箱</span>\n' +
        '            <input type="text" id="sear_email" name="email" class="form-control"  placeholder="请输入用户邮箱...."     />\n' +
        '        </div>\n' +
        '     </div>\n' +
        '     <div class="col-xs-6">  \n'+
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">上次登录IP</span>\n' +
        '            <input type="text" id="sear_lastip" name="lastip" class="form-control"  placeholder="请输入上次登录IP信息...." />\n' +
        '        </div>\n' +
        '     </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">单位</span>\n' +
        '            <input type="text" id="sear_unit"  name="unit" class="form-control"  placeholder="请输入单位信息...." />\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">联系地址</span>\n' +
        '            <input type="text" id="sear_address" name="address" class="form-control"  placeholder="请输入联系地址信息...."/>\n' +
        '        </div>\n' +
        '    </div>\n' +

        '    <div class="row">\n' +
        '        <div class="form-group input-group">\n' +
        '            <span class="input-group-addon">备注</span>\n' +
        '            <input type="text" id="sear_bz" name="bz" class="form-control"  placeholder="请输入备注信息..."/>\n' +
        '        </div>\n' +
        '    </div>\n' +
        '</form>',
        btn:['查找','取消'],
        btn1:function (index) {

            var name = $("#sear_name").val();
            var id = $("#sear_id").val();
            var unit = $("#sear_unit").val();
            var phone = $("#sear_phone").val();
            var address = $("#sear_address").val();
            var mobile = $("#sear_mobile").val();
            var email = $("#sear_email").val();
            var bz = $("#sear_bz").val();
            // var lastip = $("#sear_lastip").val();

            $("#XtYhAddInfoForms").bootstrapValidator("validate");
            if ($("#XtYhAddInfoForms").data("bootstrapValidator").isValid()) {
                layer.confirm('确认是否添加', function () {
                    $.ajax({
                        type: 'POST',
                        url: CTX + "/xt/user/addXtYh.html",
                        data: {
                            skey: skey,
                            name: name,
                            id: id,
                            unit: unit,
                            phone: phone,
                            address: address,
                            mobile: mobile,
                            email: email,
                            bz: bz,
                            sex: sex
                        },
                        dataType: 'json',
                        async: false,
                        success: function (data) {
                            if (data.success) {
                                layer.msg('修改成功', {icon: 1});
                                $("#XtYh_content").bootstrapTable('refresh', {url: CTX + "/xt/user/queryAllXtYhByPage.html?type = 1 "})
                            } else {
                                layer.msg('修改失败' + data.msg, {icon: 2});
                            }
                        },
                        error: function () {
                            alert("未能正常情求信息，请联系管理员解决问题。");
                        }
                    });
                });
            };


        },
        btn2:function () {

        }
    });
    }

/**
 * 刷新用户列表
 */
function refXtYh() {
    $("#XtYh_content").bootstrapTable('refresh',{url:CTX+"/xt/user/queryAllXtYhByPage.html?type = 1 "})

}