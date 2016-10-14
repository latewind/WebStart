<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"   isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import ="com.latewind.common.constants.CommonConstants" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
   
      String imagePath=basePath+"/"+CommonConstants.PRODUCT_IMG_PATH;
      
      String webTitle="带你飞的购物商城";
%>
<c:set var="imagePath" value="<%=imagePath%>"></c:set>
<c:set var="imagePath" value="<%=imagePath%>"></c:set>
<c:set var="base" value="<%=basePath%>"></c:set>
<c:set var="webTitle" value="<%=webTitle%>"></c:set>