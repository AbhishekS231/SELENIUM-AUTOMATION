package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Utility class to interact with Excel files for data-driven testing. It
 * provides methods to read/write data, get row and cell counts, etc.
 */
public class ExcelUtility {

	private FileInputStream fi;
	private FileOutputStream fo;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	private CellStyle style;
	private String path;

	// Constructor to initialize the file path
	public ExcelUtility(String path) {
		this.path = path;
	}

	/**
	 * Get the total number of rows in the specified sheet.
	 * 
	 * @param sheetName The name of the Excel sheet.
	 * @return The number of rows in the sheet.
	 * @throws IOException If an I/O error occurs.
	 */
	public int getRowCount(String sheetName) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum(); // Get the last row number (0-based index).
		workbook.close();
		fi.close();
		return rowCount;
	}

	/**
	 * Get the total number of cells in a specific row of the sheet.
	 * 
	 * @param sheetName The name of the Excel sheet.
	 * @param rowNum    The row number (0-based index).
	 * @return The number of cells in the row.
	 * @throws IOException If an I/O error occurs.
	 */
	public int getCellCount(String sheetName, int rowNum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum(); // Get the total number of cells in the row.
		workbook.close();
		fi.close();
		return cellCount;
	}

	/**
	 * Get the data from a specific cell in the sheet.
	 * 
	 * @param sheetName The name of the Excel sheet.
	 * @param rowNum    The row number (0-based index).
	 * @param colNum    The column number (0-based index).
	 * @return The cell data as a string.
	 * @throws IOException If an I/O error occurs.
	 */
	public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		DataFormatter formatter = new DataFormatter(); // Format cell data as string.
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = ""; // Return empty string if the cell is null or has an error.
		}
		workbook.close();
		fi.close();
		return data;
	}

	/**
	 * Write data to a specific cell in the sheet.
	 * 
	 * @param sheetName The name of the Excel sheet.
	 * @param rowNum    The row number (0-based index).
	 * @param colNum    The column number (0-based index).
	 * @param data      The data to write into the cell.
	 * @throws IOException If an I/O error occurs.
	 */
	public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
		File xlFile = new File(path);

		// Create a new file if it doesn't exist.
		if (!xlFile.exists()) {
			workbook = new XSSFWorkbook();
			fo = new FileOutputStream(path);
			workbook.write(fo);
			workbook.close();
		}

		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);

		// Create the sheet if it doesn't exist.
		if (workbook.getSheetIndex(sheetName) == -1) {
			workbook.createSheet(sheetName);
		}

		sheet = workbook.getSheet(sheetName);

		// Create the row if it doesn't exist.
		if (sheet.getRow(rowNum) == null) {
			sheet.createRow(rowNum);
		}

		row = sheet.getRow(rowNum);

		// Create the cell if it doesn't exist.
		cell = row.createCell(colNum);

		cell.setCellValue(data); // Set the cell value.

		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
}
