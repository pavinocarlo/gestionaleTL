package it.exolab.gestionaleTL.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
				request.setAttribute(ABITAZIONE+INSERT+SUCCESS, ABITAZIONE+INSERT+SUCCESS);
				request.getRequestDispatcher(HOME).include(request, response);
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
			request.setAttribute(ABITAZIONE+UPDATE+SUCCESS, ABITAZIONE+UPDATE+SUCCESS);
			request.getRequestDispatcher(HOME).include(request, response);
//		}
	}
	
	public void doFind(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		String search = request.getParameter(SEARCH+ABITAZIONE);
		List<Abitazione> listaAbitazioni = new ArrayList<Abitazione>();
		
		if(search.equals("") || search == null) {
			listaAbitazioni = abitazioneCrud.findAll();
			request.setAttribute(LISTA+"abitazioni", listaAbitazioni);
			request.getRequestDispatcher(HOME).include(request, response);
		}
		else {
			listaAbitazioni.add(abitazioneCrud.findWithProprietario(Integer.valueOf(search)));
			request.setAttribute(LISTA+"abitazioni", listaAbitazioni);
			request.getRequestDispatcher(HOME).include(request, response);
		}
	}
	
	public Abitazione doFindForLogin(int abitazione_id) {
		
		Abitazione abitazione = abitazioneCrud.find(abitazione_id);
		return abitazione;
	}
	
	public void doDelete() throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("idabitazione"));
		try {
			abitazioneCrud.delete(id);
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
		request.setAttribute(ABITAZIONE+DELETE+SUCCESS, ABITAZIONE+DELETE+SUCCESS);
		request.getRequestDispatcher(HOME).include(request, response);
		
	}
	
	public List<Abitazione> dofindByIndirizzo(String indirizzo) {
		
		List<Abitazione> listaAbitazioni = abitazioneCrud.findByIndirizzo(indirizzo);
		return listaAbitazioni;
	}
	
	public List<Abitazione> dofindAllGrouped() {
		
		List<Abitazione> listaAbitazioni = abitazioneCrud.findAllGrouped();
		return listaAbitazioni;
	}

}
