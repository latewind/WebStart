<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="jQueryPug/simditor-2.3.6/styles/simditor.css" />
<link rel="stylesheet" type="text/css" href="jQueryPug/simditor-2.3.6/styles/fonts/font-awesome.css" />
<script type="text/javascript" src="jQueryPug/simditor-2.3.6/scripts/jquery.min.js"></script>
<script type="text/javascript" src="jQueryPug/simditor-2.3.6/scripts/module.js"></script>
<script type="text/javascript" src="jQueryPug/simditor-2.3.6/scripts/hotkeys.js"></script>
<script type="text/javascript" src="jQueryPug/simditor-2.3.6/scripts/uploader.js"></script>
<script type="text/javascript" src="jQueryPug/simditor-2.3.6/scripts/simditor.js"></script>


<title>Insert title here</title>
</head>
<body>
<a href="javascript:void(0)">我的消息</a>|<a href="javascript:void(0)">消息标题</a>|<a href="javascript:void(0)"><s:property value="msg.title"/></a>
<div style='margin-top:20px;'>
<div class="simditor">
<div class="simditor-body">

<s:property value="msg.content" escape="false"/>
</div>
</div>
</div>
</body>
</html>