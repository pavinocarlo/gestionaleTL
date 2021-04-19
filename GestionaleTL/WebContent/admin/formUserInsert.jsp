<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="formA" id="formA" name="formA">
	<form action="MainServlet" id="insertuser" name="insertuser" method="post">
	<input hidden="hidden" type="text" name="id_ruolo" id="id_ruolo" value="2">
	<input hidden="hidden" type="text" name="id_abitazione" id="id_abitazione" value="8">
	<ul>
		<label>Inserisci i dati dell'utente:</label>
		<li><tr>
			<th><label class="labelA">Codice Fiscale: </label></th>
			<th><input type="text" name="cf" id="cf" placeholder="Codice Fiscale"><br/></th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Nome: </label></th>
			<th><input type="text" name="nome" id="nome" placeholder="Nome"><br/><th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Cognome: </label></th>
			<th><input type="text" name="cognome" id="cognome" placeholder="Cognome"><br/></th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Email: </label></th>
			<th><input type="text" name="email" id="email" placeholder="Email"><br/></th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Telefono: </label></th>
			<th><input type="text" name="telefono" id="telefono" placeholder="Telefono"><br/></th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Password: </label></th>
			<th><label> l'utente riceverà la password generata automaticamente. </label></th>
			<!-- 
			<th><input type="password" name="password" id="password" placeholder="Password"><br/></th>
			 -->
		</tr></li>
		<li><tr>
			<th><label class="labelA">Data di accesso: </label></th>
			<th><input type="date" name="data_in" id="data_in"><br/></th>
		</tr></li>
	</ul>
	<ul>
		<c:if test="${successo!=null}">
			<jsp:include page="/formSuccess.jsp"></jsp:include>
		</c:if>
		<c:if test="${formuserinsertfailed!=null}">
			<jsp:include page="/formFailedInsert.jsp"></jsp:include>
		</c:if>
		<c:if test="${alreadyexistexception!=null}">
			<jsp:include page="/formAlreadyExists.jsp"></jsp:include>
		</c:if>
	</ul>
	<ul>
		<input class="btn btn-success" type="submit" id="insertuser" name="insertuser" value="Inserisci" >
	</ul>
	</form>
</div>