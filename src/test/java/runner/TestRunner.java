package runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features={"src/main/resources/FeatureFiles/"},
		glue= {"steps"},
		tags={"@contactus"},
		plugin={"json:src/test/resources/Report/Automated_Test_Execution.json"})

public class TestRunner extends AbstractTestNGCucumberTests {
	
	    @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
	    
}


