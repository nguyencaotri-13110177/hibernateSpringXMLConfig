package com.hibernateex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernateex.controller.GroupController;
import com.hibernateex.controller.UserController;
import com.hibernateex.dao.GroupDAO;
import com.hibernateex.dao.IUserDAO;
import com.hibernateex.dao.UserDAO;
import com.hibernateex.entities.Group;
import com.hibernateex.entities.User;
import com.hibernateex.service.GroupService;

public class app {


	public static void main(String[] args) {


		ApplicationContext Context = new ClassPathXmlApplicationContext("Beans.xml");
//		UserDAO userDAO = (UserDAO) Context.getBean("userDAO");
//		userDAO.getAllUser();
		
//		IUserDAO iUserDAO = (IUserDAO) Context.getBean("iUserDAO");
//		iUserDAO.getAllUser();
		
		UserController controller =(UserController) Context.getBean("userController");
		controller.getAllUser();
		
//		GroupController groupController =(GroupController) Context.getBean("groupController");
//		groupController.getAllGroup();
		

	}

}
