package it.exolab.gestionaleTL.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.exolab.gestionaleTL.crud.AbitazioneCrud;
import it.exolab.gestionaleTL.crud.UserCrud;
import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.model.Abitazione;
import it.exolab.gestionaleTL.model.Riunione;
import it.exolab.gestionaleTL.model.User;


public class UserController extends BaseController {
	
	private UserCrud userCrud = new UserCrud();
	
	public UserController(HttpServletRequest request, HttpServletResponse response) {
		
		super(request, response);
	}
	
	
	private boolean validate(User user) {
		boolean ret=false;
		ret=validate(user.getCf(), user.getNome(), user.getCognome(), user.getEmail(), user.getPassword(),user.getTelefono());
		return ret;
	}
	
	private boolean validate(String email,String password) {
		boolean ret=false;
		if (	!(email.length()<1 && email.length()>70)
			 && !(password.length()<1 || password.length()>70 )
		 ) {
			ret=true;
		}
		return ret;
	}
	
	private boolean validate(String cf, String nome, String cognome, String email,String password, String telefono) {
		UserCrud uc=new UserCrud();
		boolean ret=false;
		if (!(uc.findByEmail(email)!=null)){
			if (
				    !(!email.contains("@") || !email.contains(".") || email.length()<4 && email.length()>70)
				 && !(nome.length()<2 || nome.length()>70 || hasDigits(nome)>0)
				 && !(cognome.length()<2 || cognome.length()>70 || hasDigits(cognome)>0)
				 && !(telefono.length()<5 || telefono.length()>70)	 
			 ) {
				ret=true;
			} 
		}
		return ret;
	}
	
	private int hasDigits(String s) {
		int ret=0;
		for(int i=0;i<s.length();i++) {
			if ((s.charAt(i) >= '0') && (s.charAt(i) <= '9')) {
				ret++;
			}
		}
		return ret;
	}

	public void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User user = null;
		
		if(validate(email,password)) {
			user = userCrud.findByEmailAndPassword(email, password);
			if(user.getId_ruolo()!=1) {
				/*
				 * da verificare, codice brutto
				 */
				UtilController utilController = new UtilController(request, response);
				Riunione riunione = utilController.doFindRiunioneForUserLogin(user);
				request.getSession().setAttribute("riunione", riunione);
			}
			request.getSession().setAttribute(USER, user);
			request.getRequestDispatcher(HOME).include(request, response);
			return;
		}
		request.setAttribute("notvaliddata", "notvaliddata");
		request.getRequestDispatcher(HOME).include(request, response);
	}
	
	
	public void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		response.sendRedirect(HOME);
	}
	
	public void doCheckRiunine(HttpServletRequest request, HttpServletResponse response) {
		
		
		
	}

//	private void doRuolo(User user) throws ServletException, IOException {
//		
//		if(user==null) {
//			request.setAttribute("notfoundlogin", "notfoundlogin");
//			request.getRequestDispatcher(HOME).include(request, response);
//			return;
//		}
//		request.getSession().setAttribute(USER, user);
//		request.getRequestDispatcher(HOME).include(request, response);
//	}
//	
	
	public void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		User user = new User(request.getParameter("cf"),
							request.getParameter("nome"), 
							request.getParameter("cognome"), 
							request.getParameter("email"), 
							request.getParameter("password"), 
							request.getParameter("telefono"),
							(Timestamp.valueOf("" + request.getParameter("data_in") + " 00:00:00")),
							null,
							Integer.parseInt(request.getParameter("id_ruolo")), 
							Integer.parseInt(request.getParameter("id_abitazione")));
							
		if(validate(user)) {
			
			try {
				userCrud.insert(user);
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
			request.setAttribute(USER+INSERT+SUCCESS, USER+INSERT+SUCCESS);
			request.getRequestDispatcher(HOME).include(request, response);
		}
	}
	
	public void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		User user = new User(request.getParameter("cf"),
							request.getParameter("nome"), 
							request.getParameter("cognome"), 
							request.getParameter("email"), 
							request.getParameter("password"), 
							request.getParameter("telefono"),
							(Timestamp.valueOf("" + request.getParameter("dataIn") + " 00:00:00")),
							(Timestamp.valueOf("" + request.getParameter("dataOut") + " 00:00:00")),
							Integer.parseInt(request.getParameter("id_ruolo")), 
							Integer.parseInt(request.getParameter("id_abitazione")));
								
//		if(validate(user)) {
			
			try {
				userCrud.update(user);
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
			request.setAttribute(USER+UPDATE+SUCCESS, USER+UPDATE+SUCCESS);
			request.getRequestDispatcher(HOME).include(request, response);
//		}
	}
	
	public void doFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search = request.getParameter(SEARCH+USER);
		
		List<User> listaUser = new ArrayList<>();
		
		if(search.equals("") || search == null) {
			
			listaUser = userCrud.findAll();
			request.setAttribute(LISTA+USER, listaUser);
			request.getRequestDispatcher(HOME).include(request, response);
		}
		else {
			listaUser.add(userCrud.find(Integer.valueOf(search)));
			request.setAttribute(LISTA+USER, listaUser);
			request.getRequestDispatcher(HOME).include(request, response);
		}		
	}


}
