package com.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.entity.Expense;
import com.entity.User;

import java.util.Properties;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// Create a Configuration instance
			Configuration configuration = new Configuration();

			// Hibernate settings equivalent to hibernate.cfg.xml's properties
			Properties settings = new Properties();
			settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/expense-tracker");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "mysql@123");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

			// Enable Hibernate to automatically create the database schema
			settings.put(Environment.HBM2DDL_AUTO, "update");
			settings.put(Environment.SHOW_SQL, "true");
			settings.put(Environment.FORMAT_SQL, "true");

			// Apply settings to configuration
			configuration.setProperties(settings);

			// Add annotated classes
			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Expense.class);

			// Create ServiceRegistry
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			// Create SessionFactory
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}
