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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
<style type="text/css">
/*demo styles  table{margin:0 auto;border-collapse:collapse; } 

 td, th{ width:10%; font-size:14px; padding:10px 0; text-align:center;border:1px solid #ddd; }
 th {background-color:#f4f4f4;} 
 */

/* input
td.input{ position:relative; }
td input{ width:100%; height:100%;border:1px solid #CF5C74; background:#F90; border-radius:4px; display:block; position:absolute; text-align:center; font-size:14px; left:0; top:0; padding:0px 0; margin:-1px 0 0 -1px; }
td.hover{background:#eee;}
 */

</style>
<script src="js/jQuery.js" type="text/javascript" language="javascript"></script>
<script src="js/jquery.lwTables.js" type="text/javascript"  language="javascript"></script>
<script type="text/javascript" language="javascript">

 
$(document).ready(function(){
$("#tb").lwtables({
	open:2,
	thType: "int,char,char,char,char,char,char,int,int,int,char,char,date,date,char",
	editable:true,
	onTest:function(newstr){
		console.log(newstr);				
	},
	other:123456,
	aJax:function(send){
		var sendData={};
		sendData["sendData"]=send;
		$.ajax({			
			type: "post",
			url: "json/TestAjaxAction.action",
			data:JSON.stringify(sendData),
			dataType:'json',
			contentType: 'application/json',
			success:function(data,textstatus){			
			//	$(this).text(d.result);
			//	var t=data.result[2];
			//	$("#p1").text(t);
				alert("success in AjaxAction");				
			},
		    complete: function(XMLHttpRequest, textStatus){
		            //HideLoading();
		        },
			error:function(){
				alert("error");
			}				
		});	 	 
 }
});	
});

</script>
<link href="css/lwTables.css" rel="stylesheet" type="text/css">
</head>

<body>
<fieldset>
<legend>生产统计</legend>


	<table id="tb" width="100%">
		<thead>
			<tr>
				<th>ID</th>
				<th>订单号</th>
				<th>序号</th>
				<th>客户</th>
				<th>图号</th>
				
				<th>模具号</th>
				<th>型号</th>
				<th>长度</th>
				<th>计划数</th>
				<th>生产支数</th>
				<th>重量</th>
				
								
				<th>合金状态</th>
				<th>交期</th>
				<th>下单日</th>
				<th>备注</th>
				<th>图纸</th>
				
			</tr>
		</thead>
		<tfoot></tfoot>

		<tbody>
			<s:iterator value="orderses">
 <tr><td><s:property value="id" /></td>
<td><s:property value="orderno" /></td>
<td><s:property value="no" /></td>
<td><s:property value="customer" /></td>
<td><s:property value="figureno" /></td>
<td><s:property value="mould" /></td>
<td><s:property value="model" /></td>
<td><s:property value="length" /></td>
<td><s:property value="plancount" /></td>
<td><s:property value="produce" /></td>
<td><s:property value="weight" /></td>
<td><s:property value="alloystate" /></td>
<td><s:date name="deliverydate" format="yyyy-MM-dd" /></td>
<td><s:date name="orderdate" format="yyyy-MM-dd" /></td>
<td><s:property value="remarks" /></td>	
<td><a href="<s:url action="order/tdOrdersAction.action">  
<s:param name="fid" value="{id}"></s:param> </s:url>" target="_blank" >查看图纸</a></td></tr>

</s:iterator>
		</tbody>


	</table>

</fieldset>

</body>
</html>