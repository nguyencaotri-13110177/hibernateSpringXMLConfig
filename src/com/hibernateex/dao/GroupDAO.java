package com.hibernateex.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hibernateex.entities.Group;

@Component
public class GroupDAO implements IGroupDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Group> getAllGroup() {
		List<Group> listGroup=null;
		
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			listGroup=session.createQuery("From Group").list();
			
			for(Group item : listGroup) {
				System.out.print(item.getGroupid()+" ");
				System.out.print(item.getTitle()+" ");
				System.out.println(item.getLevel()+" ");
			}
			
			tx.commit();
			
		} catch (HibernateException ex) {
			if(tx!=null)
				tx.rollback();
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		
		
		return listGroup;
	}

	@Override
	public Group getGroupById(int id) {
		Group group=null;
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			group=(Group)session.createQuery("From Group g where g.groupid=:id").setInteger("id", id).uniqueResult();
			tx.commit();
			
		} catch (HibernateException ex) {
			if(tx!=null)
				tx.rollback();
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return group;
	}

	@Override
	public boolean create(Group group) {
		boolean result=true;
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			session.save(group);
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
	public boolean update(Group group) {
		boolean result=true;
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		
		try {
			tx=session.beginTransaction();
			session.update(group);
			tx.commit();
		} catch (HibernateException ex) {
			if(tx!=null)
				tx.rollback();
			result=false;
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		
		
		return result;
	}

	@Override
	public boolean delete(Group group) {
		boolean result=true;
		
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		
		
		try {
			tx=session.beginTransaction();
			session.delete(group);
			tx.commit();
			
		} catch (HibernateException ex) {
			if(tx!=null)
				tx.rollback();
			result=false;
			ex.printStackTrace();
		}finally {
			session.close();
		}
		
		
		
		return result;
	}
	
	

}
