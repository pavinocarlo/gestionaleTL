package it.exolab.gestionaleTL.crud;

import it.exolab.gestionaleTL.mapper.AbitazioneMapper;
import it.exolab.gestionaleTL.model.Abitazione;
import it.exolab.gestionaleTL.mybatis.SqlMapFactory;

public class AbitazioneCrud {

	public Abitazione find(Integer id){
		SqlMapFactory.instance().openSession();
		AbitazioneMapper mapper =  SqlMapFactory.instance().getMapper(AbitazioneMapper.class);
		Abitazione ret = mapper.find(id);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
		return ret;
	}
	
}
