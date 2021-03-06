package it.exolab.gestionaleTL.model;

import java.util.ArrayList;
import java.util.List;

public class Documentazione {
	
	private int id, id_lavoro;
	private double costo;
	private Integer stato;
	private String nome, societa;
	private byte[] documento;
	private List<Votazione> listaVoti= new ArrayList<Votazione>();
	
	public Documentazione() {

	}

	public Documentazione(int id, double costo, String nome, String societa, int id_lavoro, Integer stato) {

		this.id = id;
		this.costo = costo;
		this.nome = nome;
		this.societa = societa;
		this.id_lavoro = id_lavoro;
		this.stato = stato;

	}
	
	public Documentazione(double costo, String nome, String societa, int id_lavoro, Integer stato) {

		this.costo = costo;
		this.nome = nome;
		this.societa = societa;
		this.id_lavoro = id_lavoro;
		this.stato = stato;

	}
	
	public Documentazione(int id, double costo, String nome, String societa, Integer stato, List<Votazione> listaVoti) {
		super();
		this.id = id;
		this.costo = costo;
		this.nome = nome;
		this.societa = societa;
		this.stato = stato;
		this.listaVoti = listaVoti;
	}

	@Override
	public String toString() {
		return "Documentazione [id=" + id + ", id_lavoro=" + id_lavoro + ", costo=" + costo + ", stato=" + stato
				+ ", nome=" + nome + ", societa=" + societa + ", listaVoti=" + listaVoti + "]";
	}

	public Integer getStato() {
		return stato;
	}

	public void setStato(Integer stato) {
		this.stato = stato;
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

	public byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}
	
	

}
