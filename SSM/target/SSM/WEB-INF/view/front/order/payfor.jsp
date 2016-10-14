<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>

<head>
<title>${webTitle}</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="">
<link rel="stylesheet" href="${base}/static/common/css/bootstrap.min.css">


</head>

<body data-spy="scroll" data-target=".nav-pills" data-offset="100">
<div class="container page-header">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="jumbotron text-center">
				<h1>
					支付页面
				</h1>
				<p>
					<img  src="${base}/static/front/order/payfor.png"></img>
				</p>
				<div class="col-md-2 col-md-offset-1">
				
				<p>
					 <button class="btn btn-primary btn-large" onClick="window.history.back()">返回</button>
				</p>
				</div>
				
				
				<div class="col-md-2 col-md-offset-6">
				
				<p>
					 <a class="btn btn-primary btn-large" href="${base}/front/order/payforSuccess?orderId=${orderId}&passKey=${passKey}">完成支付</a>
				</p>
				
				</div>

				</div>
		</div>
	</div>
</div>
	

<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
</html>
