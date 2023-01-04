package com.increff.employees;

import java.io.IOException;
import java.sql.SQLException;

public class App {

	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException {
		HibernateUtil.configure();
	}
}
