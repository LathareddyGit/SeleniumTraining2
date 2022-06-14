package sampleTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driverSettings.BaseDriver;

public class AnnotationsOrder {
	
	public int a[] = { 1,4, 2 ,6, 9, 10};
	
	@BeforeSuite
	@Parameters("environment")
	public void inBeforeSuite(String environment) {
		System.out.println("in before suite "+environment);
	
		BaseDriver base = new BaseDriver();
		base.setEnvironment(environment);
		base.openUrl("chrome", "");
	}
	
	@AfterSuite
	public void inAfterSuite() {
		System.out.println("in After suite");
	}
	
	@BeforeTest
	public void inBeforeTest() {
		System.out.println("in before Test");
	}
	
	@AfterTest
	public void inAfterTest() {
		System.out.println("in After Test");
	}
	
	@BeforeClass
	public void inBeforeClass() {
		System.out.println("in before class");
	}
	
	@AfterClass
	public void inAfterClass() {
		System.out.println("in after class");
	}
	
	@BeforeMethod
	public void inBeforeMethod() {
		System.out.println("in before method");
	}
	
	@AfterMethod
	public void inAfterMethod() {
		System.out.println("in after method");
	}
	
	@Test
	public void inTest() {
		System.out.println("in test method");
	}

}
