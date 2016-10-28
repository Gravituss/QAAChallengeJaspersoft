package com.server.reports.jasper.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class MainPageObjects {
	
	public MainPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="main_logOut_link")
	public WebElement lnkLogOut;
	
	@FindBy(xpath="//*[@id='main_manage']")
	public WebElement lnkManage;	
	
	@FindBy(xpath="//*[@class='content']//*[contains(text(), 'Users')]")
	public WebElement lnkUsers;
}