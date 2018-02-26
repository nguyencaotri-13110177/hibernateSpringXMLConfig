package com.hibernateex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hibernateex.entities.Group;
import com.hibernateex.entities.User;
import com.hibernateex.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	public IUserService iUserService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUser() {
		List<User> listUser=null;
		listUser=iUserService.getAllUser();
		return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
	}

}
