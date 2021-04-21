<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="formA" id="formA" name="formA">
	<form action="MainServlet" id="updatelavoro" name="updatelavoro" method="post">
	<table>
		<label>Modifica i dati del lavoro:</label>
		<input hidden="hidden" type="text" name="id" id="id" value="${lavoro.id }">
		<input hidden="hidden" type="text" name="id_riunione" id="id_riunione" value="${lavoro.id_riunione }">
		<tr>
			<td><label class="labelL">Nome: </label></td>
			<td><input type="text" name="nome" id="nome" value="${lavoro.nome}" placeholder="${lavoro.nome}"><br/></td>
		</tr>
		<tr>
			<td><label class="labelL">Stato: </label></td>
			<td><input type="text" name="stato" id="stato" value="${lavoro.stato}" placeholder="${lavoro.stato}"><br/></td>
		</tr>
		<tr>
			<td><label class="labelL">Esito voto: </label></td>
			<td><input type="text" name="esito_voto" id="esito_voto" value="${lavoro.esito_voto}" placeholder="${lavoro.esito_voto}"><br/></td>
		</tr>
	</table>
	<ul>
		<c:if test="${successo!=null}">
			<jsp:include page="/formSuccess.jsp"></jsp:include>
		</c:if>
		<c:if test="${formlavoroupdatefailed!=null}">
			<jsp:include page="/formFailedUpdate.jsp"></jsp:include>
		</c:if>
		<c:if test="${alreadyexistexception!=null}">
			<jsp:include page="/formAlreadyExists.jsp"></jsp:include>
		</c:if>
	</ul>
	<ul>
		<input class="btn btn-warning" type="submit" id="updatelavoro" name="updatelavoro" value="Salva Modifiche" >
	</ul>
	</form>
</div>