package com.hibernateex.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {
	
	@Autowired
	public IGroupDAO iGroupDAO;
	
	public void getAllGroup() {
		iGroupDAO.getAllGroup();
	}

}
