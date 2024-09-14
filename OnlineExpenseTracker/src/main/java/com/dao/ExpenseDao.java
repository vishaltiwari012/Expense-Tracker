package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Expense;
import com.entity.User;

public class ExpenseDao {
	private SessionFactory factory;
	private Session session = null;
	private Transaction tx = null;

	public ExpenseDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public boolean saveExpense(Expense expense) {
		boolean f = false;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(expense);
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

	public List<Expense> getAllExpenses(User user) {
		List<Expense> list = new ArrayList<>();
		try {
			session = factory.openSession();
			Query q = session.createQuery("from Expense where user=:us");
			q.setParameter("us", user);
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Expense getExpenseById(int id) {
		Expense ex = null;
		try {
			session = factory.openSession();
			Query q = session.createQuery("from Expense where id=:id");
			q.setParameter("id", id);
			
			ex = (Expense)q.uniqueResult();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ex;
	}
	
	
	public boolean updateExpense(Expense expense) {
		boolean f = false;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(expense);
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
	
	public boolean deleteExpense(int id) {
		boolean f = false;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Expense ex = session.get(Expense.class, id);
			session.delete(ex);
			tx.commit();
			f = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

}
