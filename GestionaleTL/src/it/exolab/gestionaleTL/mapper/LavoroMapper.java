package it.exolab.gestionaleTL.mapper;


import it.exolab.gestionaleTL.model.Lavoro;

public interface LavoroMapper {
	
	public void insert(Lavoro lavoro);
	public Lavoro find(Integer id);

}
