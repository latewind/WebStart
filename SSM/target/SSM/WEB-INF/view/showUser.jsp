<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>${webTitle}</title>
  </head>

  <body>
    <jsp:include page="/WEB-INF/layout/web/header.jsp"></jsp:include>
    ${user.userName}
  <jsp:include page="/WEB-INF/layout/web/footer.jsp"/>  </body>
</html>