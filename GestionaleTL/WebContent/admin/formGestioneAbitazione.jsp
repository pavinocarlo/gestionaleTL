<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="divB" id="divB" name="divB" >
	<tr class="nav navbar-nav">
		<td>
			<form action="MainServlet" id="showinsertabitazione" name="showinsertabitazione">
				<input class="btn btn-primary btn-lg" type="submit" style="width:220px;" id ="showinsertabitazionebutton" name="showinsertabitazionebutton" value="Inserisci Abitazione"/>
			</form>
		</td>
		<!--  da togliere 
		<td>
    		<form action="MainServlet" id="showFindAllAbitazione" name="showFindAllAbitazione">
    			<input class="btn btn-primary btn-lg" type="submit" style="width:220px;" id ="findAllAbitazioneButton" name="findAllAbitazioneButton" value="Lista Abitazioni"/>
        	</form>
    	</td>
    	-->
		<td>
        	<form action="MainServlet" id="findabitazione" name="findabitazione" method="post">
    			<input class="btn btn-primary btn-lg" type="submit" style="width:220px;" id ="findabitazione" name="findabitazione" value="Trova Abitazione"/>
					<label class="labelG">Indirizzo: </label>
					<input class="labelG" type="text" name="searchabitazione" id="searchabitazione" placeholder="Trova">
					<c:if test="${formrecordnotfound!=null}">
						<jsp:include page="/formRecordNotFound.jsp"></jsp:include>
					</c:if>
			</form>
        </td>
	</tr>
</div>
