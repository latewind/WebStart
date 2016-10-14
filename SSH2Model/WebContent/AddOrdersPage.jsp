<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/WEB-INF/LWtags.tld" prefix="lw"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<style>
.error{
	color:red;
}
</style>


<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">

   <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>


<link href="css/OrderPage.css"></link>

<script src="js/jQuery.js"  type="text/javascript"   ></script>
<script type="text/javascript" src="jQueryPug/laydate-master/laydate.dev.js"></script>
<script type="text/javascript" src="js/orderpage.js"></script>


<script src="jQueryPug/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="jQueryPug/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="js/jquery-ui.js"></script>  
<script type="text/javascript">
/*
$.validator.setDefaults({
    submitHandler: function() {
      alert("提交事件!");
    }
});

*/

$(document).ready(function() {


     
//$("tr").css("align","center");

	$("#odDiv").find("td").css("nowrap","nowrap");
	//日历插件
	laydate({
            elem: '#deinput'
        });        
//   $("#fileTxt").uploadPreview({ Img: "ImgPr", Width: 120, Height: 120 });  
		//验证插件
  //      $("#commentForm").validate();
      
//自动完成 插件
 $("#tags").autocomplete({
        	  source: [ "南京恒时汇", "青岛嘉祥", "东厂备料", "烟台华之源", "青岛永泰祥", "河北大圣", "北京国建" ]
        	});	
var t=true;        	
 // 新增订单扩展显示       	
$("#pd").click(function(){
$("#newdiv").slideToggle("slow");
t=!t;
if(t==true){
$(this).text("今日新增订单");
}else{
$(this).text("查看今日新增订单");
}


});
		
});


</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>   
<div id="odDiv"  align="center" style="margin:0px 50px 0px 50px">
<form action="order/AddOrdersAction.action" method="post"   enctype="multipart/form-data"  id="commentForm"  role="form" class="pure-form pure-form-aligned">

<fieldset>
    <legend>新增订单</legend>
<table   overflow="scroll" display="block" height="360px" class="table" >
  <tr>
    <td width="80" ><label>订单号:</label></td>
    <td ><input  type="text" name="orderNo" required></td>
    
    <td width="80"><label>序号:</label></td>
    <td><input type="text" name="no"  required></td>
    
    <td  rowspan="8" align="center"> 
          <div ><img id="preview" src="img/unpreview.jpg" />
          </div>
      </td>

  </tr>
  <tr>
    <td width="80" ><label>客户：</label></td>
    <td ><input type="text" name="customer"  id="tags" required></td>
     <td nowrap="nowrap"><label>合金状态：</label></td>
    <td><input type="text" name="alloyState" required></td>
  </tr>
  

  <tr>  
    <td><label>图号：</label></td>
    <td><input type="text" name="figureNo" required></td>
     <td><label>图纸：</label></td>
    <td><input id="fileTxt" type="file" name="file"   onchange="javascript:setImagePreview();" style="width: 152px; "></td>
   </tr>
   
   <tr>
    <td><label>模具号:</label></td>
    <td><input type="text" name="mould" required></td>
        <td><label>型号：</label></td>
    <td><input type="text" name="model"></td>
  </tr>
  
  
  <tr>
        <td><label >定尺：</label></td>
    <td><input type="text" name="length" required></td>
    <td nowrap="nowrap"><label>计划数：</label></td>
    <td><input type="text" name="planCount" required></td>
 
  
    </tr>
    <tr>
     <td><label>重量：</label></td>
      <td><input type="text" name="weight" required></td>
   <td><label>交货期:</label></td>
    <td><input type="text" id="deinput" name="deliveryDate"  required></td>

  </tr>
  
  <tr>
    <td>备注:</td>
    <td colspan="3"><textarea rows="3" cols="50" name="remarks"></textarea></td>
    

  </tr>
  
  <tr>
      <td align="center"  colspan="4"><button type="reset" class="btn btn-default">重置</button>
    <span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
    <botton type="submit" class="btn btn-default">提交</botton></td>
    </tr>
</table>

</fieldset>

</form>
</div>
<div align="center">
<button type="button" id="pd" class="btn btn-primary">今日新增订单</button>
<p></p>
<div id="newdiv" >
<table  width="100%" align="center" border="1" class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>订单号</th>
				<th>序号</th>
				<th>客户</th>
				<th>图号</th>				
				<th>模具号</th>
				<th>定尺</th>
				<th>计划数</th>			
				<th>合金状态</th>
				<th>交期</th>
				<th>下单日</th>
				<th>下单</th>
				
			</tr>
		</thead>
		<tfoot></tfoot>

		<tbody align="center">
<s:iterator value="listdate">
<tr><td><s:property value="id" /></td>
<td><s:property value="orderno" /></td>
<td><s:property value="no" /></td>
<td><s:property value="customer" /></td>
<td><s:property value="figureno" /></td>
<td><s:property value="mould" /></td>
<td><s:property value="length" />mm</td>
<td><s:property value="plancount" />支</td>
<td><s:property value="alloystate" /></td>
<td><s:property value="deliverydate" /></td>
<td><s:property value="orderdate" /></td>
<td><s:property value="userinfo.getChnName()" /></td></tr>
</s:iterator>
		</tbody>

	</table>

</div>
</div>

   <%--在jsp页面中使用自定义标签，标签有一个count属性 --%>
<lw:AuthorityMan count="7">
<h1></h1>
</lw:AuthorityMan>
</body>
</html>