<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<th colspan="6">
<div class="formA" id="formA" name="formA">
	<c:choose>
		<c:when test="${listalavori.size()>0}">
			<c:out value="Lista dei lavori associati a questa riunione:"/>
		</c:when>
		<c:otherwise>
			<c:out value="Non sono presenti lavori per questa riunione."/>
		</c:otherwise>
	</c:choose>
	<br/>
	<input hidden="hidden" type="text" id="searchriunione" name="searchriunione" val="${searchriunione}">
	<input hidden="hidden" type="text" id="searchlavoro" name="searchlavoro" val="${searchlavoro}">
	<c:forEach items="${listalavori}" var="lavoro" varStatus="looplavoro">
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
			 <input hidden="hidden" type="text" id="searchriunione" name="searchriunione" val="${searchriunione}">
			 <input hidden="hidden" type="text" id="searchlavoro" name="searchlavoro" val="${searchlavoro}">
			 <input hidden="hidden" id="idlavoro" name="idlavoro" value="${lavoro.id }">
			 <input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
			 <input hidden="hidden" id="looplavoroindex" name="looplavoroindex" value="${looplavoro.index }">
			 <input class="btn btn-warning" type="submit" id="showupdatelavorobutton" name="showupdatelavorobutton" value="Modifica Lavoro">
		</form>
		</td>
		<td>
		<form action="MainServlet">
			 <input hidden="hidden" type="text" id="searchriunione" name="searchriunione" val="${searchriunione}">
			 <input hidden="hidden" type="text" id="searchlavoro" name="searchlavoro" val="${searchlavoro}">
			 <input hidden="hidden" id="idlavoro" name="idlavoro" value="${lavoro.id }">
			 <input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
			 <input hidden="hidden" id="looplavoroindex" name="looplavoroindex" value="${looplavoro.index }">
			 <input class="btn btn-info" type="submit" id="showlistadocumentazionebutton" name="showlistadocumentazionebutton" value="Visualizza Documentazione">
		</form>
		</td>
		<td>
		<form action="MainServlet">
			 <input hidden="hidden" type="text" id="searchriunione" name="searchriunione" val="${searchriunione}">
			 <input hidden="hidden" type="text" id="searchlavoro" name="searchlavoro" val="${searchlavoro}">
			 <input hidden="hidden" id="idlavoro" name="idlavoro" value="${lavoro.id }">
			 <input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
			 <input hidden="hidden" id="looplavoroindex" name="looplavoroindex" value="${looplavoro.index }">
			 <input class="btn btn-info" type="submit" id="showinsertdocumentazionebutton" name="showinsertdocumentazionebutton" value="Inserisci Documentazione">
		</form>
		</td>
	</tr>
	<tr>
	<td>
	<c:if test="${looplavoroindex==looplavoro.index}">
		<jsp:include page="/formSuccess.jsp"></jsp:include>
	</c:if>
	</td>
	</tr>
	<c:if test="${looplavoroindex==looplavoro.index and showupdatelavoro!=null}">
		<tr>
			<td>
				<jsp:include page="formLavoroUpdate.jsp"></jsp:include>
			</td>
		</tr>
	</c:if>
	<br/>
	</c:forEach>
	</table>
</div>
</th>