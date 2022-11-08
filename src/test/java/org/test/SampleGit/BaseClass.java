package org.test.SampleGit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
	
	
	public static WebDriver browserLaunch(String bname) {
       if(bname.equalsIgnoreCase("chrome")) {
    	   WebDriverManager.chromedriver().setup();
    	   driver=new ChromeDriver();
       }
       else if(bname.equalsIgnoreCase("firefox")) {
    	   WebDriverManager.firefoxdriver().setup();
    	   driver=new FirefoxDriver();
       }
       else if(bname.equalsIgnoreCase("edge")) {
    	   WebDriverManager.edgedriver().setup();
    	   driver=new EdgeDriver();
       }
	return driver;
   	}
	
	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void sendKeys(WebElement e, String a) {
		e.sendKeys(a);
	}
	public static void click(WebElement e) {
		e.click();
	}
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	public static void quit() {
		driver.quit();
	}
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}
	public static String getAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}
	public static void moveToElement(WebElement target) {
		Actions a=new Actions(driver);
		a.moveToElement(target).perform();
	}
    public static void dragAndDrop(WebElement src, WebElement tar) {
       Actions a=new Actions(driver);
       a.dragAndDrop(src, tar).perform();
	}
    public static void selectByIndex(WebElement e,int a) {
    	Select s=new Select(e);
    	s.selectByIndex(a);
	}
   public static void selectByValue(WebElement e,String a) {
	  Select s=new Select(e);
	  s.selectByValue(a);
} 
   public static void selectByVisibleText(WebElement e,String a) {
      Select s=new Select(e);
      s.selectByVisibleText(a);
}
   
   public static String readExcel(String fileurl, String sheet, int row, int Cell) throws IOException {
			
			File f=new File(fileurl);
			
			FileInputStream st=new FileInputStream(f);
			
			Workbook wb=new XSSFWorkbook(st);
			
			Sheet s=wb.getSheet(sheet);
					
		    Row r=s.getRow(row);
		    
		    Cell c=r.getCell(Cell);
		    
		    System.out.println(c);
		    
		    int cellType = c.getCellType();
		    		    
		    String value=null;
		    		    
		    if(cellType==1) {
		    	 value = c.getStringCellValue();}		    
		    else {
		    	if(DateUtil.isCellDateFormatted(c)) {
					Date dateCellValue = c.getDateCellValue();
		    		SimpleDateFormat sd=new SimpleDateFormat("dd-mm-yyyy");
	                 value = sd.format(dateCellValue);
				}
		    	
		    	else {double numericCellValue = c.getNumericCellValue();
		    	long l=(long)numericCellValue;
		    	 value = String.valueOf(l);		    	
		    	}
		    	
		    }
			return value;
		    
   }	    }
   
