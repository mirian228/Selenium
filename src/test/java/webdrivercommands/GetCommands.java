package webdrivercommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GetCommands {
	WebDriver driver;

	@Test()
	public void getCommandsTest() {
		System.setProperty("webdriver.firefox.marionette", "C:\\Dev\\Drivers\\firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://facebook.com"); // Opens URL
		System.out.println(driver.getTitle()); // returns page title
		System.out.println(driver.getCurrentUrl()); // returns page current URL
		WebElement text = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[1]/h2"));
		System.out.println(text.getText()); // Returns text from page element
		driver.close(); // closes current browser window
		// driver.quit() closes all browser windows

	}

}
