package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {
	public static String getdata(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("G:\\SOFTWARE TESTING\\Testdata.xlsx");
		String a = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return a;		
	}

}
