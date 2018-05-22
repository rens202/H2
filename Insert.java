package dataprocessing.H3;

import java.sql.*;

public class Insert {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "mypassword");
			Statement stmt = con.createStatement();
			String sql="insert into REGISTRATION(first,last,age) values('hallo','doei','12'),"
					+ "('hoi','dag',15)";
			int i=stmt.executeUpdate(sql);
			System.out.println(i+ " Records inserted");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
