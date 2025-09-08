package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import Utility.ScreenshotUtils;
import commonLibs.BaseTest;  // your base test where driver is managed

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
      if(driver!=null)
      {
    	  String testName = result.getMethod().getMethodName();
    	  ScreenshotUtils.takeScreenshot(testName);
    }}

	
}
