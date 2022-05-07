package com.guru99.qa.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.guru99.qa.utilities.ReadConfig;

public class TestBase {
	public static WebDriver driver;
	
	ReadConfig readConfig=new ReadConfig();
	
	public String baseURL =readConfig.getURL();
	public String username =readConfig.getUserName();
	public String password =readConfig.getPassword();
	public static Logger logger;
	
	@Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {
    	if(browser.equals("chrome")) {
    	System.setProperty("webdriver.chrome.driver",readConfig.getChrome());
    	driver=new ChromeDriver();
    	logger=Logger.getLogger("guru99");
    	PropertyConfigurator.configure("Log4j.properties");
    	}
    	else if(browser.equals("Firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver", readConfig.getFirefox());
    		driver=new FirefoxDriver();
    		logger=Logger.getLogger("guru99");
        	PropertyConfigurator.configure("Log4j.properties");
    	}
    	else if(browser.equals("IE"))
    	{
    		System.setProperty("webdriver.ie.driver", readConfig.getIE());
    		driver=new InternetExplorerDriver();
    		logger=Logger.getLogger("guru99");
        	PropertyConfigurator.configure("Log4j.properties");
    	}
    	driver.manage().window().maximize();
    	//driver.manage().deleteAllCookies();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get(baseURL);
		logger.info("Application login successfully");
    }
    
    @AfterClass
    public void tearDown() {
    	driver.quit();
    	
    }
    
    public void captureScreen(WebDriver driver,String testname) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+testname+".png");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot taken");
		logger.info("Screenshot has taken");
		
	}


   
}
