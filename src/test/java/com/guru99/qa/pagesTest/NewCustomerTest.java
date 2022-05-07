package com.guru99.qa.pagesTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99.qa.base.TestBase;
import com.guru99.qa.pages.LoginPage;
import com.guru99.qa.pages.NewCustomerPage;

public class NewCustomerTest extends TestBase{
	@Test
	public void TC_004() {
		if(driver.getTitle().equals("Guru99 Bank Home Page")) {
			Assert.assertEquals(driver.getTitle(), "Guru99 Bank Home Page");
			logger.info("Test case loginTest_004 is passed");
		}else
		{
			captureScreen(driver,"TC_004");	
			Assert.assertFalse(false);
			logger.info("Test case loginTest_004 is failed");
			
		}
	}
	

	@Test
	public void TC_003() {
		LoginPage lp=new LoginPage(driver);
		lp.setUserID(username);
		logger.info("user name entered");
		lp.setPassword(password);
		logger.info("password entered");
		lp.clickLgnBtn();
		logger.info("clicked on login button");
		
		
		NewCustomerPage ncp=new NewCustomerPage(driver);
		ncp.ClickNewCustomer();
		ncp.setname("Avika Roy");
		ncp.clickGender();
		ncp.custdob("05","05","1997");
		ncp.setaddress("Hinjewadi");
		ncp.setcity("Pune");
		ncp.setstate("Maharshtra");
		ncp.setpin("444104");
		ncp.setmobile("7028287520");
		ncp.setemail("avikaroy@gmail.com");
		ncp.setpass("Avika@123");
		ncp.clickSubmit();
		
		
	    boolean successMsg=driver.getPageSource().contains("Customer Registered Successfully!!!");
	    if(successMsg==true) {
	    	Assert.assertTrue(true);
	    	logger.info("Test Is Passed...");
	    }else
	    {
	    	logger.info("Test is failed..");
	    	captureScreen(driver, "TC_003");
	    	Assert.assertFalse(false);
	    }
	}

}
