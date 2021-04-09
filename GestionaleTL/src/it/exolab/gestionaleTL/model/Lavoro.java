package it.exolab.gestionaleTL.model;

import java.util.ArrayList;
import java.util.List;

public class Lavoro {
	
	private int id;
	private String nome, esito_voto, stato;
	private Documentazione documentazione;
	private List<Votazione> listaVoti = new ArrayList<Votazione>();
	
	public Lavoro() {

	}
	
	public Lavoro(int id, String nome, String esito_voto, String stato, Documentazione documentazione,
			List<Votazione> listaVoti) {
		super();
		this.id = id;
		this.nome = nome;
		this.esito_voto = esito_voto;
		this.stato = stato;
		this.documentazione = documentazione;
		this.listaVoti = listaVoti;
	}

	@Override
	public String toString() {
		return "Lavoro [id=" + id + ", nome=" + nome + ", esito_voto=" + esito_voto + ", stato=" + stato
				+ ", documentazione=" + documentazione + ", listaVoti=" + listaVoti + "]";
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

	public Documentazione getDocumentazione() {
		return documentazione;
	}

	public void setDocumentazione(Documentazione documentazione) {
		this.documentazione = documentazione;
	}

	public List<Votazione> getListaVoti() {
		return listaVoti;
	}

	public void setListaVoti(List<Votazione> listaVoti) {
		this.listaVoti = listaVoti;
	}
	
	
	
	
}
