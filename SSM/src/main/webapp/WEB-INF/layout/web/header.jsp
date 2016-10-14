<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>${webTitle}</title>
<link href="${base}/static/front/css/header.css" rel="stylesheet" type="text/css">

<script src="${base}/static/front/head/jquery-1.7.2.min.js"></script>
<script src="static/front/head/jquery.movebg.js"></script>
<script type="text/javascript" src="${base}/static/front/head/zySearch.js"></script>
<script type="text/javascript" src="${base}/static/front/js/header/header.js"></script>
<script type="text/javascript">


$(document).ready(function(){
	var index=${navMap};
	console.log("test2"+index);
/*
	$("#topNav").find("li").removeClass("cur").each(function(i){
		if(i==index){
			console.log($(this).text());		
			$(this).addClass("cur");
		}		
	});
	<link href="${base}/static/front/css/header/searchstyle.css" rel="stylesheet" type="text/css">
	*/
	
	cssNavigation();/* 设置当前导航栏*/
	
});

</script>
</head>

<header>
	
<!-- 代码 开始 -->
<div class="wraper">


<div class="weblogo">
<img alt="140x140" src="${base}/static/front/images/header/weblogo.jpg" style="width:80px;height:80px;"/>
</div>
	<!-- 搜索栏设置*/ 
<div class="searchbox">
	<ul class="border1">
		<li><a href="#" class="style1">宝贝</a></li>
		<li><a href="#">商城</a></li>
		<li><a href="#">店铺</a></li>
	</ul>
	<div class="bodys">
		<p><input type="text" value="" id="" class="one" placeholder="输入宝贝" /><button class="one1">搜索</button></p>
		<p><input type="text" value="" id="" class="two" placeholder="输入宝贝" /><button class="two2">搜索</button></p>
		<p><input type="text" value="" id="" class="three" placeholder="输入店铺" /><button class="three3">搜索</button></p>
	</div>
</div>
-->
<!-- 搜索栏 
<div class="zySearch" id="zySearch" style="padding:0px 0px 0px 100px;"></div>
-->
    <div class="navdiv" id="topNav">
        <ul>
            <li class="nav-item "><a href="${base}/index" target="_self">网站首页</a></li>
            <li class="nav-item "><a href="${base}user/index" target="_self">网上商城</a></li>
            <li class="nav-item"><a href="javascript:void(0)" target="_self">智能管家</a></li>
            <li class="nav-item"><a href="javascript:void(0)" target="_self">技术支持</a></li> 
            <li class="nav-item"><a href="javascript:void(0)" target="_self">应用案例</a></li> 
            <li class="nav-item"><a href="javascript:void(0)" target="_self">关于我们</a></li>
            <li class="nav-item"><a href="javascript:void(0)" target="_self">站长素材</a></li>
        </ul>
        <!--移动的滑动-->
        <div class="move-bg"></div>
        <!--移动的滑动 end-->
    </div>
</div>
<script>
$(function(){
	console.log('${navIndex}');
	/*setSearch(); 搜索栏设置*/
	$(".navdiv").movebg({width:120/*滑块的大小*/,extra:40/*额外反弹的距离*/,speed:300/*滑块移动的速度*/,rebound_speed:400/*滑块反弹的速度*/});

	
});
/* 搜索栏设置*/
$("#zySearch").zySearch({
	"width":"355",
	"height":"33",
	"parentClass":"pageTitle",
	"callback":function(keyword){
		console.info("搜索的关键字");
		console.info(keyword);
	}
});
</script>

<!-- 代码 结束 -->


</header>