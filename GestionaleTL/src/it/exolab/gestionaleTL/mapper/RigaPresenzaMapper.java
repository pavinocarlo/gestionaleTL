package it.exolab.gestionaleTL.mapper;

import it.exolab.gestionaleTL.model.RigaPresenza;


public interface RigaPresenzaMapper {
	
	public void insert(RigaPresenza rigaPresenza);
	public void update(RigaPresenza rigaPresenza);
	public RigaPresenza find(Integer id);

}
