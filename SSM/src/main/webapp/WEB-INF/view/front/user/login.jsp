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
  
 
  	<script>
	</script>
  
  <style>
  body{
  
  padding-top:60px;
  }
  
  </style>
  
</head>

<body   data-spy="scroll" data-target=".nav-pills" data-offset="100">
				
<div class="container-fluid">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="jumbotron text-center">
				<h1 >
					欢迎登陆!
				</h1>
				<p>
				</p>
			
			</div>
			<div class="row clearfix">
				<div class="col-md-8 column">
					<!--  头部公告 -->
				<div class="jumbotron well ">
					<h1 style="color:#337AB7">${ headline.title }</h1>
					<blockquote><p><em>${ headline.content }</em></p></blockquote>
					<p>
						<a class="btn btn-primary btn-large" href="${ headline.pageLink }">立即前往</a>
					</p>
				</div>
				</div>
				<div class="col-md-3 column well">
				
							<form action="${base}/front/user/loginPageAction" method="post" >
						  <div class="form-group">
							<label for="exampleInputEmail1">用户名</label>
							
							<input type="email" class="form-control" id="exampleInputEmail1"  name="userName" placeholder="example@example.com" required>
						  </div>
						  <div class="form-group">
							<label for="exampleInputPassword1">密码</label>
							<input type="password" class="form-control" id="exampleInputPassword2" name="password" placeholder="密码" required>
						  </div>
				
						  <div class="checkbox">
							<label>
							  <input type="checkbox" name="autoLogin"> 自动登录
							</label>
						  </div>
						  
					  
						  <input type="hidden" name="origPage" value="${origPage}">
						  <button type="submit" class="btn btn-primary btn-block">登录</button>
						</form>
				
				
				
				
				</div>
			</div>
		</div>
	</div>
</div>	
				
				
	
<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
</html>