package it.exolab.gestionaleTL.maintest;

import it.exolab.gestionaleTL.crud.CondominioCrud;

public class MainTest {

	public static void main(String[] args) {

		CondominioCrud condominioCrud = new CondominioCrud();
		
		System.out.println(condominioCrud.find(3));

	}

}
