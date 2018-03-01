package com.caly;

import java.sql.SQLException;
import java.util.ArrayList;

public class insertData extends connection {

	public String insertData(contact datalist) {

		String Class=new classifier().classifier(datalist);
		
		if (connect())
			try {
				java.sql.Statement stmt = con.createStatement();
				stmt.execute("INSERT INTO animals (name,givebirth,canfly,livewater,havelegs,class) VALUES ('"
						+ datalist.getName() + "','" 
						+ datalist.getGivebirth()+ "','"
						+ datalist.getCanfly() + "','"
						+ datalist.getLivewater() + "','"
						+ datalist.getHavelegs() + "','" + Class + "')");
				System.out.println("insert success..!");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				// e.printStackTrace();
			}
		else
			System.out.println("connection Failed..!");

	
		return Class;
	}

}
