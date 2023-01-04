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

public class EmployeeJdbcApi {

	private static final Logger logger = Logger.getLogger(EmployeeJdbcApi.class.getName());
	private Connection con;
	
	public EmployeeJdbcApi() throws IOException, ClassNotFoundException, SQLException {
		Configurator.initialize(new DefaultConfiguration());
		Properties props = new Properties();
		InputStream instream = new FileInputStream("employees.properties");
		props.load(instream);
		String driver = props.getProperty("jdbc.driver");
		Class.forName(driver);
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		con = DriverManager.getConnection(url , username, password); 
	}
	
	public void insert() throws SQLException {
		logger.info("Inserting employees...");
		Statement stmt = con.createStatement();
		for(int i=0; i<3; i++) {
			int id = i; 
			int age = 30 + i;
			String name = "'name" + i + "'";
			stmt.executeUpdate("insert into employee values("+ id +", "+ name +","+ age + ")");
		}
		stmt.close();
	}
	
	public ResultSet select() throws SQLException {
		logger.info("Selecting employees...");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("select * from employee");
		return resultSet;
//		while(resultSet.next()) {  
//			logger.info(resultSet.getInt(1) + "  "+ resultSet.getString(2)+"  "+ resultSet.getInt(3));   
//		}
//		stmt.close();
	}
	
	public void delete() throws SQLException {
		logger.warning("Deleting all employees...");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("select * from employee");
		List<Integer> idlist = new ArrayList<Integer>();
		while(resultSet.next()) {  
			idlist.add(resultSet.getInt(1));  
		}
		for(int i = 0; i < idlist.size(); i++) {
			stmt.executeUpdate("delete from employee where id =" + idlist.get(i));
		}
		stmt.close();
	}
}
