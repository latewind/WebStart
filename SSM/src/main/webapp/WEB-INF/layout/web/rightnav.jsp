<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>${webTitle}</title>
<link rel="stylesheet" href="${base}/static/front/css/rightnav/zzsc.css"/>
</head>
<!-- 代码 开始 -->
<div id="leftsead">
	<ul>
		<li>
			<a href="javascript:void(0)" class="youhui">
				<img src="${base}/static/front/images/rightnav/l02.png" width="47" height="49" class="shows" />
				<img src="${base}/static/front/images/rightnav/a.png" width="57" height="49" class="hides" />
				<img src="${base}/static/front/images/rightnav/weixin.jpg" width="145" class="2wm" style="display:none;margin:-100px 57px 0 0" />
			</a>
		</li>
		<li>
			<a href="http://wpa.qq.com/msgrd?v=3&uin=800000000&site=qq&menu=yes" target="_blank">
				<div class="hides" style="width:161px;display:none;" id="qq">
					<div class="hides" id="p1">
						<img src="${base}/static/front/images/rightnav/ll04.png">
					</div>
					<div class="hides" id="p2"><span style="color:#FFF;font-size:13px">800000000</span>
					</div>
				</div>
				<img src="${base}/static/front/images/rightnav/l04.png" width="47" height="49" class="shows" />
			</a>
		</li>
        <li id="tel">
        <a href="javascript:void(0)">
            <div class="hides" style="width:161px;display:none;" id="tels">
                <div class="hides" id="p1">
                    <img src="${base}/static/front/images/rightnav/ll05.png">
                </div>
                <div class="hides" id="p3"><span style="color:#FFF;font-size:12px">0592-88888888</span>
                </div>
            </div>
        <img src="${base}/static/front/images/rightnav/l05.png" width="47" height="49" class="shows" />
        </a>
        </li>
        <li id="btn">
        <a id="top_btn">
            <div class="hides" style="width:161px;display:none">
                <img src="${base}/static/front/images/rightnav/ll06.png" width="161" height="49" />
            </div>
            <img src="${base}/static/front/images/rightnav/l06.png" width="47" height="49" class="shows" />
        </a>
    </li>
    </ul>
</div>

<script>

$(document).ready(function(){
    
    $("#leftsead a").hover(function(){
        if($(this).prop("className")=="youhui"){
            $(this).children("img.hides").show();
        }else{
            $(this).children("div.hides").show();
            $(this).children("img.shows").hide();
            $(this).children("div.hides").animate({marginRight:'0px'},'0'); 
        }
    },function(){ 
        if($(this).prop("className")=="youhui"){
            $(this).children("img.hides").hide();
        }else{
            $(this).children("div.hides").animate({marginRight:'-163px'},0,function(){$(this).hide();$(this).next("img.shows").show();});
        }
    });

    $("#top_btn").click(function(){if(scroll=="off") return;$("html,body").animate({scrollTop: 0}, 600);});

	    //右侧导航 - 二维码
        $(".youhui").mouseover(function(){
            $(this).children(".2wm").show();
        })
        $(".youhui").mouseout(function(){
            $(this).children(".2wm").hide();
        });


});


</script>
<!-- 代码 结束 -->
</div>
</html>