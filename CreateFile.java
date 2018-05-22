package dataprocessing.H3;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateFile {
	public static void main(String[] args) throws Exception {
		Class.forName("org.h2.Driver").newInstance();
		Connection con = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "mypassword");
		System.out.println("Database created");
	}
}
