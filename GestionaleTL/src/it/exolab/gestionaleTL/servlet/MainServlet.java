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


/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	
	
	private static final String INSERT="insert";
	private static final String UPDATE="update";
	private static final String FIND="find";
	private static final String USER="user";
	private static final String ABITAZIONE="abitazione";
	private static final String RIUNIONE="riunione";
	private static final String LAVORO="lavoro";
	private static final String DOCUMENTAZIONE="documentazione";
	private static final String LOGIN="login";
	private static final String LOGOUT="logout";
	private static final String BUTTON="button";
	private static final String SHOW="show";
	private static final String GESTIONE="gestione";
	
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

		doActionRiunione(request, response);
		doActionUser(request, response);
		doActionAbitazione(request, response);
		doActionLavoro(request, response);
		doActionDocumentazione(request, response);

		request.getRequestDispatcher("home.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doActionRiunione(request, response);
		doActionUser(request, response);
		doActionAbitazione(request, response);
		doActionLavoro(request, response);
		doActionDocumentazione(request, response);

	}
	
	
	protected void doActionRiunione(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter(SHOW + GESTIONE + RIUNIONE + BUTTON) != null) {
			request.setAttribute(SHOW + GESTIONE + RIUNIONE, SHOW + GESTIONE + RIUNIONE);
			return;
		}
		if(request.getParameter(SHOW + INSERT + RIUNIONE + BUTTON) != null) {
			request.setAttribute(SHOW + GESTIONE + RIUNIONE, SHOW + GESTIONE + RIUNIONE);
			request.setAttribute(SHOW + INSERT + RIUNIONE, SHOW + INSERT + RIUNIONE);
			return;
		}
		
		RiunioneController riunioneController = new RiunioneController(request, response);
		
		if(request.getParameter(SHOW + UPDATE + RIUNIONE + BUTTON) != null) {
			riunioneController.doFind(request, response);
			riunioneController.doFindForUpdate(request, response);
			request.setAttribute(SHOW + GESTIONE + RIUNIONE, SHOW + GESTIONE + RIUNIONE);
			request.setAttribute(SHOW + UPDATE + RIUNIONE, SHOW + UPDATE + RIUNIONE);
			request.setAttribute("loopindex", request.getParameter("loopindex"));
			request.setAttribute("idriunione", request.getParameter("idriunione"));
			return;
		}
		if(request.getParameter(INSERT + RIUNIONE) != null) {
			riunioneController.doInsert(request, response);
			return;
		}
		if(request.getParameter(UPDATE + RIUNIONE) != null) {
			riunioneController.doUpdate(request, response);
			return;
		}
		if(request.getParameter(FIND + RIUNIONE) != null) {
			riunioneController.doFind(request, response);
			return;
		}
	}
	
	protected void doActionUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter(SHOW + GESTIONE + USER + BUTTON) != null) {
			request.setAttribute(SHOW + GESTIONE + USER, SHOW + GESTIONE + USER);
			return;
		}
		if(request.getParameter(SHOW + INSERT + USER + BUTTON) != null) {
			request.setAttribute(SHOW + GESTIONE + USER, SHOW + GESTIONE + USER);
			request.setAttribute(SHOW + INSERT + USER, SHOW + INSERT + USER);
			return;
		}
		
		UserController userController = new UserController(request, response);
		
		if(request.getParameter(LOGIN) != null) {
			userController.doLogin(request, response);
			return;
		}
		if(request.getParameter(LOGOUT) != null) {
			userController.doLogout(request, response);
			return;
		}
		if(request.getParameter(INSERT + USER) != null) {
			userController.doInsert(request, response);
			return;
		}
		if(request.getParameter(UPDATE + USER) != null) {
			userController.doUpdate(request, response);
			return;
		}
		if(request.getParameter(FIND + USER) != null) {
			userController.doFind(request, response);
			return;
		}
	}
	
	private void doActionAbitazione(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter(SHOW + GESTIONE + ABITAZIONE + BUTTON) != null) {
			request.setAttribute(SHOW + GESTIONE + ABITAZIONE, SHOW + GESTIONE + ABITAZIONE);
			return;
		}
		if(request.getParameter(SHOW + INSERT + ABITAZIONE + BUTTON) != null) {
			request.setAttribute(SHOW + GESTIONE + ABITAZIONE, SHOW + GESTIONE + ABITAZIONE);
			request.setAttribute(SHOW + INSERT + ABITAZIONE, SHOW + INSERT + ABITAZIONE);
			return;
		}
		
		AbitazioneController abitazioneController = new AbitazioneController(request, response);
		
		if(request.getParameter(INSERT + ABITAZIONE) != null) {
			abitazioneController.doInsert(request, response);
			return;
		}
		if(request.getParameter(UPDATE + ABITAZIONE) != null) {
			abitazioneController.doUpdate(request, response);
			return;
		}
		if(request.getParameter(FIND + ABITAZIONE) != null) {
			abitazioneController.doFind(request, response);
			return;
		}
		
	}
	
	private void doActionLavoro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter(SHOW + GESTIONE + LAVORO + BUTTON) != null) {
			
			request.setAttribute(SHOW + GESTIONE + LAVORO, SHOW + GESTIONE + LAVORO);
			return;
		}
