<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
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
<tr>
	<div>
		<c:forEach items="${riunione.listaLavori}" var="lavoro" >
			<td>lavoro : ${lavoro.nome}</td><br/>
				<c:forEach items="${lavoro.listaDocumenti}" var="documentazione"> 
					<td>Documento : ${documentazione.nome}</td><br/>
				    <td>Societa: ${documentazione.societa}</td><br/>
				    <td>costo: ${documentazione.costo}</td><br/>
		    	</c:forEach>	
	    </c:forEach>
	</div>
</tr>
<div id="div2">
</div>
	<div id="div3">
</div>
<div id="div4">
</div>
<script>
 	var c = setInterval('checkRiunione()', 5000);
	
	function checkRiunione(){
		
		$.ajax({
			url     : 'TestServlet',
			method     : 'GET',
			data: { checkMap: 'checkMap' },
			contentType: 'text',
			success    : function(result){
				
				 var dati = $.parseJSON(result);
				 $('#div3').html('<div class="name">'+dati[1].nome+'</>');
				
				if(dati[0].stato == 2) {
					$("#div2").html("Stato riunione : Riunione in corso");
				}
				if(dati[0].stato == 1) {
					$("#div2").html("Stato riunione : In attesa");
				}
				if(dati[1].id != 0) {
					$("#div4").html("<form action='TestServlet' method='post'><p>Seleziona il tuo voto:</p><input type='radio' id='approvo' name='approvo' value='1'><label for='approvo'>Approvo</label><br><input type='radio' id='nonapprovo' name='nonapprovo' value='2'><label for='nonapprovo'>Non Approvo</label><br><input hidden='hidden' name='iddocumentazione' id='iddocumentazione' value='"+dati[1].id+"'><input class='btn btn-info' type='submit' name='votazione' id='votazione' value='vota'/></form>");
				}
		}});	
	};
</script>

</body>
</html>