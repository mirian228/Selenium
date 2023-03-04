package datadriventest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class RegistrationFormTest {
	WebDriver driver;
	
	@Test()
	public void readExcelData() throws IOException {
		FileInputStream excelFile = new FileInputStream("C:\\Dev\\Excel\\data2.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int lastRowCount = sheet.getLastRowNum();
		int lastColumnCount = sheet.getRow(0).getLastCellNum();
		System.setProperty("webdriver.chrome.driver", "C:\\Dev\\Drivers\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		
		
		// Identifying all elements
		WebElement firstNameInput = driver.findElement(By.id("firstName"));
		WebElement lastNameInput = driver.findElement(By.id("lastName"));
		WebElement userEmailInput = driver.findElement(By.xpath(".//*[@id='userEmail']"));
		WebElement userPhoneInput = driver.findElement(By.xpath((".//*[@id='userNumber']")));
		WebElement adressInput = driver.findElement(By.xpath((".//*[@id='currentAddress']")));
		ArrayList<WebElement> gender = new ArrayList<WebElement>();
		gender.add(driver.findElement(By.xpath(".//*[contains(text(), 'Male')]")));
		gender.add(driver.findElement(By.xpath(".//*[contains(text(), 'Female')]")));
		gender.add(driver.findElement(By.xpath(".//*[contains(text(), 'Other')]")));
		ArrayList<WebElement> hobbies = new ArrayList<WebElement>();
		hobbies.add(driver.findElement(By.xpath(".//*[contains(text(), 'Sports')]")));
		hobbies.add(driver.findElement(By.xpath(".//*[contains(text(), 'Reading')]")));
		hobbies.add(driver.findElement(By.xpath(".//*[contains(text(), 'Music')]")));
		WebElement country = driver.findElement(By.xpath(".//*[contains(text(), 'Select State')]"));
		WebElement submitButton = driver.findElement(By.xpath(".//*[@id='submit']"));
		
		for(int i=1; i<=lastRowCount; i++ ) {
		
			//getting excel information
			XSSFRow current_row = sheet.getRow(i);
			String FirstName = current_row.getCell(0).getStringCellValue();
			String LastName = current_row.getCell(1).getStringCellValue();
			String email = current_row.getCell(3).getStringCellValue();
			Double phone = current_row.getCell(2).getNumericCellValue();
			String adress = current_row.getCell(4).getStringCellValue();
			String city = current_row.getCell(5).getStringCellValue();
			
			// Entering all information on website
			firstNameInput.sendKeys(FirstName);
			lastNameInput.sendKeys(LastName);
			userEmailInput.sendKeys(email);
			userPhoneInput.sendKeys(phone.toString());
			adressInput.sendKeys(adress);

			
			for(int k=0; k<gender.size(); k++) {
				gender.get(k).click();
			}
			for(int l=0; l<hobbies.size(); l++) {
				hobbies.get(l).click();
			}
			
			submitButton.click();
		
		}
		
		
		
		excelFile.close();
		
		
		
		
	
		
		
		
	}
}
