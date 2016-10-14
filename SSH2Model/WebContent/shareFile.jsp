<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">  
<title>Insert title here</title>

	<link rel="stylesheet" type="text/css" href="css/uploadify.css">
     <script src="js/jquery.min.js"></script>
     <script src="uploadify/jquery.uploadify.min.js"></script> 

<script type="text/javascript">
$(function(){
	var whichFile=1;
	$("#the_file").uploadify({
		  auto:false,//是否自动上传
  		  height: 30,  
     	  buttonText:'选择文档',
		  swf : 'uploadify/uploadify.swf',
		 	// expressInstall:'js/uploadify/expressInstall.swf',
		  uploader : 'upload/fileUploadAction.action', //后台处理上传文件的action 
		  width  : 120 ,
          'multi': true, //设置为true将允许多文件上传 
          'filesSelected': '4',
          queueID:'uploadfileQueue',
          fileObjName:'the_file', //与后台Action中file属性一样
          formData:{ //附带值       
		'whichFile':whichFile
      },
      /*        */
			fileTypeDesc:'上传文件支持的文件格式:jpg,jpge,gif,png',
			fileTypeExts:'*.jpg;*.jpge;*.gif;*.png;*.doc;*.docx',//*.jpg;*.jpge;*.gif;*.png
			queueSizeLimit : 4,//只能一次上传4张图片 
			// simUploadLimit:1,//一次可以上传1个文件
			fileSizeLimit:'2097152',//上传文件最大值   单位为字节   2M
             //返回一个错误，选择文件的时候触发
      		onSelectError:function(file, errorCode, errorMsg){
     				switch(errorCode) {
       				   case -100:
                          alert("上传的文件数量已经超出系统限制的4个文件！");
                          break;
                      case -110:
                          alert("文件 ["+file.name+"] 大小超出系统限制的20M大小！");
                          break;
                      case -120:
                          alert("文件 ["+file.name+"] 大小异常！");
                          break;
                      case -130:
                          alert("文件 ["+file.name+"] 类型不正确！");
                          break;
                  }
              },  //
                //上传到服务器，服务器返回相应信息到data里
             onUploadSuccess:function(file, data, response){
            	 var d=new Date();
            	 console.log(d.getTime());
	             var objs = eval('('+data+')');
	             console.log(objs.filename);
	             $.post("upload/FileConvertAction.action",{fileName:objs.filename});
	            
	   			 var phtml = $("<span><p>"+file.name+"</p></span>");
	             if($("#imgs span").length==0){
	                   $("#imgs").html(phtml);
	              }else{
	                   $("#imgs span:last").after(phtml);
	                //上传成功，运行文件转换Action来进行文件转换            	                   
              }},
             onSelect : function(file) {
              alert(file.name);         
              },
             //removeCompleted:true,//上传的文件进度条是否消失
              requeueErrors:false,
             // removeTimeout:2,//进度条消失的时间，默认为3
              progressData:"percentage",//显示上传的百分比
              onUploadError : function(file,errorCode,errorMsg,errorString,swfuploadifyQueue) { //这里是取消的时候发生  
                // $("#dialog-message").html(errorString);  
                } 
	});
});
	//上传文件
 	function myUpload(){
 		$("#the_file").uploadify('upload','*');  
 	      }

</script>


</head>


<body>
<div id="uploaditytopdiv" align="center" >
<form action="" method="post" >
    <input type="file" name="the_file" id="the_file">
    <p>  
    <a href="javascript:void(0);" onclick="myUpload()">上传</a>
  </p>
      <div id="uploadfileQueue" ></div>
      <div id="imgs" ></div>
      <div id="dialog-message" ></div>
  </form>
 </div>   
   
   
   

</body>
</html>