package it.exolab.gestionaleTL.mapper;

import java.sql.Timestamp;

import org.apache.ibatis.annotations.Param;

import it.exolab.gestionaleTL.model.RigaPresenza;


public interface RigaPresenzaMapper {
	
	public void insert(RigaPresenza rigaPresenza);
	public void update(RigaPresenza rigaPresenza);
	public RigaPresenza find(Integer id);
	public RigaPresenza findByUserRiunione(@Param("user_id") int user_id, 
											@Param("riunione_id") int riunione_id);
}
