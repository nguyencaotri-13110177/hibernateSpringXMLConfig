package com.hibernateex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hibernateex.service.IUserService;

@Component
public class UserController {
	
	@Autowired
	public IUserService iUserService;
	
	public void getAllUser() {
		iUserService.getAllUser();
	}

}
