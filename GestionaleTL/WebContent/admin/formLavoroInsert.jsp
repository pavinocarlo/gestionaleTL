<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="formA" id="formA" name="formA">
	<form action="MainServlet" id="insertlavoro" name="insertlavoro" method="post">
	<ul>
		<label>Inserisci i dati di un nuovo lavoro:</label>
		<input hidden="hidden" type="text" name="id_riunione" id="id_riunione" value="${riunione.id}">
		<input hidden="hidden" type="text" name="esito_voto" id="esito_voto" value="non approvato">
		<li><tr>
			<th><label class="labelA">Nome: </label></th>
			<th><input type="text" name="nome" id="nome" placeholder="Nome"></th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Stato: </label></th>
			<th><input type="text" name="stato" id="stato" placeholder="Stato"><br/></th>
		</tr></li>
	</ul>
	<ul>
		<c:if test="${successo!=null}">
			<jsp:include page="/formSuccess.jsp"></jsp:include>
		</c:if>
		<c:if test="${formlavoroinsertfailed!=null}">
			<jsp:include page="/formFailedInsert.jsp"></jsp:include>
		</c:if>
		<c:if test="${alreadyexistexception!=null}">
			<jsp:include page="/formAlreadyExists.jsp"></jsp:include>
		</c:if>
	</ul>
	<ul>
		<input class="btn btn-success" type="submit" id="insertlavoro" name="insertlavoro" value="Inserisci" >
	</ul>
	</form>
</div>