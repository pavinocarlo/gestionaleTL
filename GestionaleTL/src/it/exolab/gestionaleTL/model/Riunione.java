package it.exolab.gestionaleTL.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Riunione {
	
	private int id;
	private Timestamp data_comunicazione, data_riunione, inizio_riunione, fine_riunione;
	private String ordine_del_giorno, luogo;
	private List<RigaPresenza> listaProprietari = new ArrayList<RigaPresenza>();
	private List<RigaArgomento> listaArgomenti = new ArrayList<RigaArgomento>();

}
