package com.hibernateex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hibernateex.service.IGroupService;

@Component
public class GroupController {
	
	@Autowired
	public IGroupService iGroupService;
	
	public void getAllGroup() {
		iGroupService.getAllGroup();
	}

}
