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

<link rel="stylesheet"
	href="${base}/static/common/css/dataTables.bootstrap.min.css">
<script
	src=" ${base}/static/common/js/jquery.dataTables.min.js"></script>
<script
	src="${base}/static/common/js/dataTables.bootstrap.min.js"></script>
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
						<div class="table-responsive">
						<table id="example" class="table table-striped table-bordered"
							cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>公告ID</th>
									<th>公告标题</th>
									<th>公告链接</th>
									<th>修改时间</th>
									<th>操作</th>

								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>公告ID</th>
									<th>公告标题</th>
									<th>公告链接</th>
									<th>修改时间</th>
									<th>操作</th>
								</tr>
							</tfoot>
							<tbody>

								<c:forEach items="${anList}" var="anno">
									<tr>
										<td>${anno.announId}</td>
										<td>${anno.announTitle}</td>
										<td>${anno.announAnchor}</td>
										<td>[<fmt:formatDate value="${anno.announTime}"
												pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
										<td><a href="#" onclick="updateNotice(this,'${base}');">更新</a></td>

									</tr>
								</c:forEach>

							</tbody>
						</table>

				</div>




						<!-- 更新面板 -->
						<div class="modal fade" id="updateDlg" tabindex="-1" role="dialog"
							aria-labelledby="">
							<div class="modal-dialog  " role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="">更新公告</h4>
									</div>
									<div class="modal-body">
										<form class="form-horizontal" role="form" id="loginMinForm"
											method="post">
											<div class="form-group">
												<div class="col-sm-12 text-center" id="alertLoginMsg"
													style="color: red; height: 15px; display: block;"></div>
											</div>
											
											
														<div class="form-group ">
												<label class="control-label col-sm-1 sr-only"
													for="inputSuccess3"></label>
												<div class="col-sm-2">
													<div class="input-group ">
														<span class="input-group-addon"><span
															class=" glyphicon glyphicon-header "></span></span> <input
															type="text" class="form-control" id="announId" name="title"
															aria-describedby="inputSuccess3" data-toggle="manual" readonly
															required placeholder="" title="">
													</div>
												</div>
											</div>
											
											
											
											
											<div class="form-group ">
												<label class="control-label col-sm-1 sr-only"
													for="inputSuccess3"></label>
												<div class="col-sm-10">
													<div class="input-group ">
														<span class="input-group-addon"><span
															class=" glyphicon glyphicon-header "></span></span> <input
															type="text" class="form-control" id="announTitle" name="title"
															aria-describedby="inputSuccess3" data-toggle="manual"
															required placeholder="输入标题" title="">
													</div>
												</div>
											</div>




											<div class="form-group">
												<label class="control-label col-sm-1 sr-only"
													for="inputGroupSuccess2"></label>
												<div class="col-sm-10">
													<div class="input-group">
														<span class="input-group-addon"><span
															class=" glyphicon glyphicon-link "></span></span> <input
															type="text" class="form-control" id="announLink" name="link"
															aria-describedby="inputGroupSuccess2Status"
															placeholder="输入链接" data-toggle="manual" title="不能为空">
													</div>
												</div>
											</div>



											<div class="form-group has-success has-feedback">
												<label class="control-label col-sm-1 sr-only"
													for="inputGroupSuccess4">Input group with success</label>
												<div class="col-sm-10">
													<button type="button" class="btn btn-primary btn-block"
														id="loginBtn" onClick="submitUpdate(this,'${base}')">更新</button>

												</div>
											</div>
										</form>

									</div>
									<div class="modal-footer"></div>
								</div>
							</div>
						</div>
						<!--  /.更新面板 -->


						<script>
							var submitUpdate = function(elem, path) {

								var id=$("#announId").val();
								var title=$("#announTitle").val();
								var link =$("#announLink").val();
								if (title != null && link != null) {

									$
											.ajax({

												url : 
														path+ "/admin/ajax/notice/updateAnnounAction",
												dataType : "text",
												type:"post",
												data : {
													id:id,
													title:title,
													link:link
												},
												success : function() {
													$("#updateDlg").modal(
															'hide');
													
													setTimeout(function(){
														location.reload();
	
													},1000)
													
												}

											});

								}
							}

							var updateNotice = function(elem, path) {
								var $td=$(elem).parent();
								var id=$($td.siblings().get(0)).text();
								var title=$($td.siblings().get(1)).text();
								var link=$($td.siblings().get(2)).text();
								$("#updateDlg").modal('show');
								$("#announId").val(id);
								$("#announTitle").val(title);
								$("#announLink").val(link);
							}

							$(document).ready(function() {
								$('#example').DataTable();
							});
						</script>
					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
</html>