<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base.jsp"%>
<link rel="stylesheet" href="${base}/static/front/css/personal/personal.css">
<div class="col-md-2 column well">		
<dl class="orderdl">
  <dt>个人中心</dt>
  <dd><a href="${base}/front/personal/viewInfo" >个人信息</a></dd>
  <dd><a href="${base}/front/personal/modifyPassword" >修改密码</a></dd>
  <dd><a href="#" >个性设置</a></dd>

  <dt>订单中心</dt>
  <dd><a href="${base}/front/personal/orders" >全部订单</a></dd>
  <dd><a href="${base}/front/personal/unpaidOrders" >未付款订单</a></dd>
  <dd><a href="${base}/front/personal/paidOrders" > 已付款订单</a></dd>
  <dd><a href="${base}/front/personal/deliveryOrders" > 已发货订单</a></dd>
  <dd><a href="${base}/front/personal/completedOrders" > 已完成订单</a></dd>
  <dd><a href="#" >退回订单</a></dd>

  <dt>消息中心</dt>
  <dd><a href="${base}/front/personal/message" >个人消息</a></dd>
  <dd><a href="${base}/front/personal/message"  >系统消息</a></dd>
  <dd><a href="${base}/front/personal/message"  >商家消息</a></dd>
  <dd><a href="${base}/front/personal/message"  >物品消息</a></dd>
 
</dl>
</div>
<script>
var url = window.document.location.pathname;
console.log(url);
var $a=$("a[href$='" + url + "']");
$a.addClass("current");
</script>