//		if(request.getParameter(SHOW + INSERT + LAVORO + BUTTON) != null) {
//			request.setAttribute(SHOW + GESTIONE + LAVORO, SHOW + GESTIONE + LAVORO);
//			request.setAttribute(SHOW + INSERT + LAVORO, SHOW + INSERT + LAVORO);
//			return;
//		}
//		if(request.getParameter(SHOW + UPDATE + LAVORO + BUTTON) != null) {
//			request.setAttribute(SHOW + GESTIONE + LAVORO, SHOW + GESTIONE + LAVORO);
//			request.setAttribute(SHOW + UPDATE + LAVORO, SHOW + UPDATE + LAVORO);
//			return;
//		}
		
		LavoroController lavoroController = new LavoroController(request, response);
		
		
		if(request.getParameter(UPDATE + LAVORO) != null) {
			lavoroController.doUpdate(request, response);
			return;
		}
		if(request.getParameter(FIND + LAVORO) != null) {
			lavoroController.doFind(request, response);
			return;
		}
		
		RiunioneController riunioneController = new RiunioneController(request, response);
		
		if(request.getParameter(SHOW + INSERT + LAVORO + BUTTON) != null) {
			riunioneController.doFind(request, response);
			request.setAttribute(SHOW + GESTIONE + RIUNIONE, SHOW + GESTIONE + RIUNIONE);
			request.setAttribute(SHOW + INSERT + LAVORO, SHOW + INSERT + LAVORO);
			request.setAttribute("loopindex", request.getParameter("loopindex"));
			request.setAttribute("idriunione", request.getParameter("idriunione"));
			
			return;
		}
		if(request.getParameter(SHOW + "lista" + "lavori" + BUTTON) != null) {
			riunioneController.doFind(request, response);
			lavoroController.doFindByIdRiunione(request, response);
			request.setAttribute(SHOW + GESTIONE + RIUNIONE, SHOW + GESTIONE + RIUNIONE);
			request.setAttribute("loopindex", request.getParameter("loopindex"));
			request.setAttribute("idriunione", request.getParameter("idriunione"));
			request.setAttribute(SHOW + "lista" + "lavori", SHOW + "lista" + "lavori");
			return;
		}
		if(request.getParameter(INSERT + LAVORO) != null) {
			riunioneController.doFind(request, response);
			lavoroController.doInsert(request, response);
			request.setAttribute(SHOW + GESTIONE + RIUNIONE, SHOW + GESTIONE + RIUNIONE);
			request.setAttribute(SHOW + INSERT + LAVORO, SHOW + INSERT + LAVORO);
			request.setAttribute("loopindex", request.getParameter("loopindex"));
			request.setAttribute("idriunione", request.getParameter("idriunione"));
			System.out.println("sono nell'if show update lavoro button");	 						//da cancellare
			System.out.println(																		//da cancellare
					"loopindex:"+request.getParameter("loopindex:")+", "+
					"looplavoroindex"+request.getParameter("looplavoroindex")+", "+
					"idriunione"+request.getParameter("idriunione")
					);	
			return;
		}
		if(request.getParameter(SHOW + UPDATE + LAVORO + BUTTON) != null) {
			System.out.println("sono nell'if show update lavoro button");	 													//da cancellare
			System.out.println(																		//da cancellare
					"loopindex:"+request.getParameter("loopindex:")+", "+
					"looplavoroindex"+request.getParameter("looplavoroindex")+", "+
					"idriunione"+request.getParameter("idriunione")
					);																				//da cancellare
			riunioneController.doFind(request, response);
			lavoroController.doFindByIdRiunione(request, response);
			request.setAttribute(SHOW + GESTIONE + RIUNIONE, SHOW + GESTIONE + RIUNIONE);
			request.setAttribute("loopindex", request.getParameter("loopindex"));
			request.setAttribute("looplavoroindex", request.getParameter("loolavoropindex"));
			request.setAttribute("idriunione", request.getParameter("idriunione"));
			request.setAttribute(SHOW + "lista" + "lavori", SHOW + "lista" + "lavori");
			request.setAttribute(SHOW + UPDATE + LAVORO, SHOW + UPDATE + LAVORO);
			System.out.println(																		//da cancellare
								request.getParameter("loopindex")+", "+
								request.getParameter("looplavoroindex")
								);	 																//da cancellare
			return;
		}
	}
	
	private void doActionDocumentazione(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter(SHOW + GESTIONE + DOCUMENTAZIONE + BUTTON) != null) {
			request.setAttribute(SHOW + GESTIONE + DOCUMENTAZIONE, SHOW + GESTIONE + DOCUMENTAZIONE);
			return;
		}
		if(request.getParameter(SHOW + INSERT + DOCUMENTAZIONE + BUTTON) != null) {
			request.setAttribute(SHOW + GESTIONE + DOCUMENTAZIONE, SHOW + GESTIONE + DOCUMENTAZIONE);
			request.setAttribute(SHOW + INSERT + DOCUMENTAZIONE, SHOW + INSERT + DOCUMENTAZIONE);
			return;
		}
		
		DocumentazioneController documentazioneController = new DocumentazioneController(request, response);
		
		if(request.getParameter(INSERT + DOCUMENTAZIONE) != null) {
			documentazioneController.doInsert(request, response);
			return;
		}
		if(request.getParameter(UPDATE + DOCUMENTAZIONE) != null) {
			documentazioneController.doUpdate(request, response);
			return;
		}
		if(request.getParameter(FIND + DOCUMENTAZIONE) != null) {
			documentazioneController.doFind(request, response);
			return;
		}
	}

}