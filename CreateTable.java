package dataprocessing.H3;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class CreateTable {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "mypassword");
			Statement stmt = con.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS REGISTRATION "
					+ "(id INTEGER auto_increment, "
					+ " first VARCHAR(255), "
					+ " last VARCHAR(255), "
					+ " age INTEGER, "
					+ " PRIMARY KEY ( id ))";
			
			stmt.executeUpdate(sql);
			System.out.println("Table Created");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
