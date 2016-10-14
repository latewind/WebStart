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


<body data-spy="scroll" data-target=".nav-pills" data-offset="100">
	<div class="container-fluid">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- 加入头Header-->
			<div class="jumbotron  text-center">
		<h1>Sorry,你没有相关权限！</h1>
			
	</div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
</html>