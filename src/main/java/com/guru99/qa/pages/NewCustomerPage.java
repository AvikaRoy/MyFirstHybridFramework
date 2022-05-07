package com.guru99.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	public static WebDriver driver;
	public  NewCustomerPage(WebDriver driver){
	this.driver=driver;
  	 PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement addNewCustomer;
	@FindBy(xpath="//input[@name='name']")
	WebElement name;
	@FindBy(xpath="//input[@name='rad1']")
	WebElement Gender;
	@FindBy(xpath="//input[@name='dob']")
	WebElement DateofBirth;
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement Address;
	@FindBy(xpath="//input[@name='city']")
	WebElement City;
	@FindBy(xpath="//input[@name='state']")
	WebElement State;
	@FindBy(xpath="//input[@name='pinno']")
	WebElement Pincode;
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement MobileNumber;
	@FindBy(xpath="//input[@name='emailid']")
	WebElement EmailId;
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	@FindBy(xpath="//input[@name='sub']")
	WebElement Submit;
	
	 public void ClickNewCustomer() {
		 addNewCustomer.click();
	 }
     public void setname(String Name) {
			name.sendKeys(Name);
		 }
     public void clickGender() {
    	 Gender.click();
		 }
     public void custdob(String mm,String dd,String yy) {
    	 DateofBirth.sendKeys (mm);
    	 DateofBirth.sendKeys(dd);
    	 DateofBirth.sendKeys (yy);
 	}
     public void setaddress(String address) {
    	 Address.sendKeys(address);
		 }
     public void setcity(String dist) {
    	 City.sendKeys(dist);
		 }
     public void setstate(String state) {
    	 State.sendKeys(state);
		 }
     public void setpin(String pincode) {
    	 Pincode.sendKeys(pincode);
		 }
     public void setmobile(String number) {
    	 MobileNumber.sendKeys(number);
		 }
     public void setemail(String ID) {
    	 EmailId.sendKeys(ID);
		 }
     public void setpass(String password) {
    	 Password.sendKeys(password);
		 }
     public void clickSubmit() {
    	 Submit.click();
		 }

     
     
	
	
	
	
}
		
	


