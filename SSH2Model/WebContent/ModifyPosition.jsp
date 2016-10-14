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
<style type="text/css">

#main {  
    position: absolute;  
    width:400px;  
    height:200px;  
    left:50%;  
    top:50%;  
    margin-left:-200px;  
    margin-top:-100px;  
   
} 

tr{
margin-top:20px;
}

</style>
</head>


<body>
<div align="center" >
<form action="#" method="post">
<table  cellspacing="10">

</table>
</form>
</div>

</body>
</html>