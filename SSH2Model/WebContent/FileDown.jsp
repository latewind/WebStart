<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="javascript:void(0)">企业管理</a>|<a href="javascript:void(0)">文件下载</a></br>

<s:iterator value="fileNames">

<a href="<s:url action="file/FileDownLoadAction.action">  
<s:param name="fileName" ><s:property/></s:param> </s:url>"  ><s:property/></a></br>
</s:iterator>

</body>
</html>