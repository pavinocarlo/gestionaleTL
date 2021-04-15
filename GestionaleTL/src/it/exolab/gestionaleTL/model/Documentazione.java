package it.exolab.gestionaleTL.model;

import java.util.ArrayList;
import java.util.List;

public class Documentazione {
	
	private int id, id_lavoro;
	private double costo;
	private String nome, societa;
	private List<Votazione> listaVoti= new ArrayList<Votazione>();
	
	public Documentazione() {

	}

	public Documentazione(double costo, String nome, String societa, int id_lavoro) {

		this.costo = costo;
		this.nome = nome;
		this.societa = societa;
		this.id_lavoro = id_lavoro;

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
		return "Documentazione [id=" + id + ", id_lavoro=" + id_lavoro + ", costo=" + costo + ", nome=" + nome
				+ ", societa=" + societa + ", listaVoti=" + listaVoti + "]";
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

	public int getId_lavoro() {
		return id_lavoro;
	}
	public void setId_lavoro(int id_lavoro) {
		this.id_lavoro = id_lavoro;
	}

}
