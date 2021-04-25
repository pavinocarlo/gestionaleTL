package it.exolab.gestionaleTL.servlet;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.exolab.gestionaleTL.controller.DatiRiunioneController;
import it.exolab.gestionaleTL.controller.DocumentazioneController;
import it.exolab.gestionaleTL.controller.RigaPresenzaController;
import it.exolab.gestionaleTL.controller.RiunioneController;
import it.exolab.gestionaleTL.controller.VotazioneController;
import it.exolab.gestionaleTL.model.Documentazione;
import it.exolab.gestionaleTL.model.Riunione;
import it.exolab.gestionaleTL.model.Votazione;


/**
 * Servlet implementation class PersonaServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String op = request.getParameter("checkMap");
		if(op.equals("checkMap") && op != null) {
			DatiRiunioneController datiRiunioneController = new DatiRiunioneController(request, response);
			Riunione riunione = (Riunione) request.getSession().getAttribute("riunione");
			Entry<Integer, Integer> datiAttuali = datiRiunioneController.doCheckRiunione(riunione.getId());
			if(datiAttuali.getKey() == null) {
				System.out.println("1 if");
				return;
			}
			
			if(datiAttuali.getValue() == 0 && datiAttuali.getValue() != null) {
				riunione.setStato(2);
				Gson gson = new Gson();
				String riunioneString = gson.toJson(riunione);
				response.getWriter().append(riunioneString);
				System.out.println("2 if");
				return;
			}
			if(datiAttuali.getValue() != 0) {
				DocumentazioneController documentazioneController = new DocumentazioneController(request, response);
				riunione.setStato(2);
				Documentazione documentazione = documentazioneController.doFind(datiAttuali.getValue());
				Gson gson = new Gson();
				String riunioneString = gson.toJson(riunione);
				String documentazioneString = gson.toJson(documentazione);
				String result = "["+riunioneString+","+documentazioneString+"]";
				response.getWriter().append(result);
				System.out.println("3 if");
				return;
			}
		}
		
		
		request.getRequestDispatcher("testRiunioneUser.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("showriunionibutton") != null) {
		
			RiunioneController riunioneController = new RiunioneController(request, response);
			riunioneController.doListaRiunioniDaFare();			
			request.getRequestDispatcher("testRiunione.jsp").include(request, response);
			return;
		}
		
		if(request.getParameter("avviariunione") != null) {
			
			RiunioneController riunioneController = new RiunioneController(request, response);
			riunioneController.doAvviaRiunione(request, response);
			request.getRequestDispatcher("testRiunione.jsp").include(request, response);
			return;
		}
		
		if(request.getParameter("avviavotazione") != null) {
			
			DocumentazioneController documentazioneController = new DocumentazioneController(request, response);
			Riunione riunione = (Riunione) request.getSession().getAttribute("riunione");
			documentazioneController.doAvviaVotazione(request, response, riunione);
			request.getRequestDispatcher("testRiunione.jsp").include(request, response);
			return;
		}
		
		if(request.getParameter("arrestariunione") != null) {
			
			RiunioneController riunioneController = new RiunioneController(request, response);
			riunioneController.doArrestaRiunione(request, response);
			request.getRequestDispatcher("testRiunione.jsp").include(request, response);
			return;
		}
		
		if(request.getParameter("partecipariunione") != null) {
			
			RigaPresenzaController rigaPresenzaController = new RigaPresenzaController(request, response);
			rigaPresenzaController.doUpdate(request, response);
			request.getRequestDispatcher("testRiunioneUser.jsp").include(request, response);
			return;
		}
		
		if(request.getParameter("votazione") != null) {
			
			VotazioneController votazioneController = new VotazioneController(request, response);
			votazioneController.doInsert(request, response);
			request.getRequestDispatcher("testRiunioneUser.jsp").include(request, response);
			return;
		}

	}

}
