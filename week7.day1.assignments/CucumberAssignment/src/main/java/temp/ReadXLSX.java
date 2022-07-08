/**
 * 
 */
package temp;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author vignesh
 *
 */
public class ReadXLSX extends BaseClass
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static String[][] readData(String filename) throws IOException
	{
		//Step1: Setup the path for the workbook
		XSSFWorkbook wb = new XSSFWorkbook("./data/" + filename + ".xlsx");

		//Step2: Get into the respective sheet
		XSSFSheet ws = wb.getSheet("Sheet1");

		int rowCount = ws.getLastRowNum();
		int cellCount = ws.getRow(0).getLastCellNum();
		System.out.println(cellCount);

		String[][] data =  new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++)
		{
			for (int j = 0;  j < cellCount; j++)
			{
				data[i-1][j] = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data + " ");
			}
			System.out.println("");
		}
		
		wb.close();
		
		return data;
	}

}
