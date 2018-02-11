<%--
  Created by IntelliJ IDEA.
  User: lix
  Date: 2018/1/17
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/cheader.jsp"%><html>
<head>
    <title>查询信息</title>
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/sources/js/jeDate/jeDate.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/sources/js/jeDate/jeDate.js"></script>

</head>
<body>
<form role="form" action="javascript:void(0)">
        <div class="row">
                <div class="form-group input-group"> 
                        <span class="input-group-addon">用户名</span> 
                        <input type="text" id="sear_name"  name="userName" class="form-control"  /> 
                    </div> 
            </div> 
        <div class="row"> 
                <div class="form-group input-group"> 
                        <span class="input-group-addon">用户身份证号</span> 
                        <input type="text" id="sear_id"  name="userId" class="form-control"  /> 
                    </div> 
            </div> 
        <div class="row"> 
                <div class="form-group input-group"> 
                        <span class="input-group-addon">操作名称</span> 
                        <input type="text" id="searname"  name="operateName" class="form-control"  />
                    </div> 
            </div> 
        <div class="row"> 
                <div class="form-group input-group"> 
                        <span class="input-group-addon">操作类型</span> 
                        <input type="text" id="sear_type"  name="operateType" class="form-control"  /> 
                    </div> 
            </div> 
        <div class="row"> 
                <div class="form-group input-group"> 
                        <span class="input-group-addon">操作内容</span> 
                        <input type="text" id="sear_conditon" name="operateCondition" class="form-control"  ></input> 
                    </div> 
            </div> 
        <div class="row"> 
                <div class="form-group input-group"> 
                        <span class="input-group-addon">开始时间</span> 
                        <input type="text" id="startinp" name="startTime" class="datainp" placeholder="开始时间..."  readonly />
                    </div> 
            </div> 
        <div class="row"> 
                <div class="form-group input-group"> 
                        <span class="input-group-addon">结束时间</span> 
                        <input type="text" id="endinp" name="endTime" class="datainp" placeholder="结束时间..." readonly   />
                   </div> 
            </div> 
    </form>
</body>
<script type="text/javascript">

    var start = {
        dateCell: '#startinp',
        format: 'YYYY-MM-DD hh:mm:ss',
        minDate: '2001-01-01 00:00:00',
        festival:true,
        maxDate: '2099-01-01 00:00:00',
        isTime:true,
        choosefun:function (datas) {
            end.minDate = datas;
        }

    };

    var end = {
        dateCell: '#endinp',
        format: 'YYYY-MM-DD hh:mm:ss',
        minDate: '2001-01-01 00:00:00',
        festival:true,
        maxDate: '2099-01-01 00:00:00',
        isTime:true,
        choosefun:function (datas) {
            start.maxDate = datas;
        }

    };

    jeDate(start);
    jeDate(end);

</script>
</html>
