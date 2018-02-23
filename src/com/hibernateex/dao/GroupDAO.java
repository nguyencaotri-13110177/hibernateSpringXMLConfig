package com.hibernateex.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.hibernateex.entities.Group;

public class GroupDAO {
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	public boolean create(Group group)
	{
		boolean result=true;
		
		//Session session = HibernateUtil.getSessionFactory().openSession();
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			session.save(group);
			tx.commit();

		} catch (HibernateException e) {
			result = false;
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
		return result;
	}

}
