<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="formA" id="formA" name="formA">
	<form action="MainServlet" id="updatelavoro" name="updatelavoro" method="post">
	<input hidden="hidden" type="text" id="searchriunione" name="searchriunione" val="${searchriunione}">
	<input hidden="hidden" id="loopindex" name="loopindex" value="${loopindex }">
	<input hidden="hidden" id="looplavoroindex" name="looplavoroindex" value="${looplavoroindex }">
	<input hidden="hidden" id="loopdocumentazioneindex" name="loopdocumentazioneindex" value="${loopdocumentazioneindex }">
	<table>
		<label>Modifica i dati del lavoro:</label>
		<input hidden="hidden" type="text" name="id" id="id" value="${listariunioni[loopindex].listaLavori[looplavoroindex].listaDocumenti[loopdocumentazioneindex].id }">
		<tr>
			<td><label class="labelL">ID Documento: </label><a>${listariunioni[loopindex].listaLavori[looplavoroindex].listaDocumenti[loopdocumentazioneindex].id }</a></td>
		<tr>
			<td><label class="labelL">Nome: </label></td>
			<td><input type="text" name="nome" id="nome" value="${listariunioni[loopindex].listaLavori[looplavoroindex].listaDocumenti[loopdocumentazioneindex].nome}" placeholder="${listariunioni[loopindex].listaLavori[looplavoroindex].listaDocumenti[loopdocumentazioneindex].nome}"><br/></td>
		</tr>
		<tr>
			<td><label class="labelL">Società: </label></td>
			<td><input type="text" name="societa" id="societa" value="${listariunioni[loopindex].listaLavori[looplavoroindex].listaDocumenti[loopdocumentazioneindex].societa}" placeholder="${listariunioni[loopindex].listaLavori[looplavoroindex].listaDocumenti[loopdocumentazioneindex].societa}"><br/></td>
		</tr>
		<tr>
			<td><label class="labelL">Costo: </label></td>
			<td><input type="text" name="costo" id="costo" value="${listariunioni[loopindex].listaLavori[looplavoroindex].listaDocumenti[loopdocumentazioneindex].costo}" placeholder="${listariunioni[loopindex].listaLavori[looplavoroindex].listaDocumenti[loopdocumentazioneindex].costo}"><br/></td>
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
		<input class="btn btn-warning" type="submit" id="updatedocumentazione" name="updatedocumentazione" value="Salva Modifiche" >
	</ul>
	</form>
</div>