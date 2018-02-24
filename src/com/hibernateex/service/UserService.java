package com.hibernateex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hibernateex.dao.IUserDAO;
import com.hibernateex.entities.User;

@Component
public class UserService implements IUserService {
	
	@Autowired
	public IUserDAO iUserDAO;

	@Override
	public List<User> getAllUser() {
		List<User> listUser=null;
		
		listUser=iUserDAO.getAllUser();
		
		return listUser;
	}

	@Override
	public User getUserById(int id) {
		User user=null;
		
		user=iUserDAO.getUserById(id);
		
		return user;
	}

	@Override
	public boolean create(User user) {
		boolean result=true;
		
		result=iUserDAO.create(user);
		
		return result;
	}

	@Override
	public boolean update(User user) {
		boolean result=true;
		
		result=iUserDAO.update(user);
		
		return result;
	}

	@Override
	public boolean delete(User user) {
		boolean result=true;
		
		result=iUserDAO.delete(user);
		
		return result;
	}

}
