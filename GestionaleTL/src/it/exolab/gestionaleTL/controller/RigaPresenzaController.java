package it.exolab.gestionaleTL.controller;

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
	
	protected void doInsert(HttpServletRequest request, HttpServletResponse response) throws GenericException, AlreadyExistException, InvalidFieldException {
		
		RigaPresenza rigaPresenza = new RigaPresenza(Integer.parseInt(request.getParameter("adesione")),
										Integer.parseInt(request.getParameter("presenza")),
										Integer.parseInt(request.getParameter("id_riunione")),
										Integer.parseInt(request.getParameter("id_abitazione")),
										Integer.parseInt(request.getParameter("id_user")));
								
	//		if(validate(user)) {
				
		rigaPresenzaCrud.insert(rigaPresenza);
	//		}
		}
	
	protected void doUpdate(HttpServletRequest request, HttpServletResponse response) throws GenericException, AlreadyExistException, InvalidFieldException {
			
			RigaPresenza rigaPresenza = new RigaPresenza(Integer.parseInt(request.getParameter("adesione")),
											Integer.parseInt(request.getParameter("presenza")),
											Integer.parseInt(request.getParameter("id_riunione")),
											Integer.parseInt(request.getParameter("id_abitazione")),
											Integer.parseInt(request.getParameter("id_user")));
									
		//		if(validate(user)) {
					
			rigaPresenzaCrud.update(rigaPresenza);
		//		}
		}

}
