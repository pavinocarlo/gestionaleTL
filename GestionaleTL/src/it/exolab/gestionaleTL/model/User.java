package it.exolab.gestionaleTL.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class User {
	
	private int id, id_ruolo, id_abitazione;
	private String cf, nome, cognome, email, password, telefono;
	private Timestamp data_in, data_out;
	private Ruolo ruolo;
	private List<RigaPresenza> listapresenze = new ArrayList<RigaPresenza>();

	
	public User() {

	}
	
	public User(String cf, String nome, String cognome, String email, String password, String telefono) {
		
		this.cf = cf;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		
	}
	
	
	public User(String cf, String nome, String cognome, String email, String password, String telefono,
			Timestamp data_in, Timestamp data_out, int id_ruolo, int id_abitazione) {

		this.cf = cf;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.data_in = data_in;
		this.data_out = data_out;
		this.id_ruolo = id_ruolo;
		this.id_abitazione = id_abitazione;
		this.ruolo = new Ruolo(id_ruolo);
		
	}

	

	
	public User(int id, int id_ruolo, int id_abitazione, String cf, String nome, String cognome, String email,
			String password, String telefono, Timestamp data_in, Timestamp data_out, Ruolo ruolo,
			List<RigaPresenza> listapresenze) {
		super();
		this.id = id;
		this.id_ruolo = id_ruolo;
		this.id_abitazione = id_abitazione;
		this.cf = cf;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.data_in = data_in;
		this.data_out = data_out;
		this.ruolo = ruolo;
		this.listapresenze = listapresenze;
	}
	
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", id_ruolo=" + id_ruolo + ", id_abitazione=" + id_abitazione + ", cf=" + cf
				+ ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", password=" + password
				+ ", telefono=" + telefono + ", data_in=" + data_in + ", data_out=" + data_out + ", ruolo=" + ruolo
				+ ", listapresenze=" + listapresenze + "]";
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


	public List<RigaPresenza> getListaPresenze() {
		return listapresenze;
	}


	public void setListaPresenze(List<RigaPresenza> listapresenze) {
		this.listapresenze = listapresenze;
	}


	public int getId_ruolo() {
		return id_ruolo;
	}


	public void setId_ruolo(int id_ruolo) {
		this.id_ruolo = id_ruolo;
	}


	public int getId_abitazione() {
		return id_abitazione;
	}


	public void setId_abitazione(int id_abitazione) {
		this.id_abitazione = id_abitazione;
	}
	
	

}
