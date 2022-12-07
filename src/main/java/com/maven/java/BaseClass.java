package com.maven.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;
	public static String prodName = null;

	public static void browserLaunch(String screen) throws Exception {

		driver = new ChromeDriver();
		webSites(screen);
		driver.manage().window().maximize();
	}

	public static void webSites(String screen) throws Exception {

		switch (screen) {
		case "GmailLogin":
			driver.get("https://www.gmail.com/");
			break;

		case "EbayHome":
			driver.get("https://www.ebay.com/");
			break;

		default:
			throw new Exception("No option present: " + screen);
		}
	}

}
