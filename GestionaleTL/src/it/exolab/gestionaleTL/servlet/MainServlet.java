package it.exolab.gestionaleTL.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.controller.AbitazioneController;
import it.exolab.gestionaleTL.controller.DocumentazioneController;
import it.exolab.gestionaleTL.controller.LavoroController;
import it.exolab.gestionaleTL.controller.RiunioneController;
import it.exolab.gestionaleTL.controller.UserController;
import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher("home.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			/*
			 * user
			 */
			if(request.getParameter("login") != null) {
				UserController userController = new UserController(request, response);
				userController.doLogin(request, response);
			}
			if(request.getParameter("insertUser") != null) {
				UserController userController = new UserController(request, response);
				userController.doInsert(request, response);
			}
			if(request.getParameter("updateUser") != null) {
				UserController userController = new UserController(request, response);
				userController.doUpdate(request, response);
			}
			/*
			 * abitazione
			 */
			if(request.getParameter("insertAbitazione") != null) {
				AbitazioneController abitazioneController = new AbitazioneController(request, response);
				abitazioneController.doInsert(request, response);
			}
			if(request.getParameter("updateAbitazione") != null) {
				AbitazioneController abitazioneController = new AbitazioneController(request, response);
				abitazioneController.doUpdate(request, response);
			}
			/*
			 * riunione
			 */
			if(request.getParameter("insertRiunione") != null) {
				RiunioneController riunioneController = new RiunioneController(request, response);
				riunioneController.doInsert(request, response);
			}
			if(request.getParameter("updateRiunione") != null) {
				RiunioneController riunioneController = new RiunioneController(request, response);
				riunioneController.doUpdate(request, response);
			}
			if(request.getParameter("findRiunione") != null) {
				RiunioneController riunioneController = new RiunioneController(request, response);
				riunioneController.doFind(request, response);
			}
			/*
			 * lavoro
			 */
			if(request.getParameter("insertLavoro") != null) {
				LavoroController lavoroController = new LavoroController(request, response);
				lavoroController.doInsert(request, response);
			}
			if(request.getParameter("updateLavoro") != null) {
				LavoroController lavoroController = new LavoroController(request, response);
				lavoroController.doUpdate(request, response);
			}
			if(request.getParameter("findLavoro") != null) {
				LavoroController lavoroController = new LavoroController(request, response);
				lavoroController.doFind(request, response);
			}
			/*
			 * documentazione
			 */
			if(request.getParameter("insertDocumentazione") != null) {
				DocumentazioneController documentazioneController = new DocumentazioneController(request, response);
				documentazioneController.doInsert(request, response);
			}
			if(request.getParameter("updateDocumentazione") != null) {
				DocumentazioneController documentazioneController = new DocumentazioneController(request, response);
				documentazioneController.doUpdate(request, response);
			}
			if(request.getParameter("findDocumentazione") != null) {
				DocumentazioneController documentazioneController = new DocumentazioneController(request, response);
				documentazioneController.doFind(request, response);
			}
		
		
	}

}
