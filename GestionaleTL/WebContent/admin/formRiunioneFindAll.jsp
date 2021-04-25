<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="formA" id="formA" name="formA">
	<c:out value="Storico delle riunioni:"/>
	<br/>
	<input hidden="hidden" type="text" id="searchriunione" name="searchriunione" val="${searchriunione}">
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
				 <input hidden="hidden" type="text" id="searchriunione" name="searchriunione" val="${searchriunione}">
				 <input hidden="hidden" id="idriunione" name="idriunione" value="${riunione.id }">
				 <input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
				 <input class="btn btn-warning" type="submit" id="showupdateriunionebutton" name="showupdateriunionebutton" value="Modifica Riunione">
			</form>
		</td>
		<td>
			<form action="MainServlet">
				 <input hidden="hidden" type="text" id="searchriunione" name="searchriunione" val="${searchriunione}">
				 <input hidden="hidden" id="idriunione" name="idriunione" value="${riunione.id }">
				 <input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
				 <input class="btn btn-info" type="submit" id="showinsertlavorobutton" name="showinsertlavorobutton" value="Inserisci Lavoro">
			</form>
		</td>
		<td>
			<form action="MainServlet">
				 <input hidden="hidden" type="text" id="searchriunione" name="searchriunione" val="${searchriunione}">
				 <input hidden="hidden" id="idriunione" name="idriunione" value="${riunione.id }">
				 <input hidden="hidden" id="loopindex" name="loopindex" value="${loop.index }">
				 <input class="btn btn-info" type="submit" id="showlistalavoributton" name="showlistalavoributton" value="Visualizza Lavori">
			</form>
		</td>
	</tr>
	<c:if test="${loopindex==loop.index and showupdateriunione!=null}">
		<tr>
			<td>
				<jsp:include page="formRiunioneUpdate.jsp"></jsp:include>
			</td>
		</tr>
	</c:if>
	<c:if test="${loopindex==loop.index and showinsertlavoro!=null}">
		<tr>
			<td>
				<jsp:include page="formLavoroInsert.jsp"></jsp:include>
			</td>
		</tr>
	</c:if>
	<c:if test="${loopindex==loop.index and showlistalavori!=null}">
		<tr>
			<td>
				<jsp:include page="formLavoroFindAll.jsp"></jsp:include>
			</td>
		</tr>
	</c:if>
	<c:if test="${loopindex==loop.index and updatesuccess!=null}">
		<tr>
			<td>
				<jsp:include page="/formSuccess.jsp"></jsp:include>
			</td>
		</tr>
	</c:if>
	<br/>
	</c:forEach>
	</table>
</div>