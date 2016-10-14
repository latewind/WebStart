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
					<div class="col-md-8 column col-md-offset-2">
						<!-- 加入具体内容-->
						<form class="form-horizontal" method="post"
							enctype="multipart/form-data"
							action="${base}/admin/user/addUserAction">
							<script>
								$(document).ready(function() {
								})
							</script>
							<div class="form-group">
								<label for="prtName" class="col-sm-2 control-label">登录名：</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" required
										name="loginName" placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="prtName" class="col-sm-2 control-label">登录密码：</label>
								<div class="col-sm-4">
									<input type="password" class="form-control" i
										name="oncePassword" placeholder="登录密码:" required>
								</div>
							</div>
							<div class="form-group">
								<label for="prtName" class="col-sm-2 control-label">再次输入：</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" name="twicePassword"
										placeholder="再次输入密码:" required>
								</div>
							</div>
							<div class="form-group">
								<label for="prtName" class="col-sm-2 control-label">真实姓名：</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" name="actualName"
										placeholder="">
								</div>
							</div>
							<!-- 第二行-->
							<div class="form-group">
								<label for="thirdName" class="col-sm-2  control-label">身份选择：</label>
								<div class="col-sm-2 ">
									<select class="form-control" name="role">
									
									<c:forEach items="${roleList }" var="role">
										<option>${role.roleName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2  control-label sr-only">提交：</label>
								<div class="col-sm-1 ">
									<button type="reset" class="btn btn-default">重置</button>
								</div>
								<div class="col-sm-2 ">
									<button type="submit" class="btn btn-primary">提交</button>
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
										maxFilesNum : 10,
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