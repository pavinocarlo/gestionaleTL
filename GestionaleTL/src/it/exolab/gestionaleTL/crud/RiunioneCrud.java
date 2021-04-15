package it.exolab.gestionaleTL.crud;


import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;

import it.exolab.gestionaleTL.mapper.RiunioneMapper;

import it.exolab.gestionaleTL.model.Riunione;
import it.exolab.gestionaleTL.mybatis.SqlMapFactory;

public class RiunioneCrud {
	
	public void insert(Riunione riunione) throws GenericException, AlreadyExistException, InvalidFieldException{

		SqlMapFactory.instance().openSession();
		RiunioneMapper mapper =  SqlMapFactory.instance().getMapper(RiunioneMapper.class);
		mapper.insert(riunione);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
	}
	
	public void update(Riunione riunione) throws GenericException, AlreadyExistException, InvalidFieldException{

		SqlMapFactory.instance().openSession();
		RiunioneMapper mapper =  SqlMapFactory.instance().getMapper(RiunioneMapper.class);
		mapper.update(riunione);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
	}
	
	public Riunione find(Integer id){
		SqlMapFactory.instance().openSession();
		RiunioneMapper mapper =  SqlMapFactory.instance().getMapper(RiunioneMapper.class);
		Riunione ret = mapper.find(id);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
		return ret;
	}

}
