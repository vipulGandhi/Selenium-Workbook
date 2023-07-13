// Read/ Write from/ to an excel file in Java
	// .xls – HSSF (Horrible SpreadSheet Format) Download “poi” jar files
    // .xlsx – XSSF (XML SpreadSheet Format) Download “poi-ooxml ” jar files
	// .xls & .xlsx Common spreadsheet (SS) usermodel. It can read/write excel with both extensions .xls and .xlsx

// Get 1st column as key, all other column as value

package SeleniumBasics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class S_68_ExcelOperations
{
	
	@Test(dataProvider = "getExcelData")
	public void employeeDetails(Map<Object, Object> map)
	{
		System.out.println("======================================");
		System.out.println();
		
		System.out.println("Firstname: " + map.get("FirstName"));
		System.out.println("LastName: " + map.get("LastName"));
		System.out.println("Company: " + map.get("Company"));
		System.out.println("Address: " + map.get("Address"));
		
		System.out.println();
		System.out.println("======================================");
		System.out.println();
	}
	
	@DataProvider
	public Object[][] getExcelData() throws IOException
	{
		String excelPathString = System.getProperty("user.dir") + "/LocalResourceFiles/ExcelSheets/EmployeeDetails_Hash.xlsx";
		
		FileInputStream fileInputStream = new FileInputStream(excelPathString);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		
		Object[][] objects = new Object[cellCount - 1][1];
		
		for (int j = 1; j < cellCount; j++)
		{
			
			Map<String, String> hashMapData = new HashMap<>();
			
			for (int i = 0; i < rowCount; i++)
			{
				String keyString = String.valueOf(sheet.getRow(i).getCell(0));
				String valueString = String.valueOf(sheet.getRow(i).getCell(j));
				hashMapData.put(keyString, valueString);
			}
			
			//System.out.println(hashMapData);
			
			objects[j-1][0] = hashMapData;
		}
		
		workbook.close();
		return objects;
	}
}
