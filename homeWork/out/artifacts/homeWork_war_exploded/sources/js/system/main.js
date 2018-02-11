





/**
 * 系统初始化加载方法
 */
$(document).ready(function () {
    //alert(user.name);
});

/***
 * 点击路劲加载相应的页面
 */
function getTargetUrl(url,skey,name) {
    var resourcesName = encodeURI(encodeURI(name));
    var  htmls = "            <iframe class=\"LRADMS_ifream\" width=\"100%\" height=\"100%\" src=\"" + url + '?resourcesName=' + resourcesName + '&resourcesKey='+ skey +"\" frameborder=\"0\" data-id=\"home\"></iframe>\n";
    $("#main").find('iframe.LRADMS_ifream').hide();
    $("#main").append("");
    $("#main").append(htmls);
}

/***
 * 获取用户的登陆信息
 * @param
 *
 */
function getUserInfo() {


};

/***
 * 获取用户的登录日志
 * @param
 */
function getUserLoginLog() {


}