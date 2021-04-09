package it.exolab.gestionaleTL.crud;


import it.exolab.gestionaleTL.mapper.LavoroMapper;

import it.exolab.gestionaleTL.model.Lavoro;
import it.exolab.gestionaleTL.mybatis.SqlMapFactory;

public class LavoroCrud {
	
	public Lavoro find(Integer id){
		SqlMapFactory.instance().openSession();
		LavoroMapper mapper =  SqlMapFactory.instance().getMapper(LavoroMapper.class);
		Lavoro ret = mapper.find(id);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
		return ret;
	}

}
