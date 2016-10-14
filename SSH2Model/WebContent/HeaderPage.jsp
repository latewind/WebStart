<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>Bootstrap 实例 - 超大屏幕（Jumbotron）</title>
   <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron">
   <div class="container" align="center">
      <h1>欢迎登陆LateWind Manager！</h1>
      <p>点击下方快捷入口<img  width="25px" height="25px" src="img/downArow.gif"/></p>
      <p><a href="order/listOrdersAction.action" target="rightif" class="btn btn-primary btn-lg" role="button">
         查看订单</a> <a href="AppMaterials.jsp" target="rightif" class="btn btn-primary btn-lg" role="button">
         物资申请</a>
      </p>
            <p><a href="Notice.jsp" target="blank"class="btn btn-primary btn-lg" role="button">
         公司公告</a> <a  href="msg/MyMsgAction.action" target="rightif" class="btn btn-primary btn-lg" role="button">
         我的消息</a>
      </p>
      
                  <p><a href="publishMsg.jsp" target="rightif"class="btn btn-primary btn-lg" role="button">
         发布消息</a> <a href="file/ListFilesAction.action" target="rightif" class="btn btn-primary btn-lg" role="button">
        文件下载</a>
      </p>
      
      
                  <p><a class="btn btn-primary btn-lg" role="button">
         学习更多</a> <a class="btn btn-primary btn-lg" role="button">
         学习更多</a>
      </p>
   </div>
</div>

</body>
</html>