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

import it.exolab.gestionaleTL.controller.DocumentazioneController;
import it.exolab.gestionaleTL.controller.RigaPresenzaController;
import it.exolab.gestionaleTL.crud.RiunioneCrud;
import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.model.Lavoro;
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

		RiunioneCrud riunioneCrud = new RiunioneCrud();
		DocumentazioneController documentazioneController = new DocumentazioneController(request, response);
		
		if(request.getParameter("showriunionibutton") != null) {
		
			List<Riunione> listaRiunioni = riunioneCrud.findForRiunione(Timestamp.valueOf("" + request.getParameter("data_riunione") + " 00:00:00"), 1);
			
			request.setAttribute("listariunioni", listaRiunioni);
			request.getRequestDispatcher("testRiunione.jsp").include(request, response);
		
		}
		
		if(request.getParameter("avviariunione") != null) {
			
			Riunione riunione = riunioneCrud.find(Integer.parseInt(request.getParameter("idriunione")));
			System.out.println(riunione);
			riunione.setStato(2);
			try {
				riunioneCrud.update(riunione);
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

			request.getSession().setAttribute("riunione", riunione);
			request.setAttribute("listadocumenti", documentazioneController.doFindForVotazione(request, response, riunione.getId()));
			request.getRequestDispatcher("testRiunione.jsp").include(request, response);
			return;
		}
		
		if(request.getParameter("avviavotazione") != null) {
			
			Riunione riunione = (Riunione) request.getSession().getAttribute("riunione");
			documentazioneController.doUpdate(request, response);
			System.out.println(riunione);
			request.setAttribute("listadocumenti", documentazioneController.doFindForVotazione(request, response, riunione.getId()));
			request.getRequestDispatcher("testRiunione.jsp").include(request, response);
			return;
		}
		
		
		if(request.getParameter("arrestariunione") != null) {
			
			Riunione riunione = riunioneCrud.find(Integer.parseInt(request.getParameter("idriunione")));
			riunione.setStato(3);
			try {
				riunioneCrud.update(riunione);
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
			request.setAttribute("riunione", riunione);
			request.getRequestDispatcher("testRiunione.jsp").include(request, response);
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
