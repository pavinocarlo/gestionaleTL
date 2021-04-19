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
<c:choose>
	<c:when test="${showgestioneriunione!=null or listariunioni!=null}">
		<!-- Riunione - condizioni e template -->
		<jsp:include page="formGestioneRiunione.jsp"></jsp:include>
		<hr>
		<c:if test="${showinsertriunione!=null}">
			<jsp:include page="formRiunioneInsert.jsp"></jsp:include>
		</c:if>
		<c:if test="${listariunioni!=null}">
			<jsp:include page="formRiunioneFindAll.jsp"></jsp:include>
		</c:if>
	</c:when>
	<c:when test="${showgestionelavoro!=null or listalavori!=null}">
		<!-- Lavori - condizioni e template -->
		<jsp:include page="formGestioneLavoro.jsp"></jsp:include>
		<hr>
		<c:if test="${showinsertlavoro!=null}">
			<jsp:include page="formLavoroInsert.jsp"></jsp:include>
		</c:if>
		<c:if test="${listalavori!=null}">
			<jsp:include page="formLavoroFindAll.jsp"></jsp:include>
		</c:if>
	</c:when>
	<c:when test="${showgestionedocumentazione!=null or listaDocumentazione!=null}">
		<!-- Documentazione - condizioni e template -->
		<jsp:include page="formGestioneDocumentazione.jsp"></jsp:include>
		<hr>
		<c:if test="${showinsertdocumentazione!=null}">
			<jsp:include page="formDocumentazioneInsert.jsp"></jsp:include>
		</c:if>
		<c:if test="${listaDocumentazione!=null}">
			<jsp:include page="formDocumentazioneFindAll.jsp"></jsp:include>
		</c:if>
	</c:when>
	<c:when test="${showgestioneabitazione!=null or listaabitazioni!=null}">
		<!-- Abitazione - condizioni e template -->
		<jsp:include page="formGestioneAbitazione.jsp"></jsp:include>
		<hr>
		<c:if test="${showinsertabitazione!=null}">
			<jsp:include page="formAbitazioneInsert.jsp"></jsp:include>
		</c:if>
		<c:if test="${listaabitazioni!=null}">
			<jsp:include page="formAbitazioneFindAll.jsp"></jsp:include>
		</c:if>
	</c:when>
	<c:when test="${showgestioneuser!=null or listaUser!=null}">
		<!-- Inquilini - condizioni e template -->
		<jsp:include page="formGestioneUser.jsp"></jsp:include>
		<hr>
		<c:if test="${showinsertuser!=null}">
			<jsp:include page="formUserInsert.jsp"></jsp:include>
		</c:if>
		<c:if test="${listaUser!=null}">
			<jsp:include page="formUserFindAll.jsp"></jsp:include>
		</c:if>
	</c:when>
</c:choose>
</div>