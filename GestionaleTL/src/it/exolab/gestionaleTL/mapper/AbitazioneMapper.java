package it.exolab.gestionaleTL.mapper;

import java.util.List;

import it.exolab.gestionaleTL.model.Abitazione;
import it.exolab.gestionaleTL.model.User;

public interface AbitazioneMapper {
	
	public Abitazione find(Integer id);
	public void insert(Abitazione abitazione);
	public void update(Abitazione abitazione);
	public Abitazione findWithProprietario(Integer id);
	public List<Abitazione> findAll();

}
