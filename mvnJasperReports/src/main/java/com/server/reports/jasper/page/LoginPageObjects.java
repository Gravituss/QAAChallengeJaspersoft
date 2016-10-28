package com.server.reports.jasper.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPageObjects {
	
	public LoginPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="j_username")
	public WebElement txtUserID;
	
	@FindBy(id="j_password_pseudo")
	public WebElement txtPassword;
	
	@FindBy(id="submitButton")
	public WebElement btnLogin;		
	
}
