package commonLibs;

public interface IBrowserActions {
	
	void openBrowser();
	void closeBrowser();
	void navigateToUrl(String url);
	void enterText(String locator,String value);
	void clickByxPath(String locator);
	void clickById(String locator);
	String getText(String locator);
	void waitForElement(String locator,int timeout);
	void logout(String locator);
	void dropdown(String locator,String text);
	void selectCheckbox(String locator);
	void selectDateByInput(String locator,String date);
	void sleep() throws InterruptedException;
	void selectRadioButtonById(String name, String id);
}
