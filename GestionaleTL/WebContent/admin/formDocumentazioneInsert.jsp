<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="formA" id="formA" name="formA">
	<form action="MainServlet" id="insertdocumentazione" name="insertdocumentazione" method="post">
	<ul>
		<label>Inserisci i dati di un nuovo documento:</label>
		<input hidden="hidden" type="text" name="id" id="id">
		<input hidden="hidden" type="text" name="id_lavoro" id="id_lavoro" value="${id_lavoro}">
		<li><tr>
			<th><label class="labelA">Nome: </label></th>
			<th><input type="text" name="nome" id="nome" placeholder="Nome"></th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Società: </label></th>
			<th><input type="text" name="societa" id="societa" placeholder="Societa"><br/></th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Costo: </label></th>
			<th><input type="text" name="costo" id="costo" placeholder="Costo"><br/></th>
		</tr></li>
	</ul>
	<ul>
		<c:if test="${successo!=null}">
			<jsp:include page="/formSuccess.jsp"></jsp:include>
		</c:if>
		<c:if test="${formDocumentazioneInsertFailed!=null}">
			<jsp:include page="/formFailedInsert.jsp"></jsp:include>
		</c:if>
		<c:if test="${AlreadyExistException!=null}">
			<jsp:include page="/formAlreadyExists.jsp"></jsp:include>
		</c:if>
	</ul>
	<ul>
		<input class="btn btn-success" type="submit" id="insertdocumentazione" name="insertdocumentazione" value="Inserisci" >
	</ul>
	</form>
</div>