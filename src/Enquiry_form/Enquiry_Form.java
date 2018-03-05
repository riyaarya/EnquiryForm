package Enquiry_form;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(dataProvider= "Enquiry_form")

public class Enquiry_Form {
	
	public void Enquiry_a_form(String fname,String lname,String email,String number) {
		
		Config_Reader cr = new Config_Reader();
		
		System.setProperty("webdriver.gecko.driver", cr.passdriverpath());
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(cr.url());
		driver.findElement(By.name("firstname")).sendKeys(fname);
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("phone")).sendKeys(number);
		Select drop_down = new Select(driver.findElement(By.name("hs_persona")));
		drop_down.selectByValue("persona_1");
		Select dd = new Select(driver.findElement(By.name("at_what_stage_is_your_app_")));
		dd.selectByValue("I have an app, and need feature planning or want to re-invest.");
		driver.findElement(By.name("casl")).click();
		driver.findElement(By.className("hs-button")).click();
		
	}
	
	@DataProvider(name = "Enquiry_form")
	
	public Object[][]passData(){
     //row bina naklehi use kar rahi ho its hould bw use after you get row na 
		Config_Reader cr = new Config_Reader();
		Enquiry_Excel ee = new Enquiry_Excel(cr.excel_path());//jab name excel_path hai to why you are using getbefore that
		int row = ee.getrowCount();
		 Object[][] arr = new Object[row][4];//now see number of parameter you passing is 4 but you defined 3 here why
		for(int i =0; i<row; i++) {
			arr[i][0] = ee.getdata(0,i,0);
			arr[i][1] = ee.getdata(0,i,1);
			arr[i][2] = ee.getdata(0,i,2);
			arr[i][3] = ee.getdata(0,i,3);

			

		}
               return arr;
		
		
		
		
	}

}
