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
}
label{
text-align:right;
display:inline-block;
width:100px;
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
        //-----------------
           $("#sbtn").click(function(){
           var cnt= $("#searchCnt")
           if(cnt.val()==""){alert("click undefine");}
           else{
           console.log(cnt.val());
           var radioType=$("input[name='searchType']:checked");
           console.log(radioType.val());
           
           		$.ajax({
			type:"post",
			url:"hrm/empHRManAction.action",
		
			data:{
			searchType:radioType.val(),
			searchCnt:cnt.val()
			},
			success:function(data,status){
			for(var index in data){			
						$("#"+index).val(data[index]);

			}	
			$("#department").val(data["department"]);		
			$("#department").trigger("change");
			$("#position").val(data["position"]);
			alert("  load employee info");
			}
			});
           
           
           }
      
      });   
        
        
        });//end ready

        
</script>
<title>员工录入</title>
</head>



<body>
<a href="javascript:void(0)">员工管理</a>|<a href="javascript:void(0)">信息更新</a>
<form action="employee/EmployeeFormAction.action" method="post" class="pure-form pure-form-aligned">
<fieldset>
<legend>信息更新</legend>
<table align="center" class="pure-table pure-table-horizontal">
<tr><td></td><td><label>搜索员工：</label></td><td><input type="text" id="searchCnt"></td>
<td>  <input type="radio" name="searchType" value="id" checked /><span>ID</span> <input type="radio" name="searchType" value="name" /><span>姓名</span></td>
<td><button type="button" value="搜索" id="sbtn" class="pure-button pure-button-primary" >>>></button></td>
<td><input type="hidden" name="empId" id="empId"></td>
</tr>
<tr><td colspan="6" align="center"><img alt="" src="img/line.jpg"></td></tr>
<tr>
	<td><label>姓名：</label></td><td><input type="text"  name="name" id="name" required="required"  readonly ></td>
	<td>
       <label class="control-label">性别：</label></td><td>
       <select name="sex" id="sex" style='height:110%;' value="nv">
      <option>男</option>
      <option>女</option></select>
	</td>
	<td><label>年龄：</label></td><td><input type="text" name="age" id="age" required="required"></td>
	</tr>
	<tr>
	<td><label>院校/专业：</label></td><td><input type="text" name="college" id="college" required="required"></td>
	
		<td>
       <label name="education"   "control-label">学历：</label></td><td>
      <select id="education" name="education" style='height:110%;'>
      <option>初中</option>
      <option>高中</option>
      <option>大专</option>
      <option>本科</option>
      <option>硕士</option>
      <option>博士</option>
      </select>
	</td>	
	<td><label>手机号：</label></td><td><input type="text" name="telephone" id="telephone" required="required"></td>
</tr>
<tr>
<td><label>身份证：</label></td><td><input type="text" name="idcode" id="idcode"required="required"></td>
<td ><label>家庭住址：</label></td><td colspan="3"><input type="text" name="address" id="address"required="required" style="width: 420px; height: 33px; "></td>
</tr>

<tr>
	<td><label>部门：</label></td><td><select id="department" name="department" style='height:110%;'></select></td>
	<td><label>职位：</label></td><td></label><select id="position" name="position" style='height:110%;'></select></td>
	<td><label>入职时间：</label></td><td><input type="text" name=entrytime required="required" id="entrytime"></td>
</tr>
<tr><td colspan="6" align="center"><label>个人简介</label></td></tr>
<tr>
<td colspan="6" align="center" >
<textarea width="100%" cols="100" name="introduction"  id="introduction"></textarea>
</td>
</tr>
<tr ><td colspan="6" align="center"><button type="reset" value="重置" style=" margin-right:20px" class="pure-button secondary">重置</button><button type="submit"  class="pure-button pure-button-primary" >更新</button></td></tr>
</table>
</fieldset>
</form>






</body>
</html>