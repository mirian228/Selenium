package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.marionette", "C:\\\\Dev\\\\Drivers\\\\firefox\\\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		WebElement username = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[1]/input"));
		WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[2]/input"));
		WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input"));
		
		username.sendKeys("mirian2288");
		password.sendKeys("mirian2288");
		loginButton.click();
		
		String expectedTitle= "ParaBank | Accounts Overview";
		String actualTitle = driver.getTitle(); 
		
		if(expectedTitle.equals(actualTitle)==true) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test failed");
		}
		
		driver.close();
	}

}
