package it.exolab.gestionaleTL.model;

import java.util.ArrayList;
import java.util.List;

public class Condominio {
	
	private int id;
	private String indirizzo;
	private List<Abitazione> listaProprietari= new ArrayList<Abitazione>();
	
	
	public Condominio() {

	}


	public Condominio(int id, String indirizzo, List<Abitazione> listaProprietari) {

		this.id = id;
		this.indirizzo = indirizzo;
		this.listaProprietari = listaProprietari;
	}


	
	@Override
	public String toString() {
		return "Condominio [id=" + id + ", indirizzo=" + indirizzo + ", listaProprietari=" + listaProprietari + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getIndirizzo() {
		return indirizzo;
	}


	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}


	public List<Abitazione> getListaProprietari() {
		return listaProprietari;
	}


	public void setListaProprietari(List<Abitazione> listaProprietari) {
		this.listaProprietari = listaProprietari;
	}

	
	
}
