<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="divBigButton" id="divBigButton">
	<table>
	<tr><td>
			<jsp:include page="navbarUser.jsp"></jsp:include>
	</td></tr>
	</table>
</div>

<c:choose>
    <c:when test="${1>0 }">
		<ul> 
      		<div class="divAlert" id="divAlert">
        		<a class="alert" name="alert" href="#" style="background-color:rgba(33,33,33,0.1);">Attenzione: una riunione è in corso. Clicca per partecipare.</a>
        	</div>
		</ul> 
    </c:when>
    <c:when test="${1>0 }">
    	<ul>
        	<div class="divAlert" id="divAlert">
        		<a class="advice" name="advice" href="#" style="background-color:rgba(33,33,33,0.1);">È stata indetta una nuova riunione. Clicca per aderire.</a>
        	</div>
        </ul>
    </c:when>
</c:choose>