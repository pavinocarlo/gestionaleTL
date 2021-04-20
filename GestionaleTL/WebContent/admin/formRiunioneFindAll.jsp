<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="formA" id="formA" name="formA">
	<c:out value="Storico delle riunioni:"/>
	<br/>
	<!--  prova  -->
	<c:if test="${listariunioni!=null}">
		<c:out value="TEST PASSATO!!!!"/>
	</c:if>
	
	<c:forEach items="${listariunioni}" var="riunione" varStatus="loop">
	<table class="table table-striped">
	<tr>
		<td>
			<c:out value="Riunione per il condominio:${riunione.indirizzo_abitazione}"/>
		</td>
		<td>
			<c:out value="Data comunicazione: ${riunione.data_comunicazione}"/>
		</td>
		<td>
			<c:out value="Data riunione: ${riunione.data_riunione}"/>
		</td>
		<td>
			<c:out value="Inizio riunione: ${riunione.inizio_riunione}"/>
		</td>
		<td>
			<c:out value="Fine riunione: ${riunione.fine_riunione}"/>
		</td>
		
	</tr>
	<tr>
		<td>
			<c:out value="Ordine del giorno: ${riunione.ordine_del_giorno}"/>
		</td>
		<td>
			<c:out value="Stato: ${riunione.stato}"/>
		</td>
		<td>
			<c:out value="ID Riunione:${riunione.id}"/>
		</td>
		<td>
			<form action="MainServlet">
				 <input hidden="hidden" id="idriunione" name="idriunione" value="${riunione.id }">
				 <input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
				 <input class="btn btn-warning" type="submit" id="showupdateriunione" name="showupdateriunione" value="Modifica Riunione">
			</form>
		</td>
		<td>
			<form action="MainServlet">
				 <input hidden="hidden" id="idriunione" name="idriunione" value="${riunione.id }">
				 <input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
				 <input class="btn btn-info" type="submit" id="showinseriscilavoro" name="showinseriscilavoro" value="Inserisci Lavoro">
			</form>
		</td>
		<td>
			<form action="MainServlet">
				 <input hidden="hidden" id="idriunione" name="idriunione" value="${riunione.id }">
				 <input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
				 <input class="btn btn-info" type="submit" id="showlistalavori" name="showlistalavori" value="Visualizza Lavori">
			</form>
		</td>
	</tr>
	<tr>
	<td>
	<c:if test="${loopindex==loop.index}">
		<jsp:include page="/formSuccess.jsp"></jsp:include>
	</c:if>
	</td>
	</tr>
	<br/>
	</c:forEach>
	</table>
</div>