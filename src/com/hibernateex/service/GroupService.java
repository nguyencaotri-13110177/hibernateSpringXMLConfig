package com.hibernateex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hibernateex.dao.IGroupDAO;
import com.hibernateex.entities.Group;

@Component
public class GroupService implements IGroupService {
	
	@Autowired
	public IGroupDAO iGroupDAO;

	@Override
	public List<Group> getAllGroup() {
		List<Group> listGroup=null;
		
		listGroup=iGroupDAO.getAllGroup();
		
		return listGroup;
	}

	@Override
	public Group getGroupById(int id) {
		Group group=null;
		
		group=iGroupDAO.getGroupById(id);
		
		return group;
	}

	@Override
	public boolean create(Group group) {
		boolean result=true;
		
		result=iGroupDAO.create(group);
		
		return result;
	}

	@Override
	public boolean update(Group group) {
		boolean result=true;
		
		result=iGroupDAO.update(group);
		
		return result;
	}

	@Override
	public boolean delete(Group group) {
		boolean result=true;
		
		result=iGroupDAO.delete(group);
		
		return result;
	}

}
