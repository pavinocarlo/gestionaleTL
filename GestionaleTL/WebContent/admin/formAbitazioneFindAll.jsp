<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="formA" id="formA" name="formA">
	<c:out value="Storico delle riunioni:"/>
	<br/>
	<!--  prova  -->
	<c:if test="${listaabitazioni!=null}">
		<c:out value="TEST PASSATO!!!!"/>
	</c:if>
	
	<c:forEach items="${listaabitazioni}" var="abitazione" varStatus="loop">
	<table class="table table-striped">
	<input hidden="hidden" type="text" id="id" value="${abitazione.id}">
	<tr>
		<td>
			<c:out value="ID Abitazione: ${abitazione.id}"/>
		</td>
		<td>
			<c:out value="Indirizzo: ${abitazione.indirizzo}"/>
		</td>
		<td>
			<c:out value="Interno: ${abitazione.interno}"/>
		</td>
	</tr>
	<tr>
		<td>
		<form action="MainServlet">
			 <input hidden="hidden" id="idabitazione" name="idabitazione" value="${abitazione.id }">
			 <input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
			 <input class="btn btn-warning" type="submit" id="showupdateuser" name="showupdateuser" value="Visualizza Proprietario">
		</form>
		</td>
		<td>
		<form action="MainServlet">
			 <input hidden="hidden" id="idabitazione" name="idabitazione" value="${abitazione.id }">
			 <input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
			 <input class="btn btn-info" type="submit" id="showlistauser" name="showlistauser" value="Visualizza Storico Proprietari">
		</form>
		</td>
		<td>
		<form action="MainServlet">
			 <input hidden="hidden" id="idabitazione" name="idabitazione" value="${abitazione.id }">
			 <input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
			 <input class="btn btn-info" type="submit" id="showinsertuser" name="showinsertuser" value="Inserisci Proprietario">
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