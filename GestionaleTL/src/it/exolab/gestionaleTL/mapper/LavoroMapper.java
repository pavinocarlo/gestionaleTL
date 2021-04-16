package it.exolab.gestionaleTL.mapper;


import java.util.List;

import it.exolab.gestionaleTL.model.Lavoro;

public interface LavoroMapper {
	
	public void insert(Lavoro lavoro);
	public void update(Lavoro lavoro);
	public Lavoro find(Integer id);
	public List<Lavoro> findAll();
	public List<Lavoro> findByNome(String nome);

}
