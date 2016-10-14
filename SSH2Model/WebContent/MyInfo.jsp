<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">  
<title>Insert title here</title>
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
</head>
<body >
<a href="javascript:void(0)">个人管理</a>|<a href="javascript:void(0)">个人信息</a>
<h3>个人信息</h3>
<div align="center">

<table class="pure-table pure-table-striped">
<tr><td><label>姓名：</label></td><td><s:property value='employee.name'/></td></tr>
<tr><td><label>性别：</label></td><td><s:property value='employee.sex'/></td></tr>
<tr><td><label>学校：</label></td><td><s:property value='employee.getCollege()'/></td></tr>
<tr><td><label>学历：</label></td><td><s:property value='employee.getEducation()'/></td></tr>
<tr><td><label>联系方式：</label></td><td><s:property value='employee.telephone'/></td></tr>
<tr><td><label>员工号：</label></td><td><s:property value='employee.idcode'/></td></tr>
<tr><td><label>家庭住址：</label></td><td><s:property value='employee.address'/></td></tr>
<tr><td><label>入职时间：</label></td><td><s:date name="employee.entrytime" format="yyyy-MM-dd" /></td></tr>
<tr><td><label>部门：</label></td><td><s:property value='department.getName()'/></td></tr>
<tr><td><label>职位：</label></td><td><s:property value='position.name'/></td></tr>
</table>
</div>
</body>
</html>