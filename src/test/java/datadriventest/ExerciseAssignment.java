package datadriventest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExerciseAssignment {
	@Test()
	public void readExcelDataTest() {
		try {
			FileInputStream excelFile = new FileInputStream("C:\\Dev\\Excel\\data2.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int lastRowCount = sheet.getLastRowNum();
			int lastColumnCount = sheet.getRow(0).getLastCellNum();
			
			for(int i=0; i<lastRowCount; i++) {
				XSSFRow row = sheet.getRow(i);
				for(int j=0; j<lastColumnCount; j++) {
					String info = row.getCell(j).toString();
					System.out.print(" " + info + " ");
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception");
		} catch (IOException e) {
			System.out.println("Io Exception occured");
		}
		
	}
}
