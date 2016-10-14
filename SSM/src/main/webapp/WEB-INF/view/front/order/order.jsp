<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>

<head>
<title>${webTitle}</title>
<meta charset="utf-8">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="">
<link rel="stylesheet" href="${base}/static/common/css/bootstrap.min.css">

<link rel="stylesheet"
	href="${base}/static/common/css/no-responsive.css">


<script src="${base}/static/common/js/jquery-2.0.0.min.js"></script>
<script src="${base}/static/common/js/bootstrap.min.js"></script>

<link href="${base}/static/front/css/product/payfor.css" rel="stylesheet"
	type="text/css">
<script src="${base}/static/front/js/product/payfor.js"></script>
<script src="${base}/static/front/js/order/order.js"></script>

</head>

<body data-spy="scroll" data-target=".nav-pills" data-offset="100">

	<jsp:include page="/WEB-INF/layout/web/navbar.jsp"></jsp:include>
	<div class="container page-header ">
		<div class="row clearfix ">
			<div class="col-md-12 col-xs-12column">
				<fieldset id="fieldset1">
					<div class="row clearfix text-center  page-header">
						<div class="col-md-1 col-xs-1 column">
							<input type="checkbox" id="allSelect" />
						</div>

						<div class="col-md-7 col-xs-7 column">商品</div>
						<div class="col-md-1 col-xs-1 column">单价</div>
						<div class="col-md-1 col-xs-1 column">数量</div>
						<div class="col-md-1 col-xs-1 column">总价</div>
						<div class="col-md-1 col-xs-1 column text-right">操作</div>
					</div>


					<script>
						$(document).ready(function() {
					 initOrderPage();
						});

					</script>
					<!--分项 -->
					<c:forEach var="productPack" items="${productPacks}">
						<div class="row clearfix  page-header text-center prt-pack">
							<div class="col-xs-1 column ">
								<input class="singleSelect"
									data-single-select-price="${productPack.productInfo.price*productPack.quantity}"
									type="checkbox"
									data-singel-select-packId="${productPack.cartProductId}" />

							</div>
							<div class="col-md-1 col-xs-1 column">
								<img alt="140x140" height="75px" width="50px"
									src="${imagePath}/${productPack.productInfo.primImage.imageName}" />
							</div>
							<div class="col-md-6 column col-xs-6 text-left">
								<h4>${productPack.productInfo.prtName}</h4>
							</div>
							<div class="col-md-1 col-xs-1 column">${productPack.productInfo.price}￥</div>
							<div class="col-md-1 col-xs-1 column">${productPack.quantity }</div>
							<div class="col-md-1 col-xs-1 column">
								<span class="price">${productPack.productInfo.price*productPack.quantity}</span><span>￥</span>
							</div>
							<div class="col-md-1 col-xs-1 column ">
								<button type="button" class="close order-pack-delete"
									aria-hidden="true" title="删除商品">&times;</button>
							</div>
						</div>
					</c:forEach>
					<!--/.分项 -->



				</fieldset>
				<div class="row clearfix text-center">
					<div class="col-md-2 col-xs-5 col-md-offset-5">
						<button type="button" class="btn btn-primary btn-lg  btn-block"
							id="confirmChoose">确认选择</button>
					</div>
					<div class="col-md-1 col-md-offset-3">
						<label><big><span id="totalPrice">0</span><span>￥</span></big></label>
					</div>
				</div>


			</div>
		</div>
		<div class="row clearfix well page-header">
			<div class="col-md-2 column"></div>
			<div class="col-md-8 column">
				<fieldset id="fieldset2" disabled="">
					<form role="form" class="form-horizontal" href="#" method="post">


						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">收件人：</label>
							<div class="col-sm-3">
								<p class="form-control-static" name="name" id="name">${user.actualName}</p>
							</div>

							<label for="contact" class="col-sm-2 control-label">联系方式：</label>
							<div class="col-sm-4">
								<p class="form-control-static" name="contact" id="contact">${user.tel }</p>
							</div>



						</div>


						<div class="form-group">
							<label for="address" class="col-sm-2  control-label">收件地址：</label>

							<div class="col-sm-9">
								<p class="form-control-static" name="address" id="address">${user.address}</p>
							</div>
							<div class="col-sm-1">
								<button type="button" class="btn btn-default btn-xs"
									data-toggle="modal" data-target="#exampleModal">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									修改
								</button>
							</div>
						</div>


						<div class="form-group">

							<label for="" class="col-sm-2  control-label">支付方式：</label>
							<div class="btn-group col-sm-10" data-toggle="buttons">
								<label class="btn btn-default active"> <input
									type="radio" name="payMethod" autocomplete="off" required
									value="支付宝" checked="checked" /> 支付宝
								</label> <label class="btn btn-default"> <input type="radio"
									name="payMethod" autocomplete="off" value="微信" required /> 微信
								</label> <label class="btn btn-default"> <input type="radio"
									name="payMethod" autocomplete="off" value="网银" required /> 网银
								</label>
							</div>
						</div>

						<div class="form-group">

							<label for="" class="col-sm-2  control-label">配送方式：</label>
							<div class="btn-group col-sm-10" data-toggle="buttons">
								<label class="btn btn-default "> <input type="radio"
									name="delivery" id="delivery" autocomplete="off" value="申通快递"
									required> 申通快递
								</label> <label class="btn btn-default active"> <input
									type="radio" name="delivery" id="delivery" autocomplete="off"
									value="顺丰快递" required checked> 顺丰快递
								</label> <label class="btn btn-default"> <input type="radio"
									name="delivery" id="delivery" autocomplete="off" value="圆通快递"
									required> 圆通快递
								</label> <label class="btn btn-default"> <input type="radio"
									name="delivery" id="delivery" autocomplete="off" value="中国邮政"
									required> 中国邮政
								</label>
							</div>
						</div>



						<div class="form-group">
							<div class="btn-group col-sm-2 col-sm-offset-10">
								<button type="button" class="btn btn-warning  btn-block"
									onclick="submitOrder('${base}')">确认购买</button>
							</div>


						</div>




					</form>
				</fieldset>
			</div>
			<div class="col-md-2 column"></div>
		</div>
	</div>




	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">更新信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">

							<label for="recipient-name" class=" col-md-2 control-label">姓名:</label>
							<div class="col-md-3">
								<input type="text" id="newName" class="form-control"
									placeholder="" name="newName" aria-describedby="basic-addon1"
									data-toggle="manual" title="不能为空">
							</div>

							<label for="recipient-name" class=" col-md-2 control-label">联系方式:</label>
							<div class="col-md-4">
								<input type="text" id="newContact" class="form-control"
									placeholder="" name="newContact"
									aria-describedby="basic-addon1" data-toggle="manual"
									title="不能为空">
							</div>
						</div>


						<div class="form-group">
							<label for="message-text" class="control-label col-md-2">收货地址:</label>
							<div class="col-md-9">
								<textarea class="form-control" id="newAddress"
									data-toggle="manual" title="不能为空"></textarea>
							</div>

						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="saveInfo">保存</button>
				</div>
			</div>
		</div>
	</div>


<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
</html>
