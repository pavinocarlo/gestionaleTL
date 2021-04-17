<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${user == null}">
		<jsp:include page="header.jsp"></jsp:include>
	</c:if>



	<c:choose>
	    <c:when test="${user.ruolo.id == 1}">
	       <jsp:include page="admin/homeadmin.jsp"></jsp:include>
	    </c:when>
	    <c:when test="${user.ruolo.id == 2 or user.ruolo.id == 3}">
	        <jsp:include page="user/homeuser.jsp"></jsp:include>
	    </c:when>

	</c:choose>

<!--  test -->
<jsp:include page="admin/homeadmin.jsp"></jsp:include>
<hr>
<hr>
<jsp:include page="user/homeuser.jsp"></jsp:include>

</body>
</html>