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


<script>
	
</script>

<style>
.well form {
	padding: 20px;
}
</style>
<body>


	<div class="jumbotron  text-center">
		<h1>后台登录</h1>

	</div>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">

				<div class="row clearfix ">

					<div class="col-md-4 column  col-md-offset-4 well">

						<form action="${base}/admin/user/loginAction" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">用户名</label> <input type="email"
									class="form-control" id="exampleInputEmail1" name="loginName"
									placeholder="example@example.com" required>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">密码</label> <input name="password"
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="密码" required>
							</div>

							<div class="checkbox">
								<label> <input type="checkbox" name="autoLogin"> 自动登录
								</label>
							</div>
							<button type="submit" class="btn btn-primary btn-block">登录</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
</html>