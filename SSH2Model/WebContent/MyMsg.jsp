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
<link href="css/msg.css" rel="stylesheet" type="text/css" />


</head>
<body>
<a href="javascript:void(0)">个人管理</a>|<a href="javascript:void(0)">我的消息</a>
<table align="center">
<tbody>
<s:iterator value="msgs">
<tr><td class="title" ><a href="<s:url action="msg/ViewMsgAction.action"><s:param name="msgId" value="{id}"></s:param> </s:url>" target="rightif"> <s:property value="title" /></a></td><td class="sender"><s:property value="sender.getEmployee().getName()"/></td></tr>
<tr><td class="msgcontent"><s:property value="content" escape="false"/></td></tr>
</s:iterator>
</tbody>

</table>

</body>
</html>