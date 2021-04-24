<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="${pageContext.servletContext.contextPath}/js/jquery-3.6.0.min.js"></script> 
<body>
<div id="div1">
</div>
<form action="TestServlet" method="post">
	<c:if test="${riunione.stato == 2 }">
		<input hidden="hidden" name="riunione_id" id="riunione_id" value="${riunione.id}">
		<input hidden="hidden" name="user_id" id="user_id" value="${user.id}">
		<c:choose>
		    <c:when test="${rigapresenza.presenza == 2 or empty rigapresenza.presenza }">
		        <td><input class="btn btn-info" type="submit" name="partecipariunione" id="partecipariunione" value="partecipa"/></td>
		    </c:when>
		    <c:otherwise>
		        <a>Stai partecipando alla riunione</a>
		    </c:otherwise>
		</c:choose>
	</c:if>
</form>

<tr>
	<div>
		<td>Data riunione : ${riunione.data_riunione}</td><br/>
	    <td>Ordine del giorno: ${riunione.ordine_del_giorno}</td><br/>
	    <td>Indirizzo riunione: ${riunione.indirizzo_abitazione}</td><br/>
	</div>
</tr>
<div id="div2">
</div>
		
<div id="div3">
</div>
<script>
 	var c = setInterval('checkRiunione()', 5000);
	

	
	function checkRiunione(){
		if(${riunione.stato == 2}) {
			$("#div2").html("Stato riunione : Riunione in corso");
		}
		if(${riunione.stato == 1}) {
			$("#div2").html("Stato riunione : In attesa");
		}
		if(${documentazione.id != 0 }) {
			$("#div3").html("<form action='TestServlet' method='post'><input class='btn btn-info' type='submit' name='votazione' id='votazione' value='vota'/></form>");
		}

		$.ajax({
			url     : 'TestServlet',
			method     : 'GET',
			data: { checkMap: 'checkMap' }
// 			success    : function(resultText){
// 			$('#result').html(resultText);
// 			}
			});
	};

</script>

</body>
</html>