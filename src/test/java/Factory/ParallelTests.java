package Factory;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driverSettings.BaseDriver;

public class ParallelTests {
	
	BaseDriver base = new BaseDriver();
	WebDriver driver = null;
	
	@BeforeMethod
	public void launchBrowser() {
		base.setEnvironment("production");
		driver = base.openUrl("chrome", "production");
		
	}
	
	@Test(invocationCount = 5, threadPoolSize = 5)
	public void first() {
		System.out.println("first"+ Thread.currentThread().getId());
	}
	
	@Test
	public void second() {
		System.out.println("second"+ Thread.currentThread().getId());
	}
	
	@Test
	public void third() {
		System.out.println("third"+ Thread.currentThread().getId());
	}
	
	@AfterMethod
	public void quit() {
		this.driver.quit();
	}

}
