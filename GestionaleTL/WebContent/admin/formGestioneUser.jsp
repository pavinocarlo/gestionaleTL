<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="divB" id="divB" name="divB" >
	<tr class="nav navbar-nav">
		<td>
			<form action="MainServlet" id="showinsertuser" name="showinsertuser">
				<input class="btn btn-primary btn-lg" type="submit" style="width:220px;" id ="showinsertuserbutton" name="showinsertuserbutton" value="Inserisci Inquilino"/>
			</form>
		</td>
		<!--  da togliere 
		<td>
    		<form action="MainServlet" id="showFindAllUser" name="showFindAllUser">
    			<input class="btn btn-primary btn-lg" type="submit" style="width:220px;" id ="findAllUserButton" name="findAllUserButton" value="Lista Inquilini"/>
        	</form>
    	</td>
    	-->
		<td>
        	<form action="MainServlet" id="finduser" name="finduser" method="post">
    			<input class="btn btn-primary btn-lg" type="submit" style="width:220px;" id ="finduser" name="finduser" value="Trova Inquilino"/>
					<label class="labelG">Nome: </label>
					<input class="labelG" type="text" name="searchuser" id="searchuser" placeholder="Trova">
					<c:if test="${formrecordnotfound!=null}">
						<jsp:include page="/formRecordNotFound.jsp"></jsp:include>
					</c:if>
			</form>
        </td>
	</tr>
</div>