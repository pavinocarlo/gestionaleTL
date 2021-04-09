package it.exolab.gestionaleTL.model;

public class Votazione {
	
	private int id, voto;


	public Votazione() {

	}

	public Votazione(int id, int voto) {
		super();
		this.id = id;
		this.voto = voto;
	}

	
	
	@Override
	public String toString() {
		return "Votazione [id=" + id + ", voto=" + voto + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	
	
	
}
