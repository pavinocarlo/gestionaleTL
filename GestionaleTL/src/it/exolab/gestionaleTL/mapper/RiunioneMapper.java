package it.exolab.gestionaleTL.mapper;


import it.exolab.gestionaleTL.model.Riunione;

public interface RiunioneMapper {
	
	public void insert(Riunione riunione);
	public void update(Riunione riunione);
	public Riunione find(Integer id);

}
