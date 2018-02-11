/**
 * Created by Administrator on 2017/10/13.
 */
var  currPath = location.href;
var basePath =  currPath.substring(0,currPath.indexOf('HelloWorld')+8)+"/";


function loadOption(column_value, para_code){
    var hdmdList = $("#" +  column_value);
    hdmdList.html("");
    $.ajax({
        url : basePath + '',
        dataType : 'json',
        type : 'post',
        async : false,
        data : {code : para_code},
        success : function (data) {
            if(data.success){
                var results = data.results;
                hdmdList.append("<option value = ' '>请选择...</option>");
                for (var i = 0; i < results.length; i++){
                    hdmdList.append("<option  value = '" + results[i].value+ "'>"  + results[i].name + "</option>")
                }
            }else {
                alert(data.msg);
            }
        },
        error : function (XMLHttpRequest,textStatus,errorThrown) {
            alert("加载下拉选项相关参数处理失败");
        }
    })




}
