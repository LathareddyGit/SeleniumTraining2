package Factory;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestNGListeners.MyRetry;

public class Test2 {
	
	@Test(invocationCount = 1)
	public void test2method() {
		System.out.println("in testmethod 2");
	}
	
	@Test(expectedExceptions = {NullPointerException.class, ArithmeticException.class} )
	public void test22mehtod() throws NullPointerException {
		System.out.println("in test22 method");
		throw new NullPointerException();
	}
	
	@Test
	public void testFail() {
		System.out.println("in testFail method");
		Assert.assertTrue(false);
	}

}
