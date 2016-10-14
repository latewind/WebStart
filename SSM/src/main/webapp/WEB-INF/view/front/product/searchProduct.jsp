<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>${webTitle}</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="${base}/static/common/css/bootstrap.min.css">


<script src="${base}/static/common/js/jquery-2.0.0.min.js"></script>
<script src="${base}/static/common/js/bootstrap.min.js"></script>
<script src="${base}/static/common/js/imagesloaded.pkgd.js"></script>
<script src="${base}/static/common/js/masonry.pkgd.min.js"></script>
</head>

<body data-spy="scroll" data-target=".nav-pills" data-offset="100">
	<jsp:include page="/WEB-INF/layout/web/navbar.jsp"></jsp:include>
	<!-- /头部导航End -->

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column"></div>
		</div>
		<div class="row clearfix " style="padding-top: 50px">
			<div class="col-md-12 column">


				<div class="row">
					<div class="col-md-12">
						<jsp:include page="/WEB-INF/layout/web/nav.jsp"></jsp:include>
					</div>
				</div>
				<c:forEach items="${labels}" var="label">
				
				<span class="label label-info">${label}</span>
				</c:forEach>
				<!-- 中部排序导航 -->
				<nav class="navbar navbar-default" role="navigation">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">排序</a>
					</div>


					<!-- 条件-->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">综合</a></li>
							<li><a href="">销量</a></li>

							<li><a href="">单价</a></li>


						</ul>
						<form class="navbar-form navbar-left" role="form">
							<div class="form-group input-group">
								<input class="form-control  input-sm" type="text" size="5"
									placeholder="输入" /> <span
									class="input-group-addon"><span class="glyphicon glyphicon-minus"></span></span><input
									class="form-control  input-sm" type="text" size="5"
									placeholder="价格区间" />
							</div>
							<button type="submit" class="btn btn-default">确定</button>
						</form>
						<ul class="nav navbar-nav navbar-right ">
							<li><a href="#">上一页</a></li>
							<li><a href="#">下一页</a></li>

						</ul>
					</div>

				</nav>
			</div>
		</div>
		<div class="row clearfix">
			<!-- 商品列表 -->
			<div class="col-md-12 column">
			<div class ="col-md-12 text-center">
			<p>${errorMsg }</p>
			</div>
				<div class="masonry-container" id="productDiv">

					<c:forEach var="product" items="${productInfo}">
						<div class="col-md-3 grid-item">
							<div class="thumbnail">
								<img alt="300x200"
									src="${imagePath}/${product.primImage.imageName}" />
								<div class="caption">
									<h3>${product.prtName}</h3>
									<p>${product.describ}</p>
									<p>
										<a class="btn btn-primary" prt-id="${product.prtId}"
											href="${base}/front/product/${product.prtId}">浏览</a> <a
											class="btn" href="javascript:void(0)"
											prt-id="${product.prtId}"
											onclick="showAlertMsg(this,'${base}')">加入购物车</a>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<!-- /商品列表 -->
	</div>
	<jsp:include page="/WEB-INF/layout/web/footer.jsp" />
</body>
<script>
	$(document)
			.ready(
					function() {

						//	 瀑布效果
						var $grid = $('.masonry-container').imagesLoaded(
								function() {
									$grid.masonry({
										columnWidth : '.grid-item',
										itemSelector : '.grid-item'
									});
								});

						$(window)
								.scroll(
										function() {

											//滚动条到底部 
											if ($(document).scrollTop() >= $(
													document).height()
													- $(window).height()) {
												$
														.ajax({
															url : "${base}/front/ajax/thirdCategory/product",
															type : 'post',
															dataType : 'text',
															data : {
																thirdId : "${thirdId}"
															},

															beforeSend : function() {
																console
																		.log("before load..");
															},
															success : function(
																	result) {
																var $content = $(
																		'<div></div>')
																		.append(
																				result);
																var gridItems = $content
																		.find(".grid-item");
																gridItems
																		.each(function() {
																			$grid
																					.append(
																							this)
																					.masonry(
																							'appended',
																							this);

																		});
																console
																		.log("success");
															}
														});
											}
										});
					});
</script>



</html>