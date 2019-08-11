package runner;

import cucumber.api.CucumberOptions;

@CucumberOptions(
		features={
				"src/main/resources/FeatureFiles/"},
		
		tags={"@contactus"},
		plugin={"json:src/test/resources/Report/Automated_Test_Execution.json"})
public class ScriptRunner  {
	
}