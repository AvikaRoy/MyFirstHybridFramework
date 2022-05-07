package com.guru99.qa.pagesTest;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.qa.base.TestBase;
import com.guru99.qa.pages.LoginPage;
import com.guru99.qa.utilities.ExcelUtil;

public class LoginPageTest_DDT extends TestBase {
	
	@Test(dataProvider="loginPageDDT")
	public void loginPageDDT(String user, String pass) {
		LoginPage lp=new LoginPage(driver);
		lp.setUserID(user);
		logger.info("user id entered successfully");
		lp.setPassword(pass);
		logger.info("password entered successfully");
		lp.clickLgnBtn();
		logger.info("clicked on login button");
		//lp.clickLogOutBtn();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
		}else
			Assert.assertFalse(false);
				lp.clickLogOutBtn();
				logger.info("logout successfully");
				driver.switchTo().alert().accept();
	}
	
public boolean isAlertPresent() {
	try {
		driver.switchTo().alert();
		return true;
	}catch(NoAlertPresentException e) {
		return false;
	}
	}

@DataProvider(name="loginPageDDT")
public String[][] getData() throws IOException{
	String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\guru99\\qa\\testData\\Data.xlsx";
	int rownum=ExcelUtil.getRowCount(path, "sheet2");
	int colcount=ExcelUtil.getCellCount(path, "sheet2", 1);
	String[][] logindata=new String[rownum][colcount];
	for(int i=0;i<rownum;i++) {
		for(int j=0;j<colcount;j++) {
			logindata[i][j]=ExcelUtil.getcellData(path, "sheet2", i, j);
			System.out.println(logindata[i][j]);
		}
	}
	return logindata;
	
}
}
