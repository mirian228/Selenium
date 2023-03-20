package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaLandingPage {

	WebDriver driver;
	
	
	By searchButton = By.xpath("//*[@data-jsl10n='search-input-button']");
	By searchInput = By.xpath("//*[@id='search-input']");

				
	WikipediaLandingPage(WebDriver d) {
		driver = d;
	}
	
	public void clickSearchButton() {
		driver.findElement(searchButton).click();
	}
	
	public void fillSearchInput(String input) {
		driver.findElement(searchInput).sendKeys(input);
	}
	

}
