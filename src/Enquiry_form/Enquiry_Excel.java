package Enquiry_form;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Enquiry_Excel {
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public Enquiry_Excel(String excel_path) {
		
		File src = new File(excel_path);
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);	
		} 
		
		catch (Exception e) 
		
		{
             System.out.println(e.getMessage());		

		
		}
	}
	
	public String getdata(int sheetnumber, int row, int column) {
		
		sheet1 = wb.getSheetAt(sheetnumber);
		DataFormatter df= new DataFormatter();
		String data = df.formatCellValue(sheet1.getRow(row).getCell(column));
		return data;
	}
	
	public int getrowCount() {
		int row = wb.getSheetAt(0).getLastRowNum();
		row = row+1;
		return row;
	}
}
