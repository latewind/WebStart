<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base.jsp"%>
<link rel="stylesheet" href="${base}/static/front/css/topnav/topnav.css">
<script type="text/javascript" src="${base}/static/common/js/common.js"></script>

<script type="text/javascript"
	src="${base}/static/front/js/topnav/topnav.js"></script>

<style>
.navbar, .navbar li .active {
	background-color: #E95420;
}
</style>

<nav class="navbar navbar-default navbar-fixed-top " role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
				class="icon-bar"></span><span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">LateWind </a>
	</div>

	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li><a href="${base}/index">主页</a></li>
			<li><a href="#">网站导航</a></li>

		</ul>
		<form class="navbar-form navbar-left" role="search" action="${base}/front/product/searchPrtAction"  method="post">
			<div class="form-group input-group">
				<span class="input-group-addon "><span
					class="glyphicon glyphicon-search"></span></span> <input  name="keyword"
					class="form-control" data-action="grow" type="text"  id="searchInput"  required/>
			</div>
			<button type="submit" class="btn btn-default"  id="searchBtn"	>搜索</button>
		</form>
		<ul class="nav navbar-nav navbar-right">
			<li><a class="btn btn-default btn-lg" href="javascript:void(0);"
				id="cart" data-if-show="false">购物车</a></li>

			<c:choose>
				<c:when test="${sessionScope.loginInfo==null}">
					<li><a href="javascript:showLoginDialog();"><span
							class="glyphicon glyphicon-log-in"></span> 登录</a></li>
					<li><a href="javascript:showSignUpDialog();"><span class="glyphicon glyphicon-user"></span>
							注册</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${base}/front/personal/viewInfo"><span
							class="glyphicon glyphicon-user"></span> ${sessionScope.loginInfo.nickName}</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">个人管理 <strong class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li><a href="${base}/front/personal/orders">我的订单</a></li>
							<li><a href="#">我的消息 <span class="badge">3</span></a></li>
							<li><a href="#">我的关注</a></li>
							<li class="divider"></li>
							<li><a href="${base}/front/user/logout">注销</a></li>
						</ul></li>
				</c:otherwise>
			</c:choose>
			<li><span style="display: block; width: 20px"></span></li>



		</ul>
	</div>
</nav>
<!-- 提示---->
<div class="alert alert-success" id="alertMsg">
	<strong>加入购物车！</strong>
</div>
<!-- /提示---->

<!-- 购物车面板-->
<div class="well col-md-12" id="cart-div"
	style="position: fixed; width: 400px; height: 100%; top: 5%; right: 0%; display: block; float: right; z-index: 20; display: none; backgoround: red;">

	<div class="center-block"
		style="position: fixed; bottom: 0%; width: 300px; z-index: 30; height: 50px; display: block;">

		<a class="btn  center-block btn-primary"
			href="${base}/front/order/viewOrder">结算账单</a>

	</div>
	<div id="cartContent" class="well"
		style="positon: fixed; overflow-y: scroll; height: 90%; z-index: 25; border: none;">

	</div>
</div>

<!-- /.购物车面板-->

<!-- 登录面板 -->

