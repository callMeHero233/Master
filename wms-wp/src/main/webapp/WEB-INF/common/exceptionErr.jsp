<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();

    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>" />
    <link rel="stylesheet" type="text/css" href="common/static/css/exceptionErr.css"/>
    <link rel="stylesheet" type="text/css" href="common/plugins/layui/css/modules/layer/default/layer.css"/>
    <script type="text/javascript" src="common/plugins/jquery/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="common/plugins/layui/lay/modules/layer.js"></script>
    <script type="text/javascript" src="common/static/js/exceptionErr.js">
        var errCode = '${errCode}';
        var errMsg = '${errMsg}';
    </script>
</head>

<body>
    <div id = "errContainer">
        <div id = "errBody"><image src = "common/images/${errCode}.png"/></div>
        <div id = "errFoot">
            <a href="#">返回首页</a>
            <a class = "showDetailedInfo" href = "javaScript:void(0)">查看详细信息</a>
        </div>
        <div style = "display: none">
            <input type="hidden" class = "errMsgContent" value = "${errMsg}"/>
        </div>
    </div>
</body>
</html>
