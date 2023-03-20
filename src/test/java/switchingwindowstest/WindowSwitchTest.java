package switchingwindowstest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WindowSwitchTest {

	WebDriver driver;

	@Test()
	public void testWindow() {
		System.setProperty("webdriver.firefox.marionette", "C:\\Dev\\Drivers\\firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.automationtesting.in/Windows.html");

		driver.findElement(By.xpath("//*[contains(text(), 'Open New Tabbed Windows')]")).click();
		driver.findElement(By.xpath("//*[contains(text(), 'click')]")).click();
		

		Set<String> idWebsite = driver.getWindowHandles();
		
		List<String> ids = new ArrayList<String>();
	
		for (String i : idWebsite) {
			ids.add(i);
		}
		
		driver.switchTo().window(ids.get(1));
		driver.close();
		driver.switchTo().window(ids.get(0));
		driver.navigate().refresh();

	}
}
