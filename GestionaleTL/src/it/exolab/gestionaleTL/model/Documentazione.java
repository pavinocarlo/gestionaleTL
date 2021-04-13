package it.exolab.gestionaleTL.model;

import java.util.ArrayList;
import java.util.List;

public class Documentazione {
	
	private int id;
	private double costo;
	private String nome, societa;
	private List<Votazione> listaVoti= new ArrayList<Votazione>();
	
	public Documentazione() {

	}
	
	public Documentazione(int id, double costo, String nome, String societa, List<Votazione> listaVoti) {
		super();
		this.id = id;
		this.costo = costo;
		this.nome = nome;
		this.societa = societa;
		this.listaVoti = listaVoti;
	}
	
	@Override
	public String toString() {
		return "Documentazione [id=" + id + ", costo=" + costo + ", nome=" + nome + ", societa=" + societa
				+ ", listaVoti=" + listaVoti + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSocieta() {
		return societa;
	}
	public void setSocieta(String societa) {
		this.societa = societa;
	}

	public List<Votazione> getListaVoti() {
		return listaVoti;
	}

	public void setListaVoti(List<Votazione> listaVoti) {
		this.listaVoti = listaVoti;
	}
	
	
	
}
