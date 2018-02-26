package com.hibernateex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hibernateex.entities.Group;
import com.hibernateex.service.IGroupService;

@Controller
public class GroupController {
	
	@Autowired
	public IGroupService iGroupService;
	
	@RequestMapping(value = "/group", method = RequestMethod.GET)
	public String getAllGroup(ModelMap model) {
		
		
		List<Group> listGroup=null;
		listGroup=iGroupService.getAllGroup();
		
		model.addAttribute("listGroup", listGroup);
		
		return "listGroup";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		
		return "index";
	}
	
	@RequestMapping(value = "/index2", method = RequestMethod.GET)
	public String index2() {
		
		return "index2";
	}

}
