<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>


<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="css/NewPage.css" media="screen" rel="stylesheet" type="text/css" />


<title>Insert title here</title>
</head>

<body class='login'>
<img alt="Cloud-logo" class="logo" height="150" src="img/newLogo3.png" border="0"/>


<form accept-charset="UTF-8" action="http://user.zhxin.net/portal/login" class="vertical-form" id="new_user" method="post">
	<div style="margin:0;padding:0;display:inline">
		<input name="utf8" type="hidden" value="&#x2713;" />
		<input name="authenticity_token" type="hidden" value="XPUWie8/pucc/HjUFnAjA9fYrhcLWm/aNjq0oemgGKY=" />
	</div>
	<legend>
		后台登录
	</legend>
	<input name="act" type="hidden" value="login"/>
	
	<input id="user_email" label="false" name="email" placeholder="账号" size="30" type="text" value="" />
	<input autocomplete="off" id="user_password" label="false" name="password" placeholder="密码" size="30" type="password"  />
	
	<input name="commit" type="submit" value="登 录" />
	
	<div class='footer'>
		<p><a href="/portal/forgotpwd">忘记密码了？</a></p>
	</div>
</form>




</body>
</html>