<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/base.jsp"%>
<nav>
<ul class="nav nav-tabs  nav-justified"
	style="margin-bottom: 10px; font-weight: bold;">
	
	<c:forEach items="${navTabs}" var="nav">
	<li><a href="${base}${nav.navLink}"><strong>${nav.navName }</strong></a></li>
	</c:forEach>
</ul>
</nav>
<script>
	var url = window.document.location.pathname;
	console.log(url);
	var $a = $("a[href$='" + url + "']");
	$a.parent().addClass("active");
</script>
<style>
body{
padding-top:60px;

}

</style>