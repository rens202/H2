package dataprocessing.H3;

import java.sql.*;

public class Display {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "mypassword");
			Statement stmt = con.createStatement();
			String sql="select * from REGISTRATION";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
