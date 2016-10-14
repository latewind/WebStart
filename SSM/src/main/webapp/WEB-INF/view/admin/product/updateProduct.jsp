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
						<!-- 加入具体内容-->
						<form class="form-horizontal" method="post"
							enctype="multipart/form-data"
							action="${base}/admin/product/updateProductAction">


							<div class="form-group">
								<label for="prtName" class="col-sm-2 control-label sr-only">商品Id：</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="loadPrtId"
										placeholder="输入商品id" />
								</div>
								<button type="button" class="btn" onclick="loadPrt()">加载商品</button>
							</div>

							<script>
								var loadPrt = function() {
									var prtId = $("#loadPrtId").val();
									console.log(prtId);
									window.location.href = "${base}/admin/product/updateProduct.html?prtId="
											+ prtId;

								}
							</script>


							<div class="form-group">
								<label for="prtName" class="col-sm-2 control-label">商品Id：</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="prtName"
										value="${productInfo.prtId }" name="prtId" placeholder="商品ID"
										readonly required>
								</div>

							</div>

							<div class="form-group">
								<label for="prtName" class="col-sm-2 control-label">商品名称：</label>
								<div class="col-sm-4">
									<input type="text" class="form-control"
										value="${productInfo.prtName }" name="prtName"
										placeholder="商品名称" required>
								</div>
								<label for="price" class="col-sm-1 control-label">商品单价：</label>
								<div class="input-group col-sm-2">
									<input type="text" id="price" name="price" class="form-control"
										value="${productInfo.price}" placeholder="单价"
										aria-describedby="basic-addon1"> <span
										class="input-group-addon">￥</span>
								</div>
							</div>

							<!-- 第二行-->
							<div class="form-group">
								<label for="thirdName" class="col-sm-2  control-label">商品分类：</label>
								<div class="col-sm-2 ">
									<select class="form-control" id="thirdName" name="thirdName">

										<c:forEach items="${thirds}" var="third">
											<option
												<c:if test="${third.name==thirdName }"> selected</c:if>>${third.name}</option>
										</c:forEach>

									</select>
								</div>
								<label for="num" class="col-sm-1 control-label col-sm-offset-2">商品库存：</label>
								<div class="input-group col-sm-2 col-sm-offset-7">
									<input type="text" id="num" class="form-control"
										value="${productInfo.num}" placeholder="库存量" name="num"
										aria-describedby="basic-addon1"> <span
										class="input-group-addon">件</span>
								</div>
							</div>
							<!-- /.第二行-->
							<!-- 第三行-->
							<div class="form-group">
								<label for="descirb" class="col-sm-2   control-label ">商品描述：</label>
								<div class=" col-sm-7 ">
									<textarea class="form-control" rows="5" id="descirb"
										name="describ">${productInfo.describ}</textarea>
								</div>
							</div>


							<!-- /.第三行-->
							<div class="form-group">
								<label for="file-1" class=" col-sm-2 control-label ">商品图片：</label>
								<div class=" col-sm-7 ">
									<input id="picFile" type="file" multiple class="file"
										name="picFiles" data-overwrite-initial="false"
										data-min-file-count="0">
								</div>
							</div>
							<!-- 第五行-->
							<div class="form-group">
								<label for="intro" class="col-sm-2   control-label ">商品介绍：</label>
								<div class=" col-sm-7 ">
									<textarea class="form-control" rows="5" id="intro" name="intro">${productInfo.intro } </textarea>
								</div>
							</div>
							<!-- /.第五行-->
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-2">
									<button type="submit" class="btn btn-primary btn-block">更新</button>
								</div>
							</div>
						</form>
						<script>
							$("#picFile").fileinput(
									{
										//   uploadUrl: '#', // you must set a valid URL here else you will get an error
										language : 'zh',
										allowedFileExtensions : [ 'jpg', 'png',
												'gif' ],
										overwriteInitial : false,
										maxFileSize : 1000,
										maxFilesNum : 6,
										showUpload : false,
										showRemove : false,
										showCaption : false,
									//allowedFileTypes: ['image', 'video', 'flash'],
									});
							$("[title='Upload file']").addClass("niHao");
						</script>
					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
</html>