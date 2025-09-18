package pages;
import java.sql.ResultSet;
import org.testng.Assert;
import commonLibs.BaseTest;
import commonLibs.DatabaseUtils;

public class AppointmentPage extends BaseTest{

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
