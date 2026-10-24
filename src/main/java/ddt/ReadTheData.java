package ddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTheData {

	public static void main(String[] args) throws IOException {
		// Excel--->Workbook---->sheet--->Row--->Cell

		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\ReadData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rows = sheet.getLastRowNum();
		short totalCell = sheet.getRow(1).getLastCellNum();
		System.out.println("No of rows==>" + rows);
		System.out.println("No of cells==>" + totalCell);

// Read the data
		for (int r = 0; r <= rows; r++) {
			for (int c = 0; c < totalCell; c++) {
				XSSFRow currentRow = sheet.getRow(r);
				XSSFCell currentCell = currentRow.getCell(c);
				System.out.print(currentCell.toString());
				System.out.print(" ");
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}
}
