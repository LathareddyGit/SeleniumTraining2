package Factory;

import org.testng.annotations.Factory;

public class factoryClass {
	
	@Factory
	public Object[] facExe() {
		
		Object[] tests = new Object[2];
		tests[0] = new Test1();
		tests[1] = new Test2();
		return tests;

		
	}

}
