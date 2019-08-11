package com.secure.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.secure.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase()  {
		
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\secure\\qa\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\geckodriver.exe");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

	public void waitForPageReady() {
		try {
			String sPageInteractiveStatus = "";
			for (int iPageStatusLoop = 0; iPageStatusLoop < 60; iPageStatusLoop++) {
				if (sPageInteractiveStatus.equalsIgnoreCase("complete")
						|| sPageInteractiveStatus.equalsIgnoreCase("interactive")) {
					Thread.sleep(500);
					break;
				} else {
					Thread.sleep(1000);
					sPageInteractiveStatus = String.valueOf(((JavascriptExecutor) driver)
							.executeScript("return document.readyState"));
				}
			}
		} catch (Exception e) {
			System.out.println("error while getting page interactive status; " + e);
		}
	}
}
