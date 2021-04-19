package it.exolab.gestionaleTL.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import it.exolab.gestionaleTL.model.User;

public interface UserMapper {
	
	public User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	public User findByEmail(String email);
	public User find(Integer id);
	public void insert(User user);
	public void update(User user);
	public List<User> findAll();

}
