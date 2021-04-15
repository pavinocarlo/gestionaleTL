package it.exolab.gestionaleTL.model;

public class Votazione {
	
	private int id, voto, id_abitazione, id_documentazione;


	public Votazione() {

	}

	public Votazione(int id, int voto) {
		super();
		this.id = id;
		this.voto = voto;
	}


	public Votazione(int voto, int id_abitazione, int id_documentazione) {

		this.voto = voto;
		this.id_abitazione = id_abitazione;
		this.id_documentazione = id_documentazione;
	}


	@Override
	public String toString() {
		return "Votazione [id=" + id + ", voto=" + voto + ", id_abitazione=" + id_abitazione + ", id_documentazione="
				+ id_documentazione + "]";
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

	public int getId_abitazione() {
		return id_abitazione;
	}

	public void setId_abitazione(int id_abitazione) {
		this.id_abitazione = id_abitazione;
	}

	public int getId_documentazione() {
		return id_documentazione;
	}

	public void setId_documentazione(int id_documentazione) {
		this.id_documentazione = id_documentazione;
	}

	
	
	
}
