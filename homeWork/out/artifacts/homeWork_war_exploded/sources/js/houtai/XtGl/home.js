$(document).ready(function () {

  //获取用户数量
    getXtYhCount();
  //获取用户信息
    getYhInfo();
});

function getXtYhCount() {
    $.ajax({
        type: 'POST',
        url: CTX + "/tjCount/getXtYhCount.html",
        data: {},
        dataType: 'json',
        async: false,
        success: function (data) {
             //alert(JSON.stringify(data));

            $("#xtYhCountId").html("").html(data.xtYhCount+ "人");
            $("#dlCountId").html("").html(data.dlCount+ "次");
            $("#czCountId").html("").html(data.czCount+ "次");
            $("#yhDlCountId").html("").html(data.yhSelfDlCount);
            $("#yhFwlId").html("").html(data.dlCount+ "次");
            // $("#nowXtYhCountId").html("").html(data.nowXtYhCount);

        },
        error: function (XMLHttpRequest,textStatus) {
            alert(XMLHttpRequest + "---" + textStatus + "获取失败")
        }
    });
}

function getYhInfo() {
    $.ajax({
        type: 'POST',
        url: CTX + "/tjCount/getYhInfo.html",
        data: {},
        dataType: 'json',
        async: false,
        success: function (data) {
            // alert(JSON.stringify(data));
            $("#lastLoginTimeId").html("").html("上次登录时间: "+data.results.lasttime+" , 上次登录IP: " +data.results.lastip+ "");
            $("#xtYhXmId").html("").html(data.results.name);
        },
        error: function (XMLHttpRequest,textStatus) {
            alert(XMLHttpRequest + "---" + textStatus + "获取失败")
        }
    });
}