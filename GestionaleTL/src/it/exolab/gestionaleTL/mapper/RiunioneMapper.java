package it.exolab.gestionaleTL.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import it.exolab.gestionaleTL.model.Riunione;

public interface RiunioneMapper {
	
	public void insert(Riunione riunione);
	public void update(Riunione riunione);
	public Riunione find(Integer id);
	public List<Riunione> findAll();
	public List<Riunione> findForRiunione(@Param("data_riunione") Timestamp data_riunione,
										@Param("stato") int stato);

}
