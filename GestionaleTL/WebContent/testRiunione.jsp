<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>



<form action="TestServlet" method="post">
	<label>
	Data Riunione
	</label>
	<input type="date" name="data_riunione" id="data_riunione"><br/>

	<input type="submit" value="Invia" name="showriunionibutton" id="showriunionibutton"/>
</form>

<c:forEach items="${listariunioni}" var="riunione" varStatus="loop">
	<form action="TestServlet" method="post">
		<tr>
			<div>
				<td>Data riunione : ${riunione.data_riunione}</td><br/>
			    <td>Ordine del giorno: ${riunione.ordine_del_giorno}</td><br/>
			    <td>Indirizzo riunione: ${riunione.indirizzo_abitazione}</td><br/>
			    <td>Stato riunione: ${riunione.stato}</td><br/>
			    <td><input class="btn btn-info" type="submit" name="avviariunione" id="avviariunione" value="avvia"/></td>
			    <input hidden="hidden" name="indiceriunione" value="${loop.index}"/>
			    <input hidden="hidden" name="idriunione" value="${riunione.id}"/>
			</div>
		</tr>
		</form>
</c:forEach>

<div id="div1">
</div>

<c:if test="${riunione.stato == 2}">
	<div class="divAlert" id="divAlert">
		<a class="advice" name="advice" href="#" style="background-color:rgba(33,33,33,0.1);">Riunione in corso</a>
		<form action="TestServlet" method="post">
			<input hidden="hidden" name="idriunione" value="${riunione.id}"/>
			<input class="btn btn-info" type="submit" name="arrestariunione" id="arrestariunione" value="Arresta"/>
		</form>
		<c:forEach items="${listadocumenti}" var="documento" varStatus="loop">
			<form action="TestServlet" method="post">
				<td>Documento: ${documento.nome}</td><br/>
				<td>Società: ${documento.societa}</td><br/>
				<td>Costo: ${documento.costo}</td><br/>
				<td>Stato: ${documento.stato}</td><br/>
				<input hidden="hidden" name="iddocumento" value="${documento.id}"/>
				<input hidden="hidden" name="costo" value="${documento.costo}"/>
				<input hidden="hidden" name="nome" value="${documento.nome}"/>
				<input hidden="hidden" name="societa" value="${documento.societa}"/>
				<input hidden="hidden" name="id_lavoro" value="${documento.id_lavoro}"/>
				<input hidden="hidden" name="stato" value="1"/>
				<c:if test="${empty documento.stato}">
					<input class="btn btn-info" type="submit" name="avviavotazione" id="avviavotazione" value="avvia votazione"/>
				</c:if>
			</form>
		</c:forEach>
	</div>
</c:if>
<c:if test="${riunione.stato == 3}">
	<div class="divAlert" id="divAlert">
		<a class="advice" name="advice" href="#" style="background-color:rgba(33,33,33,0.1);">Riunione Terminata</a>
	</div>
</c:if>



</body>
</html>