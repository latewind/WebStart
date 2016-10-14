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
					<div class="col-md-8 column col-md-offset-2">
						<!-- 加入具体内容-->
						<form class="form-inline  " style="" method="post"
							action="${base}/admin/system/createRoleAction">
							<div class="form-group">
								<label>创建角色：</label> <input class="form-control" name="newRole"
									placeholder="输入角色名" required type="text">
							</div>
							<button class="btn btn-default" type="submit" >确定</button>
						</form>
						<form class="form-inline  " method="post"
							action="${base}/admin/system/updateRoleAction">
							<div class="form-group">
								<label>选择角色：</label> <select class="form-control"
									name="origRole" id="role">
									<c:forEach items="${roleList }" var="role">
										<option>${role.roleName}</option>
									</c:forEach>
								</select> <input class="form-control" placeholder="输入新角色名" required
									name="newRole" id="updateInput" type="text">
							</div>
							<button class="btn btn-default" type="submit" title="">更改</button>
						</form>


						<script>
							$(document).ready(function() {
								//切换角色 获取权限
								$("#role").change(function() {
									console.log($(this).val());
									$("#updateInput").val($(this).val());
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