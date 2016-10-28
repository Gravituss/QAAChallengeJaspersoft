package com.server.reports.jasper.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AddUserPageObjects {
	
	public AddUserPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="addUserFullName")
	public WebElement txtFullName;
	
	@FindBy(xpath="//*[@for='addUserID']/input")
	public WebElement txtUserID;	
	
	@FindBy(xpath="//*[@for='addUserEmail']/input")
	public WebElement txtEmail;	
	
	@FindBy(xpath="//*[@for='addUserPassword']/input")
	public WebElement txtPassw;		
	
	@FindBy(xpath="//*[@for='addUserConfirmPassword']/input")
	public WebElement txtPasswConfirm;		
	
	@FindBy(id="addUserBtn")
	public WebElement btnAddUser;	

}

