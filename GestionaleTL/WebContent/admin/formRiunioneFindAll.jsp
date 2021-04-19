<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="formA" id="formA" name="formA">
	<c:out value="Storico delle riunioni:"/>
	<br/>
	<!--  prova  -->

	<c:out value="questo + ${listaRiunioni}"/>
	
	
	<c:forEach items="${listaRiunioni}" var="riunione" varStatus="loop">
	<table class="table table-striped">
	<tr>	
		<td>
			<c:out value="Data comunicazione: ${riunione.data_comunicazione}"/>
		</td>
		<td>
			<c:out value="Data riunione: ${riunione.data_riunione}"/>
		</td>
		<td>
			<c:out value="Inizio: ${riunione.inizio_riunione}"/>
		</td>
		<td>
			<c:out value="Fine: ${riunione.fine_comunicazione}"/>
		</td>
	</tr>
	<tr>
		<td>
			<c:out value="ID Riunione:${riunione.id}"/>
		</td>
		<td>
			<c:out value="Ordine del giorno: ${riunione.data_comunicazione}"/>
		</td>
		<td>
			<c:out value="Stato: ${riunione.data_comunicazione}"/>
		</td>
		<td>
		<form action="MainServlet" method="post">
			<!--  ancora da vedere questo tasto -->
			 <input hidden="hidden" id="idRiunione" name="idRiunione" value="${riunione.id }">
			 <input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
			 <input class="btn btn-info" type="submit" id="viewRiunione" name="viewRiunione" value="Visualizza dettagli">
			 <!--  ancora da vedere sopra  -->
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