package com.hibernateex.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hibernateex.entities.User;

@Component
public interface IUserDAO {
	
	List<User> getAllUser();
	User getUserById(int id);
	boolean create(User user);
	boolean update(User user);
	boolean delete(User user);

}
