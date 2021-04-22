package it.exolab.gestionaleTL.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.model.Abitazione;
import it.exolab.gestionaleTL.model.Riunione;
import it.exolab.gestionaleTL.model.User;

public class UtilController extends BaseController {
	
	
	AbitazioneController abitazioneController = new AbitazioneController(request, response);
	
	public UtilController(HttpServletRequest request, HttpServletResponse response) {
		
		super(request, response);
	}
	
	public Riunione doFindRiunioneForUserLogin(User user) {
		
		int stato = 3;
		RiunioneController riunioneController = new RiunioneController(request, response);
		
		Abitazione abitazione = abitazioneController.doFindForLogin(user.getId_abitazione());
		
		Riunione riunione = riunioneController.doFindForLogin(abitazione.getIndirizzo(), stato, user.getId());
		return riunione;
	}
	
	public void doInsertRighePresenza(Riunione riunione) throws GenericException, AlreadyExistException, InvalidFieldException {
		
		RigaPresenzaController rigaPresenzaController = new RigaPresenzaController(request, response);
		
		List<Abitazione> listaAbitazioni = abitazioneController.dofindByIndirizzo(riunione.getIndirizzo_abitazione());
		for(Abitazione abitazione : listaAbitazioni) {
			rigaPresenzaController.doInsert(riunione.getId(), abitazione.getId());
		}
	}
	
	

}
