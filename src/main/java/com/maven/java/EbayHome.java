package com.maven.java;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class EbayHome extends BaseClass {

	private static By text = By.xpath("//input[@placeholder='Search for anything']");
	private static By searchbtn = By.xpath("//input[@value='Search']");
	private static By products = By.xpath("//option[text()='Electric Guitars']");
	private static By producttxt = By.xpath("((//div[@class='s-item__info clearfix'])[2]//span[1])[1]");
	private static By productdetail = By.xpath("//h1[@class='x-item-title__mainTitle']//span");
	private static By productprice = By.xpath("//span[@itemprop='price']//span");

	public void enterText(String value, String field) throws Exception {

		switch (field) {
		case "SearchBox":
			Thread.sleep(3000);
			driver.findElement(text).sendKeys(value);
			break;

		default:
			throw new Exception("No option present: " + field);
		}
	}

	public void clickButton(String button) throws Exception {

		switch (button) {
		case "Search":
			Thread.sleep(3000);
			driver.findElement(searchbtn).click();
			break;

		case "FirstResult":
			Thread.sleep(3000);
			WebElement prod = driver.findElement(producttxt);
			prodName = prod.getText();
			System.out.println("First Electric Guitar Model name displayed: " + prodName);
			prod.click();
			break;

		default:
			throw new Exception("No option present: " + button);
		}
	}

	public void verify(String value) throws Exception {

		switch (value) {
		case "Electric Guitar":
			Thread.sleep(3000);
			WebElement prod = driver.findElement(products);
			boolean act = prod.isDisplayed();
			Assert.assertTrue(act, value + " is not displayed");
			System.out.println("List of " + prod.getText() + " were displayed");
			break;

		case "Guitar Details with Price":
			Thread.sleep(5000);
			switchTab();
			String actProdName = driver.findElement(productdetail).getText();
			System.out.println("\nActual Model name: " + actProdName);
			System.out.println("Expected Model name: " + prodName);
			Assert.assertTrue(prodName.contains(actProdName), "Actual and Expected were not matching");
			System.out.println("\nPrice of " + actProdName + ": " + driver.findElement(productprice).getText() + "\n");
			break;

		default:
			throw new Exception("No option present: " + value);
		}
	}

	public void switchTab() {

		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> it = s.iterator();
		while (it.hasNext()) {

			String child = it.next();

			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				System.out
						.println("\nSwitched to the Product Details tab: " + driver.switchTo().window(child).getTitle());
			}
		}
	}

}
