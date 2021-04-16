package it.exolab.gestionaleTL.mapper;

import java.util.List;

import it.exolab.gestionaleTL.model.Documentazione;

public interface DocumentazioneMapper {
	
	public void insert(Documentazione documentazione);
	public void update(Documentazione documentazione);
	public Documentazione find(Integer id);
	public List<Documentazione> findAll();

}
