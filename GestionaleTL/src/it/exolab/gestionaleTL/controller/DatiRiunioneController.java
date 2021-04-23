package it.exolab.gestionaleTL.controller;

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

}
