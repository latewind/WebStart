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

<script src="js/jQuery.js" type="text/javascript" language="javascript"></script>
<script src="js/jquery.lwTables.js?ver=125" type="text/javascript"
	language="javascript"></script>
<script type="text/javascript" language="javascript">

 
$(document).ready(function(){
$("#tb").lwtables({
	open:2,
	thType: "int,char,char,char,char,char,char,int,int,int,char,char,date,date,char",
	editable:false
});
	
});

</script>
 <link href="css/lwTables.css" rel="stylesheet" type="text/css"> 
</head>

<body>
<fieldset>
<legend>销售订单</legend>
	<table id="tb" width="100%" class="pure-table pure-table-striped">
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
				<th nowrap="nowrap">生产支数</th>
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