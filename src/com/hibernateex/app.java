package com.hibernateex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernateex.dao.EmployeeDAO;
import com.hibernateex.dao.GroupDAO;
import com.hibernateex.dao.UserDAO;
import com.hibernateex.entities.Employee;
import com.hibernateex.entities.Group;
import com.hibernateex.entities.User;

public class app {

	// private static SessionFactory factory;

	public static void main(String[] args) {

		// EmployeeDAO ME = new EmployeeDAO();
		// //Employee em1=new Employee(null,"nam",null , 0);
		// Employee em1=new Employee();
		// em1.setFirstName("tri");
		// em1.setLastName("tri nguyen cao 2");
		// em1.setSalary(467);
		// em1.setId(6);
		//
		//
		//
		// //ME.update(em1);
		// //ME.delete(em1);
		// ME.listEmployees();
		// //ME.getUserByID(5);
		// //ME.create(em1);
		//
		// //ME.listEmployees();
		// //ME.deleteUser(1);
		// //ME.addUser("tri123", "nguyen", 300);
		// //ME.updateUser(3, "nam123", "tran", 700);
		//
		// UserDAO userdao=new UserDAO();
		//
		// User us1=new User();
		// us1.setEmail("tringuyen@123");
		// us1.setUsername("nam nguyen");
		// //us1.setUserid(4);
		// //us1.setGroup(group);;
		//
		// //userdao.create(us1);
		// userdao.getAllUser();
		//
		//
		// GroupDAO groupdao=new GroupDAO();
		// Group group1=new Group();
		// group1.setLevel("leval 1");
		// group1.setTitle("dev java");
		// group1.setGroupid(1);
		// //groupdao.create(group1);

		ApplicationContext Context = new ClassPathXmlApplicationContext("Beans.xml");
		UserDAO userDAO = (UserDAO) Context.getBean("userDAO");
		userDAO.getAllUser();
		
		EmployeeDAO employeeDAO = (EmployeeDAO) Context.getBean("employeeDAO");
		employeeDAO.listEmployees();

	}

}
