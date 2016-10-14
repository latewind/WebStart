<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>${webTitle}</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${base}/static/common/css/bootstrap.min.css">
<link rel="stylesheet" href="${base}/static/common/css/bootstrap-responsive.css">
<script src="${base}/static/common/js/jquery-2.0.0.min.js"></script>
<script src="${base}/static/common/js/bootstrap.min.js"></script>
<link href="${base}/static/front/css/product/payfor.css" rel="stylesheet"
	type="text/css">
<script src="${base}/static/front/js/product/payfor.js"></script>
<style>
.bottom-thumbnail img:hover {
	transition: border linear .2s, box-shadow linear .5s;
	-moz-transition: border linear .2s, -moz-box-shadow linear .5s;
	-webkit-transition: border linear .2s, -webkit-box-shadow linear .5s;
	outline: none;
	border-color: rgba(51, 51, 255, 1);
	box-shadow: 0 0 8px rgba(51, 51, 255, 1);
	-moz-box-shadow: 0 0 8px rgba(51, 51, 255, 1);
	-webkit-box-shadow: 0 0 8px rgba(51, 51, 255, 1);
}

.comment-head {
	padding-top: 20px;
}

.grid-item img {
	height: 200px !important;
}

.grid-item .thumbnail {
	height: 310px !important;
}
.productInfo{
padding:10px 0px !important;

}
</style>
</head>
<body data-spy="scroll" data-target=".nav-pills" data-offset="100">
	<jsp:include page="/WEB-INF/layout/web/navbar.jsp"></jsp:include>
	<div class="container">
		<div class="row clearfix " style="padding-top: 50px">
			<div class="col-md-12 column ">
				<jsp:include page="/WEB-INF/layout/web/nav.jsp" />
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<!-- 路径导航 -->
					<c:forEach var="cMap" items="${categoryMap }">
						<li><a href="${base}/front/${cMap.value }">${cMap.key }</a></li>
					</c:forEach>
					<li class="active">${productInfo.prtName }</li>
				</ul>
				<!-- ./路径导航 -->
				<div class="row clearfix">
					<!-- 右侧商品图片 Start-->
					<div class="col-md-5 col-xs-12 column ">
						<div class="row clearfix">
							<div class="col-md-12 col-xs-12">
								<!-- 播放Start-->
								<div class="carousel slide" id="carousel-660917">
									<div class="carousel-inner " style="height: 400px;">
										<c:forEach var="prtImg" items="${productInfo.images}"
											varStatus="imgStatus">
											<div
												<c:choose > <c:when test="${imgStatus.first}">class="item active " </c:when> <c:otherwise > class="item "</c:otherwise>   </c:choose>>
												<img class="center-block" style="height:400px;"
													src="${imagePath}/${prtImg.imageName}" />
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
						<!-- /播放结束-->
						<script>
							$(document).ready(function() {
								$(".bottom-thumbnail").each(function(index) {
									console.log(index + "index");
									$(this).hover(function() {
										$("#carousel-660917").carousel(index);
									});
								});
							});
						</script>
						<!-- 播放下方6张图片Start-->
						<div class="row clearfix" style="margin-top: 20px;">
							<c:forEach var="prtImg" items="${productInfo.images }"
								varStatus="statusImg">
								<c:if test="${statusImg.index <6 }">
									<div class="col-md-2  bottom-thumbnail col-xs-2" style="padding: 0px;">
										<div class="thumbnail  col ">
											<a href="javascript:void(0);"><img alt="300x200"
												src="${imagePath}/${prtImg.imageName}"
												style="height: 70px" /></a>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
						<!-- 播放下方6张图片End-->
					</div>
					<!-- 右侧商品图片 End-->


					<!-- 中间商品购买 Start-->
					<div class="col-md-5 col-xs-12 column ">
						<div class="well productInfo " style="background-color: white; border: none">
							<h4>
								<span>${productInfo.prtName }</span>
							</h4>
							<div class="well">
								<h4>
									<small>价格 </small>&nbsp;&nbsp;<big>￥${productInfo.price}</big>
								</h4>
								<h4>
									<small>促销信息</small>
								</h4>
							</div>
							<form action="#" method="post">
								<!--尺寸Start-->
								<ul class="list-group list-inline">
									<li>
										<h5>选择：</h5>
									</li>
									<li>
										<div class="btn-group" data-toggle="buttons">
											<label class="btn btn-info"> <input type="radio"
												name="options" id="option1" required> S
											</label> <label class="btn btn-info"> <input type="radio"
												name="options" id="option2" required> M
											</label> <label class="btn btn-info"> <input type="radio"
												name="options" id="option3" required> L
											</label>
										</div>
									</li>
								</ul>
								<!-- /尺寸END-->
								<p class="text-info">
									&nbsp;&nbsp;&nbsp;&nbsp;${productInfo.describ }</p>
								<!-- 商品数量-->
								<div class="p_number">
									<div style="height: 36px; font-size: 16px; display: none;">
										商品单价：<strong id="price_item_1">￥${productInfo.price}</strong>
									</div>
									<div>库存量：${productInfo.num}</div>
									<div class="f_l add_chose">
										<a class="reduce" onClick="setAmount.reduce('#qty_item_1')"
											href="javascript:void(0)"> -</a> <input type="text"
											name="qty_item_1" value="1" id="qty_item_1"
											onKeyUp="setAmount.modify('#qty_item_1')" class="text" /> <a
											class="add" onClick="setAmount.add('#qty_item_1')"
											href="javascript:void(0)"> +</a>
									</div>
									<div class="f_l buy">
										<span class="total-font" id="total_item_1">￥89.00</span> <input
											type="hidden" name="total_price" id="total_price" value="" />
									</div>
								</div>
								<p>
									<!--  <input type="submit" class="btn btn-info" value="购买"> -->
									<button type="button" class="btn btn-warning" value="加入购物车"
										prt-id="${productInfo.prtId}"
										onclick="showAlertMsg(this,'${base}')
										">加入购物车</button>
								</p>
							</form>
						</div>
					</div>
					<!-- 中间商品购买 End-->

					<!-- 右侧栏框 数据信息 -->
					<div class="col-md-2  hidden-phone column">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">商品</h3>
							</div>
							<div class="panel-body">
								<span>销量：</span><span>${productInfo.sellCount}</span>
							</div>
							<div class="panel-body">
								<span>点击量：</span><span>${productInfo.clickCount}</span>
							</div>
							<div class="panel-body">
								<span>评分：</span><span>${productInfo.clickCount}</span>
							</div>


							<div class="panel-footer">
								<span class="glyphicon glyphicon-star-empty"></span>收藏
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<!-- 中部推荐商品Start-->
		<div class="row hidden-phone" style="margin-bottom: 10px; margin-bottom: 30px;">
			<div class="col-md-12 "
				style="background-color: #CA7A31; color: white;">
				<strong><span>猜你喜欢</span></strong><span class="pull-right"><a
					href="${base}/front/thirdCategory/${productInfo.thirdId}"><small>更多</small></a></span>
			</div>
		</div>
		<div class="row clearfix hidden-phone">
			<div class="col-md-12 column">
				<div class="row">
					<c:forEach items="${recomment}" var="product">
						<div class="col-md-3 col-sm-6 grid-item ">
							<div class="thumbnail">
								<img src="${imagePath}/${product.primImage.imageName}" />
								<div class="caption">
									<a href="${base}/front/product/${product.prtId}">
										${product.prtName} </a>
									<p>
										<strong>${product.price}</strong><span>￥</span>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<!-- /.中部推荐商品End-->

		<div class="row clearfix">
			<div class="col-md-2 hidden-phone column">



				<c:forEach var="topPrt" items="${topPrts}" varStatus="rStatus">
					<div class="list-group ">
						<a href="javascript:void(0);"
							class="list-group-item active text-center">TOP${rStatus.index+1}</a>
						<div class="list-group-item thumbnail">
							<img src="${imagePath}/${topPrt.primImage.imageName}" />
						</div>
						<div class="list-group-item text-align">
							<a href="${base}/front/product/${topPrt.prtId}">${topPrt.prtName}</a>
						</div>
						<a class="list-group-item active"> <span class="badge">


								${topPrt.sellCount} </span>销量
						</a>
					</div>
				</c:forEach>

				<div class="list-group">
					<a href="#" class="list-group-item active">Home</a>
					<div class="list-group-item">List header</div>
					<div class="list-group-item">
						<h4 class="list-group-item-heading">List group item heading</h4>
						<p class="list-group-item-text">...</p>
					</div>
					<div class="list-group-item">
						<span class="badge">14</span> Help
					</div>
					<a class="list-group-item active"> <span class="badge">14</span>
						Help
					</a>
				</div>
			</div>
			<!-- 商品介绍及商品评价-->
			<div class="col-md-10 col-xs-12 column">
				<div class="tabbable" id="tabs-comment">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#panel-intro" data-toggle="tab">商品介绍</a>
						</li>
						<li><a href="#panel-comment" data-toggle="tab">商品评价</a></li>
					</ul>
					<div class="tab-content">
						<!--商品介绍详情内容-->
						<div class="tab-pane active" id="panel-intro">
							 <!--  添加商品介绍 -->
							 ${productInfo.intro }
					
					
					
					
						</div>
						<!--商品评价内容-->
						<div class="tab-pane" id="panel-comment">
							<div class="row clearfix">
								<div class="col-md-12 column">
									<c:forEach items="${comments}" var="comment">
										<div class="row clearfix">
											<div class="col-md-9 column">
												<blockquote>
													<p>${comment.content }</p>
													<small> <cite> <c:choose>
																<c:when test="${comment.evalRank==-1 }">
												差评
												</c:when>
																<c:when test="${comment.evalRank==0 }">
												中评
												</c:when>
																<c:otherwise>
												好评	
													</c:otherwise>
															</c:choose>
													</cite></small>
												</blockquote>
											</div>
											<div class="col-md-3 column comment-head">
												<img class="img-rounded" style="width: 30px; height: 30px;"
													src="${base}/front/personal/getHead?userId=${comment.userInfo.userId}" />
												<small> ${comment.userInfo.nickname }</small>
											</div>
										</div>
										<hr
											style="height: 1px; border: none; border-top: 1px solid #555555;" />
									</c:forEach>
								</div>
							</div>
						</div>
						<!-- 商品评价END-->
					</div>
				</div>
			</div>

		</div>
	</div>
<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
</html>