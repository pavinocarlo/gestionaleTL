package it.exolab.gestionaleTL.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.gestionaleTL.crud.UserCrud;
import it.exolab.gestionaleTL.model.User;



public class UserController extends BaseController {
	
	private UserCrud userCrud = new UserCrud();
	private User user = new User();
	
	public UserController(HttpServletRequest request, HttpServletResponse response) {
		
		super(request, response);
		
		
	}
	
	protected boolean validate(String email,String password) {
		boolean ret=false;
		if (	!(email.length()<1 && email.length()>70)
			 && !(password.length()<1 || password.length()>70 )
		 ) {
			ret=true;
		}
		return ret;
	}

	protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		if(validate(email,password)) {
			user.setEmail(email);
			user.setPassword(password);
			user = userCrud.findByEmailAndPassword(user);
			doRuolo(user);
			return;
		}
		request.setAttribute("notValidData", "notValidData");
		request.getRequestDispatcher("home.jsp").include(request, response);
	}

	protected void doRuolo(User user) throws ServletException, IOException {
		
		if(user==null) {
			request.setAttribute("notFoundLogin", "notFoundLogin");
			request.getRequestDispatcher("home.jsp").include(request, response);
			return;
		}
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher(
				user.getRuolo().getRuolo().equals("Amministratore") ? "adminhome.jsp" : "homeuser.jsp");
	}
		
	

}
