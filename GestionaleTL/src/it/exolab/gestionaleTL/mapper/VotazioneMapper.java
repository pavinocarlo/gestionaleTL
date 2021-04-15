package it.exolab.gestionaleTL.mapper;

import it.exolab.gestionaleTL.model.Votazione;

public interface VotazioneMapper {
	
	public void insert(Votazione votazione);
	public void update(Votazione votazione);
	public Votazione find(Integer id);

}
