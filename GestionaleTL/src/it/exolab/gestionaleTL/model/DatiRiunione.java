package it.exolab.gestionaleTL.model;

import java.util.HashMap;

public class DatiRiunione {
	
	
	protected static HashMap<Integer, Integer>  mappaDati= new HashMap<Integer, Integer>();
	private static DatiRiunione instance = null;
	
	
	public static DatiRiunione getInstance() {
		if(instance==null) {
			instance = new DatiRiunione();
		}
		return instance;
	}	
	
	private DatiRiunione(){
		
	}

	public HashMap<Integer, Integer> getMappaDati() {
		return mappaDati; 
	}

	public void addDati(Integer key, Integer value) {
		
		mappaDati.put(key, value);
	}
}
