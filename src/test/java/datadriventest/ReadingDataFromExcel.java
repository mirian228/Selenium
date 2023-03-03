package datadriventest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingDataFromExcel {

	@Test()
	public void readDataTest() throws FileNotFoundException {
		try {
			FileInputStream excel = new FileInputStream("C:\\Dev\\Excel\\data1.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(excel);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int rowcount = sheet.getLastRowNum();
			int columnNumber = sheet.getRow(0).getLastCellNum();

			for (int i = 0; i < rowcount; i++) 
				{
				XSSFRow everyRow = sheet.getRow(i);
				for (int j = 0; j < columnNumber; j++) {
					String everyCell = everyRow.getCell(j).toString();
					System.out.print(" " + everyCell + " ");
				}
				System.out.println();
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Can't find file");
		} catch (IOException e) {
			System.out.println("Java IO exception");
		}
	}

}
