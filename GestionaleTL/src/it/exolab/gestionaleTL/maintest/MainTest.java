package it.exolab.gestionaleTL.maintest;

import it.exolab.gestionaleTL.crud.AbitazioneCrud;


public class MainTest {

	public static void main(String[] args) {

		AbitazioneCrud abitazioneCrud = new AbitazioneCrud();
		
		System.out.println(abitazioneCrud.find(1));

	}

}
