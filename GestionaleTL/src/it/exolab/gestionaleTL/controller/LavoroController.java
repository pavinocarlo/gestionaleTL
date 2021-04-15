package it.exolab.gestionaleTL.controller;

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

	protected void doInsert(HttpServletRequest request, HttpServletResponse response) throws GenericException, AlreadyExistException, InvalidFieldException {
		
		Lavoro lavoro = new Lavoro(Integer.parseInt(request.getParameter("Id_riunione")),
									request.getParameter("nome"),
									request.getParameter("esito_voto"),
									request.getParameter("stato"));
							
//		if(validate(user)) {
			
			lavoroCrud.insert(lavoro);
//		}
}

}
