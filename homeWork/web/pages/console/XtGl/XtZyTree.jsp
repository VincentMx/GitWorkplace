<%--
  Created by IntelliJ IDEA.
  User: lix
  Date: 2017/12/6
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/cheader.jsp"%>
<html>
<head>
    <title>单位树</title>
    <script src="${pageContext.request.contextPath}/sources/js/houtai/jquery-2.1.4.min.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/sources/tools/zTreev3/css/zTreeStyle/zTreeStyle.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/sources/tools/zTreev3/js/jquery.ztree.all.min.js"></script>
</head>
<body>
<div id="unittree">
    <input type="hidden" id="xtzyId"> <input type="hidden" id="xtzyName"> <input type="hidden" value="620000000000">
    <div>
        <ul id="xtzyTreeDemo" class="ztree"></ul>
    </div>
</div>
</body>

<script>
    $(function () {
        $.fn.zTree.init($("#xtzyTreeDemo"),setting);
    });

    var setting = {
        async:{
            enable:true,
            type:"post",
            url: CTX +'/xtzy/findXtZyTree.html',
            otherParam:["parentKey","","type","00"],
            dataFilter:ajaxDataFilter

        },
        view: {
            expandSpeed:"slow"
        },
        callback:{
            onAsyncSuccess:zTreeOnAsyncSuccess,
            onAsyncError:function () {
                alert("获取单位信息失败");
            },
            onClick:function (event, treeId, treeNode ) {
                if(treeNode && !treeNode.isParent){
                    var chirdTree = "";
                    chirdTree = getChildUnit("addTreeNodes",treeNode.id,treeNode.pId,treeNode.name);
                    chirdTree = "["+chirdTree.substring(0,chirdTree.length - 1)+"]";
                    chirdTree = eval('('+chirdTree+')');
                    if(chirdTree.length > 1){
                        var zTreeObj = $.fn.zTree.getZTreeObj("xtzyTreeDemo");
                        zTreeObj.addNodes(treeNode, -1,chirdTree);
                    }
                }
            },
            onCheck:function (event,treeId,treeNode) {
              var xtzyid = "";
                if(treeNode.length > 1){
                    for (var i = 0; i < treeNode.id.length; i ++){
                      xtzyid += treeNode[i].id + ",";
                        alert(xtzyid);

                    }
                }
                $("#xtzyId").val(xtzyid);
                $("#xtzyName").val(treeNode.name);
            }
        },
        data:{
            simpleData: {
                enable: true
            }
        },
        check:{
            enable:true,
            chkboxType:{"Y":"","N":""},
            chkStyle:"checkbox",
            radioType:"all"
        }
    }

    function ajaxDataFilter(treeId,parentNode,responseData) {
        var treeStr ="";
        if(responseData && responseData.data){
            for(var i = 0; i < responseData.data.length; i ++){

                treeStr += "{id:'"+responseData.data[i].skey +"',"+
                    "pId: '"+responseData.data[i].parentkey +"',"+
                    "name:'"+responseData.data[i].name+"'},";
                treeStr += getChildUnit("addTreeNodes",responseData.data[i].skey,responseData.data[i].parentkey,responseData.data[i].name);
            }
        }

        treeStr = "["+treeStr.substring(0,treeStr.length - 1)+"]";
        treeStr = eval('('+treeStr+')');
        console.log(treeStr);
        return treeStr;
    }

    //加载完成
    function zTreeOnAsyncSuccess() {
        var zTreeObj = $.fn.zTree.getZTreeObj("xtzyTreeDemo");
        zTreeObj.expandAll(true);
    }

    //获取子单位
    function getChildUnit(type,id,pId,name) {
        var unitStr = "";
        $.ajax({
            type:"POST",
            async:false,
            url: CTX + '/xtzy/findXtZyTree.html',
            data: {parentKey:id,type:type},
            dateType:'json',
            success:function (obj) {
                obj = JSON.parse(obj);
                var childTreeStr = "";
                for(var j = 0; j < obj.data.length; j++){
                    unitStr += "{id:'"+obj.data[j].skey+"', "+
                        "pId: '" +obj.data[j].parentkey +"'," +
                        "name:'" + obj.data[j].name +"'},";
                }
            }
        });
        return unitStr;
    }





</script>
</html>
