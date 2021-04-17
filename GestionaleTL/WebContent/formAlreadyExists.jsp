<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

	<div class="formFailure" id="formFailure">
			<c:out value="Un problema è sorto con i nostri sistemi."/>
			<c:out value="La registrazione non è andata a buon fine."/>
			<c:out value="Riprovare, se il problema persiste, contattare l'amministratore."/>
	</div>