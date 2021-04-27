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
				    <input hidden="hidden" name="iddocumentazione" id="iddocumentazione" value="${documentazione.id}">
		    	</c:forEach>	
	    </c:forEach>
	</div>
</tr>
<div id="div2">
</div>
<input hidden="hidden" name="buttonPresence" id="buttonPresence" value="on">
<div id="div3">
</div>
<input hidden="hidden" name="buttonVote" id="buttonVote" value="on">
<div id="div4">
</div>
<div id="div5">
</div>

<script>
	var flag = false;
	
 	var c = setInterval('checkRiunione()', 5000);
	
	function checkRiunione(){
		
		$.ajax({
			url     : 'TestServlet',
			method     : 'GET',
			data: { checkMap: 'checkMap' },
			contentType: 'text',
			success    : function(result){
		
			if(!(flag && dati == null) ){	
				
				if(result.length != 0) {
					
					var dati = $.parseJSON(result);
				
					if(dati.stato == 2) {
						$("#div2").html("Stato riunione : Riunione in corso");
						if($("#buttonPresence").val() === "on" ) {
							
							$("#div3").html("<input hidden='hidden' name='riunione_id' id='riunione_id' value='"+dati.id+"'><input hidden='hidden' name='user_id' id='user_id' value='"+${user.id}+"'><input class='btn btn-info' type='submit' name='partecipariunione' id='partecipariunione' value='partecipa' onclick='buttonPresenceOff()'/>");
						}
						else{
							$("#div3").html("<a></a>");
						}
					}
					if($("#buttonVote").val() === "on" && dati[1] != null && dati[1].id != 0 ) {
						$("#div5").html("<div class='name'>'"+dati[1].nome+"'</></br><p>Seleziona il tuo voto:</p><input type='radio' id='approvo' name='approvo' value='1'><label for='approvo'>Approvo</label><br><input type='radio' id='nonapprovo' name='nonapprovo' value='2'><label for='nonapprovo'>Non Approvo</label><br><input hidden='hidden' name='iddocumentazione' id='iddocumentazione' value='"+dati[1].id+"'><input class='btn btn-info' type='submit' name='votazione' id='votazione' value='vota' onclick='votazione()'/>");
						
					}
					if(dati[1] == null) {
						$("#div5").html("<a>Non c'e' votazione</a>");
					}
					if($("#buttonVote").val() === "off") {
						$("#div5").html("<a>Hai votato</a>");
					}
				}
				else{
					$("#div2").html("Stato riunione : In attesa");
				}
			}
			else {
				$("#div2").html("Stato riunione : Conclusa");
			}
		}});
		
	};
	
	function buttonPresenceOff() {
        $("#buttonPresence").val("off");
        $.ajax({
			url     : 'TestServlet?partecipariunione=partecipariunione&user_id='+$('#user_id').val()+'&riunione_id='+$('#riunione_id').val(),
			method     : 'POST',
	
			
			contentType: 'text',
			success    : function(){
				alert("ora sei presente")
			}});
    };
    
    function votazione() {
    	$("#buttonVote").val("off");
        $.ajax({
			url     : 'TestServlet?votazione=votazione&approvo='+$("#approvo").val()+'&nonapprovo='+$("#nonapprovo").val()+'&iddocumentazione='+$("#iddocumentazione").val(),
			method     : 'POST',

			contentType: 'text',
			success    : function(){
				alert("hai votato");
			}});
    };
	
</script>

</body>
</html>