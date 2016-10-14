<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>

<head>
<title>${webTitle}</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${base}/static/common/css/bootstrap.min.css">
  <link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="${base}/static/common/js/jquery-2.0.0.min.js"></script>
  <script src="${base}/static/common/js/bootstrap.min.js"></script>
   <script src="${base}/static/admin/js/header/adminHeader.js"></script>
</head>

<body   data-spy="scroll" data-target=".nav-pills" data-offset="100">
			
				
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
				
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
</html>