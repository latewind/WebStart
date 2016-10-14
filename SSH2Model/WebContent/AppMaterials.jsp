<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jQuery.js" type="text/javascript"></script>
<script src="js/jquery.simpleTablelw.js" type="text/javascript"></script>
<script>
$(document).ready(function(){
	
	$("#tb").simpleTablelw({
		aJaxJson:function(send){
			var sendData={};
			sendData["tbData"]=send;
			$.ajax({			
				type: "post",
				url: "json/RowsJsonAction.action",
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

<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<title>Insert title here</title>
</head>
<body>
<a href="javascript:void(0)">物资管理</a>|<a href="javascript:void(0)">物资申请</a>
<div align="center">
<form class="pure-form pure-form-aligned">
	<table id="tb" width="100%" class="pure-table pure-table-bordered">
		<thead>
			<tr align="center">
				<th>物资名称</th>
				<th>型号</th>
				<th>数量</th>
				<th>单位</th>			
				<th>单价</th>
				<th>总价</th>
				<th>分类</th>
				<th>备注</th>					
				
			</tr>
		</thead>
		<tfoot></tfoot>

		<tbody>
		</tbody>
</table>
</form>
</div>
</body>
</html>