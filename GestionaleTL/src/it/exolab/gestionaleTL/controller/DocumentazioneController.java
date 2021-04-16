package it.exolab.gestionaleTL.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
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
	
	public void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Documentazione documentazione = new Documentazione(Double.parseDouble(request.getParameter("costo")),
														request.getParameter("nome"),
														request.getParameter("societa"),
														Integer.parseInt(request.getParameter("id_lavoro")));
							
//		if(validate(user)) {
			
		try {
			documentazioneCrud.insert(documentazione);
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
	
	public void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Documentazione documentazione = new Documentazione(Double.parseDouble(request.getParameter("costo")),
														request.getParameter("nome"),
														request.getParameter("societa"),
														Integer.parseInt(request.getParameter("id_lavoro")));
//		if(validate(user)) {
			
		try {
			documentazioneCrud.update(documentazione);
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
	
	public void doFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = (String) request.getAttribute("id");
		if(!id.equals("")) {
			Documentazione documentazione = documentazioneCrud.find(Integer.valueOf(id));
			request.setAttribute("documentazione", documentazione);
			request.getRequestDispatcher("home.jsp").include(request, response);
		}
		else {
			List<Documentazione> listaDocumentazione = documentazioneCrud.findAll();
			request.setAttribute("listaDocumentazione", listaDocumentazione);
			request.getRequestDispatcher("home.jsp").include(request, response);
		}
	}

}
