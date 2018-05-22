package connection;

import java.sql.*;
public class Test {
	protected static Connection conn;
	
    protected Connection getConnection() {
    	Connection conn = null;
			try {
				Class.forName("org.h2.Driver");
				conn = DriverManager.
					getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
				/*Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery("SELECT * FROM test");
    			
    			while (rs.next()) {
    				System.out.println(rs.getString("NAME"));
    			}*/
								
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
    			
}
}