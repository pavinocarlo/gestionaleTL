<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<body>
<jsp:include page="style.jsp"></jsp:include>

<!--  -default dopo navbar, -custom per la custom, niente per niente -->
<nav class="navbar navbar" style="background-color: rgba(233,233,233,0.5);">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header" style="margin:8px;">
        <img alt="Brand" src="img/stocklogo.jpg" height="84">
    </div>
      <ul class="nav navbar-nav">
        <li><jsp:include page="loginForm.jsp"></jsp:include></li>
        <c:choose>
        	<c:when test="${0>0}">
        		<li><jsp:include page="admin/navbarAdmin.jsp"></jsp:include></li>
        	</c:when>
       		<c:when test="${1>0}">
        	<li><jsp:include page="user/navbarUser.jsp"></jsp:include></li>
        	</c:when>
        </c:choose>
      </ul>
  </div><!-- /.container-fluid -->
</nav>



</body>
</html>