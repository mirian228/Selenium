package headless;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadLessChrome {

	WebDriver driver;
	
@SuppressWarnings("deprecation")
@Test()	
public void headLessChromeTest() {
	System.setProperty("webdriver.chrome.driver", "C:\\Dev\\Drivers\\chrome\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.setHeadless(true);
	// options.addArguments("--headless"); Works the same
	driver = new ChromeDriver(options);
	driver.get("https://facebook.com");
	System.out.println(driver.getTitle());
}
	
}
