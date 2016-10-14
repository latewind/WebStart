<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<c:forEach var="product" items="${productInfo}">
	<div class="col-md-2 grid-item">
		<div class="thumbnail" style="position: relative">
			<a href="${base}/front/product/${product.prtId}">
			<img alt="300x200" style="width: 200px; height: 200px"
				src="${imagePath}/${product.primImage.imageName}" />
				</a>
			<div class="caption " style="height: 80px;">
				<p>
					<small>${product.prtName}</small>
				</p>
				<p style="color: #E95420">
					<span>￥</span>${product.price}</p>
				<div class="hover-div"
					style="position: absolute; top: 200px; width: 100%; height: 80px; padding: 20px 0px; display: none; right: 0px">
					<a class="btn btn-primary"
						href="${base}/front/product/${product.prtId}">浏览</a>
					<button class="btn btn-warning" prt-id="${product.prtId}"
						onclick="showAlertMsg(this,'${base}')">加入购物车</button>
				</div>
			</div>
		</div>
	</div>
</c:forEach>