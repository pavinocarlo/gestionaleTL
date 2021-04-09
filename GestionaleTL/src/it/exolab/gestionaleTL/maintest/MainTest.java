package it.exolab.gestionaleTL.maintest;

import it.exolab.gestionaleTL.controller.LavoroController;
import it.exolab.gestionaleTL.crud.AbitazioneCrud;
import it.exolab.gestionaleTL.crud.LavoroCrud;
import it.exolab.gestionaleTL.model.Lavoro;


public class MainTest {

	public static void main(String[] args) {

		AbitazioneCrud abitazioneCrud = new AbitazioneCrud();
		LavoroCrud lavoroCrud =  new LavoroCrud();
		
		System.out.println(lavoroCrud.find(1));

	}

}
