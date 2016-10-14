<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="jQueryPug/simditor-2.3.6/styles/simditor.css" />
<link rel="stylesheet" type="text/css" href="jQueryPug/simditor-2.3.6/styles/fonts/font-awesome.css" />
<style>

</style>
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<script type="text/javascript" src="jQueryPug/simditor-2.3.6/scripts/jquery.min.js"></script>
<script type="text/javascript" src="jQueryPug/simditor-2.3.6/scripts/module.js"></script>
<script type="text/javascript" src="jQueryPug/simditor-2.3.6/scripts/hotkeys.js"></script>
<script type="text/javascript" src="jQueryPug/simditor-2.3.6/scripts/uploader.js"></script>
<script type="text/javascript" src="jQueryPug/simditor-2.3.6/scripts/simditor.js"></script>
<script>


$(document).ready(function(){
	
	var editor = new Simditor({
		  textarea: $('#editor'),
		  placeholder: '输入内容',
		  toolbar:[
		           'title',
		           'bold',
		           'italic',
		           'underline',
		           'strikethrough',
		           'fontScale',
		           'color',
		           'ol',           
		           'ul',            
		           'blockquote',
		           'code',           
		           'table',
		           'link',
		           'image',
		           'hr',          
		           'indent',
		           'outdent',
		           'alignment',
		           ]
		  //optional options
		});
	
	$("button").click(function(){
		
		console.log($("#editor").val()+"test");
		var text=$("#editor").val();
		
		$("#div").html(text);
		var test=editor.sync();
		console.log(test)
		return true;
		
	});

});


</script>
<title>发布消息</title>
</head>
<body>
<div style='margin:10px 10px 0 10px;'>
<form action="msg/PublishMsgAction.action" method="post">
<label>标题：</label><input type="text" name="title"  required style='border-radius:5px;margin-bottom:20px;height:150%;border:1px solid #ccc;display:inline-block;height:33px;width:300px;font-size:1.2em;' />
<textarea id="editor" placeholder="Balabala" autofocus name="content"></textarea>
<div align="center" style='margin-top:5px;'>
<button type="submit" class="pure-button pure-button-primary">提交</button>
</div>
</form>
</div>
<div id="div"></div>

</body>
</html>