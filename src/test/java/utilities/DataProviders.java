package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * DataProviders class to supply data for test cases using ExcelUtility. This
 * class fetches test data from an Excel file and provides it as a 2D array.
 */
public class DataProviders {

	/**
	 * DataProvider method to supply login data from an Excel file.
	 *
	 * @return A two-dimensional array containing the login data.
	 * @throws IOException If an I/O error occurs.
	 */
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		// Path to the Excel file containing the test data.
		String path = ".\\testData\\Pros_LoginData.xlsx"; // Replace with the actual file path.

		// Create an instance of ExcelUtility for the specified Excel file.
		ExcelUtility xlutil = new ExcelUtility(path);

		// Get the total number of rows and columns in the specified sheet.
		int totalRows = xlutil.getRowCount("Sheet1");
		int totalCols = xlutil.getCellCount("Sheet1", 1);

		// Create a 2D array to store the data read from the Excel sheet.
		String[][] loginData = new String[totalRows][totalCols];

		// Loop through all rows and columns to read data from the Excel sheet.
		for (int i = 1; i <= totalRows; i++) { // Start from 1 to skip the header row.
			for (int j = 0; j < totalCols; j++) {
				// Read data from the specified cell and store it in the 2D array.
				loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		  // Log all data
	    System.out.println("Login Data:");
	    for (int i = 0; i < loginData.length; i++) {
	        for (int j = 0; j < loginData[i].length; j++) {
	            System.out.print(loginData[i][j] + " ");
	        }
	        System.out.println();
	    }
		// Return the 2D array containing the login data.
		return loginData;
	}
}
