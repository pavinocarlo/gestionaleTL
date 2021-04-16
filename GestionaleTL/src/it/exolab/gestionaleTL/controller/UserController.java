package it.exolab.gestionaleTL.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.exolab.gestionaleTL.crud.UserCrud;
import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.model.User;



public class UserController extends BaseController {
	
	private UserCrud userCrud = new UserCrud();
	private User user = new User();
	
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
				 && !(password.length()<8 || password.length()>70 || hasDigits(password)<2)
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
		
		if(validate(email,password)) {
			user = userCrud.findByEmailAndPassword(email, password);
			doRuolo(user);
			return;
		}
		request.setAttribute("notValidData", "notValidData");
		request.getRequestDispatcher("home.jsp").include(request, response);
	}

	private void doRuolo(User user) throws ServletException, IOException {
		
		if(user==null) {
			request.setAttribute("notFoundLogin", "notFoundLogin");
			request.getRequestDispatcher("home.jsp").include(request, response);
			return;
		}
		request.getSession().setAttribute("user", user);
//		request.getRequestDispatcher(
//				user.getRuolo().getRuolo().equals("Amministratore") ? "adminhome.jsp" : "homeuser.jsp");
		request.getRequestDispatcher("home.jsp").include(request, response);
	}
	
	
	public void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User(request.getParameter("cf"),
							request.getParameter("nome"), 
							request.getParameter("cognome"), 
							request.getParameter("email"), 
							request.getParameter("password"), 
							request.getParameter("telefono"),
							(Timestamp.valueOf("" + request.getParameter("dataIn") + "00:00:00")),
							(Timestamp.valueOf("" + request.getParameter("dataOut") + "00:00:00")),
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
			request.setAttribute("successo", "successo");
			request.getRequestDispatcher("home.jsp").include(request, response);
		}
	}
	
	public void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		User user = new User(request.getParameter("cf"),
							request.getParameter("nome"), 
							request.getParameter("cognome"), 
							request.getParameter("email"), 
							request.getParameter("password"), 
							request.getParameter("telefono"),
							(Timestamp.valueOf("" + request.getParameter("dataIn") + "00:00:00")),
							(Timestamp.valueOf("" + request.getParameter("dataOut") + "00:00:00")),
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
			request.setAttribute("successo", "successo");
			request.getRequestDispatcher("home.jsp").include(request, response);
//		}
	}
	
		
	
		
	

}
