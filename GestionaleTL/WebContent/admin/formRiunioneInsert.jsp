<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="formA" id="formA" name="formA">
	<form action="MainServlet" id="insertriunione" name="insertriunione" method="post">
	<ul>
		<label>Inserisci i dati di un nuovo lavoro:</label>
		<input hidden="hidden" type="text" name="id" id="id">
		<input hidden="hidden" type="datetime-local" name="data_comunicazione" id="data_comunicazione">
		<input hidden="hidden" type="datetime-local" name="inizio_riunione" id="inizio_riunione">
		<input hidden="hidden" type="datetime-local" name="fine_riunione" id="fine_riunione">
		<li><tr>
			<th><label class="labelA">Ordine del giorno: </label></th>
			<th><input type="text" name="ordine_del_giorno" id="ordine_del_giorno" placeholder="Ordine del giorno"></th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Stato: </label></th>
			<th><input type="text" name="stato" id="stato" placeholder="Stato"><br/></th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Data Riunione: </label></th>
			<th><input type="datetime-local" name="data_riunione" id="data_riunione" placeholder="Data riunione"><br/></th>
		</tr></li>
	</ul>
	<ul>
		<c:if test="${successo!=null}">
			<jsp:include page="/formSuccess.jsp"></jsp:include>
		</c:if>
		<c:if test="${formriunioneinsertfailed!=null}">
			<jsp:include page="/formFailedInsert.jsp"></jsp:include>
		</c:if>
		<c:if test="${alreadyexistexception!=null}">
			<jsp:include page="/formAlreadyExists.jsp"></jsp:include>
		</c:if>
	</ul>
	<ul>
		<input class="btn btn-success" type="submit" id="insertriunione" name="insertriunione" value="Inserisci" >
	</ul>
	</form>
</div>