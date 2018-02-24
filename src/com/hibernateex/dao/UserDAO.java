package com.hibernateex.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hibernateex.entities.User;

@Component
public class UserDAO implements IUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getAllUser() {
		List<User> listUser = null;

		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			listUser = session.createQuery("From User").list();
			
			for(User item:listUser) {
				System.out.print(item.getUserid()+" ");
				System.out.print(item.getUsername()+" ");
				System.out.print(item.getEmail()+" ");
				System.out.println(item.getGroup().getGroupid()+" ");
			}
			
			
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return listUser;
	}

	@Override
	public User getUserById(int id) {
		User user=null;
		
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			user=(User)session.createQuery("from User u where u.userid=:id").setInteger("userid", id).uniqueResult();
			tx.commit();
		} catch (HibernateException ex) {
			if(tx!=null)
				tx.rollback();
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		return user;
	}

	@Override
	public boolean create(User user) {
		boolean result=true;
		
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (HibernateException ex) {
			result=false;
			if(tx!=null)
				tx.rollback();
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return result;
	}

	@Override
	public boolean update(User user) {
		boolean result=true;
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			session.update(user);
			tx.commit();
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			result=false;
		}finally {
			session.close();
		}
		
		
		return result;
	}

	@Override
	public boolean delete(User user) {
		boolean result=true;
		
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		
		
		try {
			tx=session.beginTransaction();
			session.delete(user);
			tx.commit();
			
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			result=false;
		}finally {
			session.close();
		}
		
		
		return result;
	}

}
