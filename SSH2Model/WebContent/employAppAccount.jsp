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
<style type="text/css">

#main {  
    position: absolute;  
    width:400px;  
    height:200px;  
    left:50%;  
    top:30%;  
    margin-left:-200px;  
    margin-top:-100px;  
   
} 

tr{
margin-top:20px;
}

</style>
</head>


<body>
<a href="javascript:void(0)">员工管理</a>|<a href="javascript:void(0)">账号申请</a>
<div align="center" id="main">
<form action="hrm/appAccountAction.action" method="post" class="pure-form pure-form-aligned">
<table  cellspacing="10" class="pure-table pure-table-striped">
<tr align="center"><td colspan="2"></td></tr>
<tr><td><s:property value="promptMsg"/></td></tr>
<tr><td><label>员工id:</label></td><td><input type="text"  name="id" required></td></tr>
<tr><td><label>账号:</label></td><td><input type="text"  name="account" required></td></tr>
<tr><td><label>新密码:</label></td><td><input type="password" name="password" required></td></tr>
<tr><td><label>重复密码:</label></td><td><input type="password"  name="repassword" required></td></tr>
<tr><td></td><td align="center"><button type="reset"  style=" margin-right:20px"  class="pure-button secondary">重置</button><button type="submit"  class="pure-button pure-button-primary">提交</button></td></tr>
</table>
</form>
</div>

</body>
</html>