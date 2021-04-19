package it.exolab.gestionaleTL.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.crud.LavoroCrud;
import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;

import it.exolab.gestionaleTL.model.Lavoro;

public class LavoroController extends BaseController {
	
	LavoroCrud lavoroCrud = new LavoroCrud();
	
	public LavoroController(HttpServletRequest request, HttpServletResponse response) {
			
			super(request, response);
			
		}

	public void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Lavoro lavoro = new Lavoro(Integer.parseInt(request.getParameter("id_riunione")),
									request.getParameter("nome"),
									request.getParameter("esito_voto"),
									request.getParameter("stato"));
							
//		if(validate(user)) {
			
			try {
				lavoroCrud.insert(lavoro);
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
			request.setAttribute("lavoroinsertsuccess", "lavoroinsertsuccess");
			request.getRequestDispatcher(HOME).include(request, response);
//		}
	}
	
	public void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Lavoro lavoro = new Lavoro(Integer.parseInt(request.getParameter("Id_riunione")),
									request.getParameter("nome"),
									request.getParameter("esito_voto"),
									request.getParameter("stato"));
							
//		if(validate(user)) {
			
			try {
				lavoroCrud.update(lavoro);
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
			request.setAttribute("lavoroupdatesuccess", "lavoroupdatesuccess");
			request.getRequestDispatcher(HOME).include(request, response);
//		}
	}
	
	public void doFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search = request.getParameter("searchlavoro");
		List<Lavoro> listaLavori = new ArrayList<Lavoro>();
		
		if(search.equals("") || search == null) {
			listaLavori = lavoroCrud.findAll();
			request.setAttribute("listalavori", listaLavori);
			request.getRequestDispatcher(HOME).include(request, response);
		}
		else {
			try {
				if(Integer.parseInt(search) != 0) {
					listaLavori.add(lavoroCrud.find(Integer.valueOf(search)));
					request.setAttribute("listalavori", listaLavori);
					request.getRequestDispatcher(HOME).include(request, response);
				}
				else {
					request.setAttribute("notfound", "notfound");
					request.getRequestDispatcher(HOME).include(request, response);
				}
				
			} catch (NumberFormatException e) {
		    	
	    		listaLavori = lavoroCrud.findByNome(search);
	    		if(listaLavori.size() == 0) {
					request.setAttribute("listalavori", listaLavori);
					request.getRequestDispatcher(HOME).include(request, response);
	    		}
	    		else {
	    			request.setAttribute("notfound", "notfound");
					request.getRequestDispatcher(HOME).include(request, response);
	    		}
		    }
		}	
	}

}
