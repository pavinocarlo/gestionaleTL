<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="formA" id="formA" name="formA">
	<form action="MainServlet" id="updateabitazione" name="updateabitazione" method="post">
	<ul>
		<label>Modifica i dati dell'unit� abitativa:</label>
		<li><tr>
			<th><label class="labelA">Indirizzo: </label></th>
			<th><input type="text" name="indirizzo" id="indirizzo" placeholder="Indirizzo" value="${abitazione.indirizzo}"></th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Interno: </label></th>
			<th><input type="text" name="interno" id="interno" placeholder="Interno" value="${abitazione.interno}"><br/></th>
		</tr></li>
				<input hidden="hidden" type="text" name="id" id="id" placeholder="id" value="${abitazione.id}">
	</ul>
	<ul>
		<c:if test="${successo!=null}">
			<jsp:include page="/formSuccess.jsp"></jsp:include>
		</c:if>
		<c:if test="${formabitazioneapdateFailed!=null}">
			<jsp:include page="/formFailedUpdate.jsp"></jsp:include>
		</c:if>
		<c:if test="${alreadyexistexception!=null}">
			<jsp:include page="/formAlreadyExists.jsp"></jsp:include>
		</c:if>
	</ul>
	<ul>
		<input class="btn btn-warning" type="submit" id="updateabitazione" name="updateabitazione" value="Modifica" >
	</ul>
	</form>	
	
	<form action="MainServlet" id="abitazionechiamauser" name="abitazionechiamauser">
	<ul>
		<th><input class="btn btn-info" type="submit" id="showabitazioneincludeuserbutton" name="showabitazioneincludeuserbutton" value="Mostra Dati" ></th>
		<th><label>Mostra i dati del proprietario dell'abitazione.</label></th>
	</ul>
	</form>
	<c:if test="${showabitazioneincludeuser!=null}">
		<jsp:include page="formAbitazione_includeUser.jsp"></jsp:include>
	</c:if>
</div>