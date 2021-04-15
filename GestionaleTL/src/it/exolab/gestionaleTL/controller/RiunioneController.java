package it.exolab.gestionaleTL.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.crud.RiunioneCrud;
import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.model.Abitazione;
import it.exolab.gestionaleTL.model.Riunione;

public class RiunioneController extends BaseController {
	
	RiunioneCrud riunioneCrud =  new RiunioneCrud();

	public RiunioneController(HttpServletRequest request, HttpServletResponse response) {
			
			super(request, response);
			
		}
	
	protected void doInsert(HttpServletRequest request, HttpServletResponse response) throws GenericException, AlreadyExistException, InvalidFieldException {
		
		Riunione riunione = new Riunione((Timestamp.valueOf("" + request.getParameter("data_comunicazione") + "00:00:00")),
										(Timestamp.valueOf("" + request.getParameter("data_riunione") + "00:00:00")),
										request.getParameter("ordine_del_giorno"),
										request.getParameter("luogo"));
							
//		if(validate(user)) {
			
		riunioneCrud.insert(riunione);
//		}
	}
	
	protected void doUpdate(HttpServletRequest request, HttpServletResponse response) throws GenericException, AlreadyExistException, InvalidFieldException {
			
			Riunione riunione = new Riunione((Timestamp.valueOf("" + request.getParameter("data_comunicazione") + "00:00:00")),
											(Timestamp.valueOf("" + request.getParameter("data_riunione") + "00:00:00")),
											(Timestamp.valueOf("" + request.getParameter("inizio_riunione") + "00:00:00")),
											(Timestamp.valueOf("" + request.getParameter("fine_riunione") + "00:00:00")),
											request.getParameter("ordine_del_giorno"),
											request.getParameter("luogo"));
								
	//		if(validate(user)) {
				
			riunioneCrud.update(riunione);
	//		}
		}
}
