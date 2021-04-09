package it.exolab.gestionaleTL.model;

import java.sql.Timestamp;

public class User {
	
	private int id;
	private String cf, nome, cognome, email, password, telefono;
	private Timestamp data_in, data_out;
	private Ruolo ruolo;

	
	public User() {

	}
	public User(int id, String cf, String nome, String cognome, String email, String password, String telefono,
			Timestamp data_in, Timestamp data_out, Ruolo ruolo) {
		
		this.id = id;
		this.cf = cf;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.data_in = data_in;
		this.data_out = data_out;
		this.ruolo = ruolo;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", cf=" + cf + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
				+ ", password=" + password + ", telefono=" + telefono + ", data_in=" + data_in + ", data_out="
				+ data_out + ", ruolo=" + ruolo + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Timestamp getData_in() {
		return data_in;
	}
	public void setData_in(Timestamp data_in) {
		this.data_in = data_in;
	}
	public Timestamp getData_out() {
		return data_out;
	}
	public void setData_out(Timestamp data_out) {
		this.data_out = data_out;
	}
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	
	

}
