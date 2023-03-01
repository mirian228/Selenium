package headless;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class HeadLessFirefox {
	WebDriver driver;
	@SuppressWarnings("deprecation")
	@Test()
	public void HeadLessFirefoxTest() {
		System.setProperty("webdriver.firefox.marionette", "C:\\Dev\\Drivers\\firefox\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		// options.addArguments("--headless"); Works the same
		driver = new FirefoxDriver(options);
		driver.get("https://facebook.com");
		System.out.println(driver.getTitle());
	}
	
}
