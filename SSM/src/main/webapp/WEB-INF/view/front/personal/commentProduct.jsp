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
</head>
<body>
	<jsp:include page="/WEB-INF/layout/web/navbar.jsp"></jsp:include>
	<style>
body {
	padding-top: 60px;
}
</style>
	<div class="container  ">
		<!--分项 -->
		<div class="row clearfix   text-center ">
			<div class="col-md-12 column well">
				<div class="col-md-3 " >
					<h2 class="form-control-static" >
						<strong>评价</strong>
					</h2>
				</div>
				<div class="col-sm-4">
					<p class="form-control-static" >商品：ID</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="thumbnail">
						<img src="${imagePath}/${productPack.productInfo.primImage.imageName}" />
						<div class="caption">
							<p>
								<a href="${base}/front/product/${productPack.productInfo.prtId}">${productPack.productInfo.prtName }</a>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-9">
					<form class="form-horizontal" method="post"
						action="${base}/front/personal/commentProductAction">
						<div class="form-group">
							<input type="hidden" value="${productPack.cartProductId }"  name="packId"/>
							<input type="hidden" value="${productPack.passKey }"  name="passKey"/>
							<ul class="list-group list-inline">
								<li>
									<div class="btn-group" data-toggle="buttons">
										<label class="btn btn-info  <c:if test="${comment.evalRank==-1 }"> active</c:if>" > <input type="radio" <c:if test="${comment.evalRank==-1 }"> checked</c:if>
											value="-1" name="evalRank" required> 差评
										</label> <label class="btn btn-info <c:if test="${comment.evalRank==0 }"> active</c:if>" > <input type="radio" <c:if test="${comment.evalRank==0 }"> checked</c:if>
											value="0" name="evalRank" required> 中评
										</label> <label class="btn btn-info <c:if test="${comment.evalRank==1 }"> active</c:if>"> <input type="radio" <c:if test="${comment.evalRank==1 }"> checked</c:if>
											value="1" name="evalRank" required> 好评
										</label>
									</div>
								</li>
							</ul>
						</div>
						<div class="form-group">
							<label for="descirb" class="col-sm-2   control-label ">商品评价：</label>
							<div class=" col-sm-9 ">
								<textarea class="form-control" rows="5" required
									name="prtComment">${comment.content}</textarea>
							</div>
						</div>
						<button type="submit" class="btn btn-primary btn-lg ">提交评价</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/layout/web/footer.jsp" />
</body>
</html>