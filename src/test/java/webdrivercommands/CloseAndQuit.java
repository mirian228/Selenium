package webdrivercommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CloseAndQuit {
	WebDriver driver;
	
	@Test(priority=1, enabled = false)  // In this case we use driver.close() and the additional popup window won't close because driver.close() closes only current window
	public void closeTest() {
		System.setProperty("webdriver.firefox.marionette", "C:\\Dev\\Drivers\\firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.webroot.com/services/popuptester1.htm");
		driver.close();
		
		
	}
	@Test(priority=2)  // In this case we use driver.quit() and the additional popup window will be closed because driver.quit() closes all windows
	public void quitTest() {
		System.setProperty("webdriver.firefox.marionette", "C:\\Dev\\Drivers\\firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.webroot.com/services/popuptester1.htm");
		driver.quit();
		
		
	}
}
