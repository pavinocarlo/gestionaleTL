<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="formA" id="formA" name="formA">
	<form action="MainServlet" id="documentazioneinsert" name="documentazioneinsert" method="post">
	<input hidden="hidden" type="text" id="searchriunione" name="searchriunione" val="${searchriunione}">
	<input hidden="hidden" id="loopindex" name="loopindex" value="${loopindex }">
	<input hidden="hidden" id="looplavoroindex" name="looplavoroindex" value="${looplavoro.index }">
	<table>
		<label>Modifica i dati del lavoro:</label>
	
		<input hidden="hidden" type="text" name="id" id="id" value="${listariunioni[loopindex].listaLavori[looplavoro.index].id }">
		<input hidden="hidden" type="text" name="id_riunione" id="id_riunione" value="${listariunioni[loopindex].listaLavori[looplavoro.index].id_riunione }">
		<tr>
			<td><label class="labelL">ID Lavoro: </label><a>${lavoro.id }</a></td>
		<tr>
			<td><label class="labelL">Nome: </label></td>
			<td><input type="text" name="nome" id="nome" placeholder="Nome"><br/></td>
		</tr>
		<tr>
			<td><label class="labelL">Società: </label></td>
			<td><input type="text" name="societa" id="societa" placeholder="Società"><br/></td>
		</tr>
		<tr>
			<td><label class="labelL">Costo: </label></td>
			<td><input type="text" name="costo" id="costo" placeholder="Costo"><br/></td>
		</tr>
	</table>
	<ul>
		<c:if test="${successo!=null}">
			<jsp:include page="/formSuccess.jsp"></jsp:include>
		</c:if>
		<c:if test="${formdocumentazioneinsertfailed!=null}">
			<jsp:include page="/formFailedUpdate.jsp"></jsp:include>
		</c:if>
		<c:if test="${alreadyexistexception!=null}">
			<jsp:include page="/formAlreadyExists.jsp"></jsp:include>
		</c:if>
	</ul>
	<ul>
		<input class="btn btn-success" type="submit" id="documentazioneinsert" name="documentazioneinsert" value="Inserisci" >
	</ul>
	</form>
</div>