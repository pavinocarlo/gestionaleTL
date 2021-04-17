<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<!--  
<div class="divBigButton" id="divBigButton">
	<table>
	<tr><td>
			<jsp:include page="navbarAdmin.jsp"></jsp:include>
	</td></tr>
	</table>
</div>
-->

<c:choose>
    <c:when test="${1>0 }">
		<ul> 
      		<div class="divAlert" id="divAlert">
        		<a class="alert" name="alert" href="#" style="background-color:rgba(33,33,33,0.1);">Attenzione: una riunione in programma dovrebbe cominciare a breve. Clicca per gestire la riunione.</a>
        	</div>
		</ul> 
    </c:when>
    <c:when test="${1>0 }">
    	<ul>
        	<div class="divAlert" id="divAlert">
        		<a class="advice" name="advice" href="#" style="background-color:rgba(33,33,33,0.1);">Hai una riunione in programma. Clicca per andare alla schermata della riunione.</a>
        	</div>
        </ul>
    </c:when>
</c:choose>

<div class="homeadmin" id="homeadmin" name="homeadmin">
	<!-- Riunione - condizioni e template -->
	<c:if test="${0>0}">
		<jsp:include page="formRiunioneInsert.jsp"></jsp:include>
	</c:if>
	<c:if test="${0>0}">
		<jsp:include page="formRiunioneUpdate.jsp"></jsp:include>
	</c:if>
	
	<!-- Lavori - condizioni e template -->
	<c:if test="${0>0}">
		<jsp:include page="formLavoroInsert.jsp"></jsp:include>
	</c:if>
	<c:if test="${0>0}">
		<jsp:include page="formLavoroUpdate.jsp"></jsp:include>
	</c:if>
	
	<!-- Documentazione - condizioni e template -->
	<c:if test="${0>0}">
		<jsp:include page="formDocumentazioneInsert.jsp"></jsp:include>
	</c:if>
	<c:if test="${0>0}">
		<jsp:include page="formDocumentazioneUpdate.jsp"></jsp:include>
	</c:if>
	
	<!-- Abitazione - condizioni e template -->
	<c:if test="${1>0}">
		<jsp:include page="formAbitazioneInsert.jsp"></jsp:include>
	</c:if>
	<c:if test="${1>0}">
		<jsp:include page="formAbitazioneUpdate.jsp"></jsp:include>
	</c:if>
	
	<!-- Inquilini - condizioni e template -->
	<c:if test="${0>0}">
		<jsp:include page="formUserInsert.jsp"></jsp:include>
	</c:if>
	<c:if test="${0>0}">
		<jsp:include page="formUserUpdate.jsp"></jsp:include>
	</c:if>
</div>