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
<script
	src="${base}/static/front/js/personal/laydate-master/laydate.dev.js"></script>
</head>
<style>
.info-text {
	padding-top: 100px;
}
.info-img {
	padding-top: 100px;
}
</style>
<body>
	<jsp:include page="/WEB-INF/layout/web/navbar.jsp"></jsp:include>
	<div class="container">
		<div class="row clearfix  page-header">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<jsp:include page="/WEB-INF/layout/web/personalNav.jsp"></jsp:include>
					<div class="col-md-8  col-md-offset-2 column  info-text">
						<form class="form-horizontal" role="form" id="personInfoFrom"
							method="post"  action="${base}/front/personal/modifyPwAction">
							<div class="form-group">
								<label class="col-sm-3 control-label">用户名</label>
								<div class="col-sm-4">
									<p class="form-control-static">${userName}</p>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-3 control-label">旧密码</label>
								<div class="col-sm-4">
									<input type="password" class="form-control" name="oldPassword" required
										id="oldPassword">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-3 control-label">新密码</label>
								<div class="col-sm-4">
									<input type="password" class="form-control" name="newPassword" required
										id="newPassword">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-3 control-label">重复密码</label>
								<div class="col-sm-4">
									<input type="password" class="form-control" required
										name="twicePassword" id="twicePassword">
								</div>
							</div>
							<div class="form-group has-success has-feedback">
								<label class="control-label col-sm-3 sr-only"
									for="inputGroupSuccess4">Input group with success</label>
								<div class="col-sm-2">
									<button type="resize" class="btn btn-default">重置</button>
								</div>
								<div class="col-sm-2">
									<button type="submit" class="btn btn-primary">保存</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
<script>
	$(document).ready(function() {

	});
</script>
</html>