package com.hibernateex.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hibernateex.entities.Employee;
import com.hibernateex.entities.User;

@Component
public class UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
//	public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
	
	public List<User> getAllUser(){
		List<User> listUser=null;
		
		//Session session = HibernateUtil.getSessionFactory().openSession();
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();

			listUser = session.createQuery("FROM User").list();

			for (User item : listUser) {
				System.out.print(item.getUserid()+" ");
				System.out.print(item.getUsername()+" ");
				System.out.print(item.getGroup()+" ");
				System.out.println(item.getEmail());
			}

			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
		
		return listUser;
		
	}
	
	public boolean create(User user) {
		
		boolean result=true;
		
		
		//Session session = HibernateUtil.getSessionFactory().openSession();
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			session.save(user);
			tx.commit();

		} catch (HibernateException e) {
			result=false;
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
		return result;
		
	}

}
