package it.exolab.gestionaleTL.model;

import java.util.ArrayList;
import java.util.List;

public class Lavoro {
	
	private int id, id_riunione;
	private String nome, esito_voto, stato;
	private List<Documentazione> listaDocumenti = new ArrayList<Documentazione>();
	
	public Lavoro() {

	}
	
	public Lavoro(int id_riunione, String nome) {

		this.id_riunione = id_riunione;
		this.nome = nome;

	}

	public Lavoro(int id_riunione, String nome, String esito_voto, String stato) {

		this.id_riunione = id_riunione;
		this.nome = nome;
		this.esito_voto = esito_voto;
		this.stato = stato;

	}

	public Lavoro(int id, String nome, String esito_voto, String stato, List<Documentazione> listaDocumenti) {
		super();
		this.id = id;
		this.nome = nome;
		this.esito_voto = esito_voto;
		this.stato = stato;
		this.listaDocumenti = listaDocumenti;
	}





	@Override
	public String toString() {
		return "Lavoro [id=" + id + ", id_riunione=" + id_riunione + ", nome=" + nome + ", esito_voto=" + esito_voto
				+ ", stato=" + stato + ", listaDocumenti=" + listaDocumenti + "]";
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEsito_voto() {
		return esito_voto;
	}

	public void setEsito_voto(String esito_voto) {
		this.esito_voto = esito_voto;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}


	public List<Documentazione> getListaDocumenti() {
		return listaDocumenti;
	}


	public void setListaDocumenti(List<Documentazione> listaDocumenti) {
		this.listaDocumenti = listaDocumenti;
	}





	public int getId_riunione() {
		return id_riunione;
	}





	public void setId_riunione(int id_riunione) {
		this.id_riunione = id_riunione;
	}
	
	
	
	
}
