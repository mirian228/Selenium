package dropdowntest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class VerifyDropDownSortedOptions {
	WebDriver driver;

	@Test()
	public void testDropDown() {
		System.setProperty("webdriver.firefox.marionette", "C:\\Dev\\Drivers\\firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://testautomationpractice.blogspot.com");

		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.xpath("//*[@id='animals']"));
		Select se = new Select(element);

		List originalList = new ArrayList();
		
		List<WebElement> options = se.getOptions();
		List tempList = new ArrayList();
		for (int i = 0; i < options.size(); i++) {
			WebElement singleElement = options.get(i);
			originalList.add(singleElement.getText());
			tempList.add(singleElement.getText());
		}
		
		System.out.println("Before" + tempList);
		Collections.sort(tempList);
		System.out.println("After" + tempList);

		if(tempList == originalList) {
			System.out.println("Dropdown sorted");
		} else {
			System.out.println("Dropdown not sorted");
		}
		
		driver.quit();
	}

}
