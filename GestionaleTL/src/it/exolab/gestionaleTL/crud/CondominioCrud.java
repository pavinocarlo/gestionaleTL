package it.exolab.gestionaleTL.crud;

import it.exolab.gestionaleTL.mapper.CondominioMapper;
import it.exolab.gestionaleTL.model.Condominio;
import it.exolab.gestionaleTL.mybatis.SqlMapFactory;

public class CondominioCrud {
	
	public Condominio find(Integer id){
		SqlMapFactory.instance().openSession();
		CondominioMapper mapper =  SqlMapFactory.instance().getMapper(CondominioMapper.class);
		Condominio ret = mapper.find(id);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
		return ret;
	}
	
	

}
