<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="formA" id="formA" name="formA">
	<c:out value="Storico delle riunioni:"/>
	<br/>
	<!--  prova  -->
	<c:if test="${listaUser!=null}">
		<c:out value="TEST PASSATO!!!!"/>
	</c:if>
	
	<c:forEach items="${listaUser}" var="user" varStatus="loop">
	<table class="table table-striped">
	<input hidden="hidden" type="text" id="id" value="${user.id}">
	<tr>
		<td>
			<c:out value="ID: ${user.id}"/>
		</td>
		<td>
			<c:out value="Codice fiscale: ${user.cf}"/>
		</td>
		<td>
			<c:out value="Nome: ${user.nome}"/>
		</td>
		<td>
			<c:out value="Cognome: ${user.cognome}"/>
		</td>
		<td>
			<c:out value="Email: ${user.email}"/>
		</td>
		<td>
			<c:out value="Telefono: ${user.telefono}"/>
		</td>
		<td>
			<c:out value="Ruolo: ${user.ruolo.ruolo}"/>
		</td>
		<td>
			<c:out value="Data accesso: ${user.data_in}"/>
		</td>
		<td>
			<c:out value="Data recesso: ${user.data_out}"/>
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