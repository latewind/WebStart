<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>${webTitle}</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script>
	
<%--JS gloable varilible--%>
	var basePath = "${base}";
</script>

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
.col-list{
	margin-left: 20px !important;

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
					<div class="col-md-10 column ">
						<!-- 加入具体内容-->
						<form class="form-horizontal" method="post" id="funcForm"
							enctype="multipart/form-data"
							action="${base}/admin/system/addUser">
							<!-- 第二行-->
							<div class="form-group col-md-12">
								<label for="thirdName" class="col-sm-5  control-label">选择身份：</label>
								<div class="col-sm-2 ">
									<select class="form-control" name="role" id="role" title="查看权限">
										<c:forEach items="${roleList }" var="role">
											<option>${role.roleName}</option>
										</c:forEach>
									</select>
								</div>
							</div>






							<c:forEach items="${funcMap}" var="map">
								<div class="form-group col-md-2 col-list">
									<label for="thirdName" class="  control-label">${map.value.functionName}：</label>
									<c:forEach items="${map.value.childList}" var="func"
										varStatus="s">
										<div class="input-group    ">
											<span class="input-group-addon"> <input
												type="checkbox" aria-label="..." value="${func.functionId}">
											</span> <input type="text" class="form-control" aria-label="..."
												readonly value="${func.functionName}">
										</div>
									</c:forEach>
									<!-- /input-group -->
								</div>
							</c:forEach>
							<div class="form-group col-md-12 ">
								
								<div class="col-sm-2 col-sm-offset-3 ">
									<button type="reset" class="btn btn-default">重置</button>
								</div>
								<div class="col-sm-2 ">
									<button type="button" id="submitFunc" class="btn btn-primary" title="变更权限">提交</button>
								</div>
							</div>
							<script>
								var loadRoleFunc = function(roleName) {
									console.log(roleName);
									$
											.ajax({
												url : basePath+"/admin/system/ajax/roleFunc",
												type : "post",
												dataType : "json",
												data : {
													roleName : roleName
												},
												success : function(data) {
													//全部取消选择
													$("#funcForm :checkbox")
															.prop("checked",
																	false);
													var obj = eval(data);
													//console.log(obj['func']);
													var funcArray = obj['func']
													for ( var index in funcArray) {
														var id = funcArray[index]['functionId'];
														console.log(id);
														//为选中的元素添加选中
														$(
																"#funcForm :checkbox[value='"
																		+ id
																		+ "']")
																.prop(
																		"checked",
																		true);
													}
												},
												error : function() {

													console.log("error");
												}
											});
								}
								$(document)
										.ready(
												function() {

													$("#submitFunc")
															.click(
																	function() {
																		var roleName = $(
																				"#role")
																				.val();
																		var funcList = [];
																		//获取选中元素的值
																		var t = $(":checkbox:checked");
																		t
																				.each(function() {
																					console
																							.log($(
																									this)
																									.val());
																					funcList
																							.push(parseInt($(
																									this)
																									.val()));
																				});
																		var sendData = {};
																		sendData["roleName"] = roleName;
																		sendData["funcId"] = funcList;
																		$
																				.ajax({
																					url : basePath+"/admin/system/ajax/submitFunc",
																					type : "post",
																					dataType : "text",
																					contentType : "application/json",
																					data : JSON
																							.stringify(sendData),
																					success : function(
																							data) {
																						console
																								.log("success");
																						document.location.href = location;
																					},
																					error : function() {
																						console
																								.log("error");
																					}
																				});
																	});
													//切换角色 获取权限
													$("#role")
															.change(
																	function() {

																		console
																				.log($(
																						this)
																						.val());

																		loadRoleFunc($(
																				this)
																				.val());
																	});
													//初始化数据
													var initSel = $("#role")
															.val();
													loadRoleFunc(initSel);

													//获取选中元素的值
													//			var t = $(":checkbox:checked");
													//		t.each(function() {

													//		console.log($(this).val());
													//	});
												});
							</script>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
</html>