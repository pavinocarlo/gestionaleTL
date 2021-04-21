package it.exolab.gestionaleTL.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.model.Abitazione;
import it.exolab.gestionaleTL.model.Riunione;
import it.exolab.gestionaleTL.model.User;

public class UtilController extends BaseController {
	
	RiunioneController riunioneController = new RiunioneController(request, response);
	
	
	public UtilController(HttpServletRequest request, HttpServletResponse response) {
		
		super(request, response);
	}
	
	public Riunione doFindRiunioneForUserLogin(User user) {
		
		int stato = 3;
		RiunioneController riunioneController = new RiunioneController(request, response);
		AbitazioneController abitazioneController = new AbitazioneController(request, response);
		Abitazione abitazione = abitazioneController.doFindForLogin(user.getId_abitazione());
		Riunione riunione = riunioneController.doFindForLogin(abitazione.getIndirizzo(), stato, user.getId());
		
		return riunione;
	}
	
	

}
