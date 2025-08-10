package Test;
import java.sql.ResultSet;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import commonLibs.BaseTest;
import commonLibs.DatabaseUtils;

public class LoginTest extends BaseTest {
	
	String url = "https://katalon-demo-cura.herokuapp.com/";
	boolean isLoggedIn = false;
	@BeforeClass
	public void invokeBrowser() throws InterruptedException
	{
		openBrowser();
		navigateToUrl(url);
		sleep();
	}
	@Test(priority = 0)
	public void makeAppointment()
	{
		clickByxPath("//a[@id='btn-make-appointment']");
		
	}

	@Test(priority=1)
	public void ValidLoginFromDB() throws Exception {
	    ResultSet rs = DatabaseUtils.getData("SELECT username, password FROM login_data WHERE id = 1");
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

	
	//@Test(priority = 3,dependsOnMethods = {"ValidLogin"},groups = "Form")
	@Test(groups = "Form",priority = 2)
	public void FillForm() throws InterruptedException
	{
		waitForElement("combo_facility",20);
		dropdown("combo_facility","Hongkong CURA Healthcare Center");
		selectCheckbox("chk_hospotal_readmission");
		selectRadioButtonById("programs","radio_program_medicaid");
		waitForElement("txt_visit_date",20);
		selectDateByInput("txt_visit_date","19/02/2025");
		waitForElement("txt_comment",20);
		clickById("txt_comment");
		enterText("txt_comment","I want to checkup for my stomach");
		clickById("btn-book-appointment");
		sleep();
	}
	@AfterClass
	public void close()
	{
		closeBrowser();
	}
}
