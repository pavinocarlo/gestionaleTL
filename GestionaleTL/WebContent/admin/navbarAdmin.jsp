

<div class="divB" id="divB" name="divB" >
	<ul class="nav navbar-nav">
		<li>
			<form>
				<input class="btn btn-primary btn-lg btn-block" type="submit" id ="showgestioneriunionebutton" name="showgestioneriunionebutton" value="Gestione Riunioni"/>
			</form>
		</li>
		<li>
    		<form>
    			<input class="btn btn-primary btn-lg btn-block" type="submit" id ="showgestioneabitazionebutton" name="showgestioneabitazionebutton" value="Gestione Abitazioni"/>
    		</form>
    	</li>
   		<li>
    		<form action="MainServlet" id="findlavoro" name="findlavoro" method="post">
    			<input class="btn btn-primary btn-lg btn-block" type="submit" id ="findlavoro" name="findlavoro" value="Visualizza Lavori"/>
    			<input hidden="hidden" class="labelG" type="text" name="searchlavoro" id="searchlavoro" value ="" placeholder="Trova">
    		</form>
    	</li>
		<li>
        	<form action="MainServlet" id="finddocumentazione" name="finddocumentazione" method="post">
    			<input class="btn btn-primary btn-lg btn-block" type="submit" id ="finddocumentazione" name="finddocumentazione" value="Visualizza Documenti"/>
    			<input hidden="hidden" class="labelG" type="text" name="searchdocumentazione" id="searchdocumentazione" value ="" placeholder="Trova">
    		</form>
        </li>
    	<li>
        	<form action="MainServlet" id="finduser" name="finduser" method="post">
    			<input class="btn btn-primary btn-lg btn-block" type="submit" id ="finduser" name="finduser" value="Visualizza Utenti"/>
    			<input hidden="hidden" class="labelG" type="text" name="searchuser" id="searchuser" value ="" placeholder="Trova">
    		</form>
        </li>
	</ul>
</div>