package it.exolab.gestionaleTL.model;

import java.util.ArrayList;
import java.util.List;

public class RigaArgomento {
	
	private int id, voto_richiesto;
	private String quesito;
	private List<Votazione> listaVoti = new ArrayList<Votazione>();
	
	
	
	
	
	public RigaArgomento() {

	}
	public RigaArgomento(int id, int voto_richiesto, String quesito, List<Votazione> listaVoti) {

		this.id = id;
		this.voto_richiesto = voto_richiesto;
		this.quesito = quesito;
		this.listaVoti = listaVoti;
	}
	@Override
	public String toString() {
		return "RigaArgomento [id=" + id + ", voto_richiesto=" + voto_richiesto + ", quesito=" + quesito
				+ ", listaVoti=" + listaVoti + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVoto_richiesto() {
		return voto_richiesto;
	}
	public void setVoto_richiesto(int voto_richiesto) {
		this.voto_richiesto = voto_richiesto;
	}
	public String getQuesito() {
		return quesito;
	}
	public void setQuesito(String quesito) {
		this.quesito = quesito;
	}
	public List<Votazione> getListaVoti() {
		return listaVoti;
	}
	public void setListaVoti(List<Votazione> listaVoti) {
		this.listaVoti = listaVoti;
	}
	
	
	
}
