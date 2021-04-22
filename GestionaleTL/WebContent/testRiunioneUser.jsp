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
		<c:if test="${rigapresenza.presenza != 1 }">
			<td><input class="btn btn-info" type="submit" name="partecipariunione" id="partecipariunione" value="partecipa"/></td>
		</c:if>
	</c:if>
</form>


	
<tr>
	<div>
		<td>Data riunione : ${riunione.data_riunione}</td><br/>
	    <td>Ordine del giorno: ${riunione.ordine_del_giorno}</td><br/>
	    <td>Indirizzo riunione: ${riunione.indirizzo_abitazione}</td><br/>
	    <td>Stato riunione: ${riunione.stato}</td><br/>
	    
	</div>
</tr>
		

<script>
	
	var c = setInterval('checkRiunione()',5000);
	function checkRiunione(){
		if(${riunione.stato == 2}) {
			//alert("cazzo");
			$("#div1").html("riunione in corso");
		}
	}
		



// $.ajax({url: "TestServlet", success: function(result){

// 	alert("è arrivata la chiamata dalla servlet");
// 	alert(result);
//     $("#div1").html(result);
//   }});


// function invia(){
// 	var n = $('#nome').val();
// 	var model = {nome:n};
// 	var json = JSON.stringify(model);
// 	alert(json);



// 		$.post("MainServlet",
// 				model,
// 		  function(data, status){
// 			alert("Ok");
// 		  });


// }


// function prova(){

// 	$.ajax({url: "MainServlet", success: function(result){

// 		alert("è arrivata la chiamata dalla servlet");
// 		alert(result);
// 	    $("#div1").html(result);
// 	  }});

// }



</script>

</body>
</html>