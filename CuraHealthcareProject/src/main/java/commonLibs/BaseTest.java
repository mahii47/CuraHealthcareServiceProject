package commonLibs;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import drivers.DriverFactory;

public class BaseTest implements IBrowserActions {

	public static WebDriver driver;
	WebDriverWait wait;
	@Override
	public void openBrowser() {
		DriverFactory.initDriver();
		driver=DriverFactory.getDriver();
	}
	@Override
	public void closeBrowser() {
		DriverFactory.quitDriver();
	}
	@Override
	public void navigateToUrl(String url) {
		driver.get(url);		
	}
	@Override
	public void enterText(String locator, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.id(locator)).sendKeys(value);	
	}
	@Override
	public void clickByxPath(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		driver.findElement(By.xpath(locator)).click();
	}
	public void Loginclick(String value)
	{	
		driver.findElement(By.id(value)).click();
	}
	@Override
	public String getText(String locator) {
		return null;
	}
	@Override
	public void waitForElement(String locator, int timeout) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
}
	@Override
	public void logout(String locator) {
	}
	@Override
	public void dropdown(String locator,String text) {
		WebElement dropdown = driver.findElement(By.id(locator));
		Select select = new Select(dropdown);
		select.selectByVisibleText(text);
	}
	@Override
	public void selectCheckbox(String locator) {
		WebElement checkbox = driver.findElement(By.id(locator));
		if(!checkbox.isSelected())
		{
			checkbox.click();
		}
		else
		{
			checkbox.click();
		}
	}
	@Override
	public void selectDateByInput(String locator, String date) {
		WebElement dateFiled = driver.findElement(By.id(locator));
		dateFiled.clear();
		dateFiled.sendKeys(date);	
	}
	@Override
	public void clickById(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		driver.findElement(By.id(locator)).click();
	}
	@Override
	public void sleep() throws InterruptedException {
		Thread.sleep(2000);	
	}
	public void selectRadioButtonById(String name, String id) {
	    List<WebElement> radioButtons = driver.findElements(By.name(name));
	    for (WebElement radio : radioButtons) {
	        if (radio.getAttribute("id").equals(id)) {
	            radio.click();
	            break;
	        }
	    }
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
		sleep();
		String url = driver.getCurrentUrl();
		Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/appointment.php#summary", url);
		sleep();
	}	
	
	
}
