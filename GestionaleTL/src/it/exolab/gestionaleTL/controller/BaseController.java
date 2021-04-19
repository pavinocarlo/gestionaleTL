package it.exolab.gestionaleTL.controller;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
	
	protected HttpServletRequest request;
	protected  HttpServletResponse response;
	protected static final String HOME="home.jsp";
	
	
	protected BaseController() {
		
	}
	
	public BaseController(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
//			
//			
//		
//		
//	
//	protected void view() throws ServletException, IOException {
//		
//		
//		if(includeCart && session_id!=null) {
//			request.setAttribute("cart", userService.getCart(session_id, user) );
//		}
//		request.getRequestDispatcher(baseView+ view).include(request, response);
//		
//		
//	}
	protected Object flash(String attribute) {
		
		Object ret = request.getSession().getAttribute(attribute);
		
		if(ret!=null) {
			request.getSession().removeAttribute(attribute);
		}
		return ret;
	}
	protected Object flash(String attribute,Object value) {
		
		request.getSession().setAttribute(attribute,value);
		return null;
	}
	protected void sendRedirect(String url) throws IOException {
		
		String base_path = (String)request.getAttribute("base_path");
		
		response.sendRedirect(base_path+url);
	}

}
