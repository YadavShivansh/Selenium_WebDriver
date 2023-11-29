package com.utils;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driverSetup {

	private static Scanner sc;

	public static WebDriver getWebDriver() 
	{
		
		WebDriver driver = null;
		sc = new Scanner(System.in);
		System.out.print("Enter the browser type (chrome/firefox): ");
		String browserType = sc.next().toLowerCase();
		
		switch (browserType)
		{
         case "chrome":
         	WebDriverManager.chromedriver().setup();
         	driver = new ChromeDriver();
         	break;
             
         case "firefox":
         	WebDriverManager.firefoxdriver().setup();
         	driver = new FirefoxDriver();
         	break;
         default:
         	System.out.println("Invalid browser type: " + browserType);
		}
		
		
		String baseUrl = " https://www.google.com/";
		driver.get(baseUrl);
		 
		return driver;
		
		
		
		
				
	}

}
