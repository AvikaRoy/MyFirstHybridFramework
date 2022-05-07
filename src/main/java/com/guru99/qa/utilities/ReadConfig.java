package com.guru99.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	public static Properties prop;
	
	public ReadConfig() {
	try {
	File file=new File("./Configuration/config.properties");
	FileInputStream fis=new FileInputStream(file);
	prop=new Properties();
	prop.load(fis);
	}catch(Exception e) {
		System.out.println(e);
	}
	}
	public String getURL() {
		String url=prop.getProperty("baseURL");
		return url;
	}
	public String getUserName() {
		String userName=prop.getProperty("username");
		return userName;
		
	}
	public String getPassword() {
		String password=prop.getProperty("password");
		return password;
	}
	public String getChrome() {
		String chrome=prop.getProperty("chrome");
		return chrome;
	}
	public String getFirefox() {
		String firefox=prop.getProperty("Firefox");
		return firefox;
	}
	public String getIE() {
		String ie=prop.getProperty("IE");
		return ie;
	}

}
