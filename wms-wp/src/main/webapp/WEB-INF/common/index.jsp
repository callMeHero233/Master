<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();

    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>" />
    <script type="text/javascript" src="common/plugins/jquery/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="common/static/js/index.js"></script>
</head>

<body>
This is my JSP page. <br>
</body>
</html>
