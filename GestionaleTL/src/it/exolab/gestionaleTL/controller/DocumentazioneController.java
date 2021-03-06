package it.exolab.gestionaleTL.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.crud.DocumentazioneCrud;
import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.model.Documentazione;
import it.exolab.gestionaleTL.model.Lavoro;
import it.exolab.gestionaleTL.model.Riunione;

public class DocumentazioneController extends BaseController {
	
	DocumentazioneCrud documentazioneCrud = new DocumentazioneCrud();
	
	public DocumentazioneController(HttpServletRequest request, HttpServletResponse response) {
		
		super(request, response);
		
	}
	
	public void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Documentazione documentazione = new Documentazione(Double.parseDouble(request.getParameter("costo")),
														request.getParameter("nome"),
														request.getParameter("societa"),
														Integer.parseInt(request.getParameter("id_lavoro")),
														null);
							
//		if(validate(user)) {
			
		try {
			documentazioneCrud.insert(documentazione);
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
		request.setAttribute(DOCUMENTAZIONE+INSERT+SUCCESS, DOCUMENTAZIONE+INSERT+SUCCESS);
		request.getRequestDispatcher(HOME).include(request, response);
//		}
	}
	
	public void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Documentazione documentazione = new Documentazione(Integer.parseInt(request.getParameter("iddocumento")),
														Double.parseDouble(request.getParameter("costo")),
														request.getParameter("nome"),
														request.getParameter("societa"),
														Integer.parseInt(request.getParameter("id_lavoro")),
														Integer.valueOf(request.getParameter("stato")));
//		if(validate(user)) {
		try {
			documentazioneCrud.update(documentazione);
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
		request.setAttribute(DOCUMENTAZIONE+UPDATE+SUCCESS, DOCUMENTAZIONE+UPDATE+SUCCESS);
		//request.getRequestDispatcher(HOME).include(request, response);
//		}
	}
	
	public void doAvviaVotazione(HttpServletRequest request, HttpServletResponse response, Riunione riunione) throws ServletException, IOException {
		
		UtilController utilController = new UtilController(request, response);
		doUpdate(request, response);
		utilController.doAvviaVotazione(riunione);
		request.setAttribute("listadocumenti", doFindForVotazione(request, response, riunione.getId()));
	}
	
	
	public void doFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search = request.getParameter(SEARCH+DOCUMENTAZIONE);
		List<Documentazione> listaDocumentazione = new ArrayList<Documentazione>();
		
		if(search.equals("") || search == null) {
			listaDocumentazione = documentazioneCrud.findAll();
			request.setAttribute(LISTA+DOCUMENTAZIONE, listaDocumentazione);
			request.getRequestDispatcher(HOME).include(request, response);
		}
		else {
			listaDocumentazione.add(documentazioneCrud.find(Integer.valueOf(search)));
			request.setAttribute(LISTA+DOCUMENTAZIONE, listaDocumentazione);
			request.getRequestDispatcher(HOME).include(request, response);
		}
	}	
	
	public List<Documentazione> doFindForVotazione(HttpServletRequest request, HttpServletResponse response, int riunione_id) {
		
		int riunione_stato = 2;
		String lavoro_stato = "da votare";
		List<Documentazione> listaDocumenti = documentazioneCrud.findForVotazione(riunione_stato, riunione_id, lavoro_stato);
		return listaDocumenti;
	}
	
	public Documentazione doFind(int id_documentazione) {
		
		return documentazioneCrud.find(id_documentazione);
		
		
	}
	
	protected byte[] uploadDocumento(String field) throws IOException, ServletException {

		byte[] ret = null;

		Part filePart = request.getPart(field);

		FileOutputStream outputStream = null;
		InputStream fileContent = null;

		try {

			// creating a new file with file path and the file name
			fileContent = filePart.getInputStream();
			// getting the input stream
			int readBytes = 0;
			byte[] readArray = new byte[1024];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			// initializing a byte array with size 1024

			while ((readBytes = fileContent.read(readArray)) != -1) {

				baos.write(readArray, 0, readBytes);
			} // this loop will write the contents of the byte array unitl the end to the
				// output stream
			ret = baos.toByteArray();

		} catch (Exception ex) {
			System.out.println("Error Writing File: " + ex);
		} finally {
			if (outputStream != null) {
				outputStream.close();
				// closing the output stream
			}
			if (fileContent != null) {
				fileContent.close();
				// clocsing the input stream
			}
		}
		return ret;
	}

}
