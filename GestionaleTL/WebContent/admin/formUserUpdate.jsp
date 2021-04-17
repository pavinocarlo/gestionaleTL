<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="formA" id="formA" name="formA">
	<form action="MainServlet" id="updateUser" name="updateUser" method="post">
	<ul>
		<!-- 
		la logica di questo if è: mostralo solo quando modifico lo User nel caso in cui dallo User voglio cambiargli casa
		 -->
		<c:if test="${ 0 > 0}">
			<th><label class="labelLong">Dati dell'abitazione del proprietario: </label></th>
			<li><tr>
				<th><label class="labelA">Indirizzo: </label></th>
				<th><input type="text" name="id_abitazione" id="id_abitazione" placeholder="Indirizzo"></th>
			</tr></li>
			<li><tr>
				<th><label class="labelA">Interno: </label></th>
				<th><input type="text" name="interno" id="interno" placeholder="Interno"></th>
			</tr></li>
			<hr>
		</c:if>
			<input hidden="hidden" type="text" name="id" id="id" value="${user.id}">
			<input hidden="hidden" type="text" name="password" id="password" value="${user.password}">
			<input hidden="hidden" type="text" name="id_ruolo" id="id_ruolo" value="${user.id_ruolo}">
			<input hidden="hidden" type="text" name="id_abitazione" id="id_abitazione" value="${user.id_abitazione}">
		<li><tr>
			<th><label class="labelA">Codice Fiscale: </label></th>
			<th><input type="text" name="cf" id="cf" placeholder="Codice Fiscale" value="${user.cf}"><br/></th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Nome: </label></th>
			<th><input type="text" name="nome" id="nome" placeholder="Nome" value="${user.nome}"><br/><th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Cognome: </label></th>
			<th><input type="text" name="cognome" id="cognome" placeholder="Cognome" value="${user.cognome}"><br/></th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Email: </label></th>
			<th><input type="text" name="email" id="email" placeholder="Email" value="${user.email}"><br/></th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Telefono: </label></th>
			<th><input type="text" name="telefono" id="telefono" placeholder="Telefono" value="${user.telefono}"><br/></th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Data di accesso: </label></th>
			<th><input type="date" name="data_in" id="data_in" value="${user.data_in}"><br/></th>
		</tr></li>
		<li><tr>
			<th><label class="labelA">Data di disdetta: </label></th>
			<th><input type="date" name="data_out" id="data_out" value="${user.data_out}"><br/></th>
		</tr></li>
		
	</ul>
	<ul>
		<c:if test="${successo!=null}">
			<jsp:include page="/formSuccess.jsp"></jsp:include>
		</c:if>
		<c:if test="${formUserUpdateFailed!=null}">
			<jsp:include page="/formFailedUpdate.jsp"></jsp:include>
		</c:if>
		<c:if test="${AlreadyExistException!=null}">
			<jsp:include page="/formAlreadyExists.jsp"></jsp:include>
		</c:if>
	</ul>
	<ul>
		<input class="btn btn-warning" type="submit" id="updateUser" name="updateUser" value="Modifica" >
	</ul>
	</form>
</div>	