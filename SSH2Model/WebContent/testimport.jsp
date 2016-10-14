<%@page import="org.springframework.util.concurrent.SuccessCallback"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    System.out.println(basePath);
    String actionString=basePath+"msg/MyMsgAction.action";
%>
<html>
<head>
 <base href="<%=basePath%>">
<title>c:import 标签实例</title>
</head>
<body>
<c:import var="data"  url="<%=actionString%>" scope="page" />
<c:out value="${data}" escapeXml="false"/>
</body>
</html>