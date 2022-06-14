package sampleTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import driverSettings.BaseDriver;

public class ToCity {

	BaseDriver base = new BaseDriver();

	@Test
	public void toCityCheck() {

//		WebDriver driver = null;
//
//		driver = base.getDriver("chrome");
//		driver.get("https://www.google.com/");
		
		WebDriver driver = base.openUrl("chrome", "https://www.google.com/");

		System.out.println("checking to city");

	}

	@AfterTest
	public void closeDriver() {
		base.closeDriver();
	}
	
	@DataProvider
	public Object[][] dataObj() {
		
			return new Object[][] { {"username1","password1"},
				{ "uname2", "password2" } ,
				};
		
	}
}
