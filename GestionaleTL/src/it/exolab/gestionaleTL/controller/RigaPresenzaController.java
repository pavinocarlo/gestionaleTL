package it.exolab.gestionaleTL.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.crud.RigaPresenzaCrud;
import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.model.RigaPresenza;


public class RigaPresenzaController extends BaseController {
	
	RigaPresenzaCrud rigaPresenzaCrud = new RigaPresenzaCrud();
	
	public RigaPresenzaController(HttpServletRequest request, HttpServletResponse response) {
			
			super(request, response);
	}
	
	public void doInsert(int id_riunione, int id_abitazione) throws GenericException, AlreadyExistException, InvalidFieldException {
		
		RigaPresenza rigaPresenza = new RigaPresenza(id_riunione, id_abitazione);
	//		if(validate(user)) {
		rigaPresenzaCrud.insert(rigaPresenza);
	//		}
		}
	
	public void doUpdate(HttpServletRequest request, HttpServletResponse response) throws GenericException, AlreadyExistException, InvalidFieldException, ServletException, IOException {
		
//		RigaPresenza rigaPresenza = rigaPresenzaCrud.findByUserRiunione(Integer.parseInt(request.getParameter("id_user")),
//																	Integer.parseInt(request.getParameter("id_riunione")));
//			RigaPresenza rigaPresenza = new RigaPresenza(Integer.parseInt(request.getParameter("id_riunione")
//											Integer.parseInt(request.getParameter("adesione")),
//											Integer.parseInt(request.getParameter("presenza")),
//											Integer.parseInt(request.getParameter("id_riunione")),
//											Integer.parseInt(request.getParameter("id_abitazione")),
//											Integer.parseInt(request.getParameter("id_user")));
									
		//		if(validate(user)) {
//		rigaPresenza.setPresenza(1);		
//		rigaPresenzaCrud.update(rigaPresenza);
		//		}
		
		request.setAttribute("rigapresenza"+UPDATE+SUCCESS, "rigapresenza"+UPDATE+SUCCESS);
		request.getRequestDispatcher("testRiunioneUser.jsp").include(request, response);
		}

}
