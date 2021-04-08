package it.exolab.gestionaleTL.model;

import java.sql.Timestamp;

public class User {
	
	private int id;
	private String cf, nome, cognome, email, password, telefono, interno;
	private Timestamp data_in, data_out;
	private Ruolo ruolo;

}
