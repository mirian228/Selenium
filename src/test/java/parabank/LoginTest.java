package parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	@Test(priority=1)
	public void TestDriver() {
		System.setProperty("webdriver.firefox.marionette", "C:\\\\Dev\\\\Drivers\\\\firefox\\\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	}
	
	@Test(priority=2)
	public void TestLogin() throws InterruptedException {
	
	WebElement username = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[1]/input"));
	WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[2]/input"));
	WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input"));
	
	username.sendKeys("mirian2288");
	password.sendKeys("mirian2288");
	loginButton.click();
	Assert.assertEquals(driver.getTitle(), "ParaBank | Accounts Overview");
	
	
	
	
}
}
