package commonLibs;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements IBrowserActions {

	protected WebDriver driver;
	WebDriverWait wait;
	@Override
	public void openBrowser() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	@Override
	public void closeBrowser() {
		// TODO Auto-generated method stub
		if(driver!=null)
		{
			driver.quit();
		}
	}
	@Override
	public void navigateToUrl(String url) {
		// TODO Auto-generated method stub
		driver.get(url);		
	}
	@Override
	public void enterText(String locator, String value) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.id(locator)).sendKeys(value);	
	}
	@Override
	public void clickByxPath(String locator) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		driver.findElement(By.xpath(locator)).click();
	}
	public void Loginclick(String value)
	{	
		driver.findElement(By.id(value)).click();
	}
	@Override
	public String getText(String locator) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void waitForElement(String locator, int timeout) {
		// TODO Auto-generated method stub
		wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
	}
	@Override
	public void logout(String locator) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void dropdown(String locator,String text) {
		// TODO Auto-generated method stub
		WebElement dropdown = driver.findElement(By.id(locator));
		Select select = new Select(dropdown);
		select.selectByVisibleText(text);
	}
	@Override
	public void selectCheckbox(String locator) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		WebElement dateFiled = driver.findElement(By.id(locator));
		dateFiled.clear();
		dateFiled.sendKeys(date);	
	}
	@Override
	public void clickById(String locator) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.id(locator)).click();
	}
	@Override
	public void sleep() throws InterruptedException {
		// TODO Auto-generated method stub
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
}
