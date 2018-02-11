
/**
* 页面初始化加载
* */

$(function () {
    alert("这是初始化");
})

alert("这是从js文件传来的消息！");

/**
 * 获取url参数
 *
 * */

function getQueryString(name){
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i" )
    var r = window.location.search.substr(1).match(reg);
    if (r != null){
        return decodeURI(unescape(r[2]));
    }
    return null;
}


