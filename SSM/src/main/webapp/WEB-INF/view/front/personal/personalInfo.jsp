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
<script src="${base}/static/front/js/personal/laydate-master/laydate.dev.js"></script>
</head>

<style>
.info-text{
padding-top:100px;

}
.info-img{
padding-top:100px;

}

</style>

<body>
	<jsp:include page="/WEB-INF/layout/web/navbar.jsp"></jsp:include>
	<div class="container">
		<div class="row clearfix  page-header">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<jsp:include page="/WEB-INF/layout/web/personalNav.jsp"></jsp:include>
					<div class="col-md-7 col-md-offset-1 column info-text">
						<form class="form-horizontal" role="form" id="personInfoFrom"
							method="post" action="${base}/front/personal/modifyInfo">
							<div class="form-group">
								<label class="col-sm-2 control-label">用户名</label>
								<div class="col-sm-3">
									<p class="form-control-static">${user.userName}</p>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-2 control-label">昵称</label>
								<div class="col-sm-3">
									<input required   type="text" class="form-control" name="newNickname"
										id="newNickname" value="${user.nickname}">
								</div>
							</div>
							<div class="form-group">
								<label for="sex" class="col-sm-2 control-label">性别</label>
								<div class="col-md-1">
									<label class="radio-inline"> <input type="radio"
										name="newSex" id="sex1" value="1"  <c:if test="${user.sex==1}"> checked </c:if>>男
									</label>
								</div>
								<div class="col-md-1">
									<label class="radio-inline"> <input type="radio"
										name="newSex" id="sex0" value="0"  <c:if test="${user.sex==0}"> checked </c:if>> 女
									</label>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-2 control-label">真实姓名</label>
								<div class="col-sm-3">
									<input required      type="text" class="form-control" id="newActualName" name="newActualName"
										 value="${user.actualName }">
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputPassword" class="col-sm-2 control-label">手机号码</label>
								<div class="col-sm-3">
									<input required   type="text" class="form-control" name="newTel"
										 value="${user.tel}">
								</div>
							</div>
							<div class="form-group">
								<label for="birth" class="col-sm-2 control-label">出生日期</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="newBirthDate"  name="newBirthDate" value="<fmt:formatDate value='${user.birthDate}' pattern='yyyy-MM-dd '/>">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-2 control-label">身份证</label>
								<div class="col-sm-5">
									<input required   type="text" class="form-control" id="newIdnumber"
									name="newIdnumber" 
										value="${user.idnumber}">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-2 control-label">住址</label>
								<div class="col-sm-8">
									<input required   type="text" class="form-control" id="newAddress" name="newAddress"
										value="${user.address }">
								</div>
							</div>
							<div class="form-group has-success has-feedback">
								<label class="control-label col-sm-1 sr-only"
									for="inputGroupSuccess4">Input group with success</label>
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">保存</button>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-2 info-img">
						<img style="width: 200px; height: 200px" src="${base}/front/personal/getHead" />
					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>

<script>
$(document).ready(function(){


	laydate({
            elem: '#birth'
        }); 

});

</script>

</html>