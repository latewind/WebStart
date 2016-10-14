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
<title>XXX管理系统</title>
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<style type="text/css">
<!--
.STYLE1 {
	font-size: xx-large
}
-->
</style>
<link href="css/loginCss.css" rel="stylesheet" type="text/css" />
<script>
function identifyinput(){
var x=document.getElementById("userName").value;
var y=document.getElementById("password").value;
var z=document.getElementById("identifyCode").value;
if(x==""){
alert("用户名不能为空");
return false;
}else if(y==""){
alert("密码不能为空");
return false;
}else if(z==""){
alert("验证码不能为空");
return false;
}
else{//都不为空

	
	 return true;
}
}
//点击 更变验证码
function changeIdentifyCode(){
	document.getElementById("imgIdentify").src="log/IdentifyCodeAction.action?"+Math.random();
	
	
}
</script>
</head>

<body>
	<div class="classdiv" id="headerdiv">
		<p align="center" class="STYLE1">&nbsp;</p>
		<p align="center" class="STYLE1">XXX管理系统</p>
	</div>


	<div class="classdiv" id="logindiv" align="center">
		<div id="formdiv" >
			<form id="formId" action="log/loginAction.action" onsubmit="return identifyinput()" method="post" class="pure-form pure-form-aligned" >
				<p style="font-family: verdana; color: red">
					&nbsp;
					<s:property value="alertMsg" />
				</p>
				
				<table align="center" cellspacing="5"  class="pure-table pure-table-horizontal">
				<tr>
					<td><label>用户：</label></td>
					<td><input name="userName" value="<s:property value="userName"/>" type="text" id="userName" placeholder="输入账号" maxlength="16" /></td>
				</tr>
				
				<tr>
					<td><label>密码：</label></td>
					<td><input name="password" type="password" value="<s:property value="password"/>" class="inputclass" id="password" placeholder="输入密码" maxlength="16" /></td>
				</tr>
				<tr>
					<td><label>验证码:</label></td>
					<td align="left"><input class="inputclass" id="identifyCode" name="identifyCode" type="text" size="7" maxlength="4" placeholder="输入验证码" /></td>
					
				</tr>
				<tr><td colspan="2"> <img id="imgIdentify" src="log/IdentifyCodeAction.action" onclick="changeIdentifyCode()" /></td></tr>
				<tr><td colspan="2"><input type="checkbox" name="keeplog" value="keep">记住登录</td></tr>
				<tr><td colspan="2"><input class="inputclass" name="resetbtn" type="reset" value="重置" /> <input name="submitbtn" type="submit" class="inputclass" value="提交" /></td> 
				
				</tr>
				</table>
			</form>
		</div>
	</div>

	<div class="classdiv" id="footerdiv">
		<div align="center">
			<p>&nbsp;</p>
			<p>
				<a href="#" target="_top">回到顶层</a>|<a href="#">关于我们</a>|<a href="#">联系我们</a>
			</p>
		</div>
	</div>
</body>

</html>
