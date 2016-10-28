package com.server.reports.jasper.page;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.server.reports.jasper.page.JRSBase;

public class JRSTestSuite {
	
	String webpageURL;
	WebDriver driver;
	LoginPageObjects pageLogin;
	MainPageObjects page2Main;
	UsersPageObjects page3Users, page5Users;
	AddUserPageObjects page4Add;
	WebDriverWait wait;
	
	@BeforeTest
	void init(){
		  System.setProperty("webdriver.chrome.driver", 
				  "src/main/resources/chromedriver.exe");
		  try {
			  webpageURL = JRSBase.readExcelFile(1, 1);
		  } catch (IOException e) {
			  System.out.println(e);
		  }		  
	}
	
	
	
	@Test // The first test case
	// Expected result: Log Out link should appear after we log in
	// Actual result: Log Out link appears after we log in
	// Status: Pass
	public void LoginTestCase() {
	  
		initDriverGoURL();
		pageLogin = new LoginPageObjects(driver);
		loginAs("joeuser", "joeuser");
	  
		page2Main = new MainPageObjects(driver);
		waitFor(page2Main.lnkLogOut);
		assert(page2Main.lnkLogOut.isDisplayed());
	  
		driver.quit();
	}
	
	
  
	@Test // The second test case
	// Expected result: Whitenbergg surname appears on the page after we add the user
	// Actual result: Whitenbergg surname appears on the page after we add the user
	// Status: Pass
	public void SecondTestCase(){

		initDriverGoURL();
		pageLogin = new LoginPageObjects(driver);
		loginAs("jasperadmin", "jasperadmin");
	  
		// Waiting for "Log Out" link to be visible and
		// then clicking on "Manage -> Users"
		page2Main = new MainPageObjects(driver);
		waitFor(page2Main.lnkLogOut);
		page2Main.lnkManage.click();
		page2Main.lnkUsers.click();
		
		// Waiting for the button "Add User..." to appear and then
		// clicking on it
		page3Users = new UsersPageObjects(driver);
		waitFor(page3Users.btnAddUser);
		page3Users.btnAddUser.click();
		
		// Filling the form of the new User and then
		// clicking on "Add User" button
		page4Add = new AddUserPageObjects(driver);
		waitFor(page4Add.btnAddUser);
		page4Add.txtFullName.sendKeys("John Whitenbergg");
		page4Add.txtUserID.clear();
		String sID = JRSBase.generateRandomStr();
		page4Add.txtUserID.sendKeys(sID);
		page4Add.txtEmail.sendKeys(JRSBase.generateRandomEmail());
		
		String userPassword = JRSBase.generateRandomStr();
		page4Add.txtPassw.sendKeys(userPassword);
		page4Add.txtPasswConfirm.sendKeys(userPassword);
		page4Add.btnAddUser.click();
		
		// After we added the user, new WebElement dynamically appeared
		// on the page. This element couldn't be detected, so the workaround
		// is to refresh the page and to use the new instance of UsersPageObjects
		driver.navigate().refresh();
		page5Users = new UsersPageObjects(driver);
		waitFor(page5Users.lblWhitenberggUser);
		
		assert(driver.getPageSource().contains(sID));
		
		driver.quit();
	}
  
	// This method initializes ChromeDriver and opens URL
	private void initDriverGoURL(){
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(webpageURL);
	}
  
	// This method helps us to login at LoginPage
	private void loginAs(String login, String password){
		
		pageLogin.txtUserID.sendKeys(login);
		pageLogin.txtPassword.sendKeys(password);
		pageLogin.btnLogin.click();
	}
  
	// This method waits for a given web element 
	// as an indication of successful move to the next page
	private void waitFor(WebElement element){
		
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
