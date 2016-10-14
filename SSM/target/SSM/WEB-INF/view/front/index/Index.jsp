<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>${webTitle}</title>
<meta charset="utf-8">

<link rel="stylesheet"
	href="${base}/static/common/css/bootstrap.min.css">

<link rel="stylesheet"
	href="${base}/static/common/css/no-responsive.css">

<script src="${base}/static/common/js/jquery-2.0.0.min.js"></script>
<script src="${base}/static/common/js/bootstrap.min.js"></script>
<script src="${base}/static/common/js/imagesloaded.pkgd.js"></script>
<script src="${base}/static/common/js/masonry.pkgd.min.js"></script>
<link href="${base}/static/front/css/index/index.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="${base}/static/front/js/index/index.js"></script>
<style type="text/css">
.thumbnail {
	padding: 0px !important;
}

.hover-div {
	text-align: center !important;
	background-color: #E95420;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/layout/web/navbar.jsp"></jsp:include>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 col-xs-12 column ">
				<!--  头部公告 -->
				<div class="jumbotron well bg-color-or page-header">
					<h1 style="color: #FFFFFF">${ headline.title }</h1>
					<blockquote>
						<p style="color: #FFFFFF">
							<em>${ headline.content }</em>
						</p>
					</blockquote>
					<p>
						<a class="btn btn-primary btn-large" href="${ headline.pageLink }">立即123前往</a>
					</p>
				</div>
				<div class="row">
					<div class="col-md-12">
						<jsp:include page="/WEB-INF/layout/web/nav.jsp"></jsp:include>
					</div>
				</div>

				<div class="row clearfix">
					<div class="col-md-2 col-xs-2 column">
						<ul class=" list-group" id="rightNav">
							<!-- 每一行-->
							<c:forEach var="tMap" items="${topMap}">
								<li class="list-group-item list-group-item-info   nav-li-left">
									<ul class="list-group  list-inline">
										<c:forEach var="subCategory" items="${tMap.value}"
											varStatus="substatus">
											<!-- 左侧导航只显示3个2级分类 -->
											<c:if test="${substatus.count<4 }">
												<li><a
													href="${base}/front/subCategory/${subCategory.id}">${subCategory.name}</a></li>
											</c:if>
										</c:forEach>
									</ul>
								</li>
								<!-- 展开分类 START -->
								<div class="sub-item-rignt item-list">
									<div class="subitem">
										<c:forEach var="subCategory2" items="${tMap.value}">
											<dl>
												<dt>
													<a href="${base}/front/subCategory/${subCategory2.id}">${subCategory2.name}</a>
												</dt>
												<dd>
													<c:forEach var="thirdCategory"
														items="${subCategory2.thirdCategories}">
														<em><a
															href="${base}/front/thirdCategory/${thirdCategory.id}">${thirdCategory.name }</a></em>
													</c:forEach>
												</dd>
											</dl>
										</c:forEach>
									</div>
								</div>
								<!-- 展开分类 END-->
							</c:forEach>
						</ul>
					</div>
					<!--  幻灯片播放 -->
					<div class="col-md-8 col-xs-8 column">
						<div class="carousel slide" id="carousel-668027">
							<ol class="carousel-indicators" style="z-index: 1;">
								<li class="active" data-slide-to="0"
									data-target="#carousel-668027"></li>
								<li data-slide-to="1" data-target="#carousel-668027"></li>
								<li data-slide-to="2" data-target="#carousel-668027"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<img alt="" src="${base}/static/front/images/index/3.jpg" />
								</div>
								<div class="item">
									<img alt="" src="${base}/static/front/images/index/4.jpg" />
								</div>
								<div class="item">
									<img alt="" src="${base}/static/front/images/index/5.jpg" />
								</div>
							</div>
							<a class="left carousel-control" href="#carousel-668027"
								data-slide="prev"><span
								class="glyphicon glyphicon-chevron-left"></span></a> <a
								class="right carousel-control" href="#carousel-668027"
								data-slide="next"><span
								class="glyphicon glyphicon-chevron-right"></span></a>
						</div>
					</div>
					<!--  /.幻灯片播放 -->

					<!-- 公告 新闻栏 -->
					<div class="col-md-2 col-xs-12 column">
						<ul class="nav nav-tabs nav-justified">
							<li class="active"><a href="#panel-announce"
								onmouseover="tabPanelShow(this)" data-toggle="tab">公告</a></li>
							<li><a href="#panel-news" onmouseover="tabPanelShow(this)"
								data-toggle="tab">新闻</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane well fade in active " id="panel-announce">
								<ul class="list-unstyled ">

									<c:forEach items="${anList}" var="anno">
										<li><p class="text-info text-left">
												<a href="${anno.announAnchor}"><small>【公告】${anno.announTitle}<span>
															&nbsp;[<fmt:formatDate value="${anno.announTime}"
																pattern="yyyy-MM-dd " />
													</span>]
												</small></a>
											</p></li>


									</c:forEach>
								</ul>
							</div>
							<div class="tab-pane fade well" id="panel-news">

								<ul class="list-unstyled small text-left">
									<li>1</li>
									<li>1</li>
									<li>1</li>
									<li>1</li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /.公告新闻 -->


				</div>
			</div>
			<!-- 提示---->
			<div class="alert alert-success" id="alertMsg">
				<strong>加入购物车！</strong>
			</div>
			<!-- /提示---->
			<!-- ========================================================================= -->
			<c:forEach items="${part}" var="part">
				<div class="row">
					<div class="col-md-12 ">
						<div class="page-header">
							<h3>
								${part.key} <small></small>
							</h3>
						</div>
					</div>
				</div>
				<div class="row clearfix ">
					<div class="col-md-10 col-xs-10 column">
						<div class=" masonry-container">
							<c:forEach var="leftMap" items="${part.value[0]}">
								<c:forEach var="leftProduct" items="${leftMap.value}"
									varStatus="s">
									<div class="col-md-3 col-xs-3 grid-item">
										<div class="thumbnail" style="position: relative">
											<a href="${base}/front/product/${leftProduct.prtId}"><img
												style="width: 250px; height: 250px"
												src="${imagePath}/${leftProduct.primImage.imageName}" /></a>
											<div class="caption " style="height: 80px;">
												<p>
													<small>${leftProduct.prtName}</small>
												</p>
												<p style="color: #E95420">
													<span>￥</span>${leftProduct.price}</p>
												<div class="hover-div"
													style="position: absolute; top: 250px; width: 100%; height: 80px; padding: 20px 0px; display: none; right: 0px">
													<a class="btn btn-primary"
														href="${base}/front/product/${leftProduct.prtId}">浏览</a>
													<button class="btn btn-warning"
														prt-id="${leftProduct.prtId}"
														onclick="showAlertMsg(this,'${base}')">加入购物车</button>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:forEach>
						</div>
					</div>
					<div class="col-md-2 col-xs-2 column">
						<c:forEach var="rightMap" items="${part.value[1]}">
							<c:forEach var="rightProduct" items="${rightMap.value}"
								varStatus="rStatus">
								<div class="list-group ">
									<a href="javascript:void(0);" class="list-group-item active">${rightMap.key}产品-TOP${rStatus.index+1}</a>
									<div class="list-group-item thumbnail">
										<img src="${imagePath}/${rightProduct.primImage.imageName}" />
									</div>
									<div class="list-group-item text-align">
										<a href="${base}/front/product/${rightProduct.prtId}">${rightProduct.prtName}</a>
									</div>
									<a class="list-group-item active"> <span class="badge">
											<c:choose>
												<c:when test="${rightMap.key=='热销' }">
										${rightProduct.sellCount}
										</c:when>
												<c:otherwise>
										${rightProduct.clickCount}
										</c:otherwise>
											</c:choose>
									</span>${rightMap.key}值</a>
								</div>
							</c:forEach>
						</c:forEach>
					</div>
				</div>
			</c:forEach>
			<!-- ========================================================================= -->
			<c:forEach items="${map}" var="m">
				<div class="row">
					<div class="col-md-12 ">
						<div class="page-header">
							<h3>
								${m.key } <small></small>
							</h3>
						</div>
					</div>
				</div>
				<div class="row clearfix">
					<div class="col-md-12 col-xs-12 column ">
						<div class=" masonry-container">
							<c:forEach var="product" items="${m.value}">
								<div class="col-md-3 col-xs-3 grid-item">
									<div class="thumbnail" style="position: relative">
										<img alt="300x200" style="width: 250px; height: 250px"
											src="${imagePath}/${product.primImage.imageName}" />
										<div class="caption" style="height: 80px;">
											<p>
												<small>${product.prtName}</small>
											</p>
											<p style="color: #E95420">
												<span>￥</span>${product.price}</p>
											<div class="hover-div"
												style="position: absolute; top: 250px; width: 100%; height: 80px; padding: 20px 0px; display: none; right: 0px">
												<a class="btn btn-primary"
													href="${base}/front/product/${product.prtId}">浏览</a>
												<button class="btn btn-warning" prt-id="${product.prtId}"
													onclick="showAlertMsg(this,'${base}')">加入购物车</button>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</c:forEach>
			<!-- ================================================================= -->
		</div>
	</div>

	<script>
		$(document).ready(function() {
			var $container = $('.masonry-container');
			$container.imagesLoaded(function() {
				$container.masonry({
					columnWidth : '.grid-item',
					itemSelector : '.grid-item',
				

				});
			});

			$(".caption").hover(function() {

				$(this).find("div").show();
			}, function() {

				$(this).find("div").hide();

			});
		});
	</script>
	<jsp:include page="/WEB-INF/layout/web/footer.jsp" />
</body>
</html>