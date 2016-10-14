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
<script src="js/jQuery.js"  type="text/javascript"   ></script>
<script type="text/javascript" src="jQueryPug/laydate-master/laydate.dev.js"></script>
<script type="text/javascript" src="js/orderpage.js"></script>
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<style>
td{
	color:red;

}
input{
border:1;
	font-size:0.85em;
}
label{
text-align:right;
display:inline-block;
width:100px;
}
table select{
height:110%;
}
</style>
<script>
$(document).ready(function() {

//部门 、职位下拉菜单数据
var selectData;
$.ajax({
	url:"hrm/dpHRManAction.action",
	success:function(data,staus){
		selectData=data;
		var init=false;
		for(var index in selectData){
			var subData;
			console.log(index);
			$("#department").append("<option>"+index.toString()+"</option>");	//初始化下拉菜单		
			if(!init){//初始化职位菜单		
			subData=selectData[index];
			for(var i in subData){
				console.log(subData[i]);
				$("#position").append("<option>"+subData[i].toString()+"</option>");
				}
				init=true;
			}			
		}		
	}//end success	
});  
$("#department").change(function(){
	var selValue=$(this).val();
	console.log(selValue);
	
		var subData;
		subData=selectData[selValue];
		$("#position").empty();
		for(var i in subData){
			$("#position").append("<option>"+subData[i].toString()+"</option>");
			console.log(subData[i].toString());
		}		
	
	});
 
 
	//日历插件
	laydate({
            elem: '#entrytime'
        });
        });
</script>

<title>员工录入</title>
</head>



<body>
<a href="javascript:void(0)">员工管理</a>|<a href="javascript:void(0)">新增员工</a>
<form action="employee/EmployeeFormAction.action" method="post" class="pure-form pure-form-aligned">
<fieldset>
<legend>新增员工</legend>
<table align="center" class="pure-table pure-table-horizontal">
<tr>
	<td><label>姓名：</label><input type="text"  name="name" required="required" ></td>
	<td>
       <label class="control-label">性别：</label>
       <select name="sex" class="input-xlarge">
      <option>男</option>
      <option>女</option></select>
	</td>
	<td><label>年龄：</label><input type="text" name="age" required="required"></td>
	</tr>
	<tr>
	<td><label>院校/专业：</label><input type="text" name="college" required="required"></td>
	
		<td>
       <label name="education" class="control-label">学历：</label>
       <select >
      <option>初中</option>
      <option>高中</option>
      <option>大专</option>
      <option>本科</option>
      <option>硕士</option>
      <option>博士</option>
      </select>
	</td>	
	<td><label>手机号：</label><input type="text" name="telephone" required="required"></td>
</tr>
<tr>
<td><label>身份证：</label><input type="text" name="idcode"required="required"></td>
<td colspan="2"><label>家庭住址：</label><input type="text" name="address" required="required" style="width: 420px; height: 33px; "></td>
</tr>

<tr>
	<td><label>部门：</label><select id="department" name="department"></select></td>
	<td><label>职位：</label></label><select id="position" name="position"></select></td>
	<td><label>入职时间：</label><input type="text" name=entrytime required="required" id="entrytime"></td>
</tr>
<tr><td colspan="3" align="center"><label>个人简介</label></td></tr>
<tr>
<td colspan="3" align="center" >
<textarea width="100%" cols="100" name="introduction"></textarea>
</td>
</tr>
<tr ><td colspan="3" align="center"><button type="reset" value="重置" style=" margin-right:20px" class="pure-button secondary">重置</button><button type="submit"  class="pure-button pure-button-primary" >提交</button></td></tr>
</table>
</fieldset>
</form>






</body>
</html>