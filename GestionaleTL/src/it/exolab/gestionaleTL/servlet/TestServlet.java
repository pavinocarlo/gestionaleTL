package it.exolab.gestionaleTL.servlet;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.controller.DatiRiunioneController;
import it.exolab.gestionaleTL.controller.DocumentazioneController;
import it.exolab.gestionaleTL.controller.RigaPresenzaController;
import it.exolab.gestionaleTL.controller.RiunioneController;
import it.exolab.gestionaleTL.model.Documentazione;
import it.exolab.gestionaleTL.model.Riunione;


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
		if(op.equals("checkMap")) {
			DatiRiunioneController datiRiunioneController = new DatiRiunioneController(request, response);
			Riunione riunione = (Riunione) request.getSession().getAttribute("riunione");
			Entry<Integer, Integer> datiAttuali = datiRiunioneController.doCheckRiunione(riunione.getId());
			if(datiAttuali == null) {
				request.getRequestDispatcher("testRiunioneUser.jsp").include(request, response);
				return;
			}
			
			if(datiAttuali.getValue() == 0) {
				riunione.setStato(2);
				request.getSession().setAttribute("riunione", riunione);
				request.getRequestDispatcher("testRiunioneUser.jsp").include(request, response);
				return;
			}
			if(datiAttuali.getValue() != 0) {
				DocumentazioneController documentazioneController = new DocumentazioneController(request, response);
				riunione.setStato(2);
				Documentazione documentazione = documentazioneController.doFind(datiAttuali.getValue());
				request.setAttribute("documentazione", documentazione);
				request.getSession().setAttribute("riunione", riunione);
				request.getRequestDispatcher("testRiunioneUser.jsp").include(request, response);
				return;
			}
		}
		
		
		request.getRequestDispatcher("testRiunioneUser.jsp").include(request, response);
//		response.getWriter().append(ret);
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
			
			
		}

	}

}
