package it.exolab.gestionaleTL.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.crud.RiunioneCrud;
import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.model.Abitazione;
import it.exolab.gestionaleTL.model.Documentazione;
import it.exolab.gestionaleTL.model.Riunione;

public class RiunioneController extends BaseController {
	
	RiunioneCrud riunioneCrud =  new RiunioneCrud();

	public RiunioneController(HttpServletRequest request, HttpServletResponse response) {
			
			super(request, response);
			
		}
	
	public void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String data = request.getParameter("data_riunione").toString();
		data = data.replace('T', ' ');

		Riunione riunione = new Riunione(Integer.parseInt(request.getParameter("stato")),
										null,
										(Timestamp.valueOf("" + data + ":00")),
										request.getParameter("ordine_del_giorno"),
										request.getParameter("luogo"),
										request.getParameter("indirizzo_abitazione"));
							
//		if(validate(user)) {
			
		try {
			riunioneCrud.insert(riunione);
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
		request.setAttribute(RIUNIONE+INSERT+SUCCESS, RIUNIONE+INSERT+SUCCESS);
		request.getRequestDispatcher(HOME).include(request, response);
//		}
	}
	
	public void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		Riunione riunione = new Riunione(Integer.parseInt(request.getParameter("stato")),
										(Timestamp.valueOf("" + request.getParameter("data_comunicazione") + "00:00:00")),
										(Timestamp.valueOf("" + request.getParameter("data_riunione") + "00:00:00")),
										(Timestamp.valueOf("" + request.getParameter("inizio_riunione") + "00:00:00")),
										(Timestamp.valueOf("" + request.getParameter("fine_riunione") + "00:00:00")),
										request.getParameter("ordine_del_giorno"),
										request.getParameter("luogo"),
										request.getParameter("indirizzo_abitazione"));
							
//		if(validate(user)) {
			
		try {
			riunioneCrud.update(riunione);
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
		request.setAttribute(RIUNIONE+UPDATE+SUCCESS, RIUNIONE+UPDATE+SUCCESS);
		request.getRequestDispatcher(HOME).include(request, response);
//		}
	}
	
	public void doFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String search = request.getParameter(SEARCH+RIUNIONE);
		List<Riunione> listaRiunioni = new ArrayList<Riunione>();
		
		if(search.equals("") || search == null) {
			listaRiunioni = riunioneCrud.findAll();
			request.setAttribute(LISTA+"riunioni", listaRiunioni);
			request.getRequestDispatcher(HOME).include(request, response);
		}
		else {
			listaRiunioni.add(riunioneCrud.find(Integer.valueOf(search)));
			request.setAttribute(LISTA+"riunioni", listaRiunioni);
			request.getRequestDispatcher(HOME).include(request, response);
			
		}
	}
}
