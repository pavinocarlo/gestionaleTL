package it.exolab.gestionaleTL.model;

public class RigaPresenza {
	
	private int id, adesione, presenza;

	
	public RigaPresenza() {

	}

	public RigaPresenza(int id, int adesione, int presenza) {

		this.id = id;
		this.adesione = adesione;
		this.presenza = presenza;
	}

	@Override
	public String toString() {
		return "RigaPresenza [id=" + id + ",  adesione=" + adesione + ", presenza=" + presenza + "]";
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
	
	
	
	

}
