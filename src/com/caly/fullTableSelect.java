package com.caly;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class fullTableSelect extends connection {
	private ArrayList<contact> list = new ArrayList<>();

	protected void select(){
	if (connect()) {
		try {
			java.sql.Statement stmt = con.createStatement();
           
				list.clear();
			
			ResultSet rs = stmt
					.executeQuery("select * from animals");

			while (rs.next()) {
		
			list.add(new contact.Builder(rs.getString("name"),rs.getString("givebirth"), rs.getString("canfly") ,rs.getString("livewater"),rs.getString("havelegs")).setClass(rs.getString("class")).build());
            }
            
			con.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		

	} 
		

}

	public ArrayList<contact> getlist() {
		// TODO Auto-generated method stub
		return list;
	}
}
