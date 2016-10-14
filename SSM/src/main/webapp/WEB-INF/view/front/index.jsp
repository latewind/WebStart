<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>${webTitle}</title>
<link href="${base}/static/front/css/index/index.css" rel="stylesheet" type="text/css">
<link href="${base}/static/front/css/index/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base}/static/common/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${base}/static/common/js/jquery-ui.js"></script>
<link href="${base}/static/common/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="${base}/static/common/js/bootstrap.min.ol.js"></script>
<script type="text/javascript" src="${base}/static/front/js/index/index.js"></script>
<script>
</script>
</head> 
<body>
<!-- 加载头页面  -->
  <jsp:include page="/WEB-INF/layout/web/header.jsp"></jsp:include>
  <jsp:include page="/WEB-INF/layout/web/rightnav.jsp"></jsp:include> 
  <!-- 正文开始 -->
  <div id="contain">
  <div class="container-fluid" >
	<div class="row-fluid">
		<div class="span2">
			<img alt="140x140" src="img/a.jpg" />
		</div>
		<div class="span8">
		</div>
		<div class="span2">
			 <button class="btn" type="button">按钮</button> <button class="btn" type="button">按钮</button>
		</div>
	</div>
	<div class="row-fluid">
	<!-- Start 商品分类
		<div class="span2">
			<ul class="nav nav-list well" id="rightNav">
				<li class="nav-header">
					商品分类
				</li>
				<c:forEach var="category" items="${categoryList}">
				<li>
					<a href="/category/${category.id}">${category.name}</a>
				</li>				
				
				</c:forEach>
				
				
			</ul>
		</div>
		-->
		<!-- End 商品分类 -->
		
			<!-- Start 商品分类-->
		<div class="span2">
			<ul class="nav nav-list well" id="rightNav">
				<li class="nav-header">
					商品分类
				</li>
				<c:forEach var="tMap" items="${topMap}">
				<li class="nav-li-left"  subId=${tMap.key }>
					<c:forEach var="subCategory" items="${tMap.value}" varStatus="substatus">
						<!-- 左侧导航只显示3个2级分类 -->
						<c:if test="${substatus.count<4 }">			
						<a  style="" class="nav-a-left" href="/front/subcategory/${subCategory.id}">&nbsp;&nbsp;${subCategory.name}&nbsp;</a>
						</c:if>	
					</c:forEach>		
				</li>	
				<!-- 展开分类 START -->
				<div class="sub-item-rignt item-list" >
				<div class="subitem">
				
					<c:forEach var="subCategory2" items="${tMap.value}">
					<dl>
							<dt><a href="/front/subCategory/${subCategory2.id}">${subCategory2.name}</a></dt>
							<dd>
							<c:forEach  var="thirdCategory" items="${subCategory2.thirdCategories}">
								<em><a href="/front/thirdCategory/${thirdCategory.id}">${thirdCategory.name }</a></em>
							</c:forEach>
							</dd>
						</dl>
					</c:forEach>
				
					</div>
				</div>	
				<!-- 展开分类 END-->
						
				</c:forEach>
				
				
			</ul>
		</div>
		<!-- End 商品分类 -->
		
		<!-- Start 中央幻灯片 -->
		<div class="span8">
			<div class="carousel slide" id="carousel-668027">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-668027">
					</li>
					<li data-slide-to="1" data-target="#carousel-668027">
					</li>
					<li data-slide-to="2" data-target="#carousel-668027" class="active">
					</li>
				</ol>
				
				<div class="carousel-inner">
					<div class="item">
						<img class="center-img" alt="" src="${base}/static/front/images/index/3.jpg" />
						<div class="carousel-caption">
							<h4>
								棒球
							</h4>
							<p>
								棒球运动是一种以棒打球为主要特点，集体性、对抗性很强的球类运动项目，在美国、日本尤为盛行。
							</p>
						</div>
					</div>
					<div class="item">
						<img class="center-img" alt="" src="${base}/static/front/images/index/4.jpg" />
						<div class="carousel-caption">
							<h4>
								冲浪
							</h4>
							<p>
								冲浪是以海浪为动力，利用自身的高超技巧和平衡能力，搏击海浪的一项运动。运动员站立在冲浪板上，或利用腹板、跪板、充气的橡皮垫、划艇、皮艇等驾驭海浪的一项水上运动。
							</p>
						</div>
					</div>
					<div class="item active">
						<img  class="center-img" alt="" src="${base}/static/front/images/index/5.jpg" />
						<div class="carousel-caption">
							<h4>
								自行车
							</h4>
							<p>
								以自行车为工具比赛骑行速度的体育运动。1896年第一届奥林匹克运动会上被列为正式比赛项目。环法赛为最著名的世界自行车锦标赛。
							</p>
						</div>
					</div>
				</div> <a class="left carousel-control" data-slide="prev" href="#carousel-668027">‹</a> <a class="right carousel-control" data-slide="next" href="#carousel-668027">›</a>
			</div>
		</div>
			<!-- End 中央幻灯片 -->
		
		<!-- Start右侧 分页页版 -->
		<div class="span2">
			<div class="tabbable" id="tabs-163148">
				<ul class="nav nav-tabs">
					<li>
						<a href="#panel-721364" data-toggle="tab">昨日热销</a>
					</li>
					<li class="active">
						<a href="#panel-152214" data-toggle="tab">今日推荐</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane" id="panel-721364">
						<p>
							第一部分内容.
						</p>
					</div>
					<div class="tab-pane active" id="panel-152214">
						<p>
							第二部分内容.
						</p>
					</div>
				</div>
			</div>
		</div>
		<!-- End 右侧 分页页版 -->
		
	</div>
	
	<!-- Start 加入购物车提示消息 -->
		<div class="alert alert-success" id="alertMsg">
				<h4>
					提示!
				</h4> <strong>提示!</strong> 成功加入购物车
			</div>
		</div>
		
		
	<!-- End 提示消息 -->
	
	<c:forEach items="${map}" var="m">
	
	
	
	<div class="row-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="page-header">
						<h1>
							<small>${m.key}</small>
						</h1>
					</div>
				</div>
			</div>	
				
				<!-- 获取产品列表长度 -->
				<c:set var="length" value="${fn:length(m.value)}" />
				<!-- 遍历长度 -->
			<c:forEach  var ="i"  begin="0" end="${length}" varStatus="status">
				<!-- 没四次执行产生一个ul -->
				<c:if test="${status.index%4==0}">			
					<ul class="thumbnails">
					<!-- 每个ul产生4个li -->
						<c:forEach var="product" items="${m.value}" varStatus="s" begin="${status.index}" end="${status.index+3}">
							<li class="span3">
								<div class="thumbnail">
								<img alt="300x200" src="${imagePath}/${product.primImage.imageName}" />
											<div class="caption">
														<h2>
															${product.prtName}
														</h2>
														<p>
														${product.describ}
														</p>
														<p>
															<a class="btn btn-primary" href="/front/product/${product.prtId}">浏览</a> <a class="btn" href="javascript:void(0)" onclick="showAlertMsg(this)">加入购物车</a>
														</p>
											</div>
								</div>
							</li> 
					</c:forEach>
				</ul>
				</c:if>
				
			</c:forEach>
	</div>
	
</c:forEach>
	
	<div>
	Test
	<img src="${imagePath}/${productInfo.primImage.imageName}"/>
	<c:out value="${productInfo.primImage.imageName}"/>
	</div>
	
</div>
  
<jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
</html>