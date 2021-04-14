package it.exolab.gestionaleTL.mapper;

import org.apache.ibatis.annotations.Param;

import it.exolab.gestionaleTL.model.User;

public interface UserMapper {
	
	public User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	public User findByEmail(String email);
	public void insert(User user);

}
