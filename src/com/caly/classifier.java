package com.caly;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class classifier extends connection {

	ArrayList<Double> ratelist=new ArrayList();
	ArrayList<String> sqllist=new ArrayList<>();
	
	
	public String classifier(contact contact){
		if (connect()) {
			try {
				java.sql.Statement stmt = con.createStatement();
                addsqllist(contact);
                for (String sql : sqllist) {
					
				
				ResultSet rs = stmt
						.executeQuery(sql);

				while (rs.next()) {
				    ratelist.add(Double.parseDouble(rs.getString(1)));
				}
                }
                
				con.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			return  ratecalc();

		} else
			return null;
	}


	private String ratecalc() {
		double mammalsBayes=1,nonmammalsBayes=1;
		for (int i=0;i<(ratelist.size()/2)-1;i++){
			ratelist.set(i, ratelist.get(i)/ratelist.get(8));
			ratelist.set(i+4, ratelist.get(i+4)/ratelist.get(9));
          
			mammalsBayes*=ratelist.get(i);
			nonmammalsBayes*=ratelist.get(i+4);
		}
		
		mammalsBayes*=ratelist.get(8)/(ratelist.get(8)+ratelist.get(9));
		nonmammalsBayes*=ratelist.get(9)/(ratelist.get(8)+ratelist.get(9));

		for (Double double1 : ratelist) {
			System.out.println(double1);
		}
		System.out.println(mammalsBayes+"\n"+nonmammalsBayes);
		if(mammalsBayes>nonmammalsBayes)
			return "mammals";
		else
			return "non-mamals";
		
	}


	private void addsqllist(contact contact) {
		
		sqllist.add("select count(givebirth) from animals where givebirth='"+contact.getGivebirth()+"' and class='mammals'");
		sqllist.add("select count(canfly) from animals where canfly='"+contact.getCanfly()+"' and class='mammals'");
		sqllist.add("select count(livewater) from animals where livewater='"+contact.getLivewater()+"' and class='mammals'");
		sqllist.add("select count(havelegs) from animals where havelegs='"+contact.getHavelegs()+"' and class='mammals'");
		
		//non mammals
		
		sqllist.add("select count(givebirth) from animals where givebirth='"+contact.getGivebirth()+"' and class='non-mammals'");
		sqllist.add("select count(canfly) from animals where canfly='"+contact.getCanfly()+"' and class='non-mammals'");
		sqllist.add("select count(livewater) from animals where livewater='"+contact.getLivewater()+"' and class='non-mammals'");
		sqllist.add("select count(havelegs) from animals where havelegs='"+contact.getHavelegs()+"' and class='non-mammals'");
		
		//total mammals
		sqllist.add("select count(class) from animals where class='mammals'");
		//total non-mammals
		sqllist.add("select count(class) from animals where class='non-mammals'");

	
	}

}
