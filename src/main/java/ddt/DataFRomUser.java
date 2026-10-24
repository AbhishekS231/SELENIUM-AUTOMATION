package ddt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataFRomUser {

	public static void main(String[] args) throws IOException {

		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\TestData\\FromUsers2.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		workbook.createSheet("DynamicData");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many rows you want to have");
		int noOfRows = sc.nextInt();
		System.out.println("Enter how many cell you want to have");
		int noOfCells = sc.nextInt();
		for (int r = 0; r <= noOfRows; r++) {
			XSSFRow currentRow = sheet.createRow(r);

			for (int c = 0; c < noOfCells; c++) {
				XSSFCell currentCell = currentRow.createCell(c);
				currentCell.setCellValue(sc.next());

			}
		}
		workbook.close();
		file.close();
		System.out.println("File is created");
	}

}
