package SeleniumBasics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class S_69_ReadWriteExcel
{
    public static void main(String[] args) throws IOException
    {
    	// Get the path of the excel file
        String excelpath = System.getProperty("user.dir") + "/LocalResourceFiles/ExcelSheets/EmployeeDetails.xlsx";
        
        // [Java] Get the data (in byte format) from excel to FileInputStream object
        FileInputStream inputstream = new FileInputStream(excelpath);
        
        // [Apache POI] Get the excel workbook
        XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
        
        // Go to the particular sheet from the workbook
        XSSFSheet sheet = workbook.getSheet("Employee");
                
        // Get active rows count in the sheet
        int rows = sheet.getLastRowNum();

        // Get active column count in the sheet
        int cols= sheet.getRow(1).getLastCellNum();
        
        // For every row, for every cell, print the cell value
        for(int r=0; r<rows; r++)
        {   
            XSSFRow row=sheet.getRow(r);
            
            for(int c=0; c< cols; c++)
            {    
                XSSFCell cell=row.getCell(c);
                
                System.out.println(getCellValueAsString(cell));
                
            }
            System.out.println();
        }
        
        // Write the data
        for(int r=0; r<=rows; r++)
        {
        	sheet.getRow(r).createCell(cols).setCellValue("Present");
		}
        FileOutputStream fos = new FileOutputStream(excelpath);
        workbook.write(fos);

       // Once the operations on the workbook are done, close the workbook
       workbook.close();
        
    }
    
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
