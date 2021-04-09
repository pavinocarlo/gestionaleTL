package it.exolab.gestionaleTL.crud;

import it.exolab.gestionaleTL.mybatis.SqlMapFactory;

public class AbitazioneCrud {

	public Condominio find(Integer id){
		SqlMapFactory.instance().openSession();
		CondominioMapper mapper =  SqlMapFactory.instance().getMapper(CondominioMapper.class);
		Condominio ret = mapper.find(id);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
		return ret;
	}
	
}
