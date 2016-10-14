<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<base href="<%=basePath%>">
<title>主页</title>

<link href="css/indexPage.css" rel="stylesheet" type="text/css" />
<!--[if lte IE 7]>
<style>
.content { margin-right: -1px; } /* 此 1px 负边距可以放置在此布局中的任何列中，且具有相同的校正效果。 */
ul.nav a { zoom: 1; }  /* 缩放属性将为 IE 提供其需要的 hasLayout 触发器，用于校正链接之间的额外空白 */
</style>
<![endif]-->
<script src="js/jQuery.js" type="text/javascript"></script>
<script type="text/javascript">

$(document).ready(function(){

  $px=$("#extendbar").find("p");
  $px.each(function(index, element) {
    $(this).click(function(){
		$(this).next("div").slideToggle("slow");
		});
});



  
  
 
});




</script>
</head>

<body>

<div class="container">
  <div class="header">
<a href="#"><img src="img/newLogo3.png" alt="在此处插入徽标" name="Insert_logo" width="10%"  id="Insert_logo" style="background-color: white; display: block; float: left;" /></a>

<a href="log/logoutAction.action" style="dispaly:block;float:right;color:#FFF">注销</a>
<span style="dispaly:block;float:right">&nbsp;</span>
<a id="aUserCHN" href="user/PersonalAction.action"  target="rightif" style="dispaly:block;float:right;color:#FF9"><s:property value="#session.userInfo.getChnName()"/></a>

  <!-- end .header --></div>
  
  
  <div class="sidebar1">
  
 <div id="extendbar">
 
 
 <p class="flip">销售订单</p>     
<div class="panel">

   <ul class="nav">
      <li><a href="order/AddOrdersAction.action" target="rightif">新增订单</a></li>
      <li><a href="order/listOrdersAction.action"  target="rightif">查看订单</a></li>
      <li><a href="#">链接三</a></li>
      <li><a href="#">链接四</a></li>
    </ul>
</div>
  
   
    <p class="flip">生产管理</p> 
 <div class="panel">

   <ul class="nav">
      <li><a href="testimport.jsp" target="rightif">机台计划</a></li>
      <li><a href="order/listPlansAction.action" target="rightif">生产统计</a></li>
      <li><a href="CityAction2" target="rightif">链接2</a></li>
      <li><a href="CityAction3" target="rightif">链接3</a></li>
    </ul>
</div>


 <p class="flip">物资管理</p>
 <div class="panel">
   <ul class="nav">
      <li><a href="AppMaterials.jsp" target="rightif">物资申请</a></li>
      <li><a href="materials/ApproveMaterials.action" target="rightif">申请审批</a></li>
      <li><a href="#">入库登记</a></li>
      <li><a href="#">出库登记</a></li>
      <li><a href="NewFile.jsp">物资清单</a></li>
    </ul>
</div>

 <p class="flip">企业管理</p>
<div class="panel">
   <ul class="nav">
      <li><a href="Notice.jsp" target="blank">公司公告</a></li>
      <li><a href="publishMsg.jsp" target="rightif">发布消息</a></li>
      <li><a href="upLoad.jsp" target="rightif">文件管理</a></li>
    <li><a href="file/ListFilesAction.action" target="rightif">文件下载</a></li>
    </ul>
</div>
  <p class="flip">员工管理</p> 
<div class="panel">
   <ul class="nav">
      <li><a href="AddEmployee.jsp" target="rightif">新增员工</a></li>
      <li><a href="EmployeeUpdate.jsp" target="rightif">查询更新</a></li>
      <li><a href="employAppAccount.jsp" target="rightif">申请账号</a></li>
      <li><a href="organChart.jsp" target="rightif">组织管理</a></li>
    </ul>
</div>

  <p class="flip">个人管理</p> 
<div class="panel">
   <ul class="nav">
   	  <li><a href="user/PersonalAction.action"   target="rightif">个人信息</a></li>
      <li><a href="ModifyPw.jsp" target="rightif">修改密码</a></li>
      <li><a href="msg/MyMsgAction.action" target="rightif">我的消息</a></li>
    
    </ul>
</div>
     </div>
    <span>&nbsp; </span>
    <span>&nbsp; </span>
       <div id="newnotice">
       <a >最新公告一：日期</a>
       <a >最新公告二：日期</a>
       <a >最新公告三：日期</a>
       <a >最新公告四：日期</a>
       <a >最新公告五：日期</a>
       <a >最新公告五：日期</a>
       
       </div>
      
    <!-- end .sidebar1 --></div>
  <div class="content">
    <iframe id="rtif" name="rightif" width="100%" frameborder="0" src="HeaderPage.jsp"></iframe>

    <!-- end .content --></div>
  <div class="footer">
    <p></p>
    <!-- end .footer --></div>
  <!-- end .container --></div>





</body>
</html>
