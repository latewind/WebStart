<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base.jsp"%>

<script>
	$(document).ready(function() {

		/* 让导航栏a 添加active 并设置面包导航*/
		cssNavigation();

	});
</script>
<!-- 折叠面板-->
<section>
	<div class="panel-group text-center center-block" id="panel-nav">
		<div class="panel panel-default">
			<div class="panel-heading">
				<a class="panel-title collapsed" data-toggle="collapse"
					data-parent="#panel-nav" href="#panel-element-prt">商品管理</a>
			</div>
			<div id="panel-element-prt"
				class="panel-collapse collapse list-group">
				<div class="list-group">

					<a href="${base}/admin/product/addProduct" class="list-group-item">商品上架</a>
					<a href="${base}/admin/product/listProduct.html"
						class="list-group-item">查看商品</a> <a
						href="${base}/admin/product/updateProduct.html"
						class="list-group-item">商品更新</a>
				</div>

			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<a class="panel-title collapsed" data-toggle="collapse"
					data-parent="#panel-nav" href="#panel-element-order">订单管理</a>
			</div>
			<div id="panel-element-order" class="panel-collapse collapse">
				<div class="list-group">

					<a href="${base}/admin/orders/viewOrders.html"
						class="list-group-item">订单处理</a> <a href=""
						class="list-group-item">退货处理</a> <a href="#"
						class="list-group-item">订单审核</a> <a href="#"
						class="list-group-item">订单反馈</a>
				</div>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<a class="panel-title collapsed" data-toggle="collapse"
					data-parent="#panel-nav" href="#panel-element-user">用户管理</a>
			</div>
			<div id="panel-element-user" class="panel-collapse collapse">
				<div class="list-group">
					<a href="${base}/admin/user/addUser.html" class="list-group-item">新增用户</a>
					<a href="#" class="list-group-item">Morbi leo risus</a> <a href="#"
						class="list-group-item">Porta ac consectetur ac</a> <a href="#"
						class="list-group-item">Vestibulum at eros</a>
				</div>
			</div>
		</div>


		<div class="panel panel-default">
			<div class="panel-heading">
				<a class="panel-title collapsed" data-toggle="collapse"
					data-parent="#panel-nav" href="#panel-element-notice">公告管理</a>
			</div>
			<div id="panel-element-notice" class="panel-collapse collapse">
				<div class="list-group">
					<a href="${base}/admin/notice/updateHeadline.html"
						class="list-group-item">更新头条</a><a
						href="${base}/admin/notice/updateAnnoun.html"
						class="list-group-item">更新公告</a> <a href="#"
						class="list-group-item">Porta ac </a> <a href="#"
						class="list-group-item">Vestibulum at</a>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<a class="panel-title collapsed" data-toggle="collapse"
					data-parent="#panel-nav" href="#panel-element-function">权限管理</a>
			</div>
			<div id="panel-element-function" class="panel-collapse collapse">
				<div class="list-group">
					<a href="${base}/admin/system/updateRole.html"
						class="list-group-item">角色修改</a><a
						href="${base}/admin/system/updateFunction.html"
						class="list-group-item">权限修改</a> <a
						href="${base}/admin/system/viewFunction.html"
						class="list-group-item">权限变更</a> 
				</div>
			</div>
		</div>
	</div>
	<!-- /面板-->

</section>