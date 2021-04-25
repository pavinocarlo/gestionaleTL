package it.exolab.gestionaleTL.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.crud.VotazioneCrud;
import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.model.Documentazione;
import it.exolab.gestionaleTL.model.User;
import it.exolab.gestionaleTL.model.Votazione;

public class VotazioneController extends BaseController {
	
	VotazioneCrud votazioneCrud = new VotazioneCrud();
	
	public VotazioneController(HttpServletRequest request, HttpServletResponse response) {
			
		super(request, response);	
	}
	public void doInsert(HttpServletRequest request, HttpServletResponse response) {
		
		int voto = request.getParameter("approvo") != null ? 1 : 2;
		User user = (User) request.getSession().getAttribute("user"); 
		System.out.println("id votazione + " + request.getParameter("iddocumentazione"));
		Votazione votazione = new Votazione(voto, user.getId_abitazione(),
										Integer.parseInt(request.getParameter("iddocumentazione")));
								
	//		if(validate(user)) {
				
			try {
				votazioneCrud.insert(votazione);
			} catch (GenericException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AlreadyExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	//		}
	}
}
