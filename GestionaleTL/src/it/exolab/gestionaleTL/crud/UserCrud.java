package it.exolab.gestionaleTL.crud;

import it.exolab.gestionaleTL.exception.AlreadyExistException;
import it.exolab.gestionaleTL.exception.GenericException;
import it.exolab.gestionaleTL.exception.InvalidFieldException;
import it.exolab.gestionaleTL.mapper.UserMapper;
import it.exolab.gestionaleTL.model.User;
import it.exolab.gestionaleTL.mybatis.SqlMapFactory;


public class UserCrud {
	
	private void validate(User user) throws GenericException, AlreadyExistException, InvalidFieldException {
		

		if(findByEmail(user.getEmail())!=null) {
			throw new AlreadyExistException();
		}
		if(user.getNome().length()>70 || user.getNome().equals("")) {
			throw new InvalidFieldException();
		}
		if(user.getCognome().length()>70 || user.getCognome().equals("")) {
			throw new InvalidFieldException();
		}
	
		if(!user.getEmail().contains("@") || !user.getEmail().contains(".") || user.getEmail().length()>70 || user.getEmail().equals("")) {
			throw new InvalidFieldException();
		}
		if(user.getPassword().length()>70 || user.getPassword().equals("")) {
			throw new InvalidFieldException();
		}
	}
	
	
	public void insert(User user) throws GenericException, AlreadyExistException, InvalidFieldException{
		validate(user);
		SqlMapFactory.instance().openSession();
		UserMapper mapper =  SqlMapFactory.instance().getMapper(UserMapper.class);
		mapper.insert(user);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
	}

	public User findByEmail(String email) {
		SqlMapFactory.instance().openSession();
		UserMapper mapper =  SqlMapFactory.instance().getMapper(UserMapper.class);
		User ret=mapper.findByEmail(email);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
		return ret;
	}

	public User findByEmailAndPassword(String email, String password) {
		SqlMapFactory.instance().openSession();
		UserMapper mapper =  SqlMapFactory.instance().getMapper(UserMapper.class);
		User ret=mapper.findByEmailAndPassword(email, password);
		SqlMapFactory.instance().commitSession();
		SqlMapFactory.instance().closeSession();
		return ret;
	}

}
