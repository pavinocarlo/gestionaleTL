package it.exolab.gestionaleTL.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.crud.LavoroCrud;
import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.model.Documentazione;
import it.exolab.gestionaleTL.model.Lavoro;

public class LavoroController extends BaseController {
	
	LavoroCrud lavoroCrud = new LavoroCrud();
	
	public LavoroController(HttpServletRequest request, HttpServletResponse response) {
			
			super(request, response);
			
		}

	public void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Lavoro lavoro = new Lavoro(Integer.parseInt(request.getParameter("Id_riunione")),
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
			request.setAttribute("successo", "successo");
			request.getRequestDispatcher("home.jsp").include(request, response);
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
			request.setAttribute("successo", "successo");
			request.getRequestDispatcher("home.jsp").include(request, response);
//		}
	}
	
	public void doFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = (String) request.getAttribute("id");
		if(!id.equals("")) {
			Lavoro lavoro = lavoroCrud.find(Integer.valueOf(id));
			request.setAttribute("lavoro", lavoro);
			request.getRequestDispatcher("home.jsp").include(request, response);
		}
		else {
			List<Lavoro> listaLavori = lavoroCrud.findAll();
			request.setAttribute("listaLavori", listaLavori);
			request.getRequestDispatcher("home.jsp").include(request, response);
		}
	}

}
