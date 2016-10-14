<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>


<html>
<head>

<base href="<%=basePath%>">
    <title>公司公告</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1,user-scalable=no,maximum-scale=1,width=device-width" />
    <style type="text/css" media="screen">	
    </style>
	<link type="text/css" href="css/noticeCss.css" rel="stylesheet">
  <script type="text/javascript" src="FlexPaper/js/jquery.min.js"></script>
    <script type="text/javascript" src="js/flexpaper.js"></script>
<script type="text/javascript">
    function getDocumentUrl(document){
        return "FlexPaper/php/services/view.php?doc={doc}&format={format}&page={page}".replace("{doc}",document);
    }    
  	var file="upload/2.swf";
    var startDocument = "Paper";   
 $(document).ready(function(){
	 //加载后 才NoticeAction中获取相关文件目录
	 $.ajax({
			type: "post",
			url: "man/NoticeAction.action",
			data:{
				result:"upon1"
			},
			dataType:'json',
			success:function(data,textstatus){
				//遍历json-map的写法
				for(var index in data){
					
					var newli=$("<li>"+index+"</li>");
		            alert(index+"-"+data[index]);
		            $("#ndiv ul").append(newli);
		       		 }	
				 $("li").each(function(){	    	
					 $(this).hover(function(){$(this).css("color","#C06");},function(){$(this).css("color","#000000");});
				    	$(this).click(function(){
				    		var n=$(this).text();
				    		console.log(n);
				    		alert(data[n]);
				    		var name=data[n];
				    		file="upload/"+name+".swf";
				    		console.log(file);
				    	//页面显示文件
				    	loadPaper(file);
				    	});					    	
				    });
			},//end success
			
		    complete: function(XMLHttpRequest, textStatus){
		            //HideLoading();
		        },
			error:function(){
				alert("error");
			}				
		}); 	 
    loadPaper(file);
});
function loadPaper(file){
    $('#documentViewer').FlexPaperViewer(
            { config : {
                SWFFile : file,
                Scale : 1,
                ZoomTransition : 'easeOut',
                ZoomTime : 0.5,
                ZoomInterval : 0.2,
                FitPageOnLoad : true,
                FitWidthOnLoad : true,
                FullScreenAsMaxWindow : false,
                ProgressiveLoading : true,
                MinZoomSize : 0.2,
                MaxZoomSize : 5,
                SearchMatchAll : false,
                InitViewMode : 'Portrait',
                RenderingOrder : 'flash',
                StartAtPage : '',
                ViewModeToolsVisible : true,
                ZoomToolsVisible : true,
                NavToolsVisible : true,
                CursorToolsVisible : true,
                SearchToolsVisible : true,
                WMode : 'window',
                localeChain: 'zh_CN'
            }}
    );
    }
</script>
</head>
<body>
<div id="wrapper" >
<div id="header" >...</div>

<div id="leftbar" >

<h2 align="center">通知通报</h2>
<div  id ="ndiv"class="uldiv">
<ul>
</ul>
</div>

<h2 align="center">公司流程</h2>
<div  class="uldiv">
<ul>
</ul>
</div>


</div>


<div id="content" align="center" >
<div id="documentViewer" style="width: 770px; height: 700px; "  ></div>
<p id="testP" >点击这里</p>
<button type="button">Click me</button>
</div>
<div id="rightbar" ></div>
<div id="footer" ></div>

</body>
</html>