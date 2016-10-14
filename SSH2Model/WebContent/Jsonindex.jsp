<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<base href="<%=basePath%>">
<title>Struts2 - JSON Example</title>
<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript" src="js/base.js"></script>
</head>
<body>
<!-- <h2>Struts2 json &amp; jquery - Demo</h2> -->
<a href="javascript:sendJSONData()">Write</a>
<br>
<a href="javascript:getJSONData()">Read</a>
</body>