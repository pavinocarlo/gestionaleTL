<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<th colspan="6">
<div class="formA" id="formA" name="formA">
	<form action="MainServlet" id="updateriunione" name="updateriunione" method="post">
	<input hidden="hidden" type="text" id="searchriunione" name="searchriunione" value="${searchriunione}">
	
	<table>
		<label>Modifica i dati della riunione:</label>
		<input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
		<input hidden="hidden" type="text" name="id" id="id" value="${listariunioni[loopindex].id }">
		<input hidden="hidden" type="datetime-local" name="data_comunicazione" id="data_comunicazione" value="${listariunioni[loopindex].data_comunicazione }">
		<input hidden="hidden" type="datetime-local" name="inizio_riunione" id="inizio_riunione" value="${listariunioni[loopindex].inizio_riunione }">
		<input hidden="hidden" type="datetime-local" name="fine_riunione" id="fine_riunione" value="${listariunioni[loopindex].fine_riunione }">
		<tr>
			<td><label class="labelL">Ordine del giorno: </label></td>
			<td><input type="text" name="ordine_del_giorno" id="ordine_del_giorno" value="${listariunioni[loopindex].ordine_del_giorno }" placeholder="${listariunioni[loopindex].ordine_del_giorno }"></td>
		</tr>
		<tr>
			<td><label class="labelL">Luogo: </label></td>
			<td><input type="text" name="luogo" id="luogo" value="${listariunioni[loopindex].luogo}" placeholder="${listariunioni[loopindex].luogo}"><br/></td>
		</tr>
		<tr>
			<td><label class="labelL">Stato: </label></td>
			<td><input type="text" name="stato" id="stato" value="${listariunioni[loopindex].stato}" placeholder="${listariunioni[loopindex].stato}"><br/></td>
		</tr>
		<tr>
			<td><label class="labelL">Data Riunione: </label></td>
			<td><input type="datetime-local" name="data_riunione" id="data_riunione" value="${listariunioni[loopindex].data_riunione}" placeholder="${listariunioni[loopindex].data_riunione}"><br/></td>
		</tr>
		<tr>
			<td><label class="labelL">Indirizzo: </label></td>
			<td><input type="text" name="indirizzo_abitazione" id="indirizzo_abitazione" value="${listariunioni[loopindex].indirizzo_abitazione}" placeholder="${listariunioni[loopindex].indirizzo_abitazione}"><br/></td>
		</tr>
	</table>
	<ul>
		<c:if test="${successo!=null}">
			<jsp:include page="/formSuccess.jsp"></jsp:include>
		</c:if>
		<c:if test="${formriunioneupdatefailed!=null}">
			<jsp:include page="/formFailedUpdate.jsp"></jsp:include>
		</c:if>
		<c:if test="${alreadyexistexception!=null}">
			<jsp:include page="/formAlreadyExists.jsp"></jsp:include>
		</c:if>
	</ul>
	<ul>
		<input class="btn btn-warning" type="submit" id="updateriunione" name="updateriunione" value="Salva Modifiche" >
	</ul>
	</form>
</div>
</th>