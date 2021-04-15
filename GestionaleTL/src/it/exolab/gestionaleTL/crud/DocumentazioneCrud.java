package it.exolab.gestionaleTL.crud;

import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.mapper.DocumentazioneMapper;
import it.exolab.gestionaleTL.model.Documentazione;
import it.exolab.gestionaleTL.mybatis.SqlMapFactory;

public class DocumentazioneCrud {
	
	public void insert(Documentazione documentazione) throws GenericException, AlreadyExistException, InvalidFieldException{

		SqlMapFactory.instance().openSession();
		DocumentazioneMapper mapper =  SqlMapFactory.instance().getMapper(DocumentazioneMapper.class);
		mapper.insert(documentazione);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
	}

}
