package Test;
import java.sql.ResultSet;

import org.openqa.selenium.By;
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
	@Test(priority = 1)
	public void invalidLogin1() throws Exception
	{
		LoginFromDB(1);
	}
	
	@Test(priority = 2)
	public void invalidLogin2() throws Exception
	{
		LoginFromDB(2);	
	}
	
	@Test(priority = 3)
	public void login() throws Exception
	{
		LoginFromDB(3);
	}
	
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
	@Test(priority = 4)
	public void ValidForm() throws Exception
	{
		FillForm(1);
	}
	public void FillForm(int id) throws Exception
	{
		ResultSet rs = DatabaseUtils.getData("Select facility,Visit_Date,Comment from fill_form where id ="+id);
		rs.next();
		
		String facility = rs.getString("facility");
		String Visit_Date = rs.getString("Visit_Date");
		String Comment = rs.getString("Comment");
		
		waitForElement("combo_facility",20);
		dropdown("combo_facility",facility);
		selectCheckbox("chk_hospotal_readmission");
		selectRadioButtonById("programs","radio_program_medicaid");
		waitForElement("txt_visit_date",20);
		selectDateByInput("txt_visit_date",Visit_Date);
		waitForElement("txt_comment",20);
		clickById("txt_comment");
		enterText("txt_comment",Comment);
		clickById("btn-book-appointment");
		String url = driver.getCurrentUrl();
		Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/appointment.php#summary", url);
		sleep();
	}
	@AfterClass
	public void close()
	{
		closeBrowser();
	}
}
