package dataprocessing.H3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Reiziger {
	public static int index;
	private int reizigerID;
	private String voorletters;
	private String tussenvoegsel;
	private String achternaam;
	private Date date;
	
	public Reiziger(String voorl, String tussenv, String achtern, Date dt) {
		voorletters = voorl;
		tussenvoegsel = tussenv;
		achternaam = achtern;
		date = dt;
		reizigerID = index;
		index++;
	}
	
	public void insert() {
		try {
			Connection con = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "mypassword");
			Statement stmt = con.createStatement();
			String sql="insert into REIZIGER(reizigerID,voorletters,tussenvoegsel,achternaam,geboortedatum)"
					+ " values('"+reizigerID+"','"+voorletters+"','"+tussenvoegsel+"','"+achternaam+"','"+date+"')";
			stmt.executeUpdate(sql);
			System.out.println("Reiziger added.");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void delete() {
		try {
			Connection con = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "mypassword");
			Statement stmt = con.createStatement();
			String sql="delete from REIZIGER"
					+ " where reizigerID = "+reizigerID;
			stmt.executeUpdate(sql);
			System.out.println("Reiziger deleted.");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void changeVoorletters(String voorl) {
		voorletters = voorl;
		try {
			Connection con = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "mypassword");
			Statement stmt = con.createStatement();
			String sql="update REIZIGER set voorletters = '"+voorl+"' where reizigerID = '"+reizigerID+"'";
			stmt.executeUpdate(sql);
			System.out.println("Reiziger updated.");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static String fetchData() {
		try {
			String s = "";
			
			Connection con = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "mypassword");
			Statement stmt = con.createStatement();
			String sql="select * from REIZIGER";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				s += rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+"\n";
			}
			
			if(s == "") {
				s = "No data available in this table.";
			}
			
			return s;
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return "Error: No data found.";
		}
	}
	
	public static List<Reiziger> update(){
		List<Reiziger> reizigerList = new ArrayList<Reiziger>();
		try {
			Connection con = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "mypassword");
			Statement stmt = con.createStatement();
			String sql="select * from REIZIGER";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				reizigerList.add(new Reiziger(rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5)));
			}
			
			return reizigerList;
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return reizigerList;
		}
	}
	
	public static void clearTable() {
		try {
			Connection con = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "mypassword");
			Statement stmt = con.createStatement();
			String sql="delete from REIZIGER";
			stmt.executeUpdate(sql);
			System.out.println("Table cleared");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
