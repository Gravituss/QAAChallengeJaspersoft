package com.server.reports.jasper.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class UsersPageObjects {
	
	public UsersPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="addNewUserBtn")
	public WebElement btnAddUser;
	
	@FindBy(xpath="//*[contains(text(), 'Whitenbergg')]")
	public WebElement lblWhitenberggUser;	
}