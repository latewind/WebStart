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

<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<title>Insert title here</title>
<script src="js/jQuery.js" type="text/javascript" language="javascript"></script>
<script>
$(document).ready(function(){
	
	var $checkTh=$("#allSel");
	//附加全选事件
	$checkTh.isSel=false;
	$checkTh.click(function(){//this.checked 不能正常使用	
			 if(!this.isSel){
				 console.log("clicked111");
			 $("input[name='checkTd']").each(function(){this.checked=true;});
			 }else{
				 console.log("unclicked111");
			 $("input[name='checkTd']").each(function(){this.checked=false;});}
			 this.isSel=!this.isSel;
		});
	
//点击同意或撤回按钮
	$("button[type='button']").click(function(){
		 console.log("agree");
		 var sendData={};
		 var $rows=$("input[name='checkTd']:checked").parent().parent();
		 
		 $rows.each(function(index){
			 var rowData={};
			$(this).find("td").each(function(ii){
				
//				alert($(this).val());
				console.log($(this).text());
				rowData[ii]=$(this).text();				
			});
			 sendData[index]=rowData;
		 });
		 
		alert(JSON.stringify(sendData));
		console.log(JSON.stringify(sendData));
		var url;
		if($(this).val()=="同意"){
			
			console.log("点击的是同意");
			url="json/AgreeAction.action";
			
		}
		else{
			console.log("点击的撤回");
			url='json/RevokeAction.action';
		}
// insert aJax func

		aJaxJson(sendData,url);//aJax传输
		//删除所选行
		$("input[name='checkTd']:checked").parentsUntil("tbody").remove();
		
		
	});
	
	
	function aJaxJson(send,url){
		var sendData={};
		sendData["tbData"]=send;
		$.ajax({			
			type: "post",
			url: url,
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






</script>



<style>
button{
margin-top:25px;
}

</style>
</head>


<body>
<a href="javascript:void(0)">物资管理</a>|<a href="javascript:void(0)">物资审批</a>
<fieldset>
<legend>物资审批</legend>
	<table id="tb" width="100%" align="center" class="pure-table pure-table-striped">
		<thead>
			<tr align="center">
				<th><input type="checkbox" id="allSel"></th>
				<th>ID</th>
				<th>物资名称</th>
				<th>型号</th>
				<th>数量</th>
				<th>单位</th>			
				<th>单价</th>
				<th>总价</th>
				<th>分类</th>
				<th>备注</th>
				<th>使用人</th>
				<th>申请人</th>			
			</tr>
		</thead>
		<tfoot></tfoot>

		<tbody align="center">
<s:iterator value="materials">
 <tr><td><input type="checkbox" name="checkTd"></td>
<td><s:property value="id" /></td>
<td><s:property value="name" /></td>
<td><s:property value="model" /></td>
<td><s:property value="num" /></td>
<td><s:property value="unit" /></td>
<td><s:property value="prince" /></td>
<td><s:property value="totalprice" /></td>
<td><s:property value="sort" /></td>
<td><s:property value="remark" /></td>
<td><s:property value="userId" /></td>
<td><s:property value="appId" /></td></tr></s:iterator>
</tbody>

	</table>

</fieldset>
<div align="center">
<button type="button" id="agree" class="pure-button pure-button-primary" value="同意"   >同意</button>
<button type="button" id="revoke" class="pure-button warning" value="撤回"  >撤回</button>
</div>
</body>
</html>