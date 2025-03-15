package Assignment_EVe1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static String getData(String filePath, int row, int col) throws IOException  {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = new XSSFWorkbook(fis);
	    Iterable<Row> sheet =  workbook.getSheetAt(0);
		Row r =  ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(row);
		Cell cell = r.getCell(col);
		String data = cell.getStringCellValue();
		workbook.close();
		return data ;
		
	}
	

}
