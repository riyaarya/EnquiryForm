package Enquiry_form;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Config_Reader {
	Properties pro;

	public Config_Reader() {
		File src = new File("./Configuration/Config.property");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			pro.load(fis);
			
			
		} 
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
		public String passdriverpath() {
			
			String path = pro.getProperty("dpath");
			return path;			
		
	}
		
		public String url() {
			String url = pro.getProperty("url");
			return url;
		}
		
		public String excel_path() {
			String excel_path = pro.getProperty("excel_path");
			return excel_path;
		}
}
