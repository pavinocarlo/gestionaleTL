<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

	<div class="formFailure" id="formFailure">
			<c:out value="La registrazione non è andata a buon fine."/>
			<c:out value="Ti ricordiamo che:"/>
			<c:out value="- Tutti i campi devono essere inseriti"/>
			<c:out value="- L'email deve contenere i caratteri '@' e '.'"/>
			<c:out value="- la passaword deve essere lunga almeno 8 caratteri e contenere due numeri."/>
	</div>