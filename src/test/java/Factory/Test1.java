package Factory;

import org.testng.annotations.Test;

public class Test1 {
	@Test(groups = {"smoke", "regression"})
	public void test1method() {
		System.out.println("Test method 1");
	}
	
	@Test(alwaysRun = true, groups = {"sanity","regression"})
	public void test2method() {
		System.out.println("Test method 2");
	}
	
	@Test(groups = {"sanity","regression", "smoke"})
	public void common() {
		System.out.println("In common");
	}
	
	@Test(dependsOnGroups  = "smoke")
	public void dependedMethod() {
		System.out.println("after common ");
	}

}
