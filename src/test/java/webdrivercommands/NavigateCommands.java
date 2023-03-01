package webdrivercommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NavigateCommands {
	WebDriver driver;
	@Test()
	public void navigateCommands() throws InterruptedException {
		System.setProperty("webdriver.firefox.marionette", "C:\\Dev\\Drivers\\firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://facebook.com"); 
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.navigate().to("https://booking.com"); // Goes from the get page to the page that we specify 
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.navigate().back(); // gets back to the previous page
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.navigate().forward(); // get back to the forward page
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	
}
