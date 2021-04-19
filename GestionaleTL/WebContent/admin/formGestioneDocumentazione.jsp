<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="divB" id="divB" name="divB" >
	<tr class="nav navbar-nav">
		<td>
			<form action="MainServlet" id="showinsertdocumentazione" name="showinsertdocumentazione">
				<input class="btn btn-primary btn-lg" type="submit" style="width:220px;" id ="showinsertdocumentazionebutton" name="showinsertdocumentazionebutton" value="Inserisci Documento"/>
			</form>
		</td>
		<!--  da togliere 
		<td>
    		<form action="MainServlet" id="showFindAllDocumentazione" name="showFindAllDocumentazione">
    			<input class="btn btn-primary btn-lg" type="submit" style="width:220px;" id ="findAllDocumentazioneButton" name="findAllDocumentazioneButton" value="Lista Documenti"/>
        	</form>
    	</td>
    	-->
		<td>
        	<form action="MainServlet" id="finddocumentazione" name="finddocumentazione" method="post">
    			<input class="btn btn-primary btn-lg" type="submit" style="width:220px;" id ="finddocumentazione" name="finddocumentazione" value="Trova Documento"/>
					<label class="labelG">Documento: </label>
					<input class="labelG" type="text" name="searchdocumentazione" id="searchdocumentazione" placeholder="Trova">
					<c:if test="${formrecordnotfound!=null}">
						<jsp:include page="/formRecordNotFound.jsp"></jsp:include>
					</c:if>
			</form>
        </td>
	</tr>
</div>