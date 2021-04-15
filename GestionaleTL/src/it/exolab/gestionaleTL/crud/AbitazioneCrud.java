package it.exolab.gestionaleTL.crud;

import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.mapper.AbitazioneMapper;
import it.exolab.gestionaleTL.model.Abitazione;
import it.exolab.gestionaleTL.mybatis.SqlMapFactory;

public class AbitazioneCrud {
	

	public void insert(Abitazione abitazione) throws GenericException, AlreadyExistException, InvalidFieldException{

		SqlMapFactory.instance().openSession();
		AbitazioneMapper mapper =  SqlMapFactory.instance().getMapper(AbitazioneMapper.class);
		mapper.insert(abitazione);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
	}

	public Abitazione find(Integer id){
		SqlMapFactory.instance().openSession();
		AbitazioneMapper mapper =  SqlMapFactory.instance().getMapper(AbitazioneMapper.class);
		Abitazione ret = mapper.find(id);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
		return ret;
	}
	
}
