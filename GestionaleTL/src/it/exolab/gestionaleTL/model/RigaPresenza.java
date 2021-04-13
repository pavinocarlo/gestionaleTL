package it.exolab.gestionaleTL.model;

public class RigaPresenza {
	
	private int id, adesione, presenza, id_riunione, id_abitazione, id_user;

	
	public RigaPresenza() {

	}

	public RigaPresenza(int id, int adesione, int presenza) {

		this.id = id;
		this.adesione = adesione;
		this.presenza = presenza;
	}

	

	public RigaPresenza(int id, int adesione, int presenza, int id_riunione, int id_abitazione, int id_user) {
		super();
		this.id = id;
		this.adesione = adesione;
		this.presenza = presenza;
		this.id_riunione = id_riunione;
		this.id_abitazione = id_abitazione;
		this.id_user = id_user;
	}

	@Override
	public String toString() {
		return "RigaPresenza [id=" + id + ", adesione=" + adesione + ", presenza=" + presenza + ", id_riunione="
				+ id_riunione + ", id_abitazione=" + id_abitazione + ", id_user=" + id_user + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAdesione() {
		return adesione;
	}

	public void setAdesione(int adesione) {
		this.adesione = adesione;
	}

	public int getPresenza() {
		return presenza;
	}

	public void setPresenza(int presenza) {
		this.presenza = presenza;
	}

	public int getId_riunione() {
		return id_riunione;
	}

	public void setId_riunione(int id_riunione) {
		this.id_riunione = id_riunione;
	}

	public int getId_abitazione() {
		return id_abitazione;
	}

	public void setId_abitazione(int id_abitazione) {
		this.id_abitazione = id_abitazione;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
	
	
	

}
