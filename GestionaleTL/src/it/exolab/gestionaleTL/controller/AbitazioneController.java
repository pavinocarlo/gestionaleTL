package it.exolab.gestionaleTL.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.crud.AbitazioneCrud;
import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.model.Abitazione;


public class AbitazioneController extends BaseController {
	
	private AbitazioneCrud abitazioneCrud = new AbitazioneCrud();
	
	public AbitazioneController(HttpServletRequest request, HttpServletResponse response) {
		
		super(request, response);
		
	}
	
	
	protected void doInsert(HttpServletRequest request, HttpServletResponse response) throws GenericException, AlreadyExistException, InvalidFieldException {
			
			Abitazione abitazione = new Abitazione(request.getParameter("interno"),
												request.getParameter("indirizzo"));
								
//			if(validate(user)) {
				
				abitazioneCrud.insert(abitazione);
//			}
	}

}
