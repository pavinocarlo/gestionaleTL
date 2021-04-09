 package it.exolab.gestionaleTL.model;

import java.util.ArrayList;
import java.util.List;

public class Abitazione {
	
	private int id;
	private String interno;
	private List<User> listaUser= new ArrayList<User>();
	private List<Votazione> listaVoti= new ArrayList<Votazione>();
	
	
	
	
	public Abitazione() {
		
	}
	public Abitazione(int id, String interno, List<User> listaUser, List<Votazione> listaVoti) {
	
		this.id = id;
		this.interno = interno;
		this.listaUser = listaUser;
		this.listaVoti = listaVoti;
	}
	@Override
	public String toString() {
		return "Abitazione [id=" + id + ", interno=" + interno + ", listaUser=" + listaUser + ", listaVoti=" + listaVoti
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInterno() {
		return interno;
	}
	public void setInterno(String interno) {
		this.interno = interno;
	}
	public List<User> getListaUser() {
		return listaUser;
	}
	public void setListaUser(List<User> listaUser) {
		this.listaUser = listaUser;
	}
	public List<Votazione> getListaVoti() {
		return listaVoti;
	}
	public void setListaVoti(List<Votazione> listaVoti) {
		this.listaVoti = listaVoti;
	}

	
	
}
