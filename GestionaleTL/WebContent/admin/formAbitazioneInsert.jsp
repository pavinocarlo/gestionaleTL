<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="formA" id="formA" name="formA">
	<form action="MainServlet" id="insertAbitazione" name="insertAbitazione" method="post">
	<ul>
		<label>Inserisci i dati di una nuova unità abitativa:</label>
		<li><tr>
			<th><label class="labelA">Indirizzo: </label></th>
			<th><input type="text" name="indirizzo" id="indirizzo" placeholder="Indirizzo"></th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Interno: </label></th>
			<th><input type="text" name="interno" id="interno" placeholder="Interno"><br/></th>
		</tr></li>
	</ul>
	<ul>
		<c:if test="${successo!=null}">
			<jsp:include page="/formSuccess.jsp"></jsp:include>
		</c:if>
		<c:if test="${formAbitazioneInsertFailed!=null}">
			<jsp:include page="/formFailedInsert.jsp"></jsp:include>
		</c:if>
		<c:if test="${AlreadyExistException!=null}">
			<jsp:include page="/formAlreadyExists.jsp"></jsp:include>
		</c:if>
	</ul>
	<ul>
		<input class="btn btn-success" type="submit" id="insertAbitazione" name="insertAbitazione" value="Inserisci" >
	</ul>
	</form>
</div>