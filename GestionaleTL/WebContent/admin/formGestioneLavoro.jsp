<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="divB" id="divB" name="divB" >
	<tr class="nav navbar-nav">
		<td>
			<form action="MainServlet" id="showinsertlavoro" name="showinsertlavoro">
				<input class="btn btn-primary btn-lg" type="submit" style="width:220px;" id ="showinsertlavorobutton" name="showinsertlavorobutton" value="Inserisci Lavoro"/>
			</form>
		</td>
		<!--  da togliere 
		<td>
    		<form action="MainServlet" id="showFindAllLavoro" name="showFindAllLavoro">
    			<input class="btn btn-primary btn-lg" type="submit" style="width:220px;" id ="findAllLavoroButton" name="findAllLavoroButton" value="Lista dei Lavori"/>
        	</form>
    	</td>
    	-->
		<td>
        	<form action="MainServlet" id="findlavoro" name="findlavoro" method="post">
    			<input class="btn btn-primary btn-lg" type="submit" style="width:220px;" id ="findlavoro" name="findlavoro" value="Trova Lavoro"/>
					<label class="labelG">Nome: </label>
					<input class="labelG" type="text" name="searchlavoro" id="searchlavoro" placeholder="Trova">
					<c:if test="${formrecordnotfound!=null}">
						<jsp:include page="/formRecordNotFound.jsp"></jsp:include>
					</c:if>
			</form>
        </td>
	</tr>
</div>