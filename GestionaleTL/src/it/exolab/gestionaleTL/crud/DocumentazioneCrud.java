package it.exolab.gestionaleTL.crud;

import java.util.List;

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
	
	public void update(Documentazione documentazione) throws GenericException, AlreadyExistException, InvalidFieldException{

		SqlMapFactory.instance().openSession();
		DocumentazioneMapper mapper =  SqlMapFactory.instance().getMapper(DocumentazioneMapper.class);
		mapper.update(documentazione);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
	}
	
	public Documentazione find(Integer id) {

		SqlMapFactory.instance().openSession();
		DocumentazioneMapper mapper =  SqlMapFactory.instance().getMapper(DocumentazioneMapper.class);
		Documentazione ret = mapper.find(id);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
		return ret;
	}
	
	public List<Documentazione> findAll() {

		SqlMapFactory.instance().openSession();
		DocumentazioneMapper mapper =  SqlMapFactory.instance().getMapper(DocumentazioneMapper.class);
		List<Documentazione> ret = mapper.findAll();
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
		return ret;
	}

}
