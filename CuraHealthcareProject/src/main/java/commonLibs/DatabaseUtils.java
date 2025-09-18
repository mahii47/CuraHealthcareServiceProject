package commonLibs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtils {
	private static final String URL = ConfigReader.getProperty("db.url");
	private static final String USER= ConfigReader.getProperty("db.user");
	private static final String PASSWORD= ConfigReader.getProperty("db.password");
	
	 public static ResultSet getData(String query) throws Exception {
	        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
	        Statement stmt = con.createStatement();
	           return stmt.executeQuery(query);
	 	}
}
