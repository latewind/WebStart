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
<script src="${base}/static/admin/js/header/adminHeader.js"></script>
<link href="${base}/static/common/css/fileinput.css" media="all"
	rel="stylesheet" type="text/css" />
<script src="${base}/static/common/js/fileinput.js"
	type="text/javascript"></script>

<link rel="stylesheet"
	href="${base}/static/common/css/dataTables.bootstrap.min.css">
<script
	src=" ${base}/static/common/js/jquery.dataTables.min.js"></script>
<script
	src="${base}/static/common/js/dataTables.bootstrap.min.js"></script>
<script src="${base}/static/common/js/zh.js"></script>
</head>
<body data-spy="scroll" data-target=".nav-pills" data-offset="100">
	<div class="container-fluid">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- 加入头Header-->
				<jsp:include page="/WEB-INF/layout/admin/adminHeader.jsp"></jsp:include>
				<div class="row clearfix">
					<div class="col-md-2 column">
						<!-- 加入右侧-->
						<jsp:include page="/WEB-INF/layout/admin/adminPanel.jsp"></jsp:include>
					</div>
					<div class="col-md-10 column">
					<div class="table-responsive">
						<table id="example" class="table table-striped table-bordered"
							cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>商品ID</th>
									<th>商品名</th>
									<th>价格</th>
									<th>销量</th>
									<th>点击量</th>
									<th>库存</th>
									<th>操作</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>商品ID</th>
									<th>商品名</th>
									<th>价格</th>
									<th>销量</th>
									<th>点击量</th>
									<th>库存</th>
									<th>操作</th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach items="${listPrt}" var="product">
									<tr>
										<td>${product.prtId}</td>
										<td>${product.prtName }</td>
										<td>￥${product.price}</td>
										<td>${product.sellCount }</td>
										<td>${product.clickCount }</td>
										<td>${product.num }</td>
										<td><a href="${base}/admin/product/updateProduct.html?prtId=${product.prtId}"><small>更新</small></a></td>
									</tr>

								</c:forEach>

							</tbody>
						</table>
						</div>
						<script>
							$(document).ready(function() {
								$('#example').DataTable();
							});
						</script>
						<!-- 加入具体内容-->

					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
</html>