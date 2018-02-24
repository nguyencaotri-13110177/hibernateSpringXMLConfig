package com.hibernateex.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hibernateex.entities.Group;

@Component
public interface IGroupDAO {
	
	List<Group> getAllGroup();
	Group getGroupById(int id);
	boolean create(Group group);
	boolean update(Group group);
	boolean delete(Group group);
	

}