<div class="modal fade" id="loginDialog" tabindex="-1" role="dialog"
	aria-labelledby="">
	<div class="modal-dialog  modal-sm" role="document">
		<div class="modal-content">

			<div class="tabbable" id="tabs-login-signup">
				<div class=""
					style="padding: -2px 0px 10px -1px; margin-right: 20px;">
					<ul class="nav nav-tabs  nav-justified">
						<li class="active"><a href="#panel-login" data-toggle="tab">登录</a>
						</li>
						<li><a href="#panel-signUp" data-toggle="tab">注册</a></li>
						<li>
							<button type="button" class="close " data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</li>
					</ul>



				</div>




				<div class="tab-content">
					<div class="tab-pane active" id="panel-login">


						<div class="modal-body">
							<form class="form-horizontal" role="form" id="loginMinForm"
								method="post">
								<div class="form-group">
									<div class="col-sm-12 text-center" id="alertLoginMsg"
										style="color: red; height: 15px; display: block;"></div>
								</div>
								<div class="form-group ">
									<label class="control-label col-sm-1 sr-only"
										for="inputSuccess3"></label>
									<div class="col-sm-10">
										<div class="input-group ">
											<span class="input-group-addon"><span
												class=" glyphicon glyphicon-user "></span></span> <input
												type="email" class="form-control" id="userName"
												name="userName" aria-describedby="inputSuccess3"
												data-toggle="manual" required title="请输入正确邮箱">
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-1 sr-only"
										for="inputGroupSuccess2"></label>
									<div class="col-sm-10">
										<div class="input-group">
											<span class="input-group-addon"><span
												class=" glyphicon glyphicon-lock "></span></span> <input
												type="password" class="form-control" id="password"
												name="password" aria-describedby="inputGroupSuccess2Status"
												data-toggle="manual" title="不能为空">
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md- col-md-offset-2">

										<div class="checkbox">
											<label> <input type="checkbox" name="autoLogin"
												id="autoLogin"> 自动登录
											</label>
										</div>
									</div>
								</div>


								<div class="form-group has-success has-feedback">
									<label class="control-label col-sm-1 sr-only"
										for="inputGroupSuccess4">Input group with success</label>
									<div class="col-sm-10">
										<button type="button" class="btn btn-primary btn-block"
											id="loginBtn" onClick="submitLogin(this,'${base}')">登录</button>

									</div>
								</div>
							</form>

						</div>

					</div>
					
					<div class="tab-pane" id="panel-signUp">

						<div class="modal-body">
							<form class="form-horizontal" role="form" id="signUpMinForm"
								method="post">
								<div class="form-group">
									<div class="col-sm-12 text-center" id="alertsignUpMsg"
										style="color: red; height: 15px; display: block;"></div>
								</div>
								<div class="form-group ">
									<label class="control-label col-sm-2 sr-only"
										for="inputSuccess3"></label>
									<div class="col-sm-10">
										<div class="input-group ">
											<input type="email" class="form-control" id="signUpUserName"
												aria-describedby="inputSuccess3" data-toggle="manual"
												required placeholder="输入登录邮箱" title="请输入正确邮箱">
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2 sr-only"
										for="inputGroupSuccess2"></label>
									<div class="col-sm-10">
										<div class="input-group">
											<input type="password" class="form-control" id="oncePassword"
												 aria-describedby="inputGroupSuccess2Status"
												placeholder="输入登录密码" data-toggle="manual" title="不能为空">
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2 sr-only"
										for="inputGroupSuccess2"></label>
									<div class="col-sm-10">
										<div class="input-group">
											<input type="password" class="form-control"
												id="twicePassword" placeholder="再次输入登录密码" 
												aria-describedby="inputGroupSuccess2Status"
												data-toggle="manual" title="不能为空">
										</div>
									</div>
								</div>
								<div class="form-group has-success has-feedback">
									<label class="control-label col-sm-1 sr-only"
										for="inputGroupSuccess4">Input group with success</label>
									<div class="col-sm-10">
										<button type="button" class="btn btn-primary btn-block"
											id="signUpBtn" onClick="submitSignUp(this,'${base}')">注册</button>
									</div>
								</div>
							</form>

						</div>
					</div>
				</div>
			</div>

			<div class="modal-footer">
				<div class="col-md-2  col-md-offset-3">

					<button type="button" class="btn btn-default btn-sm">
						<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
					</button>

				</div>
				<div class="col-md-2 col-md-offset-0">
					<button type="button" class="btn btn-default btn-sm">
						<span class="glyphicon glyphicon-sunglasses" aria-hidden="true"></span>
					</button>
				</div>

				<div class="col-md-2 col-md-offset-0">
					<button type="button" class="btn btn-default btn-sm">
						<span class="glyphicon glyphicon-hourglass" aria-hidden="true"></span>
					</button>

				</div>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		//打开购物车展示商品
		viewCart('${base}');
		//删除购物车商品
		//	deleteCartPrt();

	});
</script>
<!--/.g购物车-->
