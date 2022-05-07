package com.guru99.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public static WebDriver driver;
      public LoginPage(WebDriver driver) {
    	  this.driver=driver;
    	  PageFactory.initElements(driver,this);
      }
      
      @FindBy(xpath="//input[@name='uid']")
      WebElement userId;
      @FindBy(xpath="//input[@name='password']")
      WebElement pass;
      @FindBy(xpath="//input[@name='btnLogin']")
      WebElement loginbtn;
      @FindBy(xpath="//a[text()='Log out']")
      WebElement logout;
      
      public void setUserID(String username) {
    	  userId.sendKeys(username);  
      }
      public void setPassword(String password) {
    	  pass.sendKeys(password);  
      }
      public void clickLgnBtn() {
    	  loginbtn.click();  
      }
      public void clickLogOutBtn() {
    	  logout.click();  
      }
}
