package headless;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class HtmlUnitHeadless {
	@Test()
	public void HtmlUnitHeadlessTest() {
		HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.get("https://facebook.com");
		System.out.println(driver.getTitle());
			
	}
	
	
	
}
