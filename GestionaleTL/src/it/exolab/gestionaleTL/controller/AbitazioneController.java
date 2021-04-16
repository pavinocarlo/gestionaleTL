package it.exolab.gestionaleTL.controller;

import java.io.IOException;

import javax.servlet.ServletException;
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
	
	
	public void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			Abitazione abitazione = new Abitazione(request.getParameter("interno"),
												request.getParameter("indirizzo"));
								
//			if(validate(user)) {
				
				try {
					abitazioneCrud.insert(abitazione);
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
				request.setAttribute("successo", "successo");
				request.getRequestDispatcher("home.jsp").include(request, response);
//			}
	}
	public void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Abitazione abitazione = new Abitazione(request.getParameter("interno"),
											request.getParameter("indirizzo"));
							
//		if(validate(user)) {
			
			try {
				abitazioneCrud.update(abitazione);
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
			request.setAttribute("successo", "successo");
			request.getRequestDispatcher("home.jsp").include(request, response);
//		}
}

}
