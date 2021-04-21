<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="divB" id="divB" name="divB" >
	<tr class="nav navbar-nav">
		<td>
			<form action="MainServlet" id="showinsertriunione" name="showinsertriunione">
				<input class="btn btn-primary btn-lg" type="submit" style="width:220px;" id ="showinsertriunionebutton" name="showinsertriunionebutton" value="Inserisci Riunione"/>
			</form>
		</td>
		<!--  da togliere 
		<td>
    		<form action="MainServlet" id="showFindAllRiunione" name="showFindAllRiunione">
    			<input class="btn btn-primary btn-lg" type="submit" style="width:220px;" id ="findAllRiunioneButton" name="findAllRiunioneButton" value="Lista Riunione"/>
        	</form>
    	</td>
    	-->
		<td>
        	<form action="MainServlet" id="findriunione" name="findriunione" method="post">
    			<input class="btn btn-primary btn-lg" type="submit" style="width:220px;" id ="findriunione" name="findriunione" value="Trova Riunione"/>
					<label class="labelG">Riunione: </label>
					<input class="labelG" type="text" id="searchriunione" name="searchriunione" placeholder="Trova">
					<c:if test="${formrecordnotfound!=null}">
						<jsp:include page="/formRecordNotFound.jsp"></jsp:include>
					</c:if>
			</form>
        </td>
	</tr>
</div>