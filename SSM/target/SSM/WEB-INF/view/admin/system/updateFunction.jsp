<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>${webTitle}</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script>
	
<%--JS gloable varilible--%>
	var basePath = "${base}";
</script>

<link rel="stylesheet"
	href="${base}/static/common/css/bootstrap.min.css">
<script src="${base}/static/common/js/jquery-2.0.0.min.js"></script>
<script src="${base}/static/common/js/bootstrap.min.js"></script>
<script src="${base}/static/admin/js/header/adminHeader.js"></script>
<link href="${base}/static/common/css/fileinput.css" media="all"
	rel="stylesheet" type="text/css" />
<script src="${base}/static/common/js/fileinput.js"
	type="text/javascript"></script>
<script src="${base}/static/common/js/zh.js"></script>


<style>
.col-md-8 .form-group {
	margin: 20px !important;
}
</style>



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
					<div class="col-md-8 column  col-md-offset-1">
						<!-- 加入具体内容-->

						<form class="form-horizontal" method="post"
							enctype="multipart/form-data"
							action="${base}/admin/system/addFunctionAction">

							<fieldset>
								<legend>增加权限</legend>

								<div class="form-group">
									<label for="prtName" class="col-sm-2 control-label">权限名：</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" name="funcName"
											placeholder="权限名称" required>
									</div>

									<label for="" class="col-sm-2  control-label">父类权限：</label>
									<div class="col-sm-2 ">
										<select class="form-control" name="parentName">
											<option selected></option>
											<c:forEach items="${funcMap}" var="map">
												<option>${map.value.functionName}</option>
											</c:forEach>
										</select>
									</div>


								</div>

								<div class="form-group">
									<label for="prtName" class="col-sm-2 control-label">URL：</label>
									<div class="col-sm-3">
										<input type="text" class="form-control" name="url"
											placeholder="输入URL" required>
									</div>

									<label for="thirdName" class="col-sm-2  control-label">选择类型：</label>
									<div class="col-sm-2 ">
										<select class="form-control" name="type">



											<option>1</option>
											<option>0</option>

										</select>
									</div>
								</div>

								<!-- /.第五行-->
								<div class="form-group">
									<div class="col-sm-offset-4 col-sm-2">
										<button type="submit" class="btn btn-primary btn-block" title="创建权限">创建</button>
									</div>
								</div>

							</fieldset>
						</form>



						<form class="form-horizontal" method="post"
							enctype="multipart/form-data"
							action="${base}/admin/system/updateFunctionAction">

							<fieldset>
								<legend>修改权限</legend>

								<div class="form-group">
									<label for="prtName" class="col-sm-2 control-label">选择权限：</label>
									<div class="col-sm-2">
										<select class="form-control" name="funcName"  id="funcList">

											<c:forEach items="${funcMap}" var="map">
												<c:forEach items="${map.value.childList}" var="func">
													<option>${func.functionName}</option>
												</c:forEach>
											</c:forEach>

											<option selected></option>


										</select>
									</div>


									<label for="thirdName"
										class="col-sm-2 col-sm-offset-1 control-label">父类权限：</label>
									<div class="col-sm-2 ">
										<select class="form-control" name="parentName"  id="parentName">
											<option selected></option>
											<c:forEach items="${funcMap}" var="map">
												<option>${map.value.functionName}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="prtName" class="col-sm-2 control-label">URL：</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" name="url" id="url"
											placeholder="URL" required>
									</div>

									<label for="thirdName" class="col-sm-1  control-label">类型：</label>
									<div class="col-sm-2 ">
										<select class="form-control" name="type"   id="type">
											<option>0</option>
											<option>1</option>
										</select>
									</div>
								</div>
								<!-- /.第五行-->
								<div class="form-group">
									<div class="col-sm-offset-4 col-sm-2">
										<button type="submit" class="btn btn-primary btn-block" title="修改权限">更新</button>
									</div>
								</div>

							</fieldset>
						</form>
						<script>
							var loadFunction = function(funcName) {
								console.log(funcName);
								$
										.ajax({
											url : basePath
													+ "/admin/system/ajax/loadFunction",
											type : "post",
											dataType : "json",
											data : {
												funcName : funcName
											},
											success : function(data) {
												
												$("#url").val(data['url']);
												$("#parentName").val(data['parentName']);
												$("#type").val(data['type']);
									
											var obj=eval(data);
											for(var index in data){
												
												console.log(data[index]+"123");
											}
											
										
											},
											error : function() {

												console.log("error");
											}
										});
							}
							$(document).ready(function() {
								console.log("ready");
								$("#funcList").change(function() {
									console.log($(this).val());
									loadFunction($(this).val());
								});

							});
						</script>

					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
</html>