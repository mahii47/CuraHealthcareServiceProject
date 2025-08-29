package Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import commonLibs.BaseTest;
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
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "Mahesh");
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
	@Test(priority = 4)
	public void ValidForm() throws Exception
	{
		FillForm(1);
	}
	@AfterClass
	public void close()
	{
		closeBrowser();
	}
}
