package org.test.SampleGit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class FlipkartTask extends BaseClass{

	public FlipkartTask() {
      PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchField;

	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement fkcloseBtn;
	
	@FindBy(xpath="//div[@class='_4rR01T']")
	private WebElement name;
	
	@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
	private WebElement price;

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getFkcloseBtn() {
		return fkcloseBtn;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getPrice() {
		return price;
	}
	
	}
	
