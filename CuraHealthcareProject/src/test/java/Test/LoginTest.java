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
    @Test(priority = 1, groups = "Login")
    public void invalidLoginTest() throws InterruptedException {
        waitForElement("txt-username", 20);
        enterText("txt-username", "WrongUser");
        waitForElement("txt-password", 20);
        enterText("txt-password", "WrongPassword");
        waitForElement("btn-login", 20);
        Loginclick("btn-login");
        sleep();
        // Verify login failure
        boolean loginFailed = driver.getPageSource().contains("Login failed");
        Assert.assertTrue(loginFailed, "Error message not displayed for invalid login!");
    }
	@Test(priority = 2, groups = "Login")
	public void ValidLogin() throws InterruptedException
	{
		waitForElement("txt-username",20);
		enterText("txt-username","John Doe");
		waitForElement("txt-password",20);
		enterText("txt-password","ThisIsNotAPassword");
		waitForElement("btn-login",20);
		Loginclick("btn-login");
		sleep();
		
		//verify successful login
		isLoggedIn = driver.getCurrentUrl().contains("appointment");
		Assert.assertTrue(isLoggedIn,"Login failed unexpectedly!");
	}
	
	@Test(priority = 3,dependsOnMethods = {"ValidLogin"},groups = "Form")
	public void FillForm() throws InterruptedException
	{
		waitForElement("combo_facility",10);
		dropdown("combo_facility","Hongkong CURA Healthcare Center");
		selectCheckbox("chk_hospotal_readmission");
		selectRadioButtonById("programs","radio_program_medicaid");
		waitForElement("txt_visit_date",10);
		selectDateByInput("txt_visit_date","19/02/2025");
		waitForElement("txt_comment",10);
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
