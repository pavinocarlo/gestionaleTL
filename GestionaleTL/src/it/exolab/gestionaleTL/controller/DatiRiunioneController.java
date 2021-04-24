package it.exolab.gestionaleTL.controller;

import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.crud.DatiRiunioneCrud;

public class DatiRiunioneController extends BaseController{
	
	DatiRiunioneCrud datiRiunioneCrud = new DatiRiunioneCrud();
	
	
	public DatiRiunioneController(HttpServletRequest request, HttpServletResponse response) {
		
		super(request, response);
	}
	
	public void insert(int id_riunione, int id_documentazione) {
		
		datiRiunioneCrud.insert(id_riunione, id_documentazione);
	}
	
	public void delete(int id_riunione) {
		
		datiRiunioneCrud.delete(id_riunione);
	}
	
	public Entry<Integer, Integer> doCheckRiunione(int id_riunione) {
		
		Entry<Integer, Integer> datiAttuali = datiRiunioneCrud.find(id_riunione);
		
		return datiAttuali;  
	}

}
