package it.exolab.gestionaleTL.controller;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
	
	protected HttpServletRequest request;
	protected  HttpServletResponse response;
	protected static final String HOME="home.jsp";
	protected static final String INSERT="home.jsp";
	protected static final String UPDATE="home.jsp";
	protected static final String SUCCESS="success";
	protected static final String LISTA="lista";
	protected static final String SEARCH="search";
	protected static final String USER="user";
	protected static final String RIUNIONE="riunione";
	protected static final String ABITAZIONE="abitazione";
	protected static final String LAVORO="lavoro";
	protected static final String DOCUMENTAZIONE="documentazione";
	
	
	protected BaseController() {
		
	}
	
	public BaseController(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

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
