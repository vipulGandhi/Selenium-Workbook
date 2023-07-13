package SeleniumBasics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class S_70_ReadWriteExcelHashMap
{
	public static void main(String[] args) throws IOException
	{
		// Get the path of the excel file
		String excelPath = System.getProperty("user.dir")  + "/LocalResourceFiles/ExcelSheets/EmployeeDetails_Hash.xlsx";
		
		// [Java] Get the data (in byte format) from excel to FileInputStream object
		FileInputStream fileInputStream = new FileInputStream(excelPath);
		
		// [Apache POI] Get the excel workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		
		// Go to the particular sheet from the workbook
		XSSFSheet xssfSheet = workbook.getSheet("Employee");
		
		// Get active rows count in the sheet
		int rowCount = xssfSheet.getLastRowNum();
		
		// Get active column count in the sheet
		int columnCount = xssfSheet.getRow(0).getLastCellNum();
		
		// Create a list of hash map
		List<Map<String, String>> hashMapList = new ArrayList<>();
		
		// Skipping first column as it is field names
		for (int i = 1; i < columnCount; i++)
		{
			// For every column, create a hash map <field name, field value> 
			Map<String, String> hashMap = new HashMap<>();
			
			// Now we need to iterate all rows but cell should increases once all row is done
			// i.e. (1,1),(2,1),(3,1),(4,1),(5,1) - First iteration
			//      (1,2),(2,2),(3,2),(4,2),(5,2) - Second iteration
			//      (1,3),(2,3),(3,3),(4,3),(5,3) - Third iteration
			for (int j = 1; j < rowCount; j++)
			{
				// get the field name as key. Field name is constant as 0th index
				XSSFCell hashMapKey = xssfSheet.getRow(j).getCell(0);
				String hashMapKeyString = getCellValueAsString(hashMapKey);
				
				// get the field value as it's vlue
				XSSFCell hashMapValue = xssfSheet.getRow(j).getCell(i);
				String hashMapValueString = getCellValueAsString(hashMapValue);
										
				hashMap.put(hashMapKeyString, hashMapValueString);
			}
			
			// Add map to list after each iteration
			hashMapList.add(hashMap);
			System.out.println();
			
//			hashMap.entrySet().forEach(entry -> {
//			    System.out.println(entry.getKey() + " " + entry.getValue());
//			});
		}
		
		for (int k = 0; k < hashMapList.size(); k++)
		{
			System.out.println(hashMapList.get(k));
		}
		
		// Once the operations on the workbook are done, close the workbook
		workbook.close();
	}
	
	
	//
    public static String getCellValueAsString(XSSFCell cell)
    {
        String cellValue = null;
        
        switch (cell.getCellType())
        {
            case NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
                
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
                
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
                
            case FORMULA:
               cellValue= cell.getCellFormula();
            case BLANK:
            	
                cellValue="BLANK";
            default:
            	
                cellValue ="DEFAULT";
        }
        return cellValue;
    }

}
