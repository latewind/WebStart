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
							action="${base}/admin/notice/updateHeadlineAction">
						<div class="form-group">
							<label for="prtName" class="col-sm-2 control-label">头条标题：</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="title" value="${headline.title }"
									placeholder="头条标题" required>
							</div>
						</div>
						<div class="form-group">
							<label for="prtName" class="col-sm-2 control-label">链接：</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="pageLink" value="${headline.pageLink }"
									placeholder="内容链接" required>
							</div>
						</div>
						<!-- 第五行-->
						<div class="form-group">
							<label for="intro" class="col-sm-2   control-label ">内容：</label>
							<div class=" col-sm-7 ">
								<textarea class="form-control" rows="5" 
									name="content"> ${headline.content}</textarea> 
							</div>
						</div>
						<!-- /.第五行-->
						<!-- 第三行-->
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