package com.hibernateex.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hibernateex.entities.Group;

@Component
public interface IGroupService {

	List<Group> getAllGroup();
	Group getGroupById(int id);
	boolean create(Group group);
	boolean update(Group group);
	boolean delete(Group group);
	
}
