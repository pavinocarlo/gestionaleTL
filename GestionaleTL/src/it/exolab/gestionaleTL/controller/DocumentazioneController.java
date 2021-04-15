package it.exolab.gestionaleTL.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.crud.DocumentazioneCrud;
import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.model.Documentazione;

public class DocumentazioneController extends BaseController {
	
	DocumentazioneCrud documentazioneCrud = new DocumentazioneCrud();
	
	public DocumentazioneController(HttpServletRequest request, HttpServletResponse response) {
		
		super(request, response);
		
	}
	
	protected void doInsert(HttpServletRequest request, HttpServletResponse response) throws GenericException, AlreadyExistException, InvalidFieldException {
		
		Documentazione documentazione = new Documentazione(Double.parseDouble(request.getParameter("costo")),
														request.getParameter("nome"),
														request.getParameter("societa"),
														Integer.parseInt(request.getParameter("id_lavoro")));
							
//		if(validate(user)) {
			
		documentazioneCrud.insert(documentazione);
//		}
}
	

}
