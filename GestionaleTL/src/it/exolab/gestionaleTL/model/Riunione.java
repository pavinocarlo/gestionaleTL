package it.exolab.gestionaleTL.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Riunione {
	
	private int id;
	private Timestamp data_comunicazione, data_riunione, inizio_riunione, fine_riunione;
	private String ordine_del_giorno, luogo;
	private List<RigaPresenza> listaPresenze = new ArrayList<RigaPresenza>();
	private List<Lavoro> listaLavori = new ArrayList<Lavoro>();

	
	public Riunione() {

	}
	
	public Riunione(Timestamp data_comunicazione, Timestamp data_riunione, String ordine_del_giorno, String luogo) {

		this.data_comunicazione = data_comunicazione;
		this.data_riunione = data_riunione;
		this.ordine_del_giorno = ordine_del_giorno;
		this.luogo = luogo;

	}
	
	public Riunione(Timestamp data_comunicazione, Timestamp data_riunione, Timestamp inizio_riunione,
						Timestamp fine_riunione, String ordine_del_giorno, String luogo) {

		this.data_comunicazione = data_comunicazione;
		this.data_riunione = data_riunione;
		this.inizio_riunione = inizio_riunione;
		this.fine_riunione = fine_riunione;
		this.ordine_del_giorno = ordine_del_giorno;
		this.luogo = luogo;

	}
	
	public Riunione(int id, Timestamp data_comunicazione, Timestamp data_riunione, Timestamp inizio_riunione,
			Timestamp fine_riunione, String ordine_del_giorno, String luogo, List<RigaPresenza> listaPresenze,
			List<Lavoro> listaArgomenti) {

		this.id = id;
		this.data_comunicazione = data_comunicazione;
		this.data_riunione = data_riunione;
		this.inizio_riunione = inizio_riunione;
		this.fine_riunione = fine_riunione;
		this.ordine_del_giorno = ordine_del_giorno;
		this.luogo = luogo;
		this.listaPresenze = listaPresenze;
		this.listaLavori = listaArgomenti;
	}
	@Override
	public String toString() {
		return "Riunione [id=" + id + ", data_comunicazione=" + data_comunicazione + ", data_riunione=" + data_riunione
				+ ", inizio_riunione=" + inizio_riunione + ", fine_riunione=" + fine_riunione + ", ordine_del_giorno="
				+ ordine_del_giorno + ", luogo=" + luogo + ", listaPresenze=" + listaPresenze
				+ ", listaArgomenti=" + listaLavori + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getData_comunicazione() {
		return data_comunicazione;
	}
	public void setData_comunicazione(Timestamp data_comunicazione) {
		this.data_comunicazione = data_comunicazione;
	}
	public Timestamp getData_riunione() {
		return data_riunione;
	}
	public void setData_riunione(Timestamp data_riunione) {
		this.data_riunione = data_riunione;
	}
	public Timestamp getInizio_riunione() {
		return inizio_riunione;
	}
	public void setInizio_riunione(Timestamp inizio_riunione) {
		this.inizio_riunione = inizio_riunione;
	}
	public Timestamp getFine_riunione() {
		return fine_riunione;
	}
	public void setFine_riunione(Timestamp fine_riunione) {
		this.fine_riunione = fine_riunione;
	}
	public String getOrdine_del_giorno() {
		return ordine_del_giorno;
	}
	public void setOrdine_del_giorno(String ordine_del_giorno) {
		this.ordine_del_giorno = ordine_del_giorno;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	public List<RigaPresenza> getListaPresenze() {
		return listaPresenze;
	}
	public void setListaPresenze(List<RigaPresenza> listaPresenze) {
		this.listaPresenze = listaPresenze;
	}
	public List<Lavoro> getListaLavori() {
		return listaLavori;
	}
	public void setListaLavori(List<Lavoro> listaArgomenti) {
		this.listaLavori = listaArgomenti;
	}
	
	
	
}
