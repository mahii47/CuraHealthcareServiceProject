package pages;

import java.sql.ResultSet;
import commonLibs.BaseTest;
import commonLibs.DatabaseUtils;

public class LoginPage extends BaseTest {
	
	public void LoginFromDB(int id) throws Exception {
	    ResultSet rs = DatabaseUtils.getData("SELECT username, password FROM login_data WHERE id = "+id);
	    rs.next();
	    String username = rs.getString("username");
	    String password = rs.getString("password");

	    waitForElement("txt-username", 20);
	    enterText("txt-username", username);
	    waitForElement("txt-password", 20);
	    enterText("txt-password", password);
	    waitForElement("btn-login", 20);
	    Loginclick("btn-login");
	    sleep();
	    
	}

}
