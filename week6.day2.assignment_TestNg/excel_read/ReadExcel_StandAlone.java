package week6.day2.assignment.dataprovider.xlsx;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author vignesh
 *
 */
public class ReadExcel_StandAlone
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		//Step1: Setup the path for the workbook
		XSSFWorkbook wb = new XSSFWorkbook("./data/dataBook.xlsx");
		
		//Step2: Get into the respective sheet
		XSSFSheet ws = wb.getSheet("Sheet1");
		//wb.getSheetAt(index=0);
		String stringCellValue;
		System.out.println("=====irst Column For the first 2 rows ========");
		/* First Column For the first 2 rows */
		for (int i =1; i<=2; i++) {
			stringCellValue = ws.getRow(i).getCell(0).getStringCellValue();
			System.out.println(stringCellValue);
		}
		
		
		
		System.out.println("=====First Column for the existing rows========");
		//To get number of row (Excludes Header)
		/* First Column for the existing rows */
		
		int rowCount_withoutHeader = ws.getLastRowNum();
		int rowCount_withHeader = ws.getPhysicalNumberOfRows(); //including Header

		for (int i =1; i<=(rowCount_withHeader - 1); i++) {
			 stringCellValue = ws.getRow(i).getCell(0).getStringCellValue();
			 System.out.println(stringCellValue);
		}
		System.out.println("==========================================");
		// To get no of cells
		int cellCount = ws.getRow(0).getLastCellNum();
		System.out.println();
		System.out.println("CellCount: " + cellCount);
		System.out.println("rowCount_withHeader: " + rowCount_withHeader);
		System.out.println("rowCount_withoutHeader: " + rowCount_withoutHeader);
		System.out.println("");
		
		for (int i =1; i<=rowCount_withoutHeader; i++)
		{
			for (int j=0;  j<cellCount; j++)
			{
				String data = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data + " ");
			}
			System.out.println("");
		}
		
		System.out.println("==========================================");
		String[][] data = new String[rowCount_withoutHeader][cellCount];
		
		for (int i = 1; i<=rowCount_withoutHeader; i++)
		{
			for (int j=0;  j<cellCount; j++)
			{
				data[i-1][j] = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data[i-1][j] + " ");
			}
			System.out.println("");
		}
		
		//Step6: Close the workbook
		wb.close();
	}

}

