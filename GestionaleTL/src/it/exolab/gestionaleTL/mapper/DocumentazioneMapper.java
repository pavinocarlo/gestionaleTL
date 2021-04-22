package it.exolab.gestionaleTL.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import it.exolab.gestionaleTL.model.Documentazione;

public interface DocumentazioneMapper {
	
	public void insert(Documentazione documentazione);
	public void update(Documentazione documentazione);
	public Documentazione find(Integer id);
	public List<Documentazione> findAll();
	public List<Documentazione> findForVotazione(@Param("riunione_stato") int riunione_stato,
												@Param("riunione_id") int riunione_id,
												@Param("lavoro_stato") String lavoro_stato);

}
