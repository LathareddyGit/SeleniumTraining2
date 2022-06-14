package driverSettings;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseDriver {

	WebDriver driver = null;
	String env = null;

	public WebDriver getDriver(String driverType) {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setAcceptInsecureCerts(true);
		caps.setCapability(ChromeOptions.CAPABILITY, "start-maximized");
		// caps.setc

		switch (driverType) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			options.addArguments("disable-infobar");
			options.addArguments("incognito");
			options.merge(caps);
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\drivers\\firefox.exe");
			driver = new FirefoxDriver();
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}
	
	//Waits - implicit , explicit, fluent waits
	
	public void setExplicitWait() {
		//WebDriverWait wait = new WebDriverWait(driver, null)
	}
	
	public void setEnvironment(String env) {
		this.env = env;
	}
	
	public WebDriver openUrl(String driverType, String url) {
		switch(this.env) {
		case "qa":
			url = "https://qa.makemytrip.com";
			break;
		case "dev":
			url = "https://dev.makemytrip.com";
			break;
		case "production": 
			url = "https://www.makemytrip.com";
			break;
		}
		driver = this.getDriver(driverType);
		this.driver.get(url);
		return this.driver;
	}

	public void highlightElement(WebDriver driver, WebElement element) {
		for (int i = 0; i < 20; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: red; border: 2px solid red;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
		
	}
	
	public void click(WebDriver driver, WebElement ele) {
		highlightElement(driver, ele);
		ele.click();
	}

	public void sendKeys(WebDriver driver, WebElement ele, String str) {
		highlightElement(driver, ele);
		ele.sendKeys(str);
	}
	
	public WebElement findElement(WebDriver driver, By by) {
		WebElement ele =  driver.findElement(by);
		this.highlightElement(driver, ele);
		return ele;
	}
	
	public void delay(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void closeDriver() {
		this.driver.quit();
	}
}
