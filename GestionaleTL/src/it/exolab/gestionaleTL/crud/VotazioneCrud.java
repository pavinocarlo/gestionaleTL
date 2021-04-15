package it.exolab.gestionaleTL.crud;

import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.mapper.VotazioneMapper;
import it.exolab.gestionaleTL.model.Votazione;
import it.exolab.gestionaleTL.mybatis.SqlMapFactory;

public class VotazioneCrud {
	
	public void insert(Votazione votazione) throws GenericException, AlreadyExistException, InvalidFieldException{

		SqlMapFactory.instance().openSession();
		VotazioneMapper mapper =  SqlMapFactory.instance().getMapper(VotazioneMapper.class);
		mapper.insert(votazione);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
	}
	
	public void update(Votazione votazione) throws GenericException, AlreadyExistException, InvalidFieldException{

		SqlMapFactory.instance().openSession();
		VotazioneMapper mapper =  SqlMapFactory.instance().getMapper(VotazioneMapper.class);
		mapper.update(votazione);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
	}

}
