<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


	<!-- 
	la logica di questo form+radio è: mostralo solo quando chiamo la modifica dello User
	nel caso in cui dall'abitazione voglio cambiare il proprietario o i suoi dati.
	-->

	<form action="MainServlet" id="updateuser" name="updateuser" method="post">
	<ul>
		<label>Modifica i dati dell'utente:</label>
		<li><input type="radio" name="updateuser" value="0"/><label> - Stesso proprietario</label></li>
		<li><input type="radio" name="updateuser" Value="1"/><label> - Nuovo proprietario NON presente nel sistema</label></li>
		<li><input type="radio" name="updateuser" Value="2"/><label> - Nuovo proprietario già presente nel sistema</label></li>
	</ul>
		<jsp:include page="formUserUpdate.jsp"></jsp:include>
