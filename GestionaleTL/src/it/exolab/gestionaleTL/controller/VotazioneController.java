package it.exolab.gestionaleTL.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.crud.VotazioneCrud;
import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.model.Votazione;

public class VotazioneController extends BaseController {
	
	VotazioneCrud votazioneCrud = new VotazioneCrud();
	
	public VotazioneController(HttpServletRequest request, HttpServletResponse response) {
			
		super(request, response);	
	}
	
	protected void doInsert(HttpServletRequest request, HttpServletResponse response) throws GenericException, AlreadyExistException, InvalidFieldException {
			
			Votazione votazione = new Votazione(Integer.parseInt(request.getParameter("voto")),
										Integer.parseInt(request.getParameter("id_abitazione")),
										Integer.parseInt(request.getParameter("id_documentazione")));
								
	//		if(validate(user)) {
				
			votazioneCrud.insert(votazione);
	//		}
	}
	
	protected void doUpdate(HttpServletRequest request, HttpServletResponse response) throws GenericException, AlreadyExistException, InvalidFieldException {
		
		Votazione votazione = new Votazione(Integer.parseInt(request.getParameter("voto")),
									Integer.parseInt(request.getParameter("id_abitazione")),
									Integer.parseInt(request.getParameter("id_documentazione")));
							
//		if(validate(user)) {
			
		votazioneCrud.update(votazione);
//		}
	}

}
