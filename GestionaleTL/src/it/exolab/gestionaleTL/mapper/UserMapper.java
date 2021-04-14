package it.exolab.gestionaleTL.mapper;

import it.exolab.gestionaleTL.model.User;

public interface UserMapper {
	
	public User findByEmailAndPassword(User user);
	public User findByEmail(String email);

}
