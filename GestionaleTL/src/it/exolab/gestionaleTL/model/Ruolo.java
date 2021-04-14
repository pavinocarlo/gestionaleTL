package it.exolab.gestionaleTL.model;

public class Ruolo {
	
	private int id;
	private String ruolo;
	
	
	public Ruolo() {
		
	}
	public Ruolo(int id) {
	
		this.id = id;
		this.ruolo = setRuonoName(id);
	}
	@Override
	public String toString() {
		return "Ruolo [id=" + id + ", ruolo=" + ruolo + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	private String setRuonoName(int id) {
		
		String ruolo;
		if(id==1)
			ruolo = "Amministratore";
		if(id==2) 
			ruolo = "Proprietario";
		else
			ruolo = "Delegato";
		
		return ruolo;
	}
		
		
		
	
	
}
