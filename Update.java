package dataprocessing.H3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "mypassword");
			Statement stmt = con.createStatement();
			String sql="update REGISTRATION set last = 'vaarwel' where first = 'hallo'";
			stmt.executeUpdate(sql);
			System.out.println("Table updated");
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}