package pageobjectmodelwikipedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutomationTestingSwitchToPage {
	WebDriver driver;
	
	By openNewTabbedWindows = By.xpath("//*[contains(text(), 'Open New Tabbed Windows')]");

	By clickButton = By.xpath("//*[contains(text(), 'click')]");
	
	
	public AutomationTestingSwitchToPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOpenNewTabbedWindows () {
		driver.findElement(openNewTabbedWindows).click();
	}

	public void clickClickButton () {
		driver.findElement(clickButton).click();
	}
	
}
