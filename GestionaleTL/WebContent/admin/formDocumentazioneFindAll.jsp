<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="formA" id="formA" name="formA">
	<c:out value="Storico delle riunioni:"/>
	<br/>
	
	<c:forEach items="${listaDocumentazione}" var="documento" varStatus="loop">
	<table class="table table-striped">
	<input hidden="hidden" type="text" id="id_riunione" value="${documento.id_lavoro }">
	<tr>
		<td>
			<c:out value="ID Documento: ${documento.id}"/>
		</td>
		<td>
			<c:out value="Nome: ${documento.nome}"/>
		</td>
		<td>
			<c:out value="Società: ${documento.societa}"/>
		</td>
		<td>
			<c:out value="Costo: ${documento.costo}"/>
		</td>
	</tr>
	<tr>
		<td>
		<form action="MainServlet">
			 <input hidden="hidden" id="iddocumento" name="iddocumento" value="${documento.id }">
			 <input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
			 <input class="btn btn-warning" type="submit" id="showupdatedocumentazione" name="showupdatedocumentazione" value="Modifica">
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