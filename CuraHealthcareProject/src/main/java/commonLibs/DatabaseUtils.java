package commonLibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtils {
	private static final String URL = "jdbc:mysql://localhost:3306/curahealthproject";
	private static final String USER="root";
	private static final String PASSWORD="Mahesh@123";
	
	 public static ResultSet getData(String query) throws Exception {
	        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	        Statement stmt = con.createStatement();
	         return stmt.executeQuery(query);
	 	}
}
