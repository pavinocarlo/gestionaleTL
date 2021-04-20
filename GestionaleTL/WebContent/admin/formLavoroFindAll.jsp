<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="formA" id="formA" name="formA">
	<c:out value="Storico delle riunioni:"/>
	<br/>
	<!--  prova  -->
	<c:if test="${listalavori!=null}">
		<c:out value="TEST PASSATO!!!!"/>
	</c:if>
	
	<c:forEach items="${listalavori}" var="lavoro" varStatus="loop">
	<table class="table table-striped">
	<input hidden="hidden" type="text" id="id_riunione" value="${lavoro.id_riunione }">
	<tr>
		<td>
			<c:out value="ID Lavoro: ${lavoro.id}"/>
		</td>
		<td>
			<c:out value="Nome: ${lavoro.nome}"/>
		</td>
		<td>
			<c:out value="Esito: ${lavoro.esito_voto}"/>
		</td>
		<td>
			<c:out value="Stato: ${lavoro.stato}"/>
		</td>
	</tr>
	<tr>
		<td>
		<form action="MainServlet">
			<!--  ancora da vedere questo tasto -->
			 <input hidden="hidden" id="idlavoro" name="idlavoro" value="${lavoro.id }">
			 <input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
			 <input class="btn btn-warning" type="submit" id="showupdatelavoro" name="showupdatelavoro" value="Modifica Lavoro">
			 <!--  ancora da vedere sopra  -->
		</form>
		</td>
		<td>
		<form action="MainServlet">
			 <input hidden="hidden" id="idlavoro" name="idlavoro" value="${lavoro.id }">
			 <input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
			 <input class="btn btn-info" type="submit" id="showlistadocumentazione" name="showlistadocumentazione" value="Visualizza Documentazione">
		</form>
		</td>
		<td>
		<form action="MainServlet">
			 <input hidden="hidden" id="idlavoro" name="idlavoro" value="${lavoro.id }">
			 <input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
			 <input class="btn btn-info" type="submit" id="showinsertdocumentazione" name="showinsertdocumentazione" value="Inserisci Documentazione">
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