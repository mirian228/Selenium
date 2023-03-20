package pageobjectmodelwikipedia;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaLoginPage {
	WebDriver driver;
	
	
	By usernameInput = By.xpath("//*[@id='wpName1']");
	By passwordInput = By.xpath("//*[@id='wpPassword1']");
	By keepLoggedInCheckBox = By.xpath("//*[@id='wpRemember']");
	By loginButton = By.xpath("//*[@id='wpLoginAttempt']");

	WikipediaLoginPage(WebDriver d) {
		driver = d;
	}
	
	public void setUsername(Properties file, String key) {
		driver.findElement(usernameInput).sendKeys(file.get(key).toString());
	}
	
	public void setPassword(Properties file, String key) {
		driver.findElement(passwordInput).sendKeys(file.get(key).toString());
	}
	
	public void clickKeepLoggedInCheckBox() {
		driver.findElement(keepLoggedInCheckBox).click();
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
}
