package it.exolab.gestionaleTL.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.controller.DatiRiunioneController;
import it.exolab.gestionaleTL.controller.DocumentazioneController;
import it.exolab.gestionaleTL.controller.RigaPresenzaController;
import it.exolab.gestionaleTL.controller.RiunioneController;
import it.exolab.gestionaleTL.crud.RiunioneCrud;
import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.model.Lavoro;
import it.exolab.gestionaleTL.model.Riunione;
import it.exolab.gestionaleTL.model.User;






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
		
		
//		//indirizzo(via,civico,cap)
//		// {nome:"Francesco",cognome:"Protano", indirizzo:{via:"Via delle vie",civico:9,cap:"00179" } , indirizzi:[
//		// {via:"Via delle vie",civico:9,cap:"00179" }
//		// ,{via:"Via nazionale",civico:19,cap:"00179" } ]    }
//		
//		User p = new User();
//		p.setNome("mario");
//		Gson gson = new Gson();
//		String ret = gson.toJson(p);
//		
//		
//		p.setNome("maria");
//		ret = gson.toJson(p);
//		
//		User p1 = gson.fromJson(ret, User.class);
//		
//		System.out.println(p1.getNome());
//		
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
			try {
				rigaPresenzaController.doUpdate(request, response);
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
			
			
			
		}
		
//		String qs = request.getQueryString();
//		
//		Enumeration<String> params = request.getParameterNames();
//		while(params.hasMoreElements()) {
//			String s = params.nextElement();
//			System.out.println(s);
//		}
//		
//		String nome = request.getParameter("nome");
//		System.out.println(nome);
//		
		
		
		
	}

}
