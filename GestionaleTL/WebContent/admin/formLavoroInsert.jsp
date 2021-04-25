<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<th colspan="6">
<table class="table table-striped">
<div class="formA" id="formA" name="formA">
	<form action="MainServlet" id="insertlavoro" name="insertlavoro" method="post">
	<ul>
		<label>Inserisci i dati di un nuovo lavoro:</label>
		<input hidden="hidden" type="text" name="idriunione" id="idriunione" value="${idriunione}">
		<input hidden="hidden" type="text" id="searchriunione" name="searchriunione" val="${searchriunione}">
		<tr>
			
			<th colspan="3"><label class="labelA">Nome: </label><input style="width: 500px;" type="text" name="nome" id="nome" placeholder="Nome"></th>
			<th><input class="btn btn-primary" type="submit" id="insertlavoro" name="insertlavoro" value="Inserisci Lavoro" ></th>
		</tr>
	</ul>
	<ul>
		<c:if test="${lavoroinsertsuccess!=null}">
			<jsp:include page="/formSuccess.jsp"></jsp:include>
		</c:if>
		<c:if test="${formlavoroinsertfailed!=null}">
			<jsp:include page="/formFailedInsert.jsp"></jsp:include>
		</c:if>
		<c:if test="${alreadyexistexception!=null}">
			<jsp:include page="/formAlreadyExists.jsp"></jsp:include>
		</c:if>
	</ul>
	<hr/>
	</form>
</div>
</table>
</th>