<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<th colspan="6">
<div class="formA" id="formA" name="formA">
	<c:choose>
		<c:when test="${listariunioni[loopindex].listaLavori[looplavoroindex].listaDocumenti.size()>0}">
			<c:out value="Lista dei documenti associati a questo lavoro:"/>
		</c:when>
		<c:otherwise>
			<c:out value="Non sono presenti documenti per questo lavoro."/>
		</c:otherwise>
	</c:choose>
	<br/>
	<input hidden="hidden" type="text" id="searchriunione" name="searchriunione" val="${searchriunione}">
	<input hidden="hidden" id="loopindex" name="loopindex" value="${loopindex}">
	<input hidden="hidden" id="idriunione" name="idriunione" value="${idriunione}">
	<input hidden="hidden" id="looplavoroindex" name="looplavoroindex" value="${looplavoroindex}">
	<c:forEach items="${listariunioni[loopindex].listaLavori[looplavoroindex].listaDocumenti}" var="documentazione" varStatus="loopdocumentazione">
	<table class="table table-striped">
	<tr>
		<td>
			<c:out value="ID Documento: ${documentazione.id}"/>
		</td>
		<td>
			<c:out value="Nome: ${documentazione.nome}"/>
		</td>
		<td>
			<c:out value="Società: ${documentazione.societa}"/>
		</td>
		<td>
			<c:out value="Costo: ${documentazione.costo}"/>
		</td>
	</tr>
	<tr>
		<td>
		<form action="MainServlet">
			 <input hidden="hidden" type="text" id="searchriunione" name="searchriunione" val="${searchriunione}">
			 <input hidden="hidden" id="loopindex" name="loopindex" value="${loopindex }">
			 <input hidden="hidden" id="looplavoroindex" name="looplavoroindex" value="${looplavoroindex }">
			 <input hidden="hidden" id="loopdocumentazioneindex" name="loopdocumentazioneindex" value="${loopdocumentazione.index }">
			 <input hidden="hidden" id="documentazione" name="documentazione" value="${documentazione }">
			 <input class="btn btn-warning" type="submit" id="showupdatedocumentazionebutton" name="showupdatedocumentazionebutton" value="Modifica Documentazione">
		</form>
		</td>
	</tr>
	<tr>
	<td>
	<c:if test="${loopdocumentazioneindex==loopdocumentazione.index and successoplaceholder!=null}">
		<jsp:include page="/formSuccess.jsp"></jsp:include>
	</c:if>
	</td>
	</tr>
	<c:if test="${loopdocumentazioneindex==loopdocumentazione.index and showupdatedocumentazione!=null}">
		<tr>
			<td>
				<jsp:include page="formDocumentazioneUpdate.jsp"></jsp:include>
			</td>
		</tr>
	</c:if>
	<br/>
	</c:forEach>
	</table>
</div>
</th>