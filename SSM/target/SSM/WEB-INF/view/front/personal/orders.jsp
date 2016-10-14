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


<script src="${base}/static/common/js/jquery-2.0.0.min.js"></script>
<script src="${base}/static/common/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/layout/web/navbar.jsp"></jsp:include>
	<div class="container">
		<div class="row clearfix  page-header">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<jsp:include page="/WEB-INF/layout/web/personalNav.jsp"></jsp:include>
					<div class="col-md-10 column">
					<div class="table-responsive">
						<table class="table  table-strip">
							<thead>
								<tr>
									<th colspan="3">订单详情</th>
									<th>单价</th>
									<th>金额</th>
									<th>状态</th>
								</tr>
							</thead>
							<c:forEach items="${orderList}" var="orderInfo">
								<tbody>
									<tr>
										<td colspan="6"><div class=" col-md-12 "></div></td>
									</tr>
									<c:forEach items="${orderInfo.productPacks}" var="productPack">
										<c:choose>
											<c:when test="${orderInfo.orderStatus=='未付款' }">
												<tr class="warning">
											</c:when>
											<c:when test="${orderInfo.orderStatus=='已完成' }">
												<tr class="info">
											</c:when>
											<c:otherwise>
												<tr class="success">
											</c:otherwise>
										</c:choose>
										<td><div class="col-md-12 ">
												<img alt="140x140" height="75px" width="75px"
													src="${imagePath}/${productPack.productInfo.primImage.imageName}" />
											</div></td>
										<td>${productPack.productInfo.prtName}</td>
										<td>×${productPack.quantity}</td>
										<c:choose>
										<c:when test="${orderInfo.orderStatus=='未付款'}">
										<td>${productPack.productInfo.price}</td>
										<td>${productPack.productInfo.price * productPack.quantity}</td>
										</c:when>
										<c:otherwise>
										<td>${productPack.dealPrice}</td>
										<td>${productPack.dealPrice * productPack.quantity}</td>
										
										</c:otherwise>										
										</c:choose>
										<td><dl><dd>${orderInfo.orderStatus }</dd>
										  	<c:if test="${orderInfo.orderStatus=='未付款'}">
										  		<dd><a href="${base}/front/order/payfor?orderId=${orderInfo.orderId}&passKey=${orderInfo.passKey}">去付款</a></dd>
										  	</c:if>
										  	<c:if test="${orderInfo.orderStatus=='已完成'}">
										  		<dd><a href="${base}/front/personal/commentProduct.html?packId=${productPack.cartProductId}&passKey=${productPack.passKey}"><small>我的评价</small></a></dd>
										  	</c:if>
										  </dl></td>
										</tr>
									</c:forEach>
									<c:choose>
										<c:when test="${orderInfo.orderStatus=='未付款' }">
											<tr class="warning">
										</c:when>
										<c:when test="${orderInfo.orderStatus=='已完成' }">
												<tr class="info">
											</c:when>
										<c:otherwise>
											<tr class="success">
										</c:otherwise>
									</c:choose>
									<td><fmt:formatDate value='${orderInfo.createTime}' pattern='yyyy-MM-dd HH:mm:ss'/></td>
									<td>${orderInfo.name}</td>
									<td>订单号：${orderInfo.orderId}</td>
									<td colspan="2">${orderInfo.address}</td>
									<td>${orderInfo.contact}</td>
									</tr>
								</tbody>
							</c:forEach>
						</table>
						</div>
						<nav style="text-align: right">
							<ul class="pagination ">
								<c:choose>
									<c:when test="${page.hasFirst}">
										<li><a href="${base}/front/personal/${actionName}?pageNow=${page.pageNow-1}"  aria-label="Previous"> <span
												aria-hidden="true">&laquo;</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li class="disabled"><span> <span
												aria-hidden="true">&laquo;</span>
										</span></li>
									</c:otherwise>
								</c:choose>
								<c:forEach items="${page.pagination}" var="p">
									<c:choose>
										<c:when test="${p==page.pageNow }">
											<li class="active"><span>${p} <span
													class="sr-only">(current)</span></span></li>
										</c:when>
										<c:when test="${p==-1}">
												<li><span>...<span
													class="sr-only"></span></span></li>
										</c:when>
										<c:otherwise>
											<li><a href="${base}/front/personal/${actionName}?pageNow=${p}">${p }</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:choose>
									<c:when test="${page.hasLast}">
										<li><a href="${base}/front/personal/${actionName}?pageNow=${page.pageNow+1}" aria-label="Previous"> <span
												aria-hidden="true">&raquo;</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li class="disabled"><span> <span
												aria-hidden="true">&raquo;</span>
										</span></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
</html>