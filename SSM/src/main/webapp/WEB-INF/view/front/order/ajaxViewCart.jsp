<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<c:forEach var="productPack" items="${productPacks}">
	<div class="row clearfix prt-pack">
		<div class="col-md-12">
			<div class="thumbnail">
				<img alt="300x200" style="height: 150px;"
					src="${imagePath}/${productPack.productInfo.primImage.imageName}" />
				<div class="caption">
					<h4>${productPack.productInfo.prtName}</h4>
					<h4>
						<strong style="color: red;">${productPack.quantity }</strong><span>件</span>
					</h4>
					<p>
						<a class="btn btn-primary"
							href="${base}/front/product/${productPack.productInfo.prtId}">浏览</a>
						<button type="button" class="close cart-delete" aria-hidden="true"
							prt-pack-id="${productPack.cartProductId }"
							onClick="deleteCartPrt(this,'${base}')"
							title="删除商品">&times;</button>
					</p>
				</div>
			</div>
		</div>
	</div>
</c:forEach>