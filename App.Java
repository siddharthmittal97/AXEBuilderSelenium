package Learning.Automation;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.deque.axe.AXE;
import io.github.bonigarcia.wdm.WebDriverManager;
public class App 
{
	WebDriver driver;
	private static final URL scriptUrl = App.class.getResource("/axe.min.js");
	
    @Test
    public void amazonAillyTest()
    {
        WebDriver driver = WebDriverManager.chromedriver().create();
    	driver.get("https://amazon.com");
    	JSONObject responseJson = new AXE.Builder(driver, scriptUrl).analyze();
    	JSONArray violations = responseJson.getJSONArray("violations");
    	if(violations. length() == 0) 
    	{
    	System.out.println("no errors");
    	}
    	else 
    	{
    	AXE.writeResults("amazonAillyTest", responseJson);
    	Assert.assertTrue(false,AXE.report(violations));
    	}
    }
}
