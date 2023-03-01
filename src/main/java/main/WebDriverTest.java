package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.marionette", "C:\\Dev\\Drivers\\firefox\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://newtours.demoaut.com");

		
		
	}

}
