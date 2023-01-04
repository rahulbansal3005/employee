package com.increff.employees;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static void configure() {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		// Adding a mapping from pojo to database table
		config.addAnnotatedClass(EmployeePojo.class);
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();
		
		sessionFactory = config.buildSessionFactory(serviceRegistryObj);
	}

}
