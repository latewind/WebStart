<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base.jsp"%>
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">LateWind</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
					
							<li><a href="${base}/index">前台主页</a></li>
					
					</ul>
				
					<ul class="nav navbar-nav navbar-right">
						<li>
							 <a href="#">${sessionScope.systemLoginInfo.loginName}</a>
						</li>
							<li>
							 <a href="#">${sessionScope.systemLoginInfo.roleName}</a>
						</li>
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">操作<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="#">Action</a>
								</li>
								<li>
									 <a href="#">Another action</a>
								</li>
								<li>
									 <a href="#">Something else here</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="${base}/system/user/logoutAction">注销</a>
								</li>
							</ul>
						</li>
						<li><span style="display: block; width: 20px"></span></li>
					</ul>
				</div>
			</nav>
			<div class="jumbotron well page-header text-center">
				<h1>
				 后台管理
				</h1>
			</div>

			<ul class="breadcrumb" id="bread">
				<li>
					 <a href="javascript:void(0);"></a>
				</li>
				<li>
					 <a href="javascript:void(0);"></a>
				</li>
			</ul>