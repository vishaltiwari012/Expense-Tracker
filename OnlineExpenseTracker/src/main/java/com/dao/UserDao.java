package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.User;

public class UserDao {
	private SessionFactory factory;
	private Session session = null;
	private Transaction tx = null;

	public UserDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public boolean saveUser(User user) {
		boolean f = false;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			f = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
			// Close the SessionFactory when done
		}

		return f;
	}

	public User loginUser(String email, String password) {
		User user = null;
		try {
			session = factory.openSession();
			Query q = session.createQuery("from User where email=:em and password=:ps");
			q.setParameter("em", email);
			q.setParameter("ps", password);

			user = (User) q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
