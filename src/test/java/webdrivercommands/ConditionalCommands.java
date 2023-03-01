package webdrivercommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ConditionalCommands {
	WebDriver driver;

	@Test(priority=1)
	public void isDisplayedIsEnabledTest() {
		System.setProperty("webdriver.firefox.marionette", "C:\\Dev\\Drivers\\firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://facebook.com");

		WebElement loginInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		if (loginInput.isDisplayed() == true && loginInput.isEnabled() == true) {
			loginInput.sendKeys("Login is displayed");
		}
		if (passwordInput.isDisplayed() == true && passwordInput.isEnabled() == true) {
			passwordInput.sendKeys("Passwordisdisplayed");
		}

	}

	@Test(priority=2)
	public void isSelectedTest() {
		System.setProperty("webdriver.firefox.marionette", "C:\\Dev\\Drivers\\firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://automatenow.io/sandbox-automation-testing-practice-website/form-fields/");
		
		WebElement checkBoxWater = driver.findElement(By.xpath("//*[@id=\"contact-form-1103\"]/form/div/div[2]/div/label[1]"));
		WebElement radioButtonRed = driver.findElement(By.xpath("//*[@id=\"contact-form-1103\"]/form/div/div[3]/div/label[1]"));
		
		
		if(checkBoxWater.isSelected()==false) {
			checkBoxWater.click();
		} else {
			System.out.println("Checkbox for water is already selected");
		}
		
		if(radioButtonRed.isSelected()==false) {
			radioButtonRed.click();
		} else {
			System.out.println("Radio button red is already selected");
		}
		
 	}
	
	@AfterMethod
	public void teardown() {
		
	}

}
