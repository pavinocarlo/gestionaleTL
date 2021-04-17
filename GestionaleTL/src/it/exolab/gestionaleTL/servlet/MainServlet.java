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
import it.exolab.gestionaleTL.util.Util;;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	
	
	private static final String INSERT="insert";
	private static final String UPDATE="update";
	private static final String FIND="find";
	private static final String USER="User";
	private static final String ABITAZIONE="Abitazione";
	private static final String RIUNIONE="Riunione";
	private static final String LAVORO="Lavoro";
	private static final String DOCUMENTAZIONE="Documentazione";
	private static final String LOGIN="login";
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
			if(request.getParameter(LOGIN) != null) {
				UserController userController = new UserController(request, response);
				userController.doLogin(request, response);
			}
			if(request.getParameter(INSERT + USER) != null) {
				UserController userController = new UserController(request, response);
				userController.doInsert(request, response);
			}
			if(request.getParameter(UPDATE + USER) != null) {
				UserController userController = new UserController(request, response);
				userController.doUpdate(request, response);
			}
			/*
			 * abitazione
			 */
			if(request.getParameter(INSERT + ABITAZIONE) != null) {
				AbitazioneController abitazioneController = new AbitazioneController(request, response);
				abitazioneController.doInsert(request, response);
			}
			if(request.getParameter(UPDATE + ABITAZIONE) != null) {
				AbitazioneController abitazioneController = new AbitazioneController(request, response);
				abitazioneController.doUpdate(request, response);
			}
			/*
			 * riunione
			 */
			if(request.getParameter(INSERT + RIUNIONE) != null) {
				RiunioneController riunioneController = new RiunioneController(request, response);
				riunioneController.doInsert(request, response);
			}
			if(request.getParameter(UPDATE + RIUNIONE) != null) {
				RiunioneController riunioneController = new RiunioneController(request, response);
				riunioneController.doUpdate(request, response);
			}
			if(request.getParameter(FIND + RIUNIONE) != null) {
				RiunioneController riunioneController = new RiunioneController(request, response);
				riunioneController.doFind(request, response);
			}
			/*
			 * lavoro
			 */
			if(request.getParameter(INSERT + LAVORO) != null) {
				LavoroController lavoroController = new LavoroController(request, response);
				lavoroController.doInsert(request, response);
			}
			if(request.getParameter(UPDATE + LAVORO) != null) {
				LavoroController lavoroController = new LavoroController(request, response);
				lavoroController.doUpdate(request, response);
			}
			if(request.getParameter(FIND + LAVORO) != null) {
				LavoroController lavoroController = new LavoroController(request, response);
				lavoroController.doFind(request, response);
			}
			/*
			 * documentazione
			 */
			if(request.getParameter(INSERT + DOCUMENTAZIONE) != null) {
				DocumentazioneController documentazioneController = new DocumentazioneController(request, response);
				documentazioneController.doInsert(request, response);
			}
			if(request.getParameter(UPDATE + DOCUMENTAZIONE) != null) {
				DocumentazioneController documentazioneController = new DocumentazioneController(request, response);
				documentazioneController.doUpdate(request, response);
			}
			if(request.getParameter(FIND + DOCUMENTAZIONE) != null) {
				DocumentazioneController documentazioneController = new DocumentazioneController(request, response);
				documentazioneController.doFind(request, response);
			}

	}

}
