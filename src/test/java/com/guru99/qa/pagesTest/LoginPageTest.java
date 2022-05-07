package com.guru99.qa.pagesTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99.qa.base.TestBase;
import com.guru99.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	@Test(priority=-1)
	public void TC_001() {
		if(driver.getTitle().equals("Guru99 Bank Home Page")) {
			Assert.assertTrue(true);
			logger.info("Test case loginTest_001 is passed");
		}else
		{
			captureScreen(driver,"TC_001");	
			Assert.assertFalse(false);
			logger.info("Test case loginTest_001 is failed");
			
		}
	}
	
	


	@Test(priority=1)
	public void TC_002() {
		LoginPage lp=new LoginPage(driver);
		lp.setUserID(username);
		logger.info("user name entered");
		lp.setPassword(password);
		logger.info("password entered");
		lp.clickLgnBtn();
		logger.info("clicked on login button");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Test case loginTest_002 is passed");
		}else
		{
			captureScreen(driver, "TC_002");	
			Assert.assertFalse(false);
			logger.info("Test case loginTest_002 is failed");
			
		}
	}
	}

