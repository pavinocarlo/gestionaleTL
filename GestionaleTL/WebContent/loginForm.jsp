<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<div class="divA" id="divA" name="divA">
	<c:choose>
		<c:when test = "${1 > 0}">
			<c:out value="Effettua il login: "/>
			<br/>
			<form action="MainServlet" id="loginForm" name="loginForm" method="post">
				<input type="hidden" name="submitted" value="true">
				
			
				<div class="div2" id="div2" name="div2">
					<label for="email" class="div1">Email: </label>
					<input type="text" name="email" id="email" placeholder="email">
					<label for="password" class="div1">Password: </label>
					<input type="password" name="password" id="password" placeholder="password">
					<a>   </a><input class="btn btn-success" type="submit" value="Login" name="login" id="loginButton">
				</div>	
				<c:if test="${invalidLogin!=null}">
					<c:out value="Inserisci dati validi per effettuare la registrazione." />
				</c:if>
				<c:if test="${notFoundLogin!=null}">
					<c:out value="email non presente o password errata." />
				</c:if>
			</form>
			
			<form action="MainServlet">
				<br/>
				<c:out value="Non ricordi la password? Clicca qui per ottenerne una nuova sulla tua mail:  "/>
				<input class="btn btn-info" type="submit" id ="resetPasswordButton" name="resetPasswordButton" value="Reset Password"/>
			</form>	
		</c:when>
		
		<c:when test="${1 > 0}">
			<form>
				<c:out value="Benvenuto, ${User.nome}"/>
				<input class="btn btn-danger" type="submit" id ="logoutButton" name="logoutButton" value="Logout"/>
			</form>
		</c:when>
	</c:choose>
</div>