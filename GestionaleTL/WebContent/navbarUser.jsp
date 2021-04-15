

<div class="divB" id="divB" name="divB" >
	<ul class="nav navbar-nav">
    	<li style="border-style:groove; background-color:rgba(233,233,233,0.6);"><a href="#">Storico Riunioni</a></li>
        <li style="border-style:groove; background-color:rgba(233,233,233,0.6);"><a href="#">Consulta Documentazione</a></li>
        <br/>
        <li>
        <c:if test="${1>0 }">
        	<a class="alert" name="alert" href="#" style="background-color:rgba(33,33,33,0.1);">Attenzione: una riunione è in corso. Clicca per partecipare</a>
        </c:if>
        </li>
	</ul>
</div>