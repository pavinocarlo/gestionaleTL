package it.exolab.gestionaleTL.model;

public class RigaPresenza {
	
	private int id, id_riunione, id_user, adesione, presenza;

	
	
	
	
	public RigaPresenza() {

	}

	public RigaPresenza(int id, int id_riunione, int id_user, int adesione, int presenza) {

		this.id = id;
		this.id_riunione = id_riunione;
		this.id_user = id_user;
		this.adesione = adesione;
		this.presenza = presenza;
	}

	@Override
	public String toString() {
		return "RigaPresenza [id=" + id + ", id_riunione=" + id_riunione + ", id_user=" + id_user + ", adesione="
				+ adesione + ", presenza=" + presenza + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_riunione() {
		return id_riunione;
	}

	public void setId_riunione(int id_riunione) {
		this.id_riunione = id_riunione;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
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
	
	
	
	

}
