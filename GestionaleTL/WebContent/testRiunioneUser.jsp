<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<td><input class="btn btn-info" type="submit" name="avviariunione" id="avviariunione" value="avvia"/></td>
<script>
	
	var c = setInterval('checkRiunione()',5000);
	function checkRiunione(){
		if(${riunione.stato == null}) {
			alert("cazzo");
			$("#div1").html("Hello <b>world</b>!");
		}
	}
		



$.ajax({url: "TestServlet", success: function(result){

	alert("è arrivata la chiamata dalla servlet");
	alert(result);
    $("#div1").html(result);
  }});


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