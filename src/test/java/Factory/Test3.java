package Factory;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test3 {
	
	@Test(priority= 25)
	public void test3method0() {
		System.out.println("in test3-0 method");
	}
	
	
	@Test(priority = 15, successPercentage = 0)
	public void test3method3() {
		System.out.println("in test3-3 method");
		Assert.assertTrue(false);
	}
	
	
	@Test(priority = 24)
	public void test3method2() {
		System.out.println("in test3-2 method");
	}
	
	@Test(priority = 17)
	public void test3method1() {
		System.out.println("in test3-1 method");
	}

}
