package datadriventest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FixedDepositCalculatorTest {
	WebDriver driver;

	@Test()
	public void calculateTest() throws IOException {
		// Chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Dev\\Drivers\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();

		// Working with excel file
		FileInputStream excelDocument = new FileInputStream("C:\\Dev\\Excel\\FixedDepositCalculator.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(excelDocument);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int lastRowCount = sheet.getLastRowNum();
		int lastColumnCount = sheet.getRow(0).getLastCellNum();
		WebElement pushNotification = driver.findElement(By.xpath(".//*[@id='wzrk-confirm']"));
		pushNotification.click();

		for (int i = 1; i <= lastRowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			int principal = (int) row.getCell(0).getNumericCellValue();
			int rateOfInterest = (int) row.getCell(1).getNumericCellValue();
			int period = (int) row.getCell(2).getNumericCellValue();
			String frequency = row.getCell(3).getStringCellValue();
			int ExpMaturityValue = (int) row.getCell(4).getNumericCellValue();

			WebElement principalInput = driver.findElement(By.xpath(".//*[@id='principal']"));
			WebElement rateOfInterestInput = driver.findElement(By.xpath(".//*[@id='interest']"));
			WebElement periodInput = driver.findElement(By.xpath(".//*[@id='tenure']"));
			WebElement calculate = driver.findElement(By.xpath(".//*[@id='fdMatVal']/div[2]/a[1]/img"));

			// Select frequency in dropdown menu
			principalInput.sendKeys(String.valueOf(principal));
			rateOfInterestInput.sendKeys(String.valueOf(rateOfInterest));
			periodInput.sendKeys(String.valueOf(period));
			Select periodCombo = new Select(driver.findElement(By.id("tenurePeriod")));
			periodCombo.selectByVisibleText("year(s)");
			Select frequencySelect = new Select(driver.findElement(By.id("frequency")));
			frequencySelect.selectByVisibleText(frequency);
			calculate.click();

			String maturityValueResult = driver.findElement(By.xpath(".//*[@id='resp_matval']/strong")).getText();

			if ((Double.parseDouble(maturityValueResult)) == ExpMaturityValue) {
				System.out.println("Test Passed-" + "Actual Result: " + Double.parseDouble(maturityValueResult)
						+ " Expected result: " + ExpMaturityValue);
			} else {
				System.out.println("Test failed:" + "Actual Result: " + Double.parseDouble(maturityValueResult)
						+ " Expected result: " + ExpMaturityValue);
			}

			principalInput.clear();
			rateOfInterestInput.clear();
			periodInput.clear();

		}
		excelDocument.close();
		driver.close();
		driver.quit();

	}

}
