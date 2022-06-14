package sampleTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class executed");
	}

	@Test(description = "my own description", dataProvider = "dataObj", dataProviderClass = ToCity.class)
	public void login(String param, String pwd) {
		System.out.println("The parameter value is: " + param+"::::;pwd::::::;"+pwd);
	}

	


}
