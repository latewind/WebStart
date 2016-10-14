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
		
		
						${msg}
		
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