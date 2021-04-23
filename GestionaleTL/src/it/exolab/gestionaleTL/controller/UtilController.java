package it.exolab.gestionaleTL.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.model.Abitazione;
import it.exolab.gestionaleTL.model.Documentazione;
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
	
	public void doAvviaRiunione(Riunione riunione) {
		
		DocumentazioneController documentazioneController = new DocumentazioneController(request, response);
		DatiRiunioneController datiRiunioneController = new DatiRiunioneController(request, response);
		
		datiRiunioneController.insert(riunione.getId(), 0);
		
		request.setAttribute("listadocumenti", documentazioneController.doFindForVotazione(request, response, riunione.getId()));
	}
	
	public void doAvviaVotazione(Riunione riunione) throws ServletException, IOException {
		
		DatiRiunioneController datiRiunioneController = new DatiRiunioneController(request, response);
		
		datiRiunioneController.insert(riunione.getId(), Integer.parseInt(request.getParameter("iddocumento")));
	}
	
	public void doArrestaRiunione(Riunione riunione) {
		
		DatiRiunioneController datiRiunioneController = new DatiRiunioneController(request, response);
		
		datiRiunioneController.delete(riunione.getId());
		
	}
	
	

}
