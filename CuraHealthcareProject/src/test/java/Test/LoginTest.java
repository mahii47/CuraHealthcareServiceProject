package Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import commonLibs.BaseTest;
import commonLibs.ConfigReader;
import pages.AppointmentPage;
import pages.LoginPage;
public class LoginTest extends BaseTest {
	
	String url = ConfigReader.getProperty("app.url");
	boolean isLoggedIn = false;
	LoginPage lp = new LoginPage();
	AppointmentPage ap = new AppointmentPage();
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
		lp.LoginFromDB(1);
	}
	
	@Test(priority = 2)
	public void invalidLogin2() throws Exception
	{
		lp.LoginFromDB(2);	
	}
	@Test(priority = 3)
	public void login() throws Exception
	{
		lp.LoginFromDB(3);
	}
	@Test(priority = 4)
	public void ValidForm() throws Exception
	{
		ap.FillForm(1);
	}
	@AfterClass
	public void close()
	{
		closeBrowser();
	}
}
