package com.caly;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {

	Connection con;

	public boolean connect() {
		try {
			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/bayes", "postgres", "1");
			
			return true;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return false;
	}
}
