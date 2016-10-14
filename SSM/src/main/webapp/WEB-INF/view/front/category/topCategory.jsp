<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>${webTitle}</title>
<meta charset="utf-8">
<link rel="stylesheet" href="${base}/static/common/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${base}/static/common/css/no-responsive.css">

<script src="${base}/static/common/js/jquery-2.0.0.min.js"></script>
<script src="${base}/static/common/js/bootstrap.min.js"></script>
<script src="${base}/static/common/js/imagesloaded.pkgd.js"></script>
<script src="${base}/static/common/js/masonry.pkgd.min.js"></script>

<style>
.grid-item img {
	height: 200px !important;
}

.thumbnail {
	height:310px !important;
}

section{
  padding-top: 60px;
  margin-top: -35px;
}

 body {
    
      padding-top:60px;
  }
  .affix {
      top: 200px;
	  left:50px;
  }
  
      ul.nav-pills{
        width: 140px;
        margin-top: 20px;
        border-radius: 4px;
        border: 1px solid #ddd;
        box-shadow: 0 1px 4px rgba(0, 0, 0, 0.067);
    }
    ul.nav-pills li{
        margin: 0;
        border-top: 1px solid #ddd;
    }
    ul.nav-pills li:first-child{
        border-top: none;
    }
    ul.nav-pills li a{
        margin: 0;
        padding: 8px 16px;
        border-radius: 0;
    }
    ul.nav-pills li.active a, ul.nav-pills li.active a:hover{
        color: #fff;
        background: #E95420;
        border: 1px solid #E95420;
    }
    ul.nav-pills li:first-child a{
        border-radius: 4px 4px 0 0;
    }
    ul.nav-pills li:last-child a{
        border-radius: 0 0 4px 4px;
    }
  
</style>
<script>
	$(document).ready(function() {
		var $container = $('.masonry-container');
		$container.imagesLoaded(function() {
			$container.masonry({
				columnWidth : '.grid-item',
				itemSelector : '.grid-item',
			});
		});
		
		
		
		$(window).resize(function(){
			x=$(".container").offset().left;
			console.log(x);
			var width=$("#myscroll").width();
			var left=x-width;
			console.log(top+"px");
			$(".affix").css("left",left+"px");	
		})
	});
</script>
</head>
<body data-spy="scroll" data-target="#myscroll"  data-offset="15">
	<jsp:include page="/WEB-INF/layout/web/navbar.jsp"></jsp:include>
	<!-- /头部导航End -->
	<div class="container ">
		<div class="row clearfix " style="padding-top: 50px">
			<div class="col-md-12 column">
				<jsp:include page="/WEB-INF/layout/web/nav.jsp"></jsp:include>
				<div class="row clearfix">
					<nav class="col-md-2  col-xs-2 hidden-phone" id="myscroll">
						<ul class="nav nav-pills nav-stacked " data-spy="affix" data-offset-top="150">
							<c:forEach items="${thirdPrtMap}" var="thirdMap" varStatus="ss">
	
							<li class=""><a href="#s${ss.index}"><i class="icon-chevron-right"></i>${thirdMap.key}</a></li>
							</c:forEach>
						</ul>
					</nav>
					<div class="col-md-10 col-xs-10 column">
						<div class="carousel slide" id="carousel-981955">
							<ol class="carousel-indicators">
								<li class="active" data-slide-to="0"
									data-target="#carousel-981955"></li>
								<li data-slide-to="1" data-target="#carousel-981955"></li>
								<li data-slide-to="2" data-target="#carousel-981955"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<img alt=""
										src="${base}/static/front/images/index/3.jpg"" />
									<div class="carousel-caption">
								
									</div>
								</div>
								<div class="item">
									<img alt=""
										src="${base}/static/front/images/index/4.jpg"" />
									<div class="carousel-caption">
									
									</div>
								</div>
								<div class="item">
									<img alt=""
										src="${base}/static/front/images/index/5.jpg"" />
									<div class="carousel-caption">
								
									
									</div>
								</div>
							</div>
							<a class="left carousel-control" data-slide="prev"
								href="#carousel-981955"><span
								class="glyphicon glyphicon-chevron-left"></span></a> <a
								class="right carousel-control" data-slide="next"
								href="#carousel-981955"><span
								class="glyphicon glyphicon-chevron-right"></span></a>
						</div>
					</div>
				</div>

<script>


</script>
				

	<c:forEach items="${thirdPrtMap}" var="thirdMap" varStatus="s">
			<section id="s${s.index}">
				<div class="row" style="margin-top: 50px; padding: 0px 30px;"
					>
					<div class="col-md-12 col-xs-10 pull-right"
						style="background-color: #E95420; color: white;">
						<strong><span>${thirdMap.key}</span></strong><span class="pull-right"><a style="color:white;"
							href="${base}/front/thirdCategory/${thirdMap.value[1].thirdId}"><small>更多</small></a></span>
					</div>
				</div>
				<!-- 商品-->
				<div class="row clearfix">
					<div class="col-md-12 col-xs-10 pull-right">
					<c:choose>
					<c:when test="${thirdMap.value==null||fn:length(thirdMap.value)==0 }" >
						<div class="col-md-12 text-center" >
						<p>没有相关商品</p>
						</div>
					</c:when>
					<c:otherwise>	<!--商品列表-->
						<div class="masonry-container">
						
						<c:forEach items="${thirdMap.value}" var="product">
							<div class="col-md-3  col-xs-6 grid-item">
								<div class="thumbnail">
									<img src="${imagePath}/${product.primImage.imageName}" />
									<div class="caption">
									
									<a href="${base}/front/product/${product.prtId}">
										${product.prtName}
									
									</a>
										<p><strong>${product.price}</strong><span>￥</span></p>
									</div>
								</div>
							</div>
							</c:forEach>
						</div>
						<!-- ./商品列表 -->
						
						</c:otherwise>
					
					</c:choose>
					
					</div>
				</div>
				</section>
	</c:forEach>
				
				
					<!--/商品列表-End-->
				
				
				
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
</html>