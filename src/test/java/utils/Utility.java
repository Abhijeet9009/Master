package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	public static String value;

	public static String getExcelldata(String sheet, int row, int cell)
			                                throws EncryptedDocumentException, IOException 
	{
		FileInputStream MOCK = new FileInputStream("C:\\Users\\Abhijeet"
	                                                 + "\\Desktop\\New folder\\MOCK.xlsm");
		Workbook w = WorkbookFactory.create(MOCK);
		try {
			value = w.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		     } 
		catch (IllegalStateException e)
		{
			double d = w.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
			value = Double.toString(d);
			return value;
		}
		return value;
	}
	
	public static void takeScreenshot (WebDriver driver,double testID) throws IOException 
	{
		String path ="D:\\\\New folder\\\\ajio1";
		String time =new SimpleDateFormat(" dd-MM-yyyy hh.mm.ss ").format(new Date());
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File (path+testID+time+" .jpeg");
		FileHandler.copy(source, dest);

	}
	
	
}
