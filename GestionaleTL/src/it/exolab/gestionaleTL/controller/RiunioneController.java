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
		
		UtilController utilController = new UtilController(request, response);
		String data = request.getParameter("data_riunione").toString();
		data = data.replace('T', ' ');

		Riunione riunione = new Riunione(Integer.parseInt(request.getParameter("stato")),
										null,
										(Timestamp.valueOf("" + data + ":00")),
										request.getParameter("ordine_del_giorno"),
										request.getParameter("luogo"),
										request.getParameter("indirizzo"));			
//		if(validate(user)) {
			
		try {
			riunioneCrud.insert(riunione);
			System.out.println("prima della chiamata dell insert righer");
			utilController.doInsertRighePresenza(riunione);
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
	
	public void doAvviaRiunione(HttpServletRequest request, HttpServletResponse response) {
		
		UtilController utilController = new UtilController(request, response);
		Riunione riunione = riunioneCrud.find(Integer.parseInt(request.getParameter("idriunione")));
		riunione.setStato(2);			
			
		try {
			riunioneCrud.update(riunione);
			utilController.doAvviaRiunione(riunione);
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
		
		request.getSession().setAttribute("riunione", riunione);
		
	}
	
	public void doArrestaRiunione(HttpServletRequest request, HttpServletResponse response) {
		
		UtilController utilController = new UtilController(request, response);
		Riunione riunione = riunioneCrud.find(Integer.parseInt(request.getParameter("idriunione")));
		riunione.setStato(3);
		try {
			riunioneCrud.update(riunione);
			utilController.doArrestaRiunione(riunione);
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
		request.getSession().removeAttribute("riunione");
		request.setAttribute("riunione", riunione);
	}
	
	public void doFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String search = request.getParameter(SEARCH+RIUNIONE);
		List<Riunione> listaRiunioni = new ArrayList<Riunione>();
		
		if(search.equals("") || search == null) {
			listaRiunioni = riunioneCrud.findAll();
			request.setAttribute(SEARCH+RIUNIONE, search);
			request.setAttribute(LISTA+"riunioni", listaRiunioni);
			request.getRequestDispatcher(HOME).include(request, response);
		}
		else {
			listaRiunioni.add(riunioneCrud.find(Integer.valueOf(search)));
			request.setAttribute(SEARCH+RIUNIONE, search);
			request.setAttribute(LISTA+"riunioni", listaRiunioni);
			request.getRequestDispatcher(HOME).include(request, response);
		}
	}
	
	public void doFindForUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Riunione Riunione = riunioneCrud.find(Integer.valueOf(request.getParameter("idriunione")));
		request.setAttribute("riunione", Riunione);
	}
	
	public Riunione doFindForLogin(String indirizzo_abitazione, int stato, int user_id) {
	
		Riunione Riunione = riunioneCrud.findByIndirizzoStatoUser(indirizzo_abitazione, stato, user_id);
		return Riunione;
	}
	
	public void doListaRiunioniDaFare(){
		
		List<Riunione> listaRiunioni = riunioneCrud.findForRiunione(Timestamp.valueOf("" + request.getParameter("data_riunione") + " 00:00:00"), 1);
		request.setAttribute("listariunioni", listaRiunioni);
	}
	
}
