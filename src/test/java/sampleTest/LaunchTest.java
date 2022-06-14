package sampleTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driverSettings.BaseDriver;

public class LaunchTest {

//	1. open makemytrip.com
//	2. click on from button
//	3. it should open a textbar with presuggested suggestions populated 
//	4. user should search with a keyword with minimum 3 characters for example "ind"
//	5. site should populate results matching with those 3 characters 
//	6. click on first result , and site should take it as input for "from" field

	BaseDriver base = new BaseDriver();
	WebDriver driver = null;
	
	@BeforeMethod
	public void beforeTest() {
		// 1
		 driver = base.openUrl("chrome", "https://www.makemytrip.com/");
		
	}

	@Test
	public void checkFromCity() throws InterruptedException {
		
		// 2
		base.highlightElement(driver, driver.findElement(By.id("fromCity")));
		driver.findElement(By.id("fromCity")).click();

		// 3
		WebElement autoSuggestions = null;
		try {
			autoSuggestions = driver.findElement(By.id("react-autowhatever-1"));
		} catch (Exception e) {
			System.out.println("e:::" + e);
		}

		System.out.println("autoSuggestions::::" + autoSuggestions.isDisplayed());
		Assert.assertEquals(autoSuggestions.isDisplayed(), true);

		// 4
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("ind");

		// 5
		List<WebElement> fromSuggestions = driver.findElements(
				By.xpath("//ul[@role='listbox']//li[contains(@id,'react-autowhatever-1-section-0-item-')]"));

		for (int i = 0; i < fromSuggestions.size(); i++) {
			try {
				String sug = fromSuggestions.get(i).getText();
				//System.out.println("sug::: at index" + i + " ::: is:::  " + sug);

				boolean result = sug.toLowerCase().contains("ind");
			} catch (Exception e) {
				//System.out.println("exception::" + e);
			}
			// Assert.assertEquals(result, true);
			// Assert.assertTrue(result);

		}

		// 6
		String expectedText = fromSuggestions.get(0).getText();
		expectedText.replaceAll(",","");
		fromSuggestions.get(0).click();
		
		String actualText = driver.findElement(By.xpath("//label[@for='fromCity']")).getText();
		actualText+= " "+driver.findElement(By.xpath("//input[@id='fromCity']")).getAttribute("value")+" ";
		
		//System.out.println("attribute:::"+ driver.findElement(By.xpath("//input[@id='fromCity']")).getAttribute("value"));
		
		//System.out.println("expected Text:::"+ expectedText);
		System.out.println("actual Text :::"+actualText);
		
		String expectedTexts[] = expectedText.split("\n");
		//String actualTexts[] = actualText.split(",");
		//actualText.replace(",", 0)
		
		for(String str: expectedTexts) {
			if(!str.equalsIgnoreCase("India")) {
				System.out.println("To verify:::"+str);
//				if(actualText.contains(str)) {
//					System.out.println(str+" Pass");
//					Assert.assertTrue(true);
//				}
				
				Assert.assertEquals(actualText.contains(str), true);
			}
		}
		

	}
	

	@Test()
	public void test1() {
		
		System.out.println("in test1");
	}
	
	@Test
	public void test2() {
		
		System.out.println("in test2");
	}
	
	@AfterTest
	public void closeDriver() {
		 base.closeDriver();
	}

}
