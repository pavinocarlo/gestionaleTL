package it.exolab.gestionaleTL.crud;

import java.util.Map.Entry;

import it.exolab.gestionaleTL.model.DatiRiunione;

public class DatiRiunioneCrud {
	
	
	
	public void insert(Integer key, Integer value) {
		
		DatiRiunione.getInstance().addDati(key, value);
		System.out.println(DatiRiunione.getInstance().getMappaDati());
	}
	
	public void delete(int id_riunione) {
		
		DatiRiunione.getInstance().getMappaDati().remove(id_riunione);
		System.out.println(DatiRiunione.getInstance().getMappaDati());
		
	}
	
//	public int findRiunone(int id_riunione) {
//		
//		int idRiunioneAttiva = 0;
//		for(Integer riunioneId : DatiRiunione.getInstance().getMappaDati().keySet()) {
//			if(riunioneId == id_riunione) {
//				idRiunioneAttiva = id_riunione;
//				break;
//			}
//		}
//		return idRiunioneAttiva;
//	}
//	
//	public int findDocumento(int id_riunione) {
//		
//		int idDocumentoVotazione = 0;
//		if(findDocumento(id_riunione) != 0) {
//			idDocumentoVotazione = DatiRiunione.getInstance().getMappaDati().get(id_riunione);		
//		}
//		return idDocumentoVotazione;
//	}
	
	public Entry<Integer, Integer> find(int id_riunione) {
		
		Entry<Integer, Integer> datiAttuali = new Entry<Integer, Integer>() {
			
			@Override
			public Integer setValue(Integer value) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Integer getValue() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Integer getKey() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		for(Entry<Integer, Integer> dati : DatiRiunione.getInstance().getMappaDati().entrySet()) {
			if(dati.getKey() == id_riunione) {
				datiAttuali=dati;
			}
		}
		return datiAttuali;
	}
	
	

}
