package it.exolab.gestionaleTL.crud;


import it.exolab.gestionaleTL.mapper.RiunioneMapper;

import it.exolab.gestionaleTL.model.Riunione;
import it.exolab.gestionaleTL.mybatis.SqlMapFactory;

public class RiunioneCrud {
	
	public Riunione find(Integer id){
		SqlMapFactory.instance().openSession();
		RiunioneMapper mapper =  SqlMapFactory.instance().getMapper(RiunioneMapper.class);
		Riunione ret = mapper.find(id);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
		return ret;
	}

}
