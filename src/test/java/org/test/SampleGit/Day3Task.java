package org.test.SampleGit;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day3Task extends BaseClass {

	@BeforeClass
	public static void beforeClass() {
		browserLaunch("chrome");
	}
	@AfterClass
	public static void afterClass() {
    quit();
    }
		
	@BeforeTest
	public void before() {
    Date d=new Date();
    System.out.println("Start time is "+d);
	}
	@AfterTest
	public void After() {
	Date d=new Date();
	System.out.println("Start time is "+d);
	}
	
	@Test
	public void test1() {
    urlLaunch("https://www.flipkart.com/");
    FlipkartTask ft=new  FlipkartTask();
    WebElement fkcloseBtn = ft.getFkcloseBtn();
    click(fkcloseBtn);
    WebElement searchField = ft.getSearchField();
    sendKeys(searchField, "iphone 14"+Keys.ENTER);
    List<WebElement> name = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
  
    for(int i=0;i<name.size();i++) {
    	WebElement pdtname = name.get(i);
    	String text = pdtname.getText();
    	System.out.println(text);
    }
	}
	@Test
	public void test3() {
		
		urlLaunch("https://www.flipkart.com/");
	    FlipkartTask ft=new  FlipkartTask();
	    //WebElement fkcloseBtn = ft.getFkcloseBtn();
	    //click(fkcloseBtn);
	    WebElement searchField = ft.getSearchField();
	    sendKeys(searchField, "iphone 14"+Keys.ENTER);
         List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
	    
         for(int i=0;i<price.size();i++) {
	    	WebElement pdtprice = price.get(i);
	    	String text = pdtprice.getText();	
	    	if(text.contains("₹")) {
	    		text=text.replace("₹", "");
	    	if(text.contains(",")) {
	    		text=text.replace(",", "");
	    	System.out.println(text);
	    	}
	    	}
	    } 
	}

@Test
public void test5() {
		
		urlLaunch("https://www.flipkart.com/");
	    FlipkartTask ft=new  FlipkartTask();
	    //WebElement fkcloseBtn = ft.getFkcloseBtn();
	    //click(fkcloseBtn);
	    WebElement searchField = ft.getSearchField();
	    sendKeys(searchField, "iphone 14"+Keys.ENTER);
         List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
	        
	           List<Integer> ai= new LinkedList<>();
         for(int i=0;i<price.size();i++) {
	    	WebElement pdtprice = price.get(i);
	    	  String text = pdtprice.getText();
	    	if(text.contains("₹")) {
	    		text=text.replace("₹", "");
	    	if(text.contains(",")) {
	    		text=text.replace(",", "");
	            ai.add(Integer.parseInt(text));
	    	}
	    	}
         }
         
	            System.out.println("Ascending value..................");
	            
	            Collections.sort(ai);
	            System.out.println(ai);
	            
	            System.out.println("Descending value..................");

	 
	            Collections.reverse(ai);
	            System.out.println(ai);
	            
	            System.out.println("Max value..............." );
	            
	            System.out.println(Collections.max(ai));
	            System.out.println("Min value..............." );

	            
	            System.out.println(Collections.min(ai));
}
}
