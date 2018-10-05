package XlsXlsXHelpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;;

public class XlsXlsxHelper {
	
	public Object[][] ReadFromExcel(String FileType, String SheetName) throws IOException
	{
		Object[][] _data = null;
		Workbook _workbook = null;
		try {
		File _file = new File(System.getProperty("user.dir")+ "\\src\\main\\resources\\Suite.xlsx");
		
		FileInputStream _stream = null;
		
			_stream = new FileInputStream(_file);
		
		if(FileType.equalsIgnoreCase(".XlsX"))
		{
				_workbook = new XSSFWorkbook(_stream);
		}
		else {
				_workbook = new HSSFWorkbook(_stream) ;
		}
		Sheet _sheet = _workbook.getSheet(SheetName);
		
		 int rcount = _sheet.getLastRowNum();
		 int ccount = _sheet.getRow(0).getLastCellNum();
		 _data = new Object[rcount][ccount];
		 for(int i=0; i<=rcount-1; i++)
		 {
			 for(int j =0; j<=ccount-1;j++)
			 {
				 _data[i][j]=_sheet.getRow(i).getCell(j).getStringCellValue();
				 
			 }
			
		 }
		}
		catch (Exception ex) {_workbook.close();}
		finally {_workbook.close();}
		return _data;
	}
}
		
		
		
		
	

