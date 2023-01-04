package com.increff.employees;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;

public class EmployeeHibernateApi {

	private static final Logger logger = Logger.getLogger(EmployeeHibernateApi.class.getName());
	
	public EmployeeHibernateApi() throws IOException, ClassNotFoundException, SQLException {

	}
	
	public void insert() throws SQLException {
		logger.info("Inserting employees...");

	}
	
	public void select() throws SQLException {
		logger.info("Selecting employees...");

	}
	
	public void delete() throws SQLException {
		logger.warning("Deleting all employees...");

	}
}
