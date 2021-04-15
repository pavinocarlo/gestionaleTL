package it.exolab.gestionaleTL.crud;

import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.mapper.RigaPresenzaMapper;
import it.exolab.gestionaleTL.model.RigaPresenza;

import it.exolab.gestionaleTL.mybatis.SqlMapFactory;

public class RigaPresenzaCrud {
	
	public void insert(RigaPresenza rigaPresenza) throws GenericException, AlreadyExistException, InvalidFieldException{

		SqlMapFactory.instance().openSession();
		RigaPresenzaMapper mapper =  SqlMapFactory.instance().getMapper(RigaPresenzaMapper.class);
		mapper.insert(rigaPresenza);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
	}
	
	public void update(RigaPresenza rigaPresenza) throws GenericException, AlreadyExistException, InvalidFieldException{

		SqlMapFactory.instance().openSession();
		RigaPresenzaMapper mapper =  SqlMapFactory.instance().getMapper(RigaPresenzaMapper.class);
		mapper.update(rigaPresenza);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
	}
	
	public RigaPresenza find(Integer id) throws GenericException, AlreadyExistException, InvalidFieldException{

		SqlMapFactory.instance().openSession();
		RigaPresenzaMapper mapper =  SqlMapFactory.instance().getMapper(RigaPresenzaMapper.class);
		RigaPresenza ret = mapper.find(id);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
		return ret;
	}

}
