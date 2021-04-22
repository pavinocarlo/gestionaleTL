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
		<input hidden="hidden" nome="id_riunione" id="id_riunione" value="${riunione.id}">
		<input hidden="hidden" nome="id_user" id="id_user" value="${user.id}">
		<td><input class="btn btn-info" type="submit" name="partecipariunione" id="partecipariunione" value="partecipa"/></td>
	</c:if>
</form>
